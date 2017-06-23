package com.csk.exp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	public List<User> findByName(String name);
	public List<User> findByAge(Integer age);
}
