package com.example.pbapp.serviceimpl;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.pbapp.dao.BaseDAO;
import com.example.pbapp.dao.UserDAO;
import com.example.pbapp.domain.User;
import com.example.pbapp.exception.BlockUserException;
import com.example.pbapp.exception.UserAlreadyExistException;
import com.example.pbapp.rowmapper.UserRowMapper;
import com.example.pbapp.service.UserService;
import com.example.pbapp.util.SecurePasswordUtil;

@Service
public class UserServiceImpl extends BaseDAO implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public void register(User user) throws UserAlreadyExistException {
		
		try {
			userDAO.save(user);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}
	}

	public User login(String loginname, String password) throws BlockUserException {
		
		String securePassword = SecurePasswordUtil.getSecurePassword(password);
		String sql = "select * from users where loginname=:loginname and password=:password";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginname", loginname);
		params.put("password", securePassword);
		try {
			User user = getNamedParameterJdbcTemplate().queryForObject(sql,params, new UserRowMapper());
			if(user.getStatus().equals(UserService.USER_STATUS_BLOCKED)) {
				throw new BlockUserException("You are blocked. Contact admin for more information");
			} else {
			return user;
			}
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<User> getUserList() {
		
		return userDAO.findAll();
	}

	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		User user = userDAO.findById(userId);
		user.setStatus(loginStatus);
		userDAO.update(user);
	}

}
