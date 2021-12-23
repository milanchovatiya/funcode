package BFSDFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule_Topological {


    public static void main(String[] args) {
        //int[] res = canFinishtest(5, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}, {0, 4}});
        int[] res = canFinish(3, new int[][]{ {0, 1}, {0, 2}, {1, 2}});
        for(Integer i : res)
            System.out.print(i + " ");

    }


    public static int[] canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        boolean[] visited = new boolean[numCourses];
        boolean[] track = new boolean[numCourses];
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Stack<Integer> stack = new Stack<>();
        //List<Integer> res = new ArrayList<>();
        int[] result = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            if(!track[i]){
                if(!dfs(graph,visited,i, stack, track))
                    return new int[]{};
            }
        }
        int index = 0;
        while(!stack.isEmpty()){
            result[index] = stack.pop();
            index++;
        }

        return result;
    }

    private static boolean dfs(ArrayList[] graph, boolean[] visited, int course, Stack<Integer> stack, boolean[] track){


        if(visited[course])
            return false;
        if(track[course]){
            return true;
        }
        visited[course] = true;
        track[course] = true;


        for(int i=0; i<graph[course].size();i++){
            if(!dfs(graph,visited,(int)graph[course].get(i), stack, track)) {
                return false;
            }
        }
        stack.push(course);



        visited[course] = false;
        return true;
    }
}
