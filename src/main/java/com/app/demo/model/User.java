package com.app.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Component
@Data
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(
		name="uk_sample2_fullName_email_mobile",columnNames= {"fullName","email","mobile"}))
        


@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@Column(length = 10)
	@Size(min=3, max=10)
	private String fullName;
	
	@NotNull
	@Column(length = 10)
	private Long mobile;
	
	@NotNull
	@Email
	@Column(length = 20)
	private String email;
	
	@NotNull
	@Column(length=10)
	@Size(min=3,max=10)
	private String password;
	
	@ColumnDefault("true")
	private boolean userStatus;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@ToString.Exclude
	private List<Friend> friend;
	
	
	@JsonIgnore
	@OneToMany(mappedBy ="user",cascade = CascadeType.ALL )
	@ToString.Exclude
	private List<Timeline> timelines;	
	
	
}
