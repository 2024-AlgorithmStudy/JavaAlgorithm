package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CutWood {

    static long calLast(int length,int[] woods){
        long last = 0;
        for(int i=0;i<woods.length;i++){
            if (woods[i] > length) {
                last += woods[i] - length;
            }
        }
        return last;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] woods = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            woods[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0,right = 2000000000;

        while (left < right) {
            int mid = (left + right) / 2;
            long last = calLast(mid, woods);
//            System.out.println(last+" "+left+" "+right);

            if (last >= M) {
                left=mid+1;
            }else {
                right=mid;
            }
        }

        System.out.println(left-1);
    }
}
