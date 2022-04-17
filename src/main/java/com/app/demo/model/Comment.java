package com.app.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="comment")
@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer commentId;
	
	@ManyToOne
	@JoinColumn(name="messageId")
	private Timeline timeline;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@Column(length=100)
	@Size(min=6,max=100)
	private String comment;

}
