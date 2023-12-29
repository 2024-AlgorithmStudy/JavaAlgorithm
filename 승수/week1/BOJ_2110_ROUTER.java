package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Router {
    static int[] house;
    static int N,C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //N (2 ≤ N ≤ 200,000)
        C = sc.nextInt();
        house= new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = sc.nextInt();
        }
        Arrays.sort(house); //번호 순으로 정렬

        int left = 1;
        int right = house[N-1] - house[0]+1;

        while(left<right){
            int mid = (left + right) / 2;
            if(install(mid)<C){
                right = mid;
            }else {
                left = mid+1;
            }
        }

        System.out.println(left-1);
    }

    private static int install(int x) {
        // 첫 번째 집은 무조건 설치한다고 가정
        int count = 1;
        int last = house[0];

        for(int i = 1; i < house.length; i++) {
            int locate = house[i];
            if(locate - last >= x) {
                count++;
                last = locate;
            }
        }
        return count;
    }
}
