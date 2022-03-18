package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cart;
import com.example.demo.model.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	List<Cart> findCartsByUser(User user);

}
