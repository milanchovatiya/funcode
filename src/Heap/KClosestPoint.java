package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPoint {


    public static void main(String[] args) {


        List<List<Integer>> pointsList = new ArrayList<>();
        List<Integer> point1 = new ArrayList<>();
        point1.add(3);
        point1.add(6);
        pointsList.add(point1);

        List<Integer> point2 = new ArrayList<>();
        point2.add(2);
        point2.add(4);
        pointsList.add(point2);

        List<Integer> point3 = new ArrayList<>();
        point3.add(0);
        point3.add(0);
        pointsList.add(point3);

        List<Integer> point4 = new ArrayList<>();
        point4.add(2);
        point4.add(7);
        pointsList.add(point4);

        List<Integer> point5 = new ArrayList<>();
        point5.add(1);
        point5.add(8);
        pointsList.add(point5);

        List<Integer> point6 = new ArrayList<>();
        point6.add(7);
        point6.add(9);
        pointsList.add(point6);

        List<List<Integer>> resultList = closestk(3, pointsList, 3);
        for(List<Integer> points : resultList){
            System.out.println(points);
        }

    }


    public static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public int getDist(){
            return x*x+y*y;
        }

        @Override
        public int compareTo(Point o) {
            int c = Double.compare(getDist(), o.getDist());
            if(c == 0){
                c = Double.compare(x, o.x);
                if(c == 0){
                    c = Double.compare(y, o.y);
                }
            }

            return c;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    public static List<List<Integer>>  closestk(int N, List<List<Integer>> pointsList, int M) {
        int numLocations = pointsList.size();
        Point[] points = new Point[numLocations];
        int index = 0;
        for(List<Integer> pointList : pointsList) {
            points[index] = new Point(pointList.get(0), pointList.get(1));
            index++;
        }
        //max heap
        final PriorityQueue<Point> kClosest = new PriorityQueue<>(M, Collections.reverseOrder());
        for (int i = 0; i < points.length; i++) {
            if (kClosest.size() < M) {
                kClosest.add(points[i]);
            } else if (points[i].getDist() < kClosest.peek().getDist()) {
                kClosest.remove();
                kClosest.add(points[i]);
            }
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Point[] res = kClosest.toArray(new Point[M]);
        for(Point p : res){
            List<Integer> point = new ArrayList<>();
            if(p != null) {
                point.add(p.x);
                point.add(p.y);
            }
            resultList.add(point);

        }
        return resultList;
    }

}
