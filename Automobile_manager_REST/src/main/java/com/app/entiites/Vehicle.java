package com.app.entiites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

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
public class Vehicle extends BaseEntity {
	
	
	@NotBlank
	private String vehicleName;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Company company;
	@NotBlank
	private String vehicleNumber;
	@NotBlank
	private String vehicleType;
	@ManyToOne(optional = false)
	@JoinColumn(name="user_id")
	User user;

}
