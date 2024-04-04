import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Sofia Aguilar
 * @version: 04/04/24
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
        // calls helper function for recursive method
        return searchTree(val, root);
    }
    public boolean searchTree(int val, BSTNode currentNode){
        // return a false if the end of the search and finds that the current Node is null
        if (currentNode == null){
            return false;
        }
        // return true if the value is the current Node
        if ( val == currentNode.getVal()){
            return true;
        }
        // search on the left side
        else if (val < currentNode.getVal()){
            return searchTree(val, currentNode.getLeft());
        }
        // searches the right side
        else {
            return searchTree(val, currentNode.getRight());
        }
    }


    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        // initialize the arrayList
        ArrayList<BSTNode> inOrder = new ArrayList<>();
        // call the helper method
        return inOrderTraversal(root, inOrder);
    }
    public ArrayList<BSTNode> inOrderTraversal(BSTNode currentNode, ArrayList<BSTNode> inOrder){
        // if reached the leafs then return the array List
        if (currentNode == null){
            return inOrder;
        }
        // goes to the left
        inOrderTraversal(currentNode.getLeft(), inOrder);
        // add the current node
        inOrder.add(currentNode);
        // goes to the right
        inOrderTraversal(currentNode.getRight(), inOrder);
        // finally returns the Arraylist after added all the possible nodes in the tree
        return inOrder;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        // initialize the arrayList
        ArrayList<BSTNode> preOrder = new ArrayList<>();
        // call the helper method
        return preOrderTraversal(root, preOrder);
    }
    public ArrayList<BSTNode> preOrderTraversal(BSTNode currentNode, ArrayList<BSTNode> preOrder){
        // if reached the leafs then return the array List
        if (currentNode == null){
            return preOrder;
        }
        // adds current node
        preOrder.add(currentNode);
        // goes through left
        preOrderTraversal(currentNode.getLeft(), preOrder);
        // goes through right
        preOrderTraversal(currentNode.getRight(), preOrder);
        // finally returns the Arraylist after added all the possible nodes in the tree
        return preOrder;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        // initialize the arrayList
        ArrayList<BSTNode> postOrder = new ArrayList<>();
        // call the helper method
        return postOrderTraversal(root, postOrder);
    }
    public ArrayList<BSTNode> postOrderTraversal(BSTNode currentNode, ArrayList<BSTNode> postOrder){
        // if reached the leafs then return the array List
        if (currentNode== null){
            return postOrder;
        }
        // goes through the left
        postOrderTraversal(currentNode.getLeft(), postOrder);
        // goes through the right
        postOrderTraversal(currentNode.getRight(), postOrder);
        // add the current node
        postOrder.add(currentNode);
        // finally returns the Arraylist after added all the possible nodes in the tree
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
        // root has to hold the new BSTNode coming from the helper method and
        root = insertNode(root, val);
    }

    public BSTNode insertNode(BSTNode currentNode, int val) {
        if (currentNode == null) {
            // create a new node to set it in place
            return new BSTNode(val);
        }
        if (val < currentNode.getVal()) {
            // set it on the left child and check again
            currentNode.setLeft(insertNode(currentNode.getLeft(), val));
        }
        else if (val > currentNode.getVal()) {
            // set it the right child and check again
            currentNode.setRight(insertNode(currentNode.getRight(), val));
        }
        return currentNode;
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
