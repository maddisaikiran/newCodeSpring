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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
		name="uk_sample2_fullName_emailId_mobile",columnNames= {"fullName","emailId","mobile"}))
        


@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotNull
	private String fullName;
	
	@NotNull
	private Long mobile;
	@NotNull
	@Email
	private String emailId;
	@NotNull
	private String password;
	
	@ColumnDefault("true")
	private boolean userStatus;
	
//	@JsonIgnore
//	@ManyToOne
//	@JoinColumn(name = "adminId", referencedColumnName = "adminId")
//	private Admin admin;
	
//	@JsonManagedReference
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	@ToString.Exclude
//	private List<Friend> friend;
	
//	private Friend friend;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@ToString.Exclude
	private List<Friend> friend;
	
	
	@JsonIgnore
	@OneToMany(mappedBy ="user",cascade = CascadeType.ALL )
	@ToString.Exclude
	private List<Timeline> mytimelines;
	
	
	@JsonIgnore
	@OneToMany(mappedBy ="user",cascade = CascadeType.ALL )
	@ToString.Exclude
	private List<Message> message;
	
	
	
	
	
	
}
