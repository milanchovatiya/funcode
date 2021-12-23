
import java.util.Stack;

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
    }

    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};

public class QuadTree {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0}
        };
        System.out.println(construct(grid));

        }

    public static Node construct(int[][] grid) {
        return constructTree(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }

    public static Node constructTree(int[][] grid, int rl, int rh, int cl, int ch){
        if(rl == rh && cl == ch){
            if(grid[rl][cl] == 1)
                return new Node(true, true);
            else
                return new Node(false, true);
        }
        int nodeValue = grid[rl][cl];
        for(int i = rl; i <= rh; i++){
            for(int j = cl; j <= ch; j++){
                if(grid[i][j] != nodeValue){
                    Node topLeft = constructTree(grid, rl, (rh + rl) / 2, cl, (ch + cl) / 2);
                    Node bottomLeft = constructTree(grid, (rh + rl) / 2 + 1, rh, cl, (ch + cl) / 2);
                    Node topRight = constructTree(grid, rl, (rh + rl) / 2, (ch + cl) / 2 + 1, ch);
                    Node bottomRight = constructTree(grid, (rh + rl) / 2 + 1, rh, (ch + cl) / 2 + 1, ch);
                    return new Node(false, false,topLeft, topRight,bottomLeft, bottomRight);
                }
            }
        }

        if(nodeValue == 1)
            return new Node(true, true);
        else
            return new Node(false, true);

    }

}
