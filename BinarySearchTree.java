
class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class BinarySearchTree {
    Node root;

    Node insert(Node node, int value) {
        if (node == null) return new Node(value);

        if (value < node.data)
            node.left = insert(node.left, value);
        else if (value > node.data)
            node.right = insert(node.right, value);

        return node;
    }

    boolean search(Node node, int key) {
        if (node == null) return false;
        if (key == node.data) return true;
        return key < node.data ? search(node.left, key) : search(node.right, key);
    }

    Node delete(Node node, int key) {
        if (node == null) return null;

        if (key < node.data)
            node.left = delete(node.left, key);
        else if (key > node.data)
            node.right = delete(node.right, key);
        else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            node.data = minValue(node.right);
            node.right = delete(node.right, node.data);
        }
        return node;
    }

    int minValue(Node node) {
        int minv = node.data;
        while (node.left != null) {
            minv = node.left.data;
            node = node.left;
        }
        return minv;
    }

    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }
    void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }
    void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int v : values)
            tree.root = tree.insert(tree.root, v);
        System.out.print("Inorder Traversal: ");
        tree.inorder(tree.root);
        System.out.print("\nPreorder Traversal: ");
        tree.preorder(tree.root);
        System.out.print("\nPostorder Traversal: ");
        tree.postorder(tree.root);
        int key = 40;
        System.out.print("\n\nSearching for " + key + ": ");
        System.out.println(tree.search(tree.root, key) ? "Found" : "Not Found");
        int delKey = 70;
        System.out.println("Deleting node " + delKey);
        tree.root = tree.delete(tree.root, delKey);
        System.out.print("Inorder After Deletion: ");
        tree.inorder(tree.root);
    }
}
