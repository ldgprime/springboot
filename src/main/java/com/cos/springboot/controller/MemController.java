package com.cos.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.springboot.dto.RequestMemJoinDto;
import com.cos.springboot.dto.RequestMemUpdateDto;
import com.cos.springboot.dto.ResponsMemUpdateDto;
import com.cos.springboot.model.Mem;
import com.cos.springboot.repository.MemRepository;

@Controller
public class MemController {

	@Autowired
	private MemRepository memRepository;

	// model mem 사용 x db용으로만 dto만들어서 dto객체를 넣어야한다
	// username,password, email
	@PostMapping("/mem/api/join") // RequestMemJoinDto requestMemJoinDto 원래 사용 x request올 때는 json 타입으로 온다 jackson이
									// 알아서 바꿔줌 자바클래스로
	public @ResponseBody ResponseEntity<String> memApiJoin(@RequestBody RequestMemJoinDto requestMemJoinDto) {
		int result = memRepository.save(requestMemJoinDto);

		if (result == 1) { // created 데이터 생성 insert 201 put delete 200
			return new ResponseEntity<String>("정상적으로 가입되었습니다.", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("회원가입 실패", HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/mem")
	public String mems(Model model) {
		List<Mem> mems = memRepository.findAll();

		model.addAttribute("mems", mems);
		return "mem/list";
	}

	@GetMapping("/mem/{id}")
	public String update(@PathVariable int id, Model model) {
		Mem mem = memRepository.findById(id);

		model.addAttribute("mem", mem);

		return "mem/update";
	}


//	 @PutMapping("/mem/api/update") //RequestMemJoinDto requestMemJoinDto 원래 사용 x request올 때는 json 타입으로 온다 jackson이 알아서 바꿔줌 자바클래스로
//	 public @ResponseBody ResponseEntity<String> memApiUpdate(@RequestBody RequestMemUpdateDto requestMemUpdateDto) {
//	 int result = memRepository.update(requestMemUpdateDto);
//	  
//	 if(result ==1) { 
//	  //created 데이터 생성 insert 201 put delete 200 
//		 return new	ResponseEntity<String>("정상적으로 가입되었습니다.", HttpStatus.CREATED); 
//	 }else { 
//		 return	new ResponseEntity<String>("회원가입 실패",HttpStatus.BAD_REQUEST); }
//	 
//	 }
	 

	@PutMapping("/mem/api/update")
	public @ResponseBody ResponseEntity<?> updateProc(@RequestBody RequestMemUpdateDto requestMemUpdateDto) {
		
				
		
		try {
			int result = memRepository.update(requestMemUpdateDto);
			Mem mem = memRepository.findById(requestMemUpdateDto.getId());
			ResponsMemUpdateDto rmdDto = new ResponsMemUpdateDto(); 
			rmdDto.setDto(mem);
			if(result == 1) {
				rmdDto.setMsg("ok");
				rmdDto.setStatusCode(200);
				return new ResponseEntity<ResponsMemUpdateDto>(rmdDto,HttpStatus.OK);
			}else {
				rmdDto.setMsg("fail");
				rmdDto.setStatusCode(400);
				return new ResponseEntity<ResponsMemUpdateDto>(rmdDto,HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("서버오류",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
		
		
		
		
		
	}

}
