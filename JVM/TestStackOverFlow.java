package Review.Test.JVM;


/**
 * 测试单线程下StackOverFlow
 */
public class TestStackOverFlow {
    private int stackLength = 1;
    public void stackLeak(){
        this.stackLength++;
        stackLeak();
    }
    public static void main(String[] args) {
        TestStackOverFlow test = new TestStackOverFlow();
        test.stackLeak();
    }
}
