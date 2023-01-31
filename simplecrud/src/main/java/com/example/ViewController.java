package com.example;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.User;
import com.example.service.UserService;
import com.example.utility.JSONUtility;
import com.example.service.ShareService;
import com.example.model.Share;

@Controller
public class ViewController {

	@Autowired
	UserService userService;
	@Autowired
	ShareService shareService;
	
	@RequestMapping("/")
	public ModelAndView goHome(HttpServletRequest request) throws Exception {
		ModelAndView model = new ModelAndView();
		model = new ModelAndView("login");
		return model;
	}

	@RequestMapping("/home/{loginId}")
	public ModelAndView home(@PathVariable("loginId") String loginId, HttpServletRequest request) throws Exception {
		ModelAndView model = new ModelAndView();
		model = new ModelAndView("order");
		try {
			User user = userService.getUser(loginId);
			List<Share> shares = shareService.getAllShare();
			model.addObject("shares", JSONUtility.toJson(shares));
			model.addObject("user", JSONUtility.toJson(user));
		} catch (Exception e) {
			
		}
		return model;
	}

}
	
//
//@RequestMapping("/employ")
//public ModelAndView employeeHome(HttpServletRequest request) throws Exception {
//ModelAndView model = new ModelAndView();
//model = new ModelAndView("employeecrud");
//return model;
//}
//
//@RequestMapping("/gadi")
//public ModelAndView vehicleHome(HttpServletRequest request) throws Exception {
//ModelAndView model = new ModelAndView();
//model = new ModelAndView("vehiclecrud");
//return model;
//}
//}
//
