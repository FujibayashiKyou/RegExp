package main;

import static java.lang.Integer.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
        public static void main(String[] args) throws Throwable{
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                StringBuilder sb = new StringBuilder();
                
                Comparator<Character> comp = new Comparator<Character>() {
                        public int compare(Character c1, Character c2) {
                                return ((Character)Character.toLowerCase(c1)).compareTo((Character)Character.toLowerCase(c2)) !=0 
                                        ?((Character)Character.toLowerCase(c1)).compareTo((Character)Character.toLowerCase(c2)) : (c1.compareTo(c2));
                        }
                };
                
                for(int n = 0, recordsCount = parseInt(in.readLine().trim()); n < recordsCount; n++){
                        char[] arr = in.readLine().toCharArray();
                        Character[] arr1 = new Character[arr.length];
                        
                        for(int i = 0; i < arr.length; i++) arr1[i] = arr[i];
                        Arrays.sort(arr1, comp);
                        
                        for(Character w: arr1) sb.append(w);
                        sb.append("\n");
                        
                        for(Character[] res = arr1; (res = next_permutation(res, comp, (Character)Character.MAX_VALUE)) != null; ){
                                for(Character w: res) sb.append(w);
                                sb.append("\n");
                        }
                }
                System.out.print(new String(sb));
        }
        
        static <T> T[] next_permutation(T[] arr, Comparator<? super T> comp, T max_value){
            int I = -1; T min = null; boolean ws = false;
            for (int i = arr.length - 1; i >= 0 && !ws; i--) {
                min = max_value;
                for(int j = arr.length - 1; j > i && !ws; j--){
                        min = comp.compare(arr[j], arr[i]) > 0 ? 
                                (comp.compare(arr[j], min) < 0 ? arr[j] : min) : min;
                        if(ws = comp.compare(arr[i], arr[j]) < 0) I = i;
                }
            }
                if(I == -1)return null;
                T[] res = (T[])Array.newInstance(arr.getClass().getComponentType(), 
                        arr.length), 
                        temp = (T[])Array.newInstance(arr.getClass().getComponentType(), 
                        arr.length - I);
                
            for (int j = I; j < arr.length; j++) temp[j - I] = arr[j];
            Arrays.sort(temp, comp); ws = false;
            
            for (int j = 0, i = 0; j < res.length; j++)
                if (j <= I) res[j] = j < I  ? arr[j] : min;
                    else if(!ws && temp[i]==min){ i++; res[j]=temp[i++]; ws=true; }
                else res[j] = temp[i++];
            return res;
        }
}
