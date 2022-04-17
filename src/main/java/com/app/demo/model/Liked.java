package com.app.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="liked",uniqueConstraints = @UniqueConstraint(
		name="uk_sample12_messageId_userId",columnNames= {"messageId","userId"}))

@AllArgsConstructor
@NoArgsConstructor
public class Liked {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer likeId;
	
	
	@ManyToOne
	@JoinColumn(name="messageId")
	private Timeline timeline;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

}
