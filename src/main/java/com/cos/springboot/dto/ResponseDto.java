package com.cos.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
	
	//response에서 사용할 때 composition이나 extends를 사용함
	//데이터와 구분이 됨 json 안에 깊숙히 들어가 나옴
	//통일!!!
	private int statusCode;
	private String msg;
}
