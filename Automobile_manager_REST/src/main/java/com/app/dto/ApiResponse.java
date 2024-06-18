package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class ApiResponse {
	
	private String msg;
	private LocalDateTime timestamp;
	
	
	public ApiResponse() {
		
	}
	public ApiResponse(String msg) {
		super();
		this.msg=msg;
		this.timestamp=LocalDateTime.now();
	}

}
