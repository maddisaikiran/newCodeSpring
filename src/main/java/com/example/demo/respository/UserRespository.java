package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;




@Repository
public interface UserRespository extends JpaRepository <User, Integer>{
	
	User findByEmailId(String emailId);
	User findByEmailIdAndPassword(String emailId, String password) ;
	
	
	@Query("select u from User u left join Friend f on f.friend.id=u.id where f.status.id=2 and f.friend.id=:userId or f.user.id=:userId")
	List<User> findUserByFriendByOrderStatusById(@Param(value = "userId") Integer userId);

	
	
}
