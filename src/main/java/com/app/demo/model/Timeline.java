package com.app.demo.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Entity
@Table(name="timeline")
@AllArgsConstructor
@NoArgsConstructor
public class Timeline {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="timeId")
	private Integer id;
	
	@Lob
	@Column(columnDefinition= "MEDIUMBLOB")
	private String image;
	
	@Column(length=100)
	@Size(min=6,max=100)
	private String message;
	
	private Integer count;

	@JsonIgnore
	@OneToMany(mappedBy ="timeline",cascade = CascadeType.ALL )
	@ToString.Exclude
	private List<Like> likes;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@JsonIgnore
	@OneToMany(mappedBy = "timeline",cascade = CascadeType.ALL)
	@ToString.Exclude
	private List<Comment> comments;
	

}
