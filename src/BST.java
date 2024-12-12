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
        if (this.root.getVal() == val){
            return true;
        }
        return (search(val, this.root.getLeft()) || search(val, this.root.getRight()));

    }

    /// Return false if you get to the bottom of both branches with no matches
    public boolean search(int val, BSTNode node){
        if (node == null){
            return false;
        }
        else if (node.getVal() == val){
            return true;
        }
        return (search(val, node.getLeft()) || search(val, node.getRight()));
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> bstTree = new ArrayList<BSTNode>();
        inOrder(bstTree, this.root);
        return bstTree;
    }

    /// Adds to the arraylist traversing in order, starting with the left branch then the root then the right
    public void inOrder(ArrayList<BSTNode> tree, BSTNode node){
        if(node == null){
            return;
        }
        inOrder(tree, node.getLeft());
        tree.add(node);
        inOrder(tree, node.getRight());
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> bstTree = new ArrayList<BSTNode>();
        preOrder(bstTree, this.root);
        return bstTree;
    }


    /// Adds to the array list traversing pre order, starting with the node then working up from both branches
    public void preOrder(ArrayList<BSTNode> tree, BSTNode node){
        if(node == null){
            return;
        }
        tree.add(node);
        inOrder(tree, node.getLeft());
        inOrder(tree, node.getRight());
    }


    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> bstTree = new ArrayList<BSTNode>();
        postOrder(bstTree, this.root);
        return bstTree;
    }

    /// Go to the bottom of each branch, then add that node to the list, add the root last
    public void postOrder(ArrayList<BSTNode> tree, BSTNode node){
        if(node == null){
            return;
        }
        inOrder(tree, node.getLeft());
        inOrder(tree, node.getRight());
        tree.add(node);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        insert(val, root);
    }

    /// Overloaded insert helper method
    public void insert(int val, BSTNode node){
        /// If the value is the same as a node, return without inserting
        if(val == node.getVal()){
            return;
        }
        /// Check if the value should go left or right, insert if that left or right child is null
        else if (val < node.getVal()) {
            if (node.getLeft() == null) {
                node.setLeft(new BSTNode(val));
                return;
            }
            insert(val, node.getLeft());
        }
        else{
            if (node.getRight() == null){
                node.setRight(new BSTNode(val));
                return;
            }
            insert(val, node.getRight());
        }
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
