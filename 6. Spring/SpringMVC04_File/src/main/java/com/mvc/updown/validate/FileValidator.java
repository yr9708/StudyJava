package com.mvc.updown.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mvc.updown.dto.UploadFile;

@Service //비즈니스 로직이다. 컨트롤러에서 객체생성한 것을 받아 사용하기 위해서 Service로 받음(Component랑 비슷)
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UploadFile file = (UploadFile) target;
	
		
		if(file.getMpfile().getSize() == 0) { // 파일이 없다면
			errors.rejectValue("mpfile", "fileNPE", "Please select a file");
		}
		// errors에 mpfile에 대한 문제가 발생하면 fileNPE라는 에러코드로 please select a file 내용을 초기화
		/*
		 * rejectValue(String field, String errorCode, String defaultMessage) 
			: 필드에 대한 에러코드를 추가 에러코드에 대한 메세지가 존재하지 않을 경우 defaultMessage를 사용
		 */
	}

}
