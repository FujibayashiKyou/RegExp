/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thinking_in_java;

/**
 *
 * @author ANDRON
 */

interface Contents{
    int value();
}

interface Destination{
    String readLabel();
}

public class Nested_Class {
    
    private static class ParcelContents implements Contents{
        private int i = 11;
        public int value() { return i; }
    }
    
    protected static class ParcelDestination implements Destination {
        private String label;
        private ParcelDestination(String whereTo){
            label = whereTo;
            AnotherLevel al = new AnotherLevel();
            f();
        }
        public String readLabel(){ return label; }
        
        //Вложеные классы, могут сожержать и другие статические переменные
        public static void f() { System.out.println("f() start!"); }
        static int x = 15;
        
        static class AnotherLevel{
            public static void f() {System.out.println("AnotherLevel f() start!");};
            
            private AnotherLevel(){
                System.out.println("Another level start!");
                System.out.println("x = " + x);
                f();
            }
        }  
    }
    
    public static Destination destination (String s) {
        System.out.println("Destination destination start!");
        return new ParcelDestination(s);
    }
    
    public static Contents contents(){
        System.out.println("Contents contents start!");
        return new ParcelContents();
    }
    
    public static void main (String[] args){
        Contents c = contents();
        Destination d = destination("Tasmania");
        
    }
    
}
