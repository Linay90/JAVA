package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Recipe  extends BaseEntity{
	private String title;
	private String description;
	private String ingredients;
	private String instructions;
	
//	@Enumerated(EnumType.STRING)
	private Difficulty difficultyLevel;
	private String cuisninType;
	@ManyToOne
	@JoinColumn(nullable=false)
	private User author;
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDate date;
	

	 
}
