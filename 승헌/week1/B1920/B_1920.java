package B1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N(1 ≤ N ≤ 100,000)
 * M(1 ≤ M ≤ 100,000)
 *
 * 2중 for -> 1억넘음
 *  -2^31 ~ 2^31
 *
 * */
public class B_1920 {
    static int N,M;
    static int[] nArr;

    public static void main(String[] args) throws IOException {

        /**
         * StringBuilder 사용시 : 756 / 604
         *
         * 단순 System.out.println : 1404 / 1284 / 1392 /
         * */
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        /**
         * 41344	604
         * */
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        nArr = new int[N];
//        for(int i = 0 ; i< N ; i ++){
//            nArr[i] = Integer.parseInt(st.nextToken());
//        }
//        Arrays.sort(nArr);

        /**
         * 45716	756
         * */
        nArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i< M ; i ++){
            int exist = Arrays.binarySearch(nArr, Integer.parseInt(st.nextToken()));
            sb.append(exist >= 0 ? 1 : 0).append("\n");
        }

        System.out.println(sb);

    }
}
