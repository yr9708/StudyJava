package com.mvc.updown;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.mvc.updown.dto.UploadFile;
import com.mvc.updown.validate.FileValidator;


@Controller
public class HomeController {
	
	@Autowired
	private FileValidator fileValidator;
	
	@RequestMapping("/form")
	public String uploadForm() {
		return "upload";
	}
	
	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) {
		fileValidator.validate(uploadFile, result); //실제 검증 로직이 이루어지는 메서드 , BindingResult 는 Errors를 상속받는다.
		
		if(result.hasErrors()) {
			return "upload";
		}
		
		MultipartFile file = uploadFile.getMpfile(); // 파일을 잠시 담아주는 것
		String name = file.getOriginalFilename(); // 파일명 (일반회사에서는 날짜시간으로 파일명으로 잡음)
		
		UploadFile fileObj = new UploadFile(); // 다운로드 페이지로 보내줄 객체
		fileObj.setName(name); 
		fileObj.setDesc(uploadFile.getDesc());
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			inputStream = file.getInputStream(); // inputStream 
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			
			System.out.println("업로드 될 실제 경로 : "+path);
			
			File storage = new File(path);
			if(!storage.exists()) { 
				storage.mkdir();
			}
			
			File newFile = new File(path + "/" +name); //업로드한 파일과 같은 이름으로 newFile 생성, (byte[]는 0이다)
			if(!newFile.exists()) {
				newFile.createNewFile();
			} 
				
			outputStream = new FileOutputStream(newFile); // 넘어온 파일 이름+확장가 까지 그대로 서버에 파일을 만들어라.
			
			int read = 0;
			byte[] b = new byte[(int)file.getSize()]; // 인트로 변환한 Size의 byte
			
			while((read = inputStream.read(b)) != -1) { // 전달받은 inputStream에 있는 데이터를 읽어와서 newFile에다가 0번지부터 써라. (파일이 끝날때까지, 파일이의 끝을 읽게되면 -1이 리턴된다) 
				outputStream.write(b,0,read);
			}
				
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("fileObj",fileObj);
		
		
		return "download";
	}
	
	
	@RequestMapping("/download")
	@ResponseBody
	public byte[] fileDownload(HttpServletRequest request, HttpServletResponse response, String name) {
		
		byte[] down = null;
		
		try {
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			File file = new File(path+"/"+name); // 해당 경로에 있는 파일값을 가져옴
			
			down = FileCopyUtils.copyToByteArray(file); 
			// FileCopyUtils : 파일 및 스트림 복사를 위한 간단한 유틸리티 메소드의 집합체
			// copyToByteArray : 지정한 Input인 FIle의 내용을 새로운 byte[]로 복사한다. 리턴값은 copy 된 새로운 byte[]이다

			String filename = new String(file.getName().getBytes(),"8859_1"); // 한글파일이름 인코딩, 영어일때는 8859_1 없어도 잘 나온다
			
			// Content-Disposition , attachment -> file download 설정(filename 설정 가능)
			response.setHeader("Content-Disposition","attachment; filename=\""+filename+"\""); // 첨부파일, 해당 브라우저가 아 파일 다운로드 하는 애구나 라고 자동으로 알아들음
			response.setContentLength(down.length); //어떤 브라우져에서 사용할지 모르니까 브라우저에게 알려주는 것.
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return down;
	}
}
