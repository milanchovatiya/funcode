package BFSDFS;

import java.util.*;

public class CloneGraph {


    public static void main(String[] args) {



        //Clone a graph


    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Node newNode = new Node(node.val, new ArrayList<Node>()); //new node for return
        HashMap<Integer, Node> map = new HashMap(); //store visited nodes

        map.put(newNode.val, newNode); //add first node to Subarray

        LinkedList<Node> queue = new LinkedList(); //to store **original** nodes need to be visited
        queue.add(node); //add first **original** node to queue

        while (!queue.isEmpty()) { //if more nodes need to be visited
            Node n = queue.pop(); //search first node in the queue
            for (Node neighbor : n.neighbors) {
                if (!map.containsKey(neighbor.val)) { //add to map and queue if this node hasn't been searched before
                    map.put(neighbor.val, new Node(neighbor.val, new ArrayList<Node>()));
                    queue.add(neighbor);
                }
                map.get(n.val).neighbors.add(map.get(neighbor.val)); //add neighbor to new created nodes
            }
        }

        return newNode;
    }
}
