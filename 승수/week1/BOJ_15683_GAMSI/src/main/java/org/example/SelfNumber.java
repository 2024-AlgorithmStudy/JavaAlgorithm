package org.example;

public class SelfNumber {
    static boolean[] flag;
    static int eachSum(int N){
        int sum = 0;
        int temp = 10;
        while(N!=0){
            sum += (N % temp)/(temp/10);
            N = N - N % temp;
            temp*=10;
        }
        return sum;
    }
    public static void main(String[] args) {
        flag = new boolean[10001];

        for(int i=1;i<10001;i++){
            int dn=0;
            dn+=i;
            dn += eachSum(i);
            if(dn<=10000) {
                flag[dn] = true;
            }
        }

        for(int i=1;i<10001;i++){
            if(!flag[i]){
                System.out.println(i);
            }
        }
    }
}
