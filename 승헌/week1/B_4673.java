
/**
 * d(n) =  n과 n의 각 자리수를 더하는 함수
 * n을 d(n)의 생성자
 * 101은 생성자가 2개(91과 100)
 * 생성자가 없는 숫자 -> 셀프 넘버
 *
 * 구 : 10000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력
 *
 * */
public class B_4673 {

    static boolean[] dp = new boolean[10001];
    public static void main(String[] args) {

        for(int i = 1 ; i<=10000;i++){

            check(i);
            if(dp[i])
                continue;
            System.out.println(i);
        }

    }
    static void check(int i){
        int sum = i ;
        while(i != 0){
            sum += i % 10;
            i/=10;
        }

        if(sum <= 10000)
            dp[sum] = true;

    }

}
