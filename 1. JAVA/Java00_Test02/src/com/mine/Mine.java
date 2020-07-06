package com.mine;

public class Mine {
	private int size;
	private String[][] arr;
	
	public Mine() {
		this.size=10;
		
	}
	
	public Mine(int size) {
		this.size=size;
	}
	
	public String[][] make(){
		arr = new String[size][size];
		// 0으로 초기화
		fillTheZero();	
		
		// 랜덤으로 *(폭탄) 셋팅
		randomMine();
		
		// 폭탄 카운트
		countMine();
		
		
		
		return arr;
	}
	
	
	
	private int count(int x, int y) {
		int cnt = 0; 
		
		for(int i=x-1; i<=x+1; i++) {
			for(int j= y-1; j<=y+1; j++) {
				if(i < 0 || j <0 || i > arr.length-1 || j>arr.length-1) {
					continue;
				}
				if(arr[i][j].equals("*")) {
					cnt++;
				}
			}
		}
		
		
		return cnt;
	}

	private void countMine() {
		for(int i =0 ; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(!arr[i][j].equals("*")) {
					arr[i][j]=count(i,j)+"";
				}
			}
		}
		
	}

	private void randomMine() {
		int cnt = size;
		while(cnt!=0){
			int ranX = (int)(Math.random()*size);
			int ranY = (int)(Math.random()*size);
			if(!arr[ranX][ranY].equals("*")) { // 지뢰가 아니라면
				arr[ranX][ranY]="*";
				cnt--;
			}
		}
	}

	private void fillTheZero() {
		for(int i =0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				arr[i][j]="0";
			}
		}
		
	}
	
	//test ----------------------------------------- test
	
	public static void main(String[] args) {
		Mine mine = new Mine();
		//mine.fillTheZero();
		mine.make();
		mine.prn();
	
	}
	
	public void prn() {
		for(int i =0; i<arr.length;i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.printf("%3s",arr[i][j]);
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
}
