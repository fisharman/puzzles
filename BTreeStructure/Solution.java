import java.util.ArrayList;

class Node
{
    int key;
    Node left, right;

    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}

class BinaryTree
{
    Node root;

    BinaryTree()
    {
        root = null;
    }

    // BST, left subtree contain values lower than own, right subtree contain value higher than own
    // pre-order traversal 1. visit root 2. traverse left 3. traverse right
    // in-order traversal. 1. traverse left 2. visit root 3, traver left

    /* Given a binary tree, print its nodes in preorder*/
    public static ArrayList<Integer> preorder(Node node, ArrayList<Integer> visited)
    {
        if (node == null)
            return null;

        visited.add(node.key);

        /* then recur on left sutree */
        preorder(node.left, visited);

        /* now recur on right subtree */
        preorder(node.right, visited);

        return visited;

    }

    public static ArrayList<Integer> preorder_alt(Node node)
    {
        if (node == null)
            return null;

        ArrayList<Integer> nodeValues = new ArrayList<>();
        nodeValues.add(node.key);

        /* then recur on left sutree */
        ArrayList<Integer> leftValues = preorder_alt(node.left);

        /* now recur on right subtree */
        ArrayList<Integer> rightValues = preorder_alt(node.right);

        if (leftValues != null)
            nodeValues.addAll(leftValues);

        if (rightValues != null)
            nodeValues.addAll(rightValues);

        return nodeValues;

    }
}


public class Solution {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        // test whatever below...
    }

}
