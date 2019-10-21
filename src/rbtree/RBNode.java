package rbtree;

/**
 * @author gewei
 * @date 2019/10/21
 */
public class RBNode {
    private int id;
    private int data;

    private RBNode leftChild;
    private RBNode rightChild;

    private boolean red = true;
    private RBNode parent;

    public RBNode(int id, int data, boolean red) {
        super();
        this.id = id;
        this.data = data;
        this.red = red;
    }

    public boolean isRed() {
        return red;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public RBNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(RBNode leftChild) {
        this.leftChild = leftChild;
    }

    public RBNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(RBNode rightChild) {
        this.rightChild = rightChild;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public RBNode getParent() {
        return parent;
    }

    public void setParent(RBNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "RBNode{" +
                "id=" + id +
                ", data=" + data +
                ", red=" + red +
                '}';
    }
}
