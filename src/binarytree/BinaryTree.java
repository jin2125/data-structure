package binarytree;

/**
 * 演示二叉树的操作
 *
 * @author gewei
 * @date 2019/10/16
 */
public class BinaryTree {
    /**
     * 根节点
     */
    private Node root;

    /**
     * 查找一个节点
     *
     * @param key 要查找的id值
     * @return
     */
    public Node find(int key) {
        Node current = root;

        while (current.getId() != key) {
            if (current.getId() < key) {
                current = current.getLeftChild();
            } else if (current.getId() > key) {
                current = current.getRightChild();
            }
            if (current == null) {
                return null;
            }
        }

        return current;
    }

    /**
     * 插入一个节点
     *
     * @param id
     * @param data
     */
    public void insert(int id, int data) {
        Node node = new Node(id, data);
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent = null;

            while (true) {
                parent = current;
                if (id < current.getId()) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(node);
                        return;
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(node);
                        return;
                    }
                }
            }
        }
    }

    /**
     * 前序获取节点数据
     *
     * @param node
     */
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.getId() + " - ");
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

    /**
     * 中序获取节点数据
     *
     * @param node
     */
    public void inOrder(Node node) {
        if (node != null) {
            preOrder(node.getLeftChild());
            System.out.print(node.getId() + " - ");
            preOrder(node.getRightChild());
        }
    }

    /**
     * 后序获取节点数据
     *
     * @param node
     */
    public void postOrder(Node node) {
        if (node != null) {
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
            System.out.print(node.getId() + " - ");
        }
    }

    /**
     * 获取最小节点
     * @return
     */
    public Node getMinNode() {
        Node current = root;
        Node lastNode = null;
        while (current != null) {
            lastNode = current;
            current = current.getLeftChild();
        }
        return lastNode;
    }

    /**
     * 获取最大节点
     * @return
     */
    public Node getMaxNode() {
        Node current = root;
        Node lastNode = null;
        while (current != null) {
            lastNode = current;
            current = current.getRightChild();
        }
        return lastNode;
    }

    public boolean delete(int key){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while(current.getId()!=key){
            parent = current;
            if(current.getId() > key){
                isLeftChild = true;
                current = current.getLeftChild();
            }else if(current.getId() < key){
                isLeftChild = false;
                current = current.getRightChild();
            }
            if(current == null){
                return false;
            }
        }

        //2 没有子节点
        if(current.getLeftChild()==null && current.getRightChild()==null){
            this.noChildren(parent, current, isLeftChild);
        }
        //3 只有一个子节点
        //只有左节点
        else if(current.getRightChild()== null){
            this.oneLeftChild(parent, current, isLeftChild);
        }
        //只有右节点
        else if(current.getLeftChild() == null){
            this.oneRightChild(parent, current, isLeftChild);
        }
        //4右两个子节点
        else{
            //4.1 找到中序后继节点
            Node successor = this.getSuccessor(current);
            if(current == root){
                root = successor;
            }else{
                if(isLeftChild){
                    parent.setLeftChild(successor);
                }else{
                    parent.setRightChild(successor);
                }
            }
            //重新呢设置successor的leftChild
            successor.setLeftChild(current.getLeftChild());
        }
        return true;
    }

    private void oneLeftChild(Node parent,Node current,boolean isLeftChild){
        if(current == root){
            root = current.getLeftChild();
        }else{
            if(isLeftChild){
                parent.setLeftChild(current.getLeftChild());
            }else{
                parent.setRightChild(current.getLeftChild());
            }
        }
    }

    /**
     * 找到要删除节点的中序后继节点
     *
     * @param delNode
     * @return
     */
    private Node getSuccessor(Node delNode){
        Node successor = delNode;
        Node successorParent = delNode;
        Node current = delNode.getRightChild();
        // 查找节点
        while(current!=null){
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        // 设置相应的值
        if(successor!=delNode.getRightChild()){
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(delNode.getRightChild());
        }
        return successor;
    }

    private void oneRightChild(Node parent,Node current,boolean isLeftChild){
        if(current == root){
            root = current.getRightChild();
        }else{
            if(isLeftChild){
                parent.setLeftChild(current.getRightChild());
            }else{
                parent.setRightChild(current.getRightChild());
            }
        }
    }

    private void noChildren(Node parent,Node current,boolean isLeftChild){
        if(current == root){
            root = null;
        }else{
            if(isLeftChild){
                parent.setLeftChild(null);
            }else{
                parent.setRightChild(null);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();

        t.insert(6, 6);
        t.insert(5, 2);
        t.insert(8, 2433);
        t.insert(3, 5);
        t.insert(7, 77);
        t.insert(9, 233);

        t.inOrder(t.find(6));
//		System.out.println(t.root.toString());
//
//		t.inOrder(t.find(6));
//
//		Node min = t.getMinNode();
//		Node max = t.getMaxNode();
//		System.out.println("min=="+min);
//		System.out.println("max=="+max);

        t.delete(8);
        System.out.println();
        System.out.println(t.root.toString());
    }

}
