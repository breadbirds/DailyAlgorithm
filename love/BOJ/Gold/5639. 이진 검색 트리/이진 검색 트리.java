import java.io.*;

public class Main {
    static class Node {
        int value;
        Node left, right;
        Node(int value) { this.value = value; }
    }

    static Node root;

    public static void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left == null) node.left = new Node(value);
            else insert(node.left, value);
        } else {
            if (node.right == null) node.right = new Node(value);
            else insert(node.right, value);
        }
    }

    public static void postOrder(Node node, StringBuilder sb) {
        if (node == null) return;
        postOrder(node.left, sb);
        postOrder(node.right, sb);
        sb.append(node.value).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        root = new Node(Integer.parseInt(br.readLine()));

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            insert(root, Integer.parseInt(line));
        }

        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        System.out.print(sb);
    }
}
