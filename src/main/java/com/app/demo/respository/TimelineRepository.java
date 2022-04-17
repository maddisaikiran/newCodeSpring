package com.app.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.demo.model.Timeline;
import com.app.demo.model.User;


@Repository
public interface TimelineRepository extends JpaRepository<Timeline, Integer>{
	
  List<Timeline> findAllByUser(User user);
  
  
  @Query(value="select * from Friend f ,Timeline t LEFT JOIN User u on t.user_id = u.id WHERE "
  		+ "CASE "
  		+ "    WHEN f.user_id =:userId THEN f.friend_id = u.id "
  		+ "    WHEN f.friend_id =:userId THEN f.user_id = u.id "
  		+ "END "
  		+ "    AND f.status_id = 2", nativeQuery = true)
  List<Timeline> findUserByFriendByTimelineById(@Param(value = "userId") Integer userId);
  

  
}
