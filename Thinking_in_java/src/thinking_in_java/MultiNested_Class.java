/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thinking_in_java;

/**
 *
 * @author ANDRON
 */

class A{
    public void a(){
        System.out.println("A -> a()");
    }
    
    class B{
        public void ba(){
            System.out.println("B -> ba()");
        }
        public void bb(){
            System.out.println("B -> bb()");
        }
        
        class C{
            class D{
                public void da(){
                    System.out.println("D -> da()");
                }
            }
        }
    }
}

public class MultiNested_Class {
    A a = new A();
    A.B ab = a.new B();
    A.B.C abc = ab.new C();
    A.B.C.D abcd = abc.new D();
    
    

public static void main (String[] args){
    MultiNested_Class mnc = new MultiNested_Class();
    
    mnc.a.a();
    mnc.ab.ba();
    mnc.ab.bb();
    mnc.abcd.da();
}

}
