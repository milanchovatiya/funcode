import java.util.*;

class Event{
    private int eventId;
    private int[] location;
    private List<Ticket> ticketList;

    public Event(int eventId, int[] location, List<Ticket> ticketList) {
        this.eventId = eventId;
        this.location = location;
        this.ticketList = ticketList;
    }

    public int getEventId() {
        return eventId;
    }

    public int[] getLocation() {
        return location;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public int getCheapestTicket(){
        if(ticketList.isEmpty())
            return -1;
        int minimumPrice = ticketList.get(0).getPrice();
        for(Ticket ticket : ticketList){
            if(ticket.getPrice() < minimumPrice)
                minimumPrice = ticket.getPrice();
        }
        return minimumPrice;
    }

}

class Ticket{

    private int price;

    public Ticket(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Ticket)) return false;
        Ticket o = (Ticket) obj;
        return o.price == this.price;
    }

}

class Buyer{
    private int[] location;

    public Buyer(int[] location) {
        this.location = location;
    }

    public int[] getLocation() {
        return location;
    }
}

public class Test {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sizeOfWorld = Integer.parseInt(sc.nextLine());
        int numberOfEvents = Integer.parseInt(sc.nextLine());

        List<Event> eventList = new ArrayList<>();

        while(numberOfEvents > 0){
            String eventLine = sc.nextLine();
            Event event = parseEvent(eventLine);
            eventList.add(event);
            numberOfEvents--;
        }

        List<Buyer> buyerList = new ArrayList<>();


        int numberOfBuyers = Integer.parseInt(sc.nextLine());
        while(numberOfBuyers > 0){
            String buyerLine = sc.nextLine();
            Buyer buyer = parseBuyer(buyerLine);
            buyerList.add(buyer);
            numberOfBuyers--;
        }

        for(Buyer buyer : buyerList){
            List<Event> eventsWithTickets = filterEvents(eventList);
            if(eventsWithTickets.isEmpty()){
                System.out.println("-1 0");
                break;
            }
            List<Event> closeEvents = closestEvents(eventsWithTickets, buyer.getLocation());
            List<Event> cheapestEvents = cheapestTickets(closeEvents);
            Event minIdEvent = getMinimumIdEvent(cheapestEvents);
            System.out.println(minIdEvent.getEventId() + " " + minIdEvent.getCheapestTicket());
            removeTicket(eventList, minIdEvent);
        }



    }

    private static List<Event> filterEvents(List<Event> eventList) {
        List<Event> eventWithTickets = new ArrayList<>();
        for(Event event : eventList){
            if(!event.getTicketList().isEmpty())
                eventWithTickets.add(event);
        }
        return eventWithTickets;
    }


    private static void removeTicket(List<Event> eventList, Event minIdEvent) {
        for(Event event : eventList){
            if(event.getEventId() == minIdEvent.getEventId()){
                event.getTicketList().remove(new Ticket(minIdEvent.getCheapestTicket()));
            }
        }
    }

    private static Event getMinimumIdEvent(List<Event> cheapestEvents) {
        int minIndex = 0;

        for(int i = 0; i < cheapestEvents.size(); i++){
            if(cheapestEvents.get(i).getEventId() < cheapestEvents.get(minIndex).getEventId()){
                minIndex = i;
            }
        }

        return cheapestEvents.get(minIndex);
    }

    private static List<Event> cheapestTickets(List<Event> closeEvents) {
        int minIndex = 0;
        List<Event> cheapestEvents = new ArrayList<>();

        for (int i = 0; i < closeEvents.size() ; i++) {
            if (closeEvents.get(i).getCheapestTicket() == closeEvents.get(minIndex).getCheapestTicket()) {
                cheapestEvents.add(closeEvents.get(i));
            } else if (closeEvents.get(minIndex).getCheapestTicket() > closeEvents.get(i).getCheapestTicket()) {
                cheapestEvents.clear();
                cheapestEvents.add(closeEvents.get(i));
                minIndex = i;
            }
        }

        return cheapestEvents;
    }

    private static List<Event> closestEvents(List<Event> eventList, int[] userLocation) {
        List<Event> closeEvents = new ArrayList<>();
        int[] distArr = new int[eventList.size()];

        for(int i = 0; i < eventList.size(); i++){
            int[] eventLocation = eventList.get(i).getLocation();
            distArr[i] = calculateManhattanDistance(eventLocation[0], eventLocation[1], userLocation[0], userLocation[1]);
        }
        int minIndex = 0;
        for (int i = 0; i < distArr.length ; i++) {
            if (distArr[i] == distArr[minIndex]) {
                closeEvents.add(eventList.get(i));
            } else if (distArr[minIndex] > distArr[i]) {
                closeEvents.clear();
                closeEvents.add(eventList.get(i));
                minIndex = i;
            }
        }

        return closeEvents;


    }

    public static Buyer parseBuyer(String buyerLine){
        return new Buyer(new int[]{Integer.parseInt(buyerLine.split(" ")[0]), Integer.parseInt(buyerLine.split(" ")[1])});
    }

    public static Event parseEvent(String eventLine){
        int eventId = Integer.parseInt(eventLine.split(" ")[0]);
        int[] location = {Integer.parseInt(eventLine.split(" ")[1]), Integer.parseInt(eventLine.split(" ")[2])};
        int numberOfTickets = eventLine.split(" ").length - 3;
        List<Ticket> ticketList = new ArrayList<>();
        int ticketCounter = 0;
        while(ticketCounter < numberOfTickets){
            ticketList.add(new Ticket(Integer.parseInt(eventLine.split(" ")[ticketCounter + 3])));
            ticketCounter++;
        }
        return new Event(eventId, location, ticketList);
    }

    public static int calculateManhattanDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }


}
