package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChessPan {
    static int N,M;
    static boolean[][] map;
    static boolean[][] chess = {{true,false,true,false,true,false,true,false},
            {false,true,false,true,false,true,false,true},
            {true,false,true,false,true,false,true,false},
            {false,true,false,true,false,true,false,true},
            {true,false,true,false,true,false,true,false},
            {false,true,false,true,false,true,false,true},
            {true,false,true,false,true,false,true,false},
            {false,true,false,true,false,true,false,true}};
    static int findMin(int x,int y){
        int paintCount=0;
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(map[x+i][y+j]!=chess[i][j]){
                       paintCount++;
                }
            }
        }
        return 64-paintCount>paintCount?paintCount:64-paintCount;
    }

    public static void main(String[] args) throws IOException {
        int answer = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                if(str.charAt(j)=='B'){
                    map[i][j]=true;
                }else{
                    map[i][j]=false;
                }
            }
        }

        for(int i=0;i<=N-8;i++){
            for(int j=0;j<=M-8;j++){
                int temp = findMin(i,j);
                if(temp<answer){
                    answer=temp;
                }
            }
        }
        System.out.println(answer);
    }
}
