package com.app.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="message")
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="messageId")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="friend_id")
	private User friend;
	
	private String message;
	
	
	

}
