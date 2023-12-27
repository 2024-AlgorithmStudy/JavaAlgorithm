import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * K <-> 남은 합 반비례
 * K 최대값 -> M 이상인 값 중 최소 값
 *
 *  N = 1,000,000
 *  M = 2,000,000,000
 *  H = 1,000,000,000
 *
 * */
public class B_2805 {
    static int N,M ;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] tree = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        /**
         *
         * 10 15 17 20     ->  tree[0] <= K init = sum - tree[0] * N -> M 이상이되는 K의 최댓값
         *  4 26 40 42 46
         * 
         * for 1번
         */
        
        int result = binarySearch(tree);

        System.out.println(result);

    }

    static int binarySearch(int[] tree){
        int start = 0, last = tree[N-1];
        long sum ;

        while (start <= last){

            int mid = (start + last)/2;
            sum = 0;
            for (int i : tree) {
                if(i > mid){
                    sum += (i - mid);
                }
            }

            if( sum < M ){
                last = mid - 1;
            }else{
                start = mid + 1 ;
            }
        }

        return last;
    }

}

/**
 * int  ( 4 byte ) : -2,147,483,648 ~ 2,147,483,647
 * long ( 8 byte ) : -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
 *
 * */