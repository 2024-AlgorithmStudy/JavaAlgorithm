import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * x(1) ~ x(n)
 *
 * 가장 인접한 두 공유기 사이의 거리를 가능한 크게
 * 최소 거리
 * 
 * N = 200,000       ->  for 1 번?
 * x = 1,000,000,000
 *
 * ### 못 풀어서 힌트 참고 ###
 * (i) 공유기 설치 집에서 (t)이상의 거리 떨어진 곳에 (i+1)번째 공유기 설치
 * 단 2개만 생각...
 *
 * */
public class B_2110 {
        static int N,C;
        static int[] position;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        position = new int[N];
        for(int i = 0; i < N ; i ++){
            position[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(position);

        // 양 끝에는 항상 존재해야할 듯? > C - 2

        /**
         * 1. 공유기 배정 : idx 위치 ( 1 , N-1 고정 )
         * 2. min 값 : position[idx2] - position[idx1] ( 1 ~ position[N-1] - position[0] )
         * */

        System.out.println(find(position));

    }

    public static int find(int[] position){
        int start = 1, last = position[N-1] - position[0];  // 사이거리


        while(start <= last){
            int count = 1; // 공유기 개수
            int mid = (start + last) / 2; // 최소 거리
            
            int curPo = position[0];

            if(C == 2){
                return last;

            }else{ // C >= 3

                for(int i = 1 ; i< position.length; i++){
                    if(position[i] > curPo + mid){  // 떨어진 간격 > 현재위치 + 최소거리
                        curPo = position[i];        // 위치 이동
                        count ++;
                    }
                }

                if(count < C){
                    last = mid - 1; // count ( 공유기 개수 늘리려면 ) -> 최소 거리 감소해야함

                }else {
                    start = mid + 1;
                }
            }
        }

        return start;
    }

}
