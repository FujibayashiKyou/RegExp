/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thinking_in_java;

/**
 *
 * @author ANDRON
 */

class WithInner{
    class Inner{

    }
}

public class Extend_nested_class extends WithInner.Inner {
    
    Extend_nested_class (WithInner wi){
        wi.super();
    }
    
    public static void main(String[] args){
        WithInner wi = new WithInner();
       
    }
}
