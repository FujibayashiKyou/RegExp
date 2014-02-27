/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thinking_in_java;

interface Actions{
    void action1();
    void action2();
}


class RealMen implements Actions{
    
    @Override
    public void action1() {
        System.out.println("Real men: action 1");
    }

    @Override
    public void action2() {
        System.out.println("Real men: action 2");
    }
    
}


class VirtualMen implements Actions {
    private Actions real;
    
    VirtualMen(Actions actions){
        this.real = actions;
    }

    @Override
    public void action1() {
        System.out.println("Virtual men: action 1");
        real.action1();
    }

    @Override
    public void action2() {
        System.out.println("Virtual men: action 2");
        real.action2();
    }
    
}

public class SimplyProxyTest {
    public static void consumer(Actions actions){
        actions.action1();
        actions.action2();
    }
    
    public static void main(String[] args){
        consumer(new RealMen());
        consumer(new VirtualMen(new RealMen()));
    }
}
