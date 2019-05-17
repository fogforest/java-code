package com.ting.wong.code.java.core.utils.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * java正则表达式测试类
 * 参考
 * @see <a href="http://www.cnblogs.com/deerchao/archive/2006/08/24/zhengzhe30fengzhongjiaocheng.html#lookaround</a>
 * @author Ting Wong
 * @version 1.0
 **/
public class RegexUtils {

    /**
     * IP匹配
     */
    private static final Pattern IP = Pattern.compile("((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)");

    /**
     * <aabb112334>
     */
    private static final Pattern POINTED_BRACKET= Pattern.compile("<[^>]+>");

    /**
     * hello hello
     */
    private static final Pattern REPEAT_WORD = Pattern.compile("\\b(\\w+)\\b\\s+\\1\\b");

    /**
     * hello hello
     */
    private static final Pattern REPEAT_WORD2 = Pattern.compile("\\b(?<Word>\\w+)\\b\\s+\\k<Word>\\b");

    /**
     * " b "空格中间的字符
     */
    private static final Pattern SPACE_DIGITAL = Pattern.compile("(?<=\\s)\\w+(?=\\s)");

    /**
     * "breaking" 匹配以ing结束:break
     */
    private static final Pattern END = Pattern.compile("\\b\\w+(?=ing\\b)");

    /**
     * 包含后面不是字母a的字母q的单词，不能q结尾
     */
    private static final Pattern Q_NO_A_NULL = Pattern.compile("\\b\\w*q[^a]\\w*\\b");

    /**
     * 包含后面不是字母a的字母q的单词，可以q结尾
     */
    private static final Pattern Q_NO_A = Pattern.compile("\\b\\w*q(?!u)\\w*\\b");

    /**
     * 简单的HTML标签<b>a</b>
     */
    private static final Pattern HTML_TAG = Pattern.compile("(?<=<(\\w)>).*(?=</\\1>)");

    /**
     * 提取大括弧内容${key},提取KEY
     */
    private static final Pattern PARAM_PATTERN = Pattern.compile("(?<=\\$\\{)(\\w+?)(?=\\})");


    public static void main(String[] args) {

        Matcher matcher1 = IP.matcher("255.0.0.1");
        System.out.println(matcher1.matches());

        Matcher matcher2 = POINTED_BRACKET.matcher("<4562345>");
        System.out.println(matcher2.matches());

        Matcher matcher3 = REPEAT_WORD.matcher("haha haha");
        System.out.println(matcher3.matches());

        Matcher matcher4 = SPACE_DIGITAL.matcher("1b1");
        System.out.println(matcher4.find());
        System.out.println(matcher4.group());

        Matcher matcher5 = END.matcher("dancing");
        System.out.println(matcher5.find());
        System.out.println(matcher5.group());

        Matcher question = Q_NO_A_NULL.matcher("aqua");
        System.out.println(question.matches());

        Matcher iraq = Q_NO_A.matcher("iraq");
        System.out.println(iraq.matches());

        Matcher matcher = HTML_TAG.matcher("<b>a</b>");
        System.out.println(matcher.find());
        System.out.println(matcher.group());

        String in = "${a}/${b}/{c}//${d/}/${e}/f}";
        List<String> ls=new ArrayList<String>();
        Matcher matcher6 = PARAM_PATTERN.matcher(in);
        while(matcher6.find()){
            ls.add(matcher6.group());
        }
        System.out.println(ls);

    }

}
