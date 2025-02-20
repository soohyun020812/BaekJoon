package data_structure;
import java.io.*;
import java.util.*;

// 1991 트리 순회 
public class Main1991 {
	static class Node {
        char value;
        Node left, right;

        public Node(char value) {
            this.value = value;
        }
    }

    static class BinaryTree {
        Map<Character, Node> nodes = new HashMap<>();

        public BinaryTree() {
            for (char c = 'A'; c <= 'Z'; c++) {
                nodes.put(c, new Node(c));
            }
        }

        // 노드 연결
        public void addNode(char parent, char left, char right) {
            Node pNode = nodes.get(parent);
            if (left != '.') pNode.left = nodes.get(left);
            if (right != '.') pNode.right = nodes.get(right);
        }

        // 전위 순회 Preorder : (루트) (왼쪽 자식) (오른쪽 자식)
        public void preorder(Node node) {
            if (node == null) return;
            System.out.print(node.value);
            preorder(node.left);
            preorder(node.right);
        }

        // 중위 순회 Inorder : (왼쪽 자식) (루트) (오른쪽 자식)
        public void inorder(Node node) {
            if (node == null) return;
            inorder(node.left);
            System.out.print(node.value);
            inorder(node.right);
        }

        // 후위 순회 Postorder : (왼쪽 자식) (오른쪽 자식) (루트)
        public void postorder(Node node) {
            if (node == null) return;
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BinaryTree tree = new BinaryTree();
        
        // 트리 구성
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.addNode(parent, left, right);
        }

        // 트리 순회 및 출력
        // 루트는 'A'
        tree.preorder(tree.nodes.get('A'));  
        System.out.println();
        tree.inorder(tree.nodes.get('A'));
        System.out.println();
        tree.postorder(tree.nodes.get('A'));
    }
}
