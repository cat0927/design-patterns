package designpattern.prototype;

/**
 * DATE  2019-08-19
 * Product 具体实现
 *
 *
 */
public class MessageBox implements Product {
    private char decochar;

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }


    public void use(String s) {
        int lenght = s.getBytes().length;
        for (int i = 0; i < lenght + 4; i++) {
            System.out.print(decochar);
        }
        System.out.println("");
        System.out.println(decochar + "" + s + "" + decochar);
        for (int i = 0; i < lenght + 4; i++) {
            System.out.print(decochar);
        }
        System.out.println("");
    }

    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
}
