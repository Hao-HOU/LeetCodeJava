package com.acehouhao;

/**
 * Created by Hao HOU on 2017/6/4.
 *
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n, generate the nth sequence.
 * 注意：1->11->21->1211->111221->312211->...
 * 下一个是上一个按照读规则产生的！！！
 *
 * Note: The sequence of integers will be represented as a string.
 */
public class P38CountAndSay {
    private static String countAndSay(int n) {
//        此处理解错了题意，但这段代码是生成正确序列的基础。
//        StringBuilder result = new StringBuilder();
//        int count = 1;
//        int i;
//        String ns = n + "";
//        for (i = 0; i < ns.length() - 1; i++) {
//            if (ns.charAt(i) == ns.charAt(i + 1)) {
//                count++;
//                continue;
//            }
//            result.append(count);
//            result.append(ns.charAt(i));
//            count = 1;
//        }
//        if (i == ns.length() - 1) {
//            result.append(count);
//            result.append(ns.charAt(i));
//        }
//
//        return result.toString();

        String ns = "1";//输入为1时，直接返回"1"
        //输入大于等于2时，需要在前一个字符序列的基础上生成当前的字符序列
        for (int j = 2; j <= n; j++) {
            StringBuilder result = new StringBuilder();//用于存储字符序列
            int count = 1;//一个字符出现的次数
            int i;//已比较字符的下标
            for (i = 0; i < ns.length() - 1; i++) {
                if (ns.charAt(i) == ns.charAt(i + 1)) {
                    count++;
                    continue;//两字符相同，数量加一，直接继续循环，不执行该if后面的语句
                }
                result.append(count);
                result.append(ns.charAt(i));//相同字符比较完后，将数量与字符一起拼接到字符序列末尾
                count = 1;//重置计数
            }
            result.append(count);//最后一个字符与前面相同则continue语句执行后到此处，若不相同则for循环结束置为1到此处
            result.append(ns.charAt(i));//拼接最后一个字符的数量及该字符
            ns = result.toString();//当前序列赋值给ns，以便循环生成下一个序列或返回该结果序列
        }
        return ns;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(8));
    }
}
