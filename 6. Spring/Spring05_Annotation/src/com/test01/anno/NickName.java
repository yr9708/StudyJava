package com.test01.anno;

import org.springframework.stereotype.Component;
// <bean id="nickname" class="com.test01.anno.NickName"/>

@Component
public class NickName {
	public String toString() {
		return "ø≠¿”";
	}
}
