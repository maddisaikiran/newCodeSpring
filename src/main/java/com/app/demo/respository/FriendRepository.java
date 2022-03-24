package com.app.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.demo.model.Friend;


@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer>{
	
	@Query("select f from Friend f where f.user.id=(:userId) or f.friend.id = (:userId)")
	List<Friend> findFriendsByUserId(Integer userId);

}
