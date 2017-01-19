package com.citi.trs.service;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citi.trs.dao.LoginDAO;
import com.citi.trs.model.UserModel;

@Component
public class LoginService {

	@Autowired
	LoginDAO loginDAO;
	
	
	public String validateUser(UserModel inputUserModel){
		JSONObject obj = new JSONObject();
		List<UserModel> usersList=loginDAO.getAllUsers();	//List of db users and pass using rowmapper and returns jdbc template.
		obj.put("loginStatus", false);
		for(int i=0;i<usersList.size();i++){
			UserModel currentUser=usersList.get(i);
			if(inputUserModel.getUserName().equalsIgnoreCase(currentUser.getUserName())  
				&& inputUserModel.getPassword().equals(currentUser.getPassword())){
				obj.put("loginStatus", true);
				break;
			}
			
		}
		return obj.toJSONString();
		
	}
	
	
}

