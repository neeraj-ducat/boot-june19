package com.ducat.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ducat.models.User;
import com.ducat.repositories.UserDao;

@Component
public class MailValidator implements Validator {

	@Autowired
	UserDao dao;
	
	@Override
	public boolean supports(Class<?> cls) {
		
		return cls.equals(User.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// target object is typecasted to the supported class.
		User user = (User)target; 
		// perform the customer validation
		User found = dao.findByMailId(user.getMailId());
		if(found != null)
		{
			// validation is failed, add an error to the binding result.
			errors.rejectValue("mailId", "mailId", "Already registered.");
		}
	}

}
