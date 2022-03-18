package com.example.demo.model;

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

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table

public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer messageId;
	
	//private Integer id;
	
	//private String userName;
	
	private String mgs;
	
	@ManyToOne
	@JoinColumn(name="receiver_id")
	private User message;
	
	@ManyToOne
	@JoinColumn(name="sender_id")
	private User user;

}
