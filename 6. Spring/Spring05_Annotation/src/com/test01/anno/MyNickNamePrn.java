package com.test01.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//<bean id="myNickNamePrn" class="com.test01.anno.MyNickNamePrn">
@Component
public class MyNickNamePrn {
	
	// autowire="default" 
	// NickName이라는 Type을 찾아서 nickName이라는 변수에 넣어준다.
	@Autowired
	private NickName nickName;

	public NickName getNickName() {
		return nickName;
	}

	public void setNickName(NickName nickName) {
		this.nickName = nickName;
	}
	
	public String toString() {
		return "내 별명은 "+nickName+" 입니다.";
	}
}
