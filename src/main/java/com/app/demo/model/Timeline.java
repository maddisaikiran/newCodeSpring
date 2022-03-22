package com.app.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	
	private String timeLineName;
	
	private String message;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
//	@ManyToOne
//	@JoinColumn(name="id")
//	private User user;
	
	
	
//	@ManyToOne
//	@JoinColumn(name="friend_id")
//	private Friend friend;
	
	
	
	

}
