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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Component
@Data
@Entity
@Table(name="friend")
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")

	private User user;
	
	
	@ManyToOne
	@JoinColumn(name = "friend_id")

	private User friend;
	
	@OneToOne
	private FriendStatus status;
	
	@Transient
	private String StatusCode;
	
//	@JsonIgnore
//	@OneToMany(mappedBy ="friend",cascade = CascadeType.ALL )
//	@ToString.Exclude
//	private List<Timeline> mytimelines;
	
	

}
