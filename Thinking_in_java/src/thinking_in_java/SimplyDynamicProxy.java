package thinking_in_java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


class DynamicProxyHandler implements InvocationHandler{
    private Object proxied;
    
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }
    
    //invoke() - получает объект посредника на случай, 
    //если ему понадобится определить, откуда поступил запрос
    public Object invoke(Object proxy, Method method, Object[] args) 
            throws Throwable {
        System.out.print("**** proxy. " + proxy.getClass() + 
                ", method " + method +
                ", args " + args);
        
        if(args!=null)
            for(Object arg : args) System.out.println(" " + arg);
        
        return method.invoke(proxy, args);
    }
    
}

public class SimplyDynamicProxy {
    
    public static void consumer(Interfaces iFace){
        iFace.doSomething();
        iFace.somethingElse("bongo-bongo");
    }
    
    public static void main(String[] args){
        RealObject real = new RealObject();
        consumer(real);
        
        //Вызов посредника
        Interfaces proxy = (Interfaces)Proxy.newProxyInstance(
                Interfaces.class.getClassLoader(),
                new Class[]{Interfaces.class}, 
                new DynamicProxyHandler(real));
        consumer(proxy);
    }
}
