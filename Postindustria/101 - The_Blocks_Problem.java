package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 *
 * @author FujibayashiKyou
 */
public class The_Blocks_Problem {
    private static Integer[] pos; //my blocks
    private static Stack<Integer>[] blocks;
    private static BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException{
        String line = "";
        input();
        while(!(line = br.readLine()).equals("quit")){
            String REGEX_WHITESPACE = "\\s+";
            String cleanLine = line.trim().replaceAll(REGEX_WHITESPACE, " ");
            String[] tokens = cleanLine.split(REGEX_WHITESPACE);
        
            //Logic
            int a = Integer.parseInt(tokens[1]);
            int b = Integer.parseInt(tokens[3]);
            
            if(a==b || pos[a] ==pos[b]) continue;
            
            switch(tokens[0]){
                case "move":
                    if(tokens[2].equals("onto")){
                        move_onto(a, b);
                    } else {
                        move_over(a, b);
                    }
                    break;
                case "pile":
                    if(tokens[2].equals("onto")){
                        pill_onto(a, b);
                    } else {
                        pill_over(a, b);
                    }
                    break;
            } //End of switch
        }
        print();
    }
    
    private static void input() throws IOException{
        String line = br.readLine();
        int N = Integer.parseInt(line);
        blocks = new Stack[N];
        pos = new Integer[N];   
        for(int i = 0; i < pos.length; i++) {
            blocks[i] = new Stack<Integer>();
            blocks[i].push(i);
            pos[i] = i;
        }
    }
    
//============================================================================== 
    private static void print(){
        for(int i = 0; i < blocks.length; i++)
            System.out.println(blockToString(i));
    }
    
    private static String blockToString(int i){
        String answer = " ";
        while(!blocks[i].isEmpty())
            answer = " "+ blocks[i].pop() + answer;
 
        answer = i+ ":" + answer;
 
        return answer;
    }
//==============================================================================
    
    private static void move_onto(int a, int b){
        clearAbove(b);
        move_over(a,b);
    }
    
    private static void move_over(int a, int b){
        clearAbove(a);
        blocks[pos[b]].push(blocks[pos[a]].pop());
        pos[a] = pos[b];
    }
    
    private static void pill_onto(int a, int b){
        clearAbove(b);
        pill_over(a,b);
    }
    
    private static void pill_over(int a, int b){
        clearAbove(a);
        Stack<Integer> aPile = new Stack<Integer>();
        while (blocks[pos[a]].peek() != a)
            aPile.push(blocks[pos[a]].pop());
 
        aPile.push(blocks[pos[a]].pop());
 
        while (!aPile.isEmpty()) {
            int top = aPile.pop();
            blocks[pos[b]].push(top);
            pos[top] = pos[b];
        }
    }
    
    private static void clearAbove(int x) {
        while (blocks[pos[x]].peek() != x)
            returnHome(blocks[pos[x]].pop());
    }
     
     private static void returnHome(Integer x) {
        while (!blocks[x].isEmpty()) {
            returnHome(blocks[x].pop());
        }
        blocks[x].push(x);
        pos[x] = x;
    }
}
