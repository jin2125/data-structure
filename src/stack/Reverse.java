package stack;

/**
 * 反转字符串
 *
 * @author gewei
 * @date 2019/10/14
 */
public class Reverse {
    public String doRev(String str) {
        StringBuffer buffer = new StringBuffer();
        MyStack ms = new MyStack(str.length());
        char[] chars = str.toCharArray();
        for (Character c: chars) {
            ms.push(c);
        }

        while (!ms.isEmpty()) {
            char data = (char) ms.pop();
            buffer.append(data);
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        Reverse t = new Reverse();
        String ret = t.doRev("this is 阿  test");
        System.out.println("ret==="+ret);
    }
}
