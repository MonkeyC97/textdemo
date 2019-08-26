package Review.Test.reflect.Proxy;

import Review.Test.reflect.ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface ISubject{
    public void eat(String msg,int num);
}

class RealSubject implements ISubject{

    @Override
    public void eat(String msg, int num) {
        System.out.println("我要吃"+num+"个"+msg);
    }
}

/*
动态代理类
 */

class ProxySubject implements InvocationHandler{
    //绑定任意接口的对象，使用Object
    private Object target;

    /**
     * 实现真实对象的绑定处理，同时返回代理对象
     * @param target
     * @return 返回一个代理对象，这个对象是根据接口对象动态生成的
     */
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    public void preHandle(){
        System.out.println("处理之前");
    }
    public void afterHandle(){
        System.out.println("处理之后");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.preHandle();
        Object obj = method.invoke(this.target,args);
        this.afterHandle();
        return  obj;
    }
}


public class Test {
    public static void main(String[] args) {
        ISubject subject = (ISubject) new ProxySubject().bind(new RealSubject());
        subject.eat("草莓",3);
    }
}
