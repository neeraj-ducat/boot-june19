package com.ducat.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ducat.models.User;

@Repository
public class UserDao {

	// Dependency of the Repository
	@Autowired
	JdbcTemplate template;
	
	//Query to save a user
	static final String save_query="insert into UsersMaster (name,mailId,password) values (?,?,?)";
	//Query to find a user using mailId
	static final String find_query="select * from UsersMaster where mailId=?";
 // Method to save a user
	public void save(User user) { 
		template.update(save_query,user.getName(),user.getMailId(),user.getPassword());
		
	}
	// Method to find a user using mailId
		public User findByMailId(String mailId) { 
			List<User> list = 
					template.query(find_query, new String[] {mailId}, mapper);
			if (list.isEmpty())
				return null;
			else
				return list.get(0);
		}
	// Inner class to map UsersMaster records to User objects
	RowMapper<User> mapper= new RowMapper<User>() {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setMailId(rs.getString(3));
			user.setPassword(rs.getString(4));
			return user;
		}
		
	};
		
}
