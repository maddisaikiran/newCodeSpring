package com.app.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.springframework.stereotype.Component;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Component
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Timeline {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer timeId;
	
	private String name;
	
	private String message;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	

}
