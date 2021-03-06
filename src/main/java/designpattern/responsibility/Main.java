package designpattern.responsibility;

/**
 * DATE  2019-09-01
 * 责任链模式
 *
 */
public class Main {

    public static void main(String[] args) {
        Handler zhangsan = new Director("张三");
        Handler lisi = new Manager("李四");
        Handler blackCatwu = new TopManager("王五");

        // 创建责任链
        zhangsan.setNextHandler(lisi);
        lisi.setNextHandler(blackCatwu);

        // 发起请假申请
        boolean result1 = zhangsan.process(new LeaveRequest("小旋锋", 1));
        System.out.println("最终结果：" + result1 + "\n");

        boolean result2 = zhangsan.process(new LeaveRequest("小旋锋", 4));
        System.out.println("最终结果：" + result2 + "\n");

        boolean result3 = zhangsan.process(new LeaveRequest("小旋锋", 8));
        System.out.println("最终结果：" + result3 + "\n");
    }
}
