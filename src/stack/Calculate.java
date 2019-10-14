package stack;

/**
 * @author gewei
 * @date 2019/10/14
 */
public class Calculate {
    public int calculate(String str) {
        MyStack ms = new MyStack(20);
        char[] cs = str.toCharArray();
        for(int i=0;i<cs.length;i++){
            char c = cs[i];
            if(c >= '0' && c <= '9'){
                ms.push((int)(c-'0'));
            }else{
                int num2 = ms.pop();
                int num1 = ms.pop();
                int temp = 0;
                if(c=='+'){
                    temp = num1+num2;
                }else if(c=='-'){
                    temp = num1-num2;
                }else if(c=='*'){
                    temp = num1*num2;
                }else if(c=='/'){
                    temp = num1/num2;
                }
                ms.push(temp);
            }
        }
        return ms.pop();
    }
    public static void main(String[] args) {
        Calculate t = new Calculate();

        String str = new PostInfix().doTransfer("((7+9)/3-4)*3-9");

        int ret=t.calculate(str);
        System.out.println("ret=="+ret);
    }

}
