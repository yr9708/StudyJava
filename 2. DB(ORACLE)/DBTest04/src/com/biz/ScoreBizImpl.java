package com.biz;

import java.util.List;

import com.dao.ScoreDao;
import com.dao.ScoreDaoImpl;
import com.dto.ScoreDto;

public class ScoreBizImpl implements ScoreBiz {
	
	private ScoreDao dao = new ScoreDaoImpl();

	@Override
	public List<ScoreDto> selectList() {
		return dao.selectList();
	}

	@Override
	public ScoreDto selectOne(String s_name) {
		return dao.selectOne(s_name);
	}

	@Override
	public int insert(ScoreDto dto) {
//		int sum = dto.getS_kor()+dto.getS_math()+dto.getS_eng();
//		double avg = sum/3;
//		dto.setS_avg(avg);
//		dto.setS_sum(sum);
		return dao.insert(dto);
	}

	@Override
	public int update(ScoreDto dto) {
//		int sum = dto.getS_kor()+dto.getS_math()+dto.getS_eng();
//		double avg = sum/3;
//		dto.setS_avg(avg);
//		dto.setS_sum(sum);
		return dao.update(dto);
	}

	@Override
	public int delete(String s_name) {
		return dao.delete(s_name);
	}

	@Override
	public ScoreDto topNSelect(int n) {
		return dao.topNSelect(n);
	}
	
	private int getSum(int kor, int eng, int math) {
		return kor+eng+math;
	}
	
	private Double getAvg(int sum) {
		return (double)sum/3;
	}
	
	private String getGrade(double avg) {
			String grade;
			
			switch((int)avg/10) {
			case 10 :
			case 9 :
				grade = "A";
				break;
			case 8 :
				grade = "B";
				break;
			case 7:
				grade = "C";
				break;
			case 6 :
				grade = "D";
				break;
			default : grade = "F";
			}
		return grade;
		}
	
}
