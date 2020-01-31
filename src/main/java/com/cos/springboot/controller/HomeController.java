package com.cos.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.springboot.dto.RequestUserDto;
import com.cos.springboot.dto.RequestUserPhoneDto;
import com.cos.springboot.dto.ResponseData;


//localhost:8080/ 또는
//localhost:8080


@Controller
//localhost:8080/home
@RequestMapping("/home")
public class HomeController {
	
	
	
	//localhost:8080/home/
	//localhost:8080/home
	@GetMapping({"","/"})
	public String home() {
		return "home";
	}
	
	//주소는 같아도 된다 함수명은 달라도 된다. 호출은 주소로
	@GetMapping("/hello")
	public String hello_get() {
	//ajax는 요청을 한곳으로 응답을 함 무조건 응답의 commit이 두번이면 두번째 무시 return hello 무시
		//DB Select - model
		
		return "hello";
	}
	
	@PostMapping("/hello")
	//ajax return 무시  @ResponseBody로 http body에 return String "hello" 데이터 전달 타입을 dto
	//get이 아니면 @ResponseBody ResponseData로 데이터를 return
	public @ResponseBody ResponseData hello_Post(@RequestBody RequestUserDto requestUserDto ) {	
		//DB insert 로직
		System.out.println(requestUserDto.getId());
		return new ResponseData(200,"ok");
	}
	
	@DeleteMapping("/hello")
	public @ResponseBody ResponseData hello_delete(@RequestBody RequestUserDto requestUserDto) {
		//DB update 로직
		System.out.println(requestUserDto.getId());
		return new ResponseData(200,"ok");
	}	
	
	@PutMapping("/hello")
	public @ResponseBody ResponseData hello_update(@RequestBody RequestUserPhoneDto requestUserPhoneDto) {
		//DB update 로직
		System.out.println(requestUserPhoneDto.getUsername());
		System.out.println(requestUserPhoneDto.getPhone());
		return new ResponseData(200,"ok");
	}	


}
