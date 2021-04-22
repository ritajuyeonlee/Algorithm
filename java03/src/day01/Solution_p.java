package day01;

import java.util.Arrays;

public class Solution_p {
	
	
	public static void main(String[] args) throws Exception{
		

		int n=4;
		int[][] costs= {{0,1,1},
				{0,2,2},
				{1,2,5},
				{1,3,1},
				{2,3,8}};
		
		int answer=0;
		
		
		int minroad=n; //모두 연결하는 길의 갯수 최소 n-1
		int[][] min = new int[n][2]; 
			//0번섬 [연결되는 섬 , 통행료]
			
			//각 섬에 연결된 통행료중 가장 저렴한 값 저장
			for(int i=0; i<n;i++) {
				for(int j=0; j<costs.length;j++) {
					if(i==costs[j][0]&&min[i][1]==0) {//처음 비교할 값 넣기
						min[i][0] = costs[j][1];
						min[i][1]=costs[j][2];
					}
					else if(i==costs[j][0]&&min[i][1]>costs[j][2]) {
						min[i][0] = costs[j][1];
							min[i][1]=costs[j][2];
							
					}
					else if(i==costs[j][1]&&min[i][1]==0){//처음 비교할 값 넣기
						min[i][0] = costs[j][0];
						min[i][1]=costs[j][2];
					}
					else if(i==costs[j][1]&&min[i][1]>costs[j][2])
					{
						min[i][0] = costs[j][0];
						min[i][1] = costs[j][2];
					}
				}
			}
			
			
			//min에서 겹치는 길 제거후 총 통행료에 더해줌		
			boolean flag;
			for(int i=0; i<n;i++) {
				flag = true;
				for(int j=i+1; j<n ;j++) {
					 if(i==min[j][0]&&min[i][0]==j) {
						 minroad--;
						flag = false;
					 }
				}
				if(flag) {
					answer += min[i][1];
				}
			}
			
			//최소로 모두 통행할 수 잇는 길 = n-1개
			//겹치는 길 제거 후 길의 개수가 n-1 보다 작을시 남은 길 중 통행료 작은 순서대로 더함

			if(minroad<n-1)
				//통행료 작은 순으로 costs 정렬
				Arrays.sort(costs[2]);
				
		
			while(minroad<n-1) {
				answer += costs[minroad][2];
				minroad++;
			}
			
		System.out.println(answer);
			
	}
	

}
