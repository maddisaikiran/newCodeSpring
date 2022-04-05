package com.app.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.demo.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

	@Query(value="select * from User u LEFT JOIN Message m on u.id = m.user_id  where m.friend_id =:friendId",nativeQuery = true)
	List<Message> findMessagesByUserId(@Param(value="friendId")Integer friendId);
}
