package Review;

public class StringTest {
    //打印结果  false false ture
    public static void main1(String[] args) {
        String a = "abc";
        String b = new String("abc");
        String c = a.intern();
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(a == c);
    }

    public static void main2(String[] args) {
        String str1 = "abc";
        String str2 = new String("abcd");
        String str3 = new String("abc");
        //产生了4个对象，分别是第一行一个，第二行两个，由于第三行中"abc"与常量池中的str1="abc"相等，所以只产生一个对象
    }

    public static void main(String[] args) {
        //复用常量池
        String str1 = "abc";
        //复用常量池
        String str2 = "ab";
        //复用常量池
        String str3 = "c";
        //字符串变量的拼接，javac编译之后 -> StringBuilder
        //StringBuilder sb   sb.append(str2).append(str3)
        //sb.toString
        String str4 = str2 + str3;
        String str5 = "ab" + "c";
        String str6 = str2 + str3;
        String str7 = "ab" + str3;
        System.out.println(str1 == str7);
        System.out.println(str4 == str7);
        System.out.println(str1 == str4);//false
        System.out.println(str1.equals(str4));//true
        System.out.println(str4 == str5);//false
        System.out.println(str1 == str5);//true
        System.out.println(str4 == str6);//false
        System.out.println(str1 == str7);
        System.out.println(str4 == str7);
    }
}
