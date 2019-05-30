package com.example.pbapp.dao;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

import com.example.pbapp.domain.User;

/**
 * This UserDAO interface will perform all crud operation related to user
 * @author arju.yadav
 *
 */
public interface UserDAO {

	public void save(User user) throws NoSuchAlgorithmException,NoSuchProviderException;
	public void update(User user);
	public void delete(Integer userId);
	public void delete(User user);
	public User findById(Integer userId);
	public List<User> findAll();
	public List<User> findByProperty(String propertyName, Object propertyValue);
}
