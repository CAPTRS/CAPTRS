package com.citi.trs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.citi.trs.model.UserModel;

@Component
public class LoginDAO {

	
	DataSource dataSource;	//bean id
	JdbcTemplate jdbcTemplate;
	
	
	public List<UserModel> getAllUsers(){
		String sqlQuery="select username,pass from usrpass";//username,pass
		return jdbcTemplate.query(sqlQuery,new UserModelRowMapper());
	}


	@Autowired
	public void setDataSource(DataSource dataSource) {
		
		this.dataSource = dataSource;
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	class UserModelRowMapper implements RowMapper<UserModel>{

		@Override
		public UserModel mapRow(ResultSet rs, int arg1) throws SQLException {
			UserModel userModel=new UserModel();
			
			userModel.setUserName(rs.getString("username"));
			userModel.setPassword(rs.getString("pass"));
			//rs.next();
			return userModel;
		}
		
	}
}
