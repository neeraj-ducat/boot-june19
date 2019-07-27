package com.ducat.validators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ducat.dao.UserDao;
import com.ducat.entities.User;

@Component
public class MailValidator implements Validator
{
	@Autowired
	private UserDao dao;

	@Override
	public boolean supports(Class<?> cl) {
		
		return cl.equals(User.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user=(User)target;
		try {
		List<User> list=dao.findByMailId(user.getMailId());
		if(!list.isEmpty())
		{
			//mailId already exists, fail the validation
			errors.rejectValue("mailId", "mailId", "Already registered.");
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
