public class BinaryTreeNode<T> {

    T verdi;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode() {
        left = null;
        right = null;
        verdi = null;
    }

    public BinaryTreeNode(BinaryTreeNode<T> left, BinaryTreeNode<T> right){
        this.left = left;
        this.right = right;
        verdi = null;
    }
    
    public BinaryTreeNode<T> getLeft() {
        return left;
    }
    public BinaryTreeNode<T> getRight() {
        return right;
    }
    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }
    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public void print(String prefix, BinaryTreeNode<T> n, boolean isLeft) {
        if (n != null) {
            print(prefix + "    ", n.right, false);
            System.out.println (prefix + ("|--[") + n.verdi + "]");
            print(prefix + "    ", n.left, true);
        }
    }
}
