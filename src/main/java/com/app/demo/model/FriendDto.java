package com.app.demo.model;
import lombok.Data;

import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor

public class FriendDto {
private Integer id;
	
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
