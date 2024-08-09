package com.movieticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieticketbooking.dao.UserDao;
import com.movieticketbooking.entity.User;

@Service
public class UserService {

	@Autowired 
	private UserDao ud;
	
	public List<User> getAllUser() {
		return ud.getAllUser();
	}

	public User getUserbyId(int id) {
		return ud.getUserbyId(id);
	}

	public String saveUser(User user) {
		return ud.saveUser(user); 
	}

	public String updateUser(User user) {
		return ud.updateUser(user);
	}

	public String deleteUser(int id) {
		return ud.deleteUser(id);
	}

	public List<User> getUserbyMovieid(int id) {
		return ud.getUserbyMovieid(id);
	}

	public List<String> getUsernameByMovieid(int id) {
		return ud.getUsernameByMovieid(id);
	}

	public Integer getMovieidByUsername(String username) {
		return ud.getMovieidByUsername(username);
	}

	public List<String> getUsernameByInitialLetter(String letter) {
		return ud.getUsernameByInitialLetter(letter);
	}
	
	public User getUserByid(int userId)
	{
		return ud.getUserbyId(userId);
	}

	public String updateMovied(int userid,int movieid) {
		return ud.updateMovied(userid,movieid);
	}

}
