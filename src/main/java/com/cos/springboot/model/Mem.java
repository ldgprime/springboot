package com.cos.springboot.model;

import java.sql.Timestamp;



import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@NoArgsConstructor
public class Mem{
	private int id;
	private String username;
	private String password;
	private String email;
	private Timestamp createdate;
	
	@Builder
	public Mem(String username, String password, String email, Timestamp createdate) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.createdate = createdate;
	}

	
}