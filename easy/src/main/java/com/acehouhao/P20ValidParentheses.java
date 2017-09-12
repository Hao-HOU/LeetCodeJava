package com.acehouhao;

import java.util.Stack;

/**
 * @author houhao
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid. The brackets must close in the correct
 * order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 */
public class P20ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]{}[][][][](){}[][])";
        long start = System.currentTimeMillis();
        System.out.println(isValid(s) + "--" + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();
        System.out.println(isValidOther(s) + "--" + (System.currentTimeMillis() - start) + " ms");
    }

    //我的解法
    public static boolean isValid(String s) {
        Stack st = new Stack();
        for (String c : s.split("")) {
            //空栈的时候压栈
            if (st.empty()) {
                st.push(c);
            } else {
                //栈不为空时，如果当前c与栈顶元素匹配，则弹出；否则压栈
                if (st.peek().equals("(")) {
                    if (c.equals(")")) {
                        st.pop();
                    } else {
                        st.push(c);
                    }
                } else if (st.peek().equals("[")) {
                    if (c.equals("]")) {
                        st.pop();
                    } else {
                        st.push(c);
                    }
                } else if (st.peek().equals("{")) {
                    if (c.equals("}")) {
                        st.pop();
                    } else {
                        st.push(c);
                    }
                } else {
                    st.push(c);
                }
            }
        }
        //若合法，最终栈应为空
        return st.empty();
    }

    //别人的解法
    public static boolean isValidOther(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
