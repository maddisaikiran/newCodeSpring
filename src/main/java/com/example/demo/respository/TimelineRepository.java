package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Timeline;
import com.example.demo.model.User;


@Repository
public interface TimelineRepository extends JpaRepository<Timeline, Integer>{
	
  List<Timeline> findAllByUser(User user);
}
