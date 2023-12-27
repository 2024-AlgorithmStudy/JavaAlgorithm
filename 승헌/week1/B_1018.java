import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다
 * 아무데서나 8×8 크기의 체스판으로 잘라낸 후
 * 다시 칠해야 하는 정사각형의 최소 개수
 *
 * 시간 복잡도 : O(N^2)
 * */
public class B_1018 {
    static int N,M ;
    static char[][] graph;
    static String input;
    static int min = 2500;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
        StringTokenizer st = new StringTokenizer(br.readLine()); //String)
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];

        for(int row = 0 ; row < N ; row ++){
            input = br.readLine();
            for(int col = 0 ; col < M ; col ++){
                if(input.charAt(col) == 'W') {
                    graph[row][col] = 'W';
                }else{
                    graph[row][col] = 'B';
                }
            }
        }

        for(int srow = 0; srow <= N - 8  ; srow ++){
            for(int scol = 0 ; scol <= M - 8 ; scol ++){
              min = Math.min(check(graph,srow,scol),min);
            }
        }

        System.out.println(min);
    }

    /**
     * ( row + col ) % 2 == 0
     * ( row + col ) % 2 == 1    => W , B 달라야 함..
     * */
    static public int check(char[][] graph ,int srow , int scol ){
        int wscount = 0 , bscount = 0; // W로 시작 OR B로 시작
        int div = (srow + scol) % 2;  // 0 OR 1

        for(int row = srow ; row < srow + 8 ; row ++){
            for (int col = scol ; col < scol + 8 ; col ++){

                if((row + col) % 2 == div){ // 시작 위치
                    if(graph[row][col] != 'W'){
                        wscount++;
                    }else if(graph[row][col] != 'B'){
                        bscount ++;
                    }
                }else{ // 1
                    if(graph[row][col] != 'B'){
                        wscount++;
                    }else if(graph[row][col] != 'W'){
                        bscount++;
                    }
                }
            }
        }

        return Math.min(wscount,bscount);
    }
}
