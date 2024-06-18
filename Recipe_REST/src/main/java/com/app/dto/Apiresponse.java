package com.app.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Apiresponse {
	 private String message;
	 private LocalDateTime timestamp;
	 
	 public Apiresponse() {
		 
	 }
	 public Apiresponse(String message) {
		 super();
		 this.message=message;
		 this.timestamp=LocalDateTime.now();
	 }
	 
	

}
