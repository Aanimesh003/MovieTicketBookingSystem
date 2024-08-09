package com.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieticketbooking.entity.User;
import com.movieticketbooking.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService us;

	@GetMapping("/alluser")
	public List<User> getAllUser() {
		return us.getAllUser();
	}

	@GetMapping("user/{id}")
	public ResponseEntity<User> getUserbyId(@PathVariable int id) {
		User user = us.getUserbyId(id);
		if (user == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(user);
		}
	}

	@PostMapping("/saveuser")
	public String saveUser(@RequestBody User user) {
		return us.saveUser(user);
	}

	@PutMapping("user/{id}")
	public String updateUser(@PathVariable int id, @RequestBody User user) {
		user.setUserid(id);
		return us.updateUser(user);
	}

	@DeleteMapping("user/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		return us.deleteUser(id);
	}

	@GetMapping("/user/movieid/{id}")
	public List<User> getUserbyMovieid(@PathVariable int id) {
		return us.getUserbyMovieid(id);
	}

	@GetMapping("username/movieid/{id}")
	public List<String> getUsernameByMovieid(@PathVariable int id) {
		return us.getUsernameByMovieid(id);
	}

	@GetMapping("/movieid/{username}")
	public Integer getMovieidByUsername(@PathVariable String username) {
		return us.getMovieidByUsername(username);
	}

	@GetMapping("/users/letter/{letter}")
	public List<String> getUsernameByInitialLetter(@PathVariable("letter") String letter) {
		return us.getUsernameByInitialLetter(letter);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<Object> getUserByid(@PathVariable int userId) {
		User user = us.getUserByid(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(user);
		}
	}

	@PutMapping("/{userid}/movie/{movieid}")
	public String updateMovied(@PathVariable int userid, @PathVariable int movieid) {
		return us.updateMovied(userid, movieid);
	}
}
