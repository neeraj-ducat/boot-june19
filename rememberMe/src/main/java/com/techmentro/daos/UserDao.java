package com.techmentro.daos;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.techmentro.entities.User;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate template;
	
	private static final String save_query=
	"insert into UserMaster (name,mailId,password) values(?,?,?)";
	
	private static final String load_query=
			"select * from UserMaster where mailId=?";
			
	
	//method to load users
		public List<User> loadUser(String mailId) 
		{
			return template.query(load_query,new String[]{mailId},new UserMapper());
		}
	
		private class UserMapper implements RowMapper<User>
		{

			public User mapRow(ResultSet rset, int index) throws SQLException {
				User user=new User();
				user.setId(rset.getInt(1));
				user.setName(rset.getString(2));
				user.setMailId(rset.getString(3));
				user.setPassword(rset.getString(4));
				user.setActive(rset.getBoolean(5));
				return user;
			}
			
		}
		
	
	//method to save the user
	public void save(User user)
	{
		template.update(save_query,user.getName(),user.getMailId(),user.getPassword());
	}
}
