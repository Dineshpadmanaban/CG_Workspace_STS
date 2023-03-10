package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/service/user")
public class UserController {

	@Autowired
	UserService userService;

//creating a get mapping that retrieves all the users detail from the database   
	@GetMapping("/get")
	private List<User> getAllUser() {
		return userService.getAllUser();
	}

//creating a get mapping that retrieves the detail of a specific user  
	@GetMapping("/get/{userid}")
	private User getUser(@PathVariable("userno") int userid) {
		return userService.getUserById(userid);
	}

//creating a delete mapping that deletes a specified user  
	@DeleteMapping("/user/{userno}")
	private void deleteUser(@PathVariable("userno") int userid) {
		userService.delete(userid);
	}

//creating post mapping that post the user detail in the database  
	@PostMapping("/add")
	private int saveUser(@RequestBody User users) {
		userService.saveOrUpdate(users);
		return users.getUserId();
	}

//creating put mapping that updates the user detail   
	@PutMapping("/update")
	private User update(@RequestBody User user) {
		userService.saveOrUpdate(user);
		return user;
	}
	
	@PostMapping("/login")
	public String login(@RequestBody String jsonString, HttpServletRequest request) throws Exception {
		JSONObject output = new JSONObject();
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			User user = userService.getUser(jsonObject.optString("loginId"));
			if (user.getLoginId() == null) {
				output.put("ERROR", "Wrong LoginId or Password");
			} else {
				output.put("loginId",user.getLoginId());
			}

		} catch (Exception e) {
			output.put("ERROR", "Exception in login");
		}
		return output.toString();
	}
}
