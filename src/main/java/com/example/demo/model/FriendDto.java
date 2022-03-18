package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class FriendDto {

	private int id;
	
	private int userId;
	
	private int friendId;
	
	private String status;
	
	public static FriendDto convert(Friend friend) {
		FriendDto friendDto=new FriendDto();
		friendDto.setId(friend.getId());
		friendDto.setUserId(friend.getUser().getId());
		friendDto.setFriendId(friend.getFriend().getId());
		friendDto.setStatus(friend.getStatus().getCode());
		return friendDto;
	
}
}
