package ConstructBT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class NnaryTreeSerializeDeserialize {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        String res = "";
        Queue<Node> queue = new LinkedList<>();
        if(root == null) {
            return null;
        }
        queue.add(root);
        queue.add(new Node(-1));
        int level = 0;
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                Node node = queue.remove();
                if(node.val != -1) {
                    for(Node child : node.children) {
                        queue.add(child);
                    }
                    queue.add(new Node(-1));
                    res += node.val + ",";
                } else {
                    res += "null,";
                }
            }
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data == null || data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for(String node : nodes){
            queue.add(node);
        }
        Node dummy = new Node(-1);
        Queue<Node> innerQueue = new LinkedList<>();
        innerQueue.add(dummy);
        while(!innerQueue.isEmpty()) {
            Node parent = innerQueue.remove();
            List<Node> childrenList = new ArrayList<>();
            while(!queue.peek().equals("null")) {
                String val = queue.remove();
                Node newNode = new Node(Integer.parseInt(val));
                childrenList.add(newNode);
                innerQueue.add(newNode);
            }
            queue.remove();
            parent.children = childrenList;
        }
        return dummy.children.get(0);
    }
}
