package com.cos.springboot.dto;

import java.sql.Timestamp;

import com.cos.springboot.model.Mem;

import lombok.Getter;




@Getter
public class ResponsMemUpdateDto extends ResponseCM{
	private int id;
	private String username;
	private String password;
	private String email;
	private Timestamp createdate;

	public void setDto(Mem mem) {
		id= mem.getId();
		username = mem.getUsername();
		password = mem.getPassword();
		email = mem.getEmail();
		createdate = mem.getCreatedate();	
				
	}
	
}
