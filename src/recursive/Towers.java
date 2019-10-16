package recursive;

/**
 * 汉诺塔问题
 *
 * @author gewei
 * @date 2019/10/16
 */
public class Towers {
     public void transfer(int topN, String src, String temp, String dest) {
         if (topN == 1) {
             System.out.println(topN + " 从 " + src + " 移动到 " + dest);
         } else {
             transfer(topN - 1, src, dest, temp);
             System.out.println(topN + " 从 " + src +  "移动到 " + dest);
             transfer(topN - 1, temp, src, dest);
         }
     }

    public static void main(String[] args) {
        Towers t = new Towers();
        t.transfer(4, "A", "B", "C");
    }
}
