package main;

import static java.sql.Types.NULL;
import java.util.Scanner;

/**
 *
 * @author FujibayashiKyou
 */
public class ProblemD_The_dominoes_solitair {
    private static int Spaces,NumOfPieces;
    private static final int Pieces[][] = new int[205][2];
    private static final boolean Visited[] = new boolean[205];
    
    static boolean BackTrack(int Last, int Depth){
        if(Depth == Spaces) {
            if(Last == Pieces[1][0]) return true;
            return false;
        }
        
        for(int i = 1 ; i < NumOfPieces + 1 ; i++ ) {
            if(Visited[i]) continue;
            Visited[i] = true;
            if(Pieces[i][0] == Last)
                if(BackTrack(Pieces[i][1], Depth + 1)) return true;
            
            if(Pieces[i][1] == Last)
                if(BackTrack(Pieces[i][0], Depth + 1)) return true;
            
            Visited[i] = false;
        }    
        return false;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            Spaces = sc.nextInt();
            if (Spaces == 0) break;
            
            NumOfPieces = sc.nextInt();
            NumOfPieces+=2;
            
            for( int i = 0 ; i < NumOfPieces ; i++ ) {
                Pieces[i][0] = sc.nextInt();
                Pieces[i][1] = sc.nextInt();
            }
            Visited[0] = Visited[1] = true;
            
            System.out.println((BackTrack(Pieces[0][1],NULL)) ? "YES" : "NO");
        }
    }
}
