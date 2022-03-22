package com.app.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.demo.model.User;




@Repository
public interface UserRespository extends JpaRepository <User, Integer>{
	
	User findByEmailId(String emailId);
	User findByEmailIdAndPassword(String emailId, String password) ;
	
	
	//@Query("select u from User u left join Friend f on f.friend.id=u.id where f.status.id=2 and f.friend.id=:userId or f.user.id=:userId")
	
	@Query(value="select * from User u, Friend f WHERE "
			+ "CASE "
			+ "WHEN f.user_id=:userId THEN f.friend_id=u.id "
			+ "WHEN f.friend_id=:userId THEN f.user_id=u.id "
			+ "END "
			+ "AND f.status_id=2", nativeQuery = true)
	List<User> findUserByFriendByOrderStatusById(@Param(value = "userId") Integer userId);

	
	
}
