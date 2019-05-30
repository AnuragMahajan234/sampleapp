package com.example.pbapp.daoimpl;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.pbapp.dao.BaseDAO;
import com.example.pbapp.dao.UserDAO;
import com.example.pbapp.domain.User;
import com.example.pbapp.rowmapper.UserRowMapper;
import com.example.pbapp.util.SecurePasswordUtil;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO{

	public void save(User user)  throws NoSuchAlgorithmException, NoSuchProviderException {
		
		String sql = "Insert into users(name,status,role,loginname,password) values (:name,:status,:role,:loginname,:password)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", user.getName());
		params.put("status", user.getStatus());
		params.put("role", user.getRole());
		params.put("loginname", user.getLoginname());
		String passwordToHash = user.getPassword();
		//byte[] salt = SecurePasswordUtil.getSalt();
		String securePassword = SecurePasswordUtil.getSecurePassword(passwordToHash);
		params.put("password", securePassword);
		MapSqlParameterSource paramSource = new MapSqlParameterSource(params);
		KeyHolder kh = new GeneratedKeyHolder();
		
		getNamedParameterJdbcTemplate().update(sql, paramSource, kh);
		
		int id = kh.getKey().intValue();
		user.setId(id);
	}

	public void update(User user) {

		String sql = "Update users set name=:name,phone=:phone,address=:address,status=:status,role=:role,email=:email,password=:password where id=:id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", user.getName());
		params.put("phone", user.getPhone());
		params.put("address", user.getAddress());
		params.put("status", user.getStatus());
		params.put("role", user.getRole());
		params.put("email", user.getEmail());
		params.put("password", user.getPassword());
		params.put("id", user.getId());
		MapSqlParameterSource paramSource = new MapSqlParameterSource(params);
		
		getNamedParameterJdbcTemplate().update(sql, paramSource);
		
	}

	public void delete(Integer userId) {
		String sql = "DELETE from users where id=?";
		getJdbcTemplate().update(sql, userId);
		
	}

	public void delete(User user) {
		this.delete(user.getId());
		
	}

	public User findById(Integer userId) {
		String sql = "select * from users where id=?";
		User user = getJdbcTemplate().queryForObject(sql, new UserRowMapper(), userId);
		return user;
	}

	public List<User> findAll() {
		String sql = "select * from users";
		List<User> users = getJdbcTemplate().query(sql, new UserRowMapper());
		return users;
	}

	public List<User> findByProperty(String propertyName, Object propertyValue) {
		String sql = "select * from users where "+propertyName+"=?";
		List<User> users = getJdbcTemplate().query(sql, new UserRowMapper(),propertyValue);
		return users;
	}

}
