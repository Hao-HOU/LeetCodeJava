package com.acehouhao;

/**
 * Created by Hao HOU on 2017/6/4.
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows
 * like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class P06ZigZagConversion {
    private static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;//行数为1的时候，直接返回输入字符串
        }
        StringBuilder result = new StringBuilder();
        int r = numRows - 1;//去掉下标为0的字符后，其实每列的字符数为numRows-1
        for (int i = 0; (i * r) < s.length(); i += 2) {
            result.append(s.charAt(i * r));//转换后第一行的字符
        }

        //出去第一行和最后一行外的其他行
        for (int i = 1; i < r && i < s.length(); i++) {
            //此处的 i < s.length() 用来处理类似convert("A", 3)这样的情况
             result.append(s.charAt(i));//第一列的为1,2,3,4...
            for (int j = 2; (j * r) < s.length() + r; j += 2){
                //s.length() + r 此处 +r 用来保证列头下标超过字符串长度的时候能取到左侧的正常范围内的字符
                if ((j * r - i) < s.length()) {
                    result.append(s.charAt((j * r) - i));//列头左侧的
                }
                if ((j * r + i) < s.length()) {
                    result.append(s.charAt((j * r) + i));//列头下方的
                }
            }
        }


        for (int i = 1; (i * r) < s.length(); i += 2) {
            result.append(s.charAt(i * r));//转换后最后一行的字符
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String text = "PAYPALISHIRING";
        System.out.println(convert(text, 2));
        System.out.println(convert("A", 1));
        System.out.println(convert("A", 2));
        System.out.println(convert("A", 3));
        System.out.println(convert("AJHFAJHDBNASDJFHUAEADSFHADYHFUASEHAHDF", 8));
        System.out.println("PAHNAPLSIIGYIR".equals(convert(text, 3)));
        System.out.println("PHASIYIRPLIGAN".equals(convert(text, 5)));
        System.out.println("PRAIIYHNPSGAIL".equals(convert(text, 6)));
    }
}
