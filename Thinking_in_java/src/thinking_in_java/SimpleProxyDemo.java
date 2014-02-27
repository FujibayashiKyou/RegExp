package thinking_in_java;

interface Interfaces{
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interfaces {

    public void doSomething() {
        System.out.println("doSomething() ");
    }

    public void somethingElse(String arg) {
        System.out.println("somethingElse() " + arg);
    }
}

class SimplyProxy implements Interfaces {
    private Interfaces proxied;

    SimplyProxy(Interfaces proxied) {
        this.proxied = proxied;
    }
    
    public void doSomething() {
        System.out.println("SimplyProxy doSomething() ");
        proxied.doSomething();
    }

    public void somethingElse(String arg) {
        System.out.println("SimplyProxy somethingElse() " + arg);
        proxied.somethingElse(arg);
    } 
}

class SimplyProxyDemo {
    public static void consumer(Interfaces iFace){
        iFace.doSomething();
        iFace.somethingElse("bongo-bongo");
    }
    
    public static void main(String[] args){
        consumer(new RealObject());
        consumer(new SimplyProxy(new RealObject()));
    }
}
