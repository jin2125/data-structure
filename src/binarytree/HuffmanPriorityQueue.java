package binarytree;

/**
 * 优先级队列
 *
 * @author gewei
 * @date 2019/10/14
 */
public class HuffmanPriorityQueue {
    /**
     * 存放队列数据的数组
     */
    private HuffmanNode[] queue;

    /**
     * 记录当前队列存放的元素个数，也相于是索引
     */
    private int nItems;

    public HuffmanPriorityQueue(int len) {
        this.queue = new HuffmanNode[len];
        this.nItems = 0;
    }

    public void insert(HuffmanNode huffmanNode) {
        // 1: 队列里面没有数据项的话，直接赋值
        if (nItems == 0) {
            queue[nItems] = huffmanNode;
            nItems++;
            return;
        } else {
            // 2: 队列里面有数据项的话，就需要进行比较，排序后插入数据
            int i = 0;
            for (i = nItems - 1; i >= 0; i--) {
                if (queue[i].getCount() > huffmanNode.getCount()) {
                    queue[i+1] = queue[i];
                } else {
                    break;
                }
            }
            queue[i+1] = huffmanNode;
            nItems++;
        }
    }

    public HuffmanNode remove() {
        nItems--;
        return queue[nItems];
    }

    public HuffmanNode peekFront() {
        return queue[nItems - 1];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == queue.length;
    }

    public void printQueue() {
        System.out.println("==================");
        for (int i = 0; i < nItems; i++) {
            System.out.println(queue[i]);
        }
    }

    public Integer size() {
        return nItems;
    }

    public static void main(String[] args) {
        HuffmanPriorityQueue t = new HuffmanPriorityQueue(5);
        t.insert(new HuffmanNode('a', 5));
        t.insert(new HuffmanNode('b', 6));
        t.insert(new HuffmanNode('c', 3));
        t.insert(new HuffmanNode('d', 4));
        t.insert(new HuffmanNode('e', 1));

        t.printQueue();
        HuffmanNode ret = t.peekFront();
        System.out.println("now ret==" + ret);
        t.remove();
        t.printQueue();
        ret = t.peekFront();
        System.out.println("now ret==" + ret);

    }


}
