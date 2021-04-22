package day01;
//정올 1695

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int[][] arr;
	public static int N;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String msg = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = msg.charAt(j) - '0'; // 정수형으로 바꾸기
			}
		}
		int cnt = 0;

		// 부모찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					cnt++;// 동굴입구=1
					dfs(i, j, cnt + 1);// 동굴에 연결된 장소 모두 '2'로 마킹
				}
			}
		}
		System.out.println(cnt);// 땅굴의 개수
		
		
		int holecnt[] = new int[cnt];//땅굴의 크기

		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] > 1) {
					holecnt[arr[i][j]-2]++;
				}
			}
		}
		
		Arrays.sort(holecnt);
		
		for (int i = 0; i < cnt; i++) {
			System.out.println(holecnt[i]);
		}

	}

	// 상하좌우 컨트롤
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 아파트단지, 두더지굴
	public static void dfs(int x, int y, int no) {
		arr[x][y] = no;

		// 그래프 탐색은 상하좌우로 찾음
		// 막힌 경우 제외해야함
		// 1인 경우에만 가기
		for (int i = 0; i < 4; i++) {
			int newx = x + dx[i];
			int newy = y + dy[i];

			if (0 <= newx && newx < N && 0 <= newy && newy < N && arr[newx][newy] == 1) {
				dfs(newx, newy, no);
			}
		}
	}
}
