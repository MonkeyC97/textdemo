package Review.Test.Generic;
@FunctionalInterface
interface IMyMessage5<R>{
    R switchpara();
}

public class Test19 {
    public static void main(String[] args) {
        IMyMessage5 iMyMessage5 = "hello"::toUpperCase;
        System.out.println(iMyMessage5.switchpara());
    }
}
