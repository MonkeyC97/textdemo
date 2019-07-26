##### 1.Math.round(11.5)等于：12

Math类是java.lang包中定义好的类，主要方法有:

```java
Math.max():最大值
Math.min():最小值
Math.round():绝对值
Math.ceil():向上取整（天花板）
Math.floor():向下取整（地板）
```



##### 编程题1:

求俩数的最小公倍数

```java
import java.util.Scanner;

/**
 * 求最小公倍数
 * 思想：先求两个数的最大公约数，然后用俩数的乘积除以最大公约数就得俩数的最小公倍数
 * 使用辗转相除法求得两个数的最大公约数
 */
public class Test10_2 {
    public static int lcm(int m,int n){
        return (m * n) / gcd(m,n);
    }
    private static int gcd(int a,int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b,a % b);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(lcm(a,b));
    }

}
```

