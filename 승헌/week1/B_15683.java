import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * CCTV의 최대 개수는 8개를 넘지 않는다.
 * '#' -> 7 로 표현
 * <p>
 * dx : [ 0, 1, 0, -1 ]
 * dy : [ 1, 0, -1, 0 ]
 * <p>
 * 1 : ( 0 ), ( 1 ), ( 2 ), ( 3 )
 * 2 : ( 0, 2 ), ( 1, 3 )
 * 3 : ( 0, 1 ), ( 1, 2 ), ( 2, 3 ), ( 3, 0 )
 * 4 : ( 0, 1, 2 ), ( 1, 2, 3 ), ( 2, 3, 0 ), ( 3, 0, 1 )
 * 5 : ( 0, 1, 2, 3 )
 */

// ( 1, 5 ) 위치 저장 -> cctv 동작 -> 백트래킹
public class B_15683 {
    static int N, M;
    static int min = 64;
    static int[] dc = {0, 1, 0, -1};
    static int[] dr = {1, 0, -1, 0};
    static int graph[][];
    static int[][][] moveIdx = {
            {},
            {{0}, {1}, {2}, {3}},                         // 1
            {{0, 2}, {1, 3}},                             // 2
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},             // 3
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4
            {{0, 1, 2, 3}}                                // 5
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        List<List<Integer>> cctv = new ArrayList<>(); // [ [ CCTV 값 , srow , scol ] .... ] 형식으로 저장
        List<Integer> position;

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                int val = Integer.parseInt(st.nextToken());
                graph[row][col] = val;
                if (val != 0 && val != 6) {
                    position = new ArrayList<>(); // 위치
                    position.add(val);
                    position.add(row);
                    position.add(col);
                    cctv.add(position); // cctv 위치 추가
                }
            }
        }

        tracking(graph, cctv, 0);

        System.out.println(min);
    }

    static int[][] deepCopy(int[][] graph) {
        int[][] graphCopy = new int[N][M];
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                graphCopy[row][col] = graph[row][col];
            }
        }
        return graphCopy;
    }

    static void tracking(int[][] graph, List<List<Integer>> positions, int recur) {

        if (recur == positions.size()) {
            min = Math.min(zeroCount(graph), min);
            return;
        }

        /** 
         * positions 형태
         * 2 1 1  // position 0
         * 2 3 4  // position 1
         * 5 5 5  // position 2
         * */

        List<Integer> position = positions.get(recur);

        for (int[] moveIdx : moveIdx[position.get(0)]) { // 방향 {

            int[][] copyGraph = deepCopy(graph); // 원본과 별개
            moveGraph(moveIdx, copyGraph, position.get(1), position.get(2)); // move
            tracking(copyGraph, positions, recur + 1); // 백트래킹
        }

    }

    static void moveGraph(int[] moveIdx, int[][] graph, int srow, int scol) {
        for (int idx : moveIdx) { // { 0 , 2 }
            int crow = srow;
            int ccol = scol;
            while (true) {
                crow += dr[idx];
                ccol += dc[idx];

                if (crow >= N || crow < 0 || ccol >= M || ccol < 0 || graph[crow][ccol] == 6)
                    break;

                if (graph[crow][ccol] == 0) {
                    graph[crow][ccol] = 7;
                }
            }
        }
    }

    static int zeroCount(int[][] result) { //

        int count = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (result[row][col] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

}

/**
 * 1. 입력하면서 cctv 위치 저장
 * 2. 백트래킹하면서 원본은 건들면 안될 것 같았음 -> deepcopy -> python과 다르게 java는 2차원은 반복문으로 직접 복사... 해야함 (경험 때문인가??)
 * 3. graph 색칠
 * 4. 0 개수 세기
 *
 * O(N^2)
 *
 * https://www.acmicpc.net/source/70710536
 * https://www.acmicpc.net/source/70428733
 * */