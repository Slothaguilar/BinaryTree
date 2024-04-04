import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        return searchTree(val, root);
    }
    public boolean searchTree(int val, BSTNode root){
        if (root == null){
            return false;
        }
        if ( val == root.getVal()){
            return true;
        }
        else if (val < root.getVal()){
            return searchTree(val, root.getLeft());
        }
        else {
            return searchTree(val, root.getRight());
        }
    }


    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        // Return an ArrayList<BSTNode> that represents the Inorder Traversal of the tree.
        //Inorder Traversal visits each node from Left → Root → Right
        ArrayList<BSTNode> inOrder = new ArrayList<>();
        return inOrderTraversal(root, inOrder);
    }
    public ArrayList<BSTNode> inOrderTraversal(BSTNode node, ArrayList<BSTNode> inOrder){
       // base case
        if (node.getLeft() == null && node.getRight() == null){
            inOrder.add(node);
            return inOrder;
        }

        // goes through left
        inOrderTraversal(node.getLeft(), inOrder);
        inOrder.add(node);

        // goes through right
        inOrderTraversal(node.getRight(), inOrder);

        return inOrder;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> preOrder = new ArrayList<>();
        return preOrderTraversal(root, preOrder);
    }
    public ArrayList<BSTNode> preOrderTraversal(BSTNode node, ArrayList<BSTNode> preOrder){
        if (node == null){
            return preOrder;
        }
        // adds current node
        preOrder.add(node);
        // goes through left
        preOrderTraversal(node.getLeft(), preOrder);
        // goes through right
        preOrderTraversal(node.getRight(), preOrder);

        return preOrder;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> postOrder = new ArrayList<>();
        return postOrderTraversal(root, postOrder);
    }
    public ArrayList<BSTNode> postOrderTraversal(BSTNode root, ArrayList<BSTNode> postOrder){
        if (root== null){
            return postOrder;
        }
        // left
        postOrderTraversal(root.getLeft(), postOrder);

        // right
        postOrderTraversal(root.getRight(), postOrder);

        // add root
        postOrder.add(root);

        return postOrder;
    }


    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        insertNode(root, val);
    }

    public BSTNode insertNode(BSTNode node, int val) {
        if (node == null) {
            return node;
        }
        if (val < node.getVal()) {
            node.setLeft(insertNode(node.getLeft(), val));
        }
        else if (val > node.getVal()) {
            node.setRight(insertNode(node.getRight(), val));
        }
        return node;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
