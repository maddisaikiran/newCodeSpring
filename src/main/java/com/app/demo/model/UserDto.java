package com.app.demo.model;


import org.springframework.util.CollectionUtils;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


		private Integer id;
	
		private String fullName;
		
		private Long mobile;
	
		private String email;
	
		private String password;
		

		private Boolean userStatus;
		
		
		@ToString.Exclude
		private FriendDto friend;

		public static UserDto convert(User user) {
			UserDto userDto=new UserDto();
			userDto.setId(user.getId());
			userDto.setFullName(user.getFullName());
			userDto.setMobile(user.getMobile());
			userDto.setEmail(user.getEmail());
			userDto.setPassword(user.getPassword());
			if(!CollectionUtils.isEmpty(user.getFriend())) {
			userDto.setFriend(FriendDto.convert(user.getFriend().get(0)));
			}
			return userDto;
		}
}
