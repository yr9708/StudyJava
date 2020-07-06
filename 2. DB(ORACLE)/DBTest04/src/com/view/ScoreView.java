package com.view;

import java.util.List;
import java.util.Scanner;

import com.biz.ScoreBiz;
import com.biz.ScoreBizImpl;
import com.dto.ScoreDto;

public class ScoreView {
	
	static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("----------\n")
		.append("1.전체출력\n")
		.append("2.선택출력\n")
		.append("3.추    가\n")
		.append("4.수    정\n")
		.append("5.삭    제\n")
		.append("6.1등 출력\n")
		.append("7.2등 출력\n")
		.append("8.n등 출력\n")
		.append("9.종    료\n");
		System.out.println(sb);
		System.out.println("번호선택 : ");
		int select=sc.nextInt();
		
		return select;
	}
	
	public static void main(String[] args) {
		ScoreBiz biz = new ScoreBizImpl(); //다형성
		int select = 0;
		while(select!=9) {
			select = getMenu();
			switch(select) {
			case 1 : //전체출력
				System.out.println("--전체출력--");
				List<ScoreDto> selectList = biz.selectList();
				for(ScoreDto dto : selectList) {
					System.out.println(dto);
				}
				break;
				
			case 2 : //선택출력
				System.out.println("---선택출력---");
				System.out.println("이름을 입력");
				String selectName = sc.next();
				System.out.println(biz.selectOne(selectName));
				break;
			case 3 : //추가
				System.out.println("---추가---");
				System.out.println("이름 입력");
				String insertName = sc.next();
				System.out.println("kor 점수 입력");
				int insertKor = sc.nextInt();
				System.out.println("eng 점수 입력");
				int insertEng = sc.nextInt();
				System.out.println("math 점수 입력");
				int insertMath = sc.nextInt();
				
				ScoreDto dto = new ScoreDto();
				dto.setS_name(insertName);
				dto.setS_kor(insertKor);
				dto.setS_eng(insertEng);
				dto.setS_math(insertMath);
				
				int insertRes = biz.insert(dto);
				if(insertRes>0) {
					System.out.println("추가 완료");
				}else {
					System.out.println("추가 실패");
				}
				break;
			case 4 : //수정
				System.out.println("---수정---");
				System.out.println("수정할 이름 입력");
				String updateName = sc.next();
				System.out.println("kor 입력");
				int updateKor = sc.nextInt();
				System.out.println("eng 입력");
				int updateEng = sc.nextInt();
				System.out.println("math 입력");
				int updateMath = sc.nextInt();
				
				ScoreDto dto2 = new ScoreDto();
				dto2.setS_name(updateName);
				dto2.setS_kor(updateKor);
				dto2.setS_eng(updateEng);
				dto2.setS_math(updateMath);
				
				int updateRes = biz.update(dto2);
				if(updateRes>0) {
					System.out.println("수정 성공");
				}else {
					System.out.println("수정 실패");
				}
				
				break;
			case 5: //삭제
				System.out.println("---삭제---");
				System.out.println("삭제할 이름 입력");
				String deleteName = sc.next();
				int deleteRes = biz.delete(deleteName);
				if(deleteRes > 0) {
					System.out.println("삭제 성공");
				}else {
					System.out.println("삭제 실패");
				}
				break;
			case 6 ://1등 출력
				System.out.println("1등");
				System.out.println(biz.topNSelect(1));
				break;
			case 7 : // 2등 출력
				System.out.println("2등");
				System.out.println(biz.topNSelect(2));
				break;
			case 8: //n등 출력
				System.out.println("n등");
				int topN = sc.nextInt();
				System.out.println(biz.topNSelect(topN));
			break;
			case 9 : //종료
				System.out.println("종료되었습니다.");
				break;
			}
				
				
		}
		
	}
}
