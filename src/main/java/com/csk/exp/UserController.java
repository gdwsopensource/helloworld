package com.csk.exp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = "/getUserList")
	public List<User> getUserList(){
		
		return userRepository.findAll();
	}
	
	@GetMapping(value = "/getUserById")
	public User getUserById(@RequestParam("id") Integer id){
		
		return userRepository.findOne(id);
	}
	
	@GetMapping(value = "/getUserByName")
	public List<User> getUserByName(@RequestParam("name") String name){
		return userRepository.findByName(name);
	}
	
	@GetMapping(value = "/getUserByAge")
	public List<User> getUserByAge(@RequestParam("age") Integer age){
		return userRepository.findByAge(age);
	}
	
	@PostMapping(value="/addUser")
	public User addUser(@RequestParam(defaultValue="100",name="age") Integer age, 
						@RequestParam(defaultValue="mary",name="name") String name){
		User user = new User();
		user.setAge(age);
		user.setName(name);
		return userRepository.save(user);
	}
	
	@PutMapping(value="/updateUserById")
	public User updateUserById(@RequestParam("id") Integer id,
							   @RequestParam("age") Integer age,
							   @RequestParam("name") String name){
		User user = userRepository.findOne(id);
		if(age != 0){
			user.setAge(age);
		}
		if(!name.equals("")){
			user.setName(name);
		}
		return userRepository.save(user);
	}
	
	@DeleteMapping(value = "/deleteUserById")
	public void deleteUserById(@RequestParam("id") Integer id){
		userRepository.delete(id);
	}
	

}
