package com.app.demo.respository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.demo.model.FriendStatus;

@Repository
public interface FriendStatusRepository extends JpaRepository<FriendStatus, Integer>{

	@Query("select fs from FriendStatus fs where fs.code=(:statusCode)")
	FriendStatus findByStatus(String statusCode);

}
