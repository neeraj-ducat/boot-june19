package com.ducat.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import com.ducat.entities.User;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate template;
	
	
	private static final String save_query = "insert into UsersMaster (name, mailId, password) values (?,?,?)";
	private static final String find_query = "select * from UsersMaster where mailId=?";
	
	
	public void save(User user) throws Exception
	{
		template.update(save_query, user.getName(), user.getMailId(), user.getPassword());
	}
	
	public List<User> findByMailId(String mailId) throws Exception
	{
		return template.query(find_query, new String[] {mailId}, rm);
	}
	
	private RowMapper<User> rm =new RowMapper<User>() {
			
		public User mapRow(ResultSet rset, int index) throws SQLException {
			User user=new User();
			user.setId(rset.getInt(1));
			user.setName(rset.getString(2));
			user.setMailId(rset.getString(3));
			user.setPassword(rset.getString(4));
			return user;
		}
	};
}
