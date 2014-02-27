package thinking_in_java;

interface Service {
    void method1();
    void method2();
}

interface ServiceFactory {
    Service getService();
}


class Implimintation1 implements Service {
    private Implimintation1(){ }
    public void method1() { System.out.println("Impl1 - method1()"); }
    public void method2() { System.out.println("Impl1 - method2()"); }
    
    //Inner class
    public static ServiceFactory factory = 
            new ServiceFactory(){
                public Service getService() {
                    return new Implimintation1();
                }
            };
}

class Implimintation2 implements Service {
    private Implimintation2(){ }
    public void method1() { System.out.println("Impl2 - method1()"); }
    public void method2() { System.out.println("Impl2 - method2()"); }
    
    //Inner class
    public static ServiceFactory factory = 
            new ServiceFactory(){
                public Service getService() {
                    return new Implimintation2();
                }
            };
}

public class Thinking_in_java {
   public static void serviceConsumer(ServiceFactory fact){
       Service s = fact.getService();
       s.method1();
       s.method2();
   }
    
    public static void main(String[] args) {
        serviceConsumer(Implimintation1.factory);
        serviceConsumer(Implimintation2.factory);
    }
}
