package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Supoja {
	public static void main(String[] args) {
		int[] answers= {1,2,3,4,5};
		Supoja s = new Supoja();
		int[] answer=s.solution(answers);
		System.out.println(Arrays.toString(answer));
	}

/*
 * 
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
입출력 예
answers	return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
입출력 예 설명
입출력 예 #1

수포자 1은 모든 문제를 맞혔습니다.
수포자 2는 모든 문제를 틀렸습니다.
수포자 3은 모든 문제를 틀렸습니다.
따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

입출력 예 #2

모든 사람이 2문제씩을 맞췄습니다.
 * 
 */
	
	
	
	
	
	public int[] solution(int[] answers) {
		
		
		// 1번 수포자
		int[] num1=new int[10];	// 몇개의 문제를 찍을것인가, 10개의 문제 answers.length
		int y = 1;
		for(int i = 0 ; i<num1.length; i++) {
			num1[i]=y;
			y++;
			if(y==6) {
				y=1;
			}
		}
		
		System.out.println(Arrays.toString(num1));
		
		
		
		// 2번 수포자
		int[] num2=new int[10];
		int k=1;
		for(int i =0; i<num2.length; i++) {
			if(i%2==0) {
				num2[i]=2;
			}else {
				if(k>5) {
					k=1;
				}	
				num2[i]=k;
				if(k==1) {
					k+=2;
				}else {
					k++;
				}
			}
//			System.out.println(num2[i]);
		}
		
		System.out.println(Arrays.toString(num2));
		
	
		// 3번 수포자
		int[] num3= new int[10];
		int cnt=3;
		for(int i=0; i<num3.length; i++) {
			if(i%2==0 && i!=0) {
					if(cnt==3) {
						cnt=1;
					}else if(cnt==2) {
						cnt+=2;
					}else if(cnt==5) {
						cnt=3;
					}else if(cnt==1){
						cnt++;
					}else if(cnt==4) {
						cnt=5;
					}
				}
			num3[i]=cnt;
//				System.out.println(num3[i]);
			}
		
		
		System.out.println(Arrays.toString(num3));
		
		int num1Score=0;
		int num2Score=0;
		int num3Score=0;
		
		for(int i =0; i<answers.length;i++) {
			if(answers[i]==num1[i]) num1Score++;
			if(answers[i]==num2[i]) num2Score++;
			if(answers[i]==num3[i]) num3Score++;
		}
		
		// 가장 많이 맞춘 갯수?
		int topScore = Math.max(Math.max(num1Score, num2Score),num3Score);
	
		List <Integer> list = new ArrayList<Integer>();
		System.out.println("1번 수포자 맞은 갯수 : "+num1Score);
		System.out.println("2번 수포자 맞은 갯수 : "+num2Score);
		System.out.println("3번 수포자 맞은 갯수 : "+num3Score);
		
		if(topScore==num1Score) list.add(1);	//1번 수포자
		if(topScore==num2Score) list.add(2);	//2번 수포자
		if(topScore==num3Score) list.add(3);	//3번 수포자
		
		System.out.println("담긴 리스트"+list);

		int [] answer = new int [list.size()]; // 1,2번수포자가 많이 맞았을 수도 있으니까 유동적임.
		for(int i =0; i<answer.length; i++) {
			answer[i]=list.get(i);
		}
		
		
		return answer;
	}
}
