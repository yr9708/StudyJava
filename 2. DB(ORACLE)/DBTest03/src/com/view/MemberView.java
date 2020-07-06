package com.view;

import java.util.List;
import java.util.Scanner;

import com.biz.MemberBiz;
import com.dto.MemberDto;

// View : 화면
// Controller : 화면 제어
public class MemberView {

	private static Scanner sc = new Scanner(System.in);
	
	
	public static int getMenu() {
		int select = 0;
		StringBuffer sb = new StringBuffer();
		sb.append("********\n")
		.append("1.전체출력\n")
		.append("2.선택출력\n")
		.append("3.추    가\n")
		.append("4.수    정\n")
		.append("5.삭    제\n")
		.append("6.종    료\n")
		.append("----------\n")
		.append("번호 입력 : ");
		System.out.println(sb);
		
		select = sc.nextInt();
		
		
		return select;
	}
	
	public static void main(String[] args) {
		int select = 0;
		MemberBiz biz = new MemberBiz();
		
		while(select!=6) {
			select = getMenu();
			switch(select) {
			case 1:
			// 전체출력
				System.out.println("**전 체 출 력**");
					List<MemberDto> selectList = biz.selectList();
					for(MemberDto dto : selectList) {
						System.out.println(dto);
					}
				break;
			case 2:
			// 선택 출력
				System.out.println("**선 택 출 력**");
				System.out.println("출력하고싶은 번호를 입력해주세요");
				int selectNum = sc.nextInt();
				MemberDto dto = biz.selectOne(selectNum);
				System.out.println(dto);
				break;
			case 3: 
			// 추가
				System.out.println("**추 가**");
				System.out.println("이름 입력");
				String name = sc.next();
				System.out.println("나이 입력");
				int age = sc.nextInt();
				System.out.println("성별 입력 F or M");
				String gender = sc.next();
				System.out.println("주소 입력");
				String location = sc.next();
				System.out.println("직업 입력");
				String job = sc.next();
				System.out.println("번호 입력");
				String tel = sc.next();
				System.out.println("메일 입력");
				String email = sc.next();
				
				MemberDto dto1 = new MemberDto();
				dto1.setM_name(name);
				dto1.setM_age(age);
				dto1.setM_gender(gender);
				dto1.setM_location(location);
				dto1.setM_job(job);
				dto1.setM_tel(tel);
				dto1.setM_email(email);
				
				int result = biz.insert(dto1);
				if(result > 0) {
					System.out.println("추가 성공");
				}else {
					System.out.println("추가 실패");
				}
				break;
			case 4:
			// 수정
				System.out.println("**수 정**");
				System.out.println("수정할 번호를 입력해주세요");
				int updateNumber = sc.nextInt();
				System.out.println("수정할 이름을 입력해주세요");
				String updateName=sc.next();
				System.out.println("수정할 나이를 입력해주세요");
				int updateAge = sc.nextInt();
				System.out.println("성별 수정? ");
				String updateGender = sc.next();
				System.out.println("수정할 주소를 입력해주세요");
				String updateLocation = sc.next();
				System.out.println("수정할 직업을 입력해주세요");
				String updateJob = sc.next();
				System.out.println("수정할 번호를 입력해주세요");
				String updateTel = sc.next();
				System.out.println("수정할 이메일을 입력해주세요");
				String updateEmail = sc.next();
				
				MemberDto dto2 = new MemberDto(updateNumber, updateName, updateAge, updateGender, updateLocation, updateJob, updateTel, updateEmail);
				
				int updateRes = biz.update(dto2);
				if(updateRes>0) {
					System.out.println("수정 완료");
				}else {
					System.out.println("수정 실패");
				}
				break;
			case 5:
			// 삭제
				System.out.println("**삭  제**");
				System.out.println("삭제할 번호를 입력해주세요");
				int deleteInt = sc.nextInt();
				int deleteRes = biz.delete(deleteInt);
				if(deleteRes > 0) {
					System.out.println("삭제 성공");
				}else {
					System.out.println("삭제 실패");
				}
				break;
			}
		}
		System.out.println("종료되었습니다.");
	}
}
