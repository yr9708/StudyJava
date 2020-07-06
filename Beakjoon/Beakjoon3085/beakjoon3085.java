package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon3085 {
	static char [][]arr;
	static int N;
	
	public static int check() {
		int ans = 1; // 비교할 값 초기화
		
		for(int i=0 ; i<N; i++) {
			int cnt = 1; // 비교할 값 초기화
			// 세로
			for(int j=0; j<N-1; j++) {
				if(arr[j][i]==(arr[j+1][i])) {
					System.out.printf("세로 : (%d, %d) %c (%d, %d) %c \n",j,i,arr[j][i],j+1,i,arr[j+1][i]);
					cnt++;					
				}else {
					cnt=1;
				}
				ans=Math.max(ans, cnt);
			}
			// 가로
			cnt=1;
			for(int j=0; j<N-1; j++) {
				if(arr[i][j]==(arr[i][j+1])) {
					System.out.printf("가로 : (%d, %d) %c (%d, %d) %c \n",i,j,arr[i][j],i,j+1,arr[i][j+1]);
					cnt++;
				}else {
					cnt=1;
				}
				ans = Math.max(ans,cnt);
			}
		}
		// 가로 세로 중 큰 값으로 리턴
		return ans;
	}
	
	public static void swap(int x, int y, int a, int b) {
		char temp = arr[x][y];
		arr[x][y] = arr[a][b];
		arr[a][b] = temp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		
	// 더미
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				int num = (int)(Math.random()*4)+1;
				char chr;
				switch(num) {
				case 1 : 
					chr='C';
					break;
				case 2 : 
					chr='P'; 
					break;
				case 3 : 
					chr='Z';
					break;
				default :
					chr='Y';
					break;
				}
				arr[i][j]=chr;
			}
		}
		
//		for(int i=0; i<N; i++) {
//			char temp[] = br.readLine().toCharArray();
//			arr[i]=temp; 
//		}
		
		
		//잘 들어갔나 확인
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		
		
		int Max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 행
				if(j+1<N) {
					swap(i,j,i,j+1);
					int A = check();
					swap(i,j+1,i,j);
					Max = Math.max(A, Max);
				}
				// 열
				if(i+1<N) {
					swap(i,j,i+1,j);
					int A = check();
					swap(i+1,j,i,j);
					Max = Math.max(A, Max);
				}
			}
		}
		System.out.println(Max);
		
		
		
//		String temp;
//		
//		while(true) {
//		int x = sc.nextInt();
//		int y = sc.nextInt();
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		
//		if(arr[x][y]==arr[a][b]) {
//			System.out.println("색이 같습니다, 다시 입력해주세요");
//			continue;
//		}else if(x>a+1 || x<a-1 || y>b+1 || y<b-1) {
//			System.out.println("인접한 곳이 아닙니다.");
//			continue;
//		}else {
//			temp = arr[x][y];
//			arr[x][y] = arr[a][b];
//			arr[a][b] = temp;
//			break;
//			}
//		}
//		int ccnt=0;
//		int pcnt=0;
//		int zcnt=0;
//		int ycnt=0;
//		
//		for(int i=0; i<arr.length; i++) {
//			if(arr[i][0]=="C") {
//				ccnt++;
//			}else if(arr[i][0]=="P") {
//				pcnt++;
//			}else if(arr[i][0]=="Z") {
//				zcnt++;
//			}else {
//				ycnt++;
//			}
//		}
//		
//		ArrayList<Integer>intArr=new ArrayList<>();
//		intArr.add(ccnt);
//		intArr.add(pcnt);
//		intArr.add(zcnt);
//		intArr.add(ycnt);
//	
//		
//		Collections.sort(intArr);
//		System.out.println(intArr.get(3));
	}
}
