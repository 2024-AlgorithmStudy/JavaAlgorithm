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

/**
 * < Comparator<T> 전달해주는 목적으로 사용하는 듯 ? >
 * static <T> int	binarySearch(T[] a, T key, Comparator<? super T> c)
 * - 자연정렬이 아닌 순서로 나열된 배열에서 검색하는 메서드
 * ex) 텍스트1
 *     텍스트10
 *     텍스트100
 *
 *
 *
 * static int	binarySearch(Object[] a, Object key)
 * - 자연 정렬이 된 배열에서 요소의 대소관계를 판단하고 검색하는 메서드 ( 정수 배열, 문자열 배열 )
 * ex) 텍스트 1
 *     텍스트 2
 *     텍스트 3
 * */
