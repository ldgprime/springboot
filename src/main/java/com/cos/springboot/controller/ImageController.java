package com.cos.springboot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

//Controller,Configuration,Repository



@Controller
public class ImageController {
	
	//application.yml DI
	@Value("${file.path}")
	private String fileRealPath;
	
	
	@PutMapping("/image/upload")//@RequestParam 변수명이 같다면 생략가능
	public @ResponseBody String /* MultipartFile */ imageUpload(@RequestParam("imgFile") MultipartFile imgFile) {
		// 1번 imgFile 출력		
		
		System.out.println(imgFile);
		System.out.println(imgFile.getOriginalFilename());
		System.out.println(imgFile.getContentType());
		System.out.println(imgFile.getSize());
		System.out.println(imgFile.getName());
		System.out.println();
		
		try {
			System.out.println(imgFile.getBytes().toString());
			for(byte b:imgFile.getBytes()) {
				System.out.println(b);
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		UUID uuid = UUID.randomUUID();
		String uuidFilename = uuid+"_"+imgFile.getOriginalFilename();
		
		
		
		//path 저장 위치  lines		
		Path filePath = Paths.get(fileRealPath+uuidFilename);
		
		try {
			Files.write(filePath, imgFile.getBytes());
		} catch (IOException e) {			
			e.printStackTrace();
		}		
		
		return "ok";
		
	}
	
	
	
}
