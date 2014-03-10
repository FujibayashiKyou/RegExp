package main;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class I_Can_Guess_the_Data_Structure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        boolean is_queue, is_stack, is_p_queue;
        Queue<Integer> queue = new LinkedList<Integer>();
        PriorityQueue<Integer> priority = new PriorityQueue<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder out = new StringBuilder();

        int n;
        do {
            n = sc.nextInt();
            
            is_queue = is_stack = is_p_queue = true;
            stack.clear();
            queue.clear();
            priority.clear();
 
            for (int i = 0; i < n; i++) {
                int com = sc.nextInt();
                int val = sc.nextInt();
                
                if (com == 1) {
                    stack.push(val);
                    queue.add(val);
                    priority.add(-val);
                } else {
                    if (is_stack) {
                        if (stack.isEmpty()) is_stack = false;
                        else {
                            if (stack.pop() != val) is_stack = false;
                        }
                    }
                    if (is_queue) {
                        if (queue.isEmpty()) is_queue = false;
                        else {
                            if (queue.poll() != val) is_queue = false;
                        }
                    }
                    if (is_p_queue) {
                        if (priority.isEmpty()) is_p_queue = false;
                        else {
                            if (-1 * priority.poll() != val) is_p_queue = false;
                        }
                    }
                }
            }
            if (!is_queue && !is_stack && !is_p_queue)
                out.append("impossible\n");
            else if (is_queue && !(is_stack || is_p_queue))
                out.append("queue\n");
            else if (is_stack && !(is_queue || is_p_queue))
                out.append("stack\n");
            else if (is_p_queue && !(is_stack || is_queue))
                out.append("priority queue\n");
            else
                out.append("not sure\n");
            
        } while (sc.hasNext()); 
        System.out.print(out);
    }
}