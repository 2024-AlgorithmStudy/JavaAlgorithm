package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNumber {
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        int M = Integer.parseInt(br.readLine());
        int[] find = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            find[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int x = find[i];
            System.out.println(existence(x));
        }
    }

    static int existence(int x) {
        int left = 0;
        int right = num.length-1;

        while(left < right){
            int mid = (left + right) / 2;
            if(num[mid]==x){
                return 1;
            }else if(num[mid]<x){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        if (num[(left+right)/2]==x){
            return 1;
        }
        return 0;
    }
}
