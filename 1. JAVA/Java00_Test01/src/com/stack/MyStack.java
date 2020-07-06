package com.stack;

import java.util.Arrays;

public class MyStack {
	private int top = -1;
	private int size;
	private Object[]arr;
	
	
	public MyStack() {
		this.size=5;
		arr = new Object[size];
	}
	
	public MyStack(int size) {
		this.size=size;
		arr = new Object[size];
	}
	
	public void push(Object input) {
		top++;
		if(top>=size) {
			System.out.println("Overflow");
			top--;	// 배열 5번지는 없으니까 -1 해줘서 4로 바꿔준다.
		}else {
			arr[top]=input;
		}
	}
	
	public Object pop() {
		if(top<0) {
			return "Underflow";
		}else {
			Object rtn = arr[top];
			arr[top]=null;
			top--;
			
			return rtn;
		}
	}
	
	
	@Override
	public String toString() {
		return Arrays.toString(arr);
	}
	
	

}
