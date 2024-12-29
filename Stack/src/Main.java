import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        var top = stack.pop();
        System.out.println(top);
        top = stack.peek();
        System.out.println(top);

        String str = "abcd";

        StringReverser reverser = new StringReverser();
//        这里使用了 new 关键字来创建 StringReverser 类的一个对象。
//        reverser 是这个对象的引用，可以用来调用 StringReverser 类中的方法。


        String result = reverser.reverse("hello");

//        reverser.reverse("hello") 调用了 StringReverser 类中的 reverse 方法，并传入字符串 "hello" 作为参数。
//        方法的返回值是反转后的字符串 "olleh"。
//        这个返回值被赋值给变量 result。



        System.out.println(result); // 输出: "olleh"

        String str1 = "(1+2)";

        Expression exp = new Expression();
        var result1 = exp.isBalance(str1);
        System.out.println(result1);








    }
}