package stack;

/**
 * 演示用栈来实现，把中缀表达式转换成为后缀表达式
 *
 * @author gewei
 * @date 2019/10/14
 */

public class PostInfix {
    /**
     * 把中缀表达式转换为后缀表达式
     *
     * @param str 要转换的中缀表达式
     * @return 转换后的后缀表达式
     */
    public String doTransfer(String str) {
        StringBuffer buffer = new StringBuffer();
        MyStack ms = new MyStack(20);

        // 字符串转换成字符数组
        char[] chars = str.toCharArray();
        // 对每个字符进行判读并进行相应操作
        for (int i = 0; i < chars.length; i++) {
            char c =  chars[i];
            if (c == '+' || c == '-') {
                doOperation(ms, buffer, c, 1);
            } else if (c == '*' || c == '/'){
                doOperation(ms, buffer, c, 2);
            } else if (c == '('){
                ms.push(c);
            } else if (c == ')') {
                doRightBracket(ms, buffer);
            } else {
                buffer.append(c);
            }
        }
        while(!ms.isEmpty()){
            buffer.append((char)ms.pop());
        }

        return buffer.toString();
    }

    /**
     * 处理右括号的情况
     *
     * @param ms
     * @param buffer
     */
    private void doRightBracket(MyStack ms, StringBuffer buffer) {
        while (!ms.isEmpty()) {
            char topC = (char)ms.pop();
            if (topC=='(') {
                break;
            } else {
                buffer.append(topC);
            }
        }
    }

    /**
     * 按级别处理操作符
     *
     * @param ms
     * @param buffer
     * @param c
     * @param level
     */
    private void doOperation(MyStack ms, StringBuffer buffer, char c, int level) {
        // 1:依次从栈顶获取一个值
        while (!ms.isEmpty()) {
            char topC = (char) ms.pop();
            // 2： 用这个值跟传入的数据进行比较
            // 2.1: 如果栈顶元素是(, 不动，就是把它压回
            if (topC == '(') {
                ms.push(topC);
                break;
            } else {
                int topLevel = 0;
                if (topC == '+' || topC == '-') {
                    topLevel = 1;
                } else {
                    topLevel = 2;
                }

                if (topLevel >= level) {
                    buffer.append(topC);
                } else {
                    ms.push(topC);
                    break;
                }
            }
        }
        ms.push(c);
    }

    public static void main(String[] args) {
        PostInfix t = new PostInfix();
        String ret = t.doTransfer("(3+2)/5-((7+8)*4-5)");
        System.out.println("ret==="+ret);
    }

}
