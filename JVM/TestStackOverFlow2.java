package Review.Test.JVM;

/**
 * 测试多线程下的StackOverFlow
 */
public class TestStackOverFlow2 {

    private void dontStop(){
        while(true){

        }
    }
    public void stackOverFlowByThread(){
        while(true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        TestStackOverFlow2 test = new TestStackOverFlow2();
        test.stackOverFlowByThread();
    }
}
