package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Router {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(); // 각 집 사이의 거리 list
        // 거리 짧은 순으로 queue 에 넣기
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[1] - b[1];
        });
        int N = sc.nextInt(); //N (2 ≤ N ≤ 200,000)
        int C = sc.nextInt();
        int house[] = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = sc.nextInt();
        }
        Arrays.sort(house); //번호 순으로 정렬

        for (int i = 0; i < N; i++) {
            int length =  house[i+1] - house[i];
            list.add(length); // list 0 -> 0~1번째 집 사이의 거리
            pq.add(new int[]{i, length}); // i부터 i+1번 까지 집 거리
        }

        for(int  i = 0 ; i< N - C ; i++){

        }

//        while (list.size()>C-1){
//            int[] temp = pq.poll();
//            if(temp[0]==0) {
//                //오른쪽 거리와 합침
//                pq.remove(new int[]{})
//            } else if (temp[0]==list.size()-1) {
//                // 왼쪽 거리와 합침
//            }else{
//                // 오른쪽 왼쪽 거리 중 작은 값과 합침
//
//            }
//        }
        // C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램
        // 모든 거리를 잰다. PriorityQueue 에 넣는다 <거리,left,right> 로
        // 가장 짧은 거리의 house를 옆의 짧은 house랑 합친다 .
        // 옆의 짧은 house를 PriorityQueue에서 꺼낸다 .
        // 합친 거리 + index 를 PriorityQueue에 넣는다 . ( index 처리는 어떻게 할 것인가? )


    }
}
