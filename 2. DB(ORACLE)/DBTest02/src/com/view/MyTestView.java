package com.view;

import java.util.List;
import java.util.Scanner;

import com.dao.MyTestDao;
import com.dto.MyTestDto;

public class MyTestView {
	
	static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		int select = 0;
		StringBuffer sb = new StringBuffer();
		sb.append("--program menu--\n")
		.append("1. 전체출력 \n")
		.append("2. 추    가\n")
		.append("3. 수    정\n")
		.append("4. 삭    제\n")
		.append("5. 종    료\n")
		.append("----------\n")
		.append("번호선택 : ");
		
		System.out.println(sb);
		select=sc.nextInt();
		
		
		return select;
	}
	
	public static void main(String[] args) {
		MyTestDao dao = new MyTestDao();
		MyTestDto dto = new MyTestDto();
		int no = 0;
		int mno=0;
		String mname;
		String nickName;
		
		do {
			no = getMenu();
			
			switch(no) {
			case 1 : 
				System.out.println("전체출력");
				List<MyTestDto> list = dao.selectList();
				for(MyTestDto select : list) {
					System.out.println(select);
				}
				break;
			case 2 :
				System.out.println("*추   가");
				System.out.println("번호 입력 : ");
				mno = sc.nextInt();
				System.out.println("이름 입력 : ");
				mname = sc.next();
				System.out.println("별명 입력 : ");
				nickName = sc.next();
				
				dto.setMno(mno);
				dto.setMname(mname);
				dto.setNickName(nickName);
				
				int result = dao.insert(dto);
				
				// 강사님 코드
				// int result = dao.insert(new MyTestDto(mno, mname, nickName));
				if(result >0) {
					System.out.println("추가 성공");
				}else {
					System.out.println("추가 실패");
				}
				break;
			case 3 :
				System.out.println("*수   정");
				System.out.println("수정할 번호 입력 : ");
				mno = sc.nextInt();
				System.out.println("수정할 이름 입력 : ");
				mname = sc.next();
				System.out.println("수정할 별명 입력 : ");
				nickName=sc.next();
			
				
				// 강사님 코드
				int updateRes = dao.update(new MyTestDto(mno, mname, nickName));
				if(updateRes > 0) {
					System.out.println("수정 성공");
				}else {
					System.out.println("수정 실패");
				}
				
				//dao.update(dto);
				break;
			case 4 :
				System.out.println("삭제할 번호 입력 : ");
				mno = sc.nextInt();
				
				//강사님 코드
//				int deleteMno=sc.nextInt();
//				int res= dao.delete(deleteMno);
//				if(res>0) {
//					System.out.println("삭제 성공");
//				}else {
//					System.out.println("삭제 실패");
//				}
				
				dao.delete(mno);
				System.out.println("*삭   제");
				break;
			case 5 :
				System.out.println("*종   료");
				sc.close();
				break;
			}
		}while(no!=5);
	}
}
