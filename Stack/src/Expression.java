import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

    private List<Character> leftBrackets
            = Arrays.asList('(', '<', '[');
    private List<Character> rightBrackets
            = Arrays.asList(')', '>', ']');

    public boolean isBalance(String input) {
        Stack<Character> stack = new Stack<>();

        // 遍历字符串中的每个字符
        for (char ch : input.toCharArray()) {

            // 遇到左括号时，压入栈中
           if (isLeftBracket(ch))
                stack.push(ch);
            }

            // 遇到右括号时，检查是否匹配栈顶的左括号
            if (isRightBracket(ch)){
                // 如果栈为空，说明没有匹配的左括号
                if (stack.empty())
                    return false;

                // 弹出栈顶的左括号
                var top = stack.pop();

                // 检查左右括号是否匹配
                if (!bracketsMatch(top,ch)) {
                    return false;
                }
            }


        // 如果栈为空，说明所有括号都匹配；否则返回 false
        return stack.isEmpty();
    }

    private boolean isLeftBracket(char ch) {

        return leftBrackets.contains(ch);
    }
    private boolean isRightBracket(char ch) {

        return rightBrackets.contains(ch);
    }

    private boolean bracketsMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }

//    总结
//    逻辑要点：
//
//    左括号压入栈，右括号匹配栈顶的左括号。
//    检查左右括号是否在对应的列表中，并通过索引确保匹配关系。
//    时间复杂度：O(n)
//
//    遍历字符串每个字符一次，栈的操作（push 和 pop）时间复杂度为 O(1)。
//    空间复杂度：O(n)
//
//    最坏情况下，所有的字符都是左括号，全部压入栈。




//    public static void main(String[] args) {
//        Expression expression = new Expression();
//
//        // 测试示例
//        System.out.println(expression.isBalance("(<{[()]}>"));  // true
//        System.out.println(expression.isBalance("(<{[]>})"));   // true
//        System.out.println(expression.isBalance("(]"));         // false
//        System.out.println(expression.isBalance("((<>)"));      // false
//        System.out.println(expression.isBalance("([)]"));       // false
//        System.out.println(expression.isBalance("{[()]}"));     // true
//    }

//    在栈中，pop() 操作会将栈顶的元素移除并返回它的值，被弹出的元素不会再放回栈中。
    // 顺序不对也返回false
}
