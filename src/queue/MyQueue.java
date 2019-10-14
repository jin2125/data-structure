package queue;

/**
 * @author gewei
 * @date 2019/10/14
 */
public class MyQueue {
    private int[] queue;
    private int front;
    private int end;

    private int nItems;

    public MyQueue(int length) {
        queue = new int[length];
        front = 0;
        end = -1;
        nItems = 0;
    }

    public void insert(int data) {
        if (end == queue.length - 1) {
            end = -1;
        }
        end++;

        queue[end] = data;
        nItems++;

        if(nItems > queue.length){
            nItems = queue.length;
        }
    }

    public int remove(){
        if(nItems==0){
            return 0;
        }
        int temp = queue[front];
        queue[front] = 0;
        if(front==queue.length-1){
            front = 0;
        }
        front++;

        nItems--;
        return temp;
    }
    public int peekFront(){
        return queue[front];
    }
    public boolean isEmpty(){
        return nItems==0;
    }
    public boolean isFull(){
        return nItems==queue.length;
    }
    public void printQueue(){
        System.out.println("=======================>");
        for(int d : queue){
            System.out.println(d);
        }
    }
    public static void main(String[] args) {
        MyQueue t = new MyQueue(5);

        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(5);

        t.printQueue();

        int ret = t.peekFront();
        System.out.println("now ret=="+ret);

        t.remove();
        int ret2 = t.remove();
        System.out.println("now ret2=="+ret2);

        t.printQueue();

        t.insert(6);
        t.insert(7);
        t.insert(8);
        t.printQueue();

        t.remove();
        int ret3 = t.remove();
        System.out.println("now ret3=="+ret3);
        t.printQueue();
    }

}
