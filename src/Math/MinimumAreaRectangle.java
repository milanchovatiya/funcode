package Math;

import java.util.HashSet;

public class MinimumAreaRectangle {

//    You are given an array of points in the X-Y plane points where points[i] = [xi, yi].
//
//    Return the minimum area of a rectangle formed from these points, with sides parallel to the X and Y axes.
//    If there is not any such rectangle, return 0

    public int minAreaRect(int[][] points) {
        int n=points.length;
        HashSet<String> set=new HashSet<>();
        for(int i = 0; i < n; i++)
            set.add(points[i][0] + " " + points[i][1]);

        int area=Integer.MAX_VALUE;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(points[i][0] == points[j][0] || points[i][1] == points[j][1])
                    continue;
                String point1 = points[i][0] +" "+ points[j][1];
                String point2 = points[j][0] +" "+ points[i][1];
                if(set.contains(point1) && set.contains(point2))
                {
                    int temp = Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]);
                    area=Math.min(area, temp);
                }
            }
        }
        if(area == Integer.MAX_VALUE)
            return 0;
        else return area;
    }
}
