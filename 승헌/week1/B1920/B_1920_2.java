package B1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B_1920_2 {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new HashSet<>();
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        /**
         * https://hbase.tistory.com/185
         *
         * List - contains O(n)
         *
         * set 의 contains 시간복잡도 O(1)
         * TreeSet O(log N)
         *
         * */

        for(int i = 0; i< M ; i ++){
            sb.append(set.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
        }

        System.out.println(sb);

    }
}
