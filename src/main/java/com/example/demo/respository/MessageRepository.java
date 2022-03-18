package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

	List <Message> findByUserId(Integer id);
}
