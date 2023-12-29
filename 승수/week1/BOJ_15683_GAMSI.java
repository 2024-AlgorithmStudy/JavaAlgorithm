package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] move = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static ArrayList<ArrayList> list = new ArrayList<>();
    static ArrayList<Integer> num = new ArrayList<>();
    static int answer;

    static void cctv1(int x, int y) {
        for (int i = 0; i < 4; i++) {
            boolean[][] arr = new boolean[N][M];
            watch(x, y, i, arr);
            list.get(list.size() - 1).add(arr);
        }
    }

    static void cctv2(int x, int y) {
        for (int i = 0; i < 2; i++) {
            boolean[][] arr = new boolean[N][M];
            watch(x, y, i, arr);
            watch(x, y, i + 2, arr);
            list.get(list.size() - 1).add(arr);
        }
    }

    static void cctv3(int x, int y) {
        for (int i = 0; i < 4; i++) {
            boolean[][] arr = new boolean[N][M];
            watch(x, y, i, arr);
            watch(x, y, i + 1, arr);
            list.get(list.size() - 1).add(arr);
        }
    }

    static void cctv4(int x, int y) {
        for (int i = 0; i < 4; i++) {
            boolean[][] arr = new boolean[N][M];
            watch(x, y, i, arr);
            watch(x, y, i + 1, arr);
            watch(x, y, i + 2, arr);
            list.get(list.size() - 1).add(arr);
        }
    }

    static void cctv5(int x, int y) {
        boolean[][] arr = new boolean[N][M];
        watch(x, y, 0, arr);
        watch(x, y, 1, arr);
        watch(x, y, 2, arr);
        watch(x, y, 3, arr);
        list.get(list.size() - 1).add(arr);
    }

    static void watch(int x, int y, int i, boolean[][] Map) {
        i = i % 4;
        while (y >= 0 && x >= 0 && x < N && y < M && map[x][y] != 6) {
            Map[x][y] = true;
            x += move[i][0];
            y += move[i][1];
        }
    }

    static void DFS(int level) {
        if (level == list.size()) {
            boolean[][] arr = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0) {
                        arr[i][j] = true;
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                performOR(arr, (boolean[][]) list.get(i).get(num.get(i)));
            }


            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!arr[i][j]) {
                        count++;
                    }
                }
            }
            if (count < answer) {
                answer = count;
            }

            return;
        }

        for (int i = 0; i < list.get(level).size(); i++) {
            num.add(i);
            DFS(level + 1);
            num.remove(num.size() - 1);
        }
    }

    // 2차원 boolean 배열의 각 요소에 OR 연산 수행하는 메서드
    static void performOR(boolean[][] array, boolean[][] array2) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                // 각 요소에 OR 연산 수행
                array[i][j] |= array2[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N x M 크기 맵 (1 ≤ N M ≤ 8)
        // 0은 빈 칸, 6은 벽, 1~5는 CCTV 의 번호이다
        // 사각 지대의 최소 크기를 출력
        // CCTV 최대 개수는 8개 -> 1번이 8개라고 했을 떄 최대 가짓 수 4^8 -> 2^ 16 -> 8000가지
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int num = map[i][j];
                if (num > 0 && 6 > num) {
                    list.add(new ArrayList<boolean[][]>());
                    switch (num) {
                        case 1:
                            cctv1(i, j);
                            break;
                        case 2:
                            cctv2(i, j);
                            break;
                        case 3:
                            cctv3(i, j);
                            break;
                        case 4:
                            cctv4(i, j);
                            break;
                        case 5:
                            cctv5(i, j);
                            break;
                    }
                }
            }
        }
        DFS(0);
        System.out.print(answer);
    }
}