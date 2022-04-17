package com.app.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.demo.model.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like, Integer>{
	
@Query(value="select * from User u LEFT JOIN Liked l on u.id = l.user_id LEFT JOIN Timeline t on t.time_id = l.message_id where t.time_id =:timeId", nativeQuery = true)
List <Like> findUserLikesByMessageById(@Param(value = "timeId") Integer timeId);


}
