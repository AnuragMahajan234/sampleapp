package com.example.pbapp.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.pbapp.dao.BaseDAO;
import com.example.pbapp.dao.ContactDAO;
import com.example.pbapp.domain.Contact;
import com.example.pbapp.rowmapper.ContactRowMapper;


@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO {

	public void save(Contact contact) {
		String sql = "Insert into contacts(userid,name,phone,group_name) values (:userid,:name,:phone,:group_name)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userid", contact.getUserid());
		params.put("name", contact.getName());
		params.put("phone", contact.getPhone());
		params.put("group_name", contact.getGroup_name());
		System.out.println(params);
		MapSqlParameterSource paramSource = new MapSqlParameterSource(params);
		KeyHolder kh = new GeneratedKeyHolder();
		
		getNamedParameterJdbcTemplate().update(sql, paramSource, kh);
		
		int id = kh.getKey().intValue();
		contact.setId(id);

	}

	public void update(Contact contact) {
		
		String sql = "Update contacts set name=:name,phone=:phone,address=:address,email=:email,remark=:remark,group_name=:group_name where id=:id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", contact.getName());
		params.put("phone", contact.getPhone());
		params.put("group_name", contact.getGroup_name());
		params.put("address", contact.getAddress());
		params.put("email", contact.getEmail());
		params.put("remark", contact.getRemark());
		params.put("id", contact.getId());
		MapSqlParameterSource paramSource = new MapSqlParameterSource(params);
		
		getNamedParameterJdbcTemplate().update(sql, paramSource);

	}

	public void delete(Integer contactId) {
		String sql = "DELETE from contacts where id=?";
		getJdbcTemplate().update(sql, contactId);
	}

	public void delete(Contact contact) {
		this.delete(contact.getId());
	}

	public Contact findById(Integer contactId) {
		String sql = "select * from contacts where id=?";
		Contact contact = getJdbcTemplate().queryForObject(sql, new ContactRowMapper(), contactId);
		return contact;
	}

	public List<Contact> findAll() {
		String sql = "select * from contacts";
		List<Contact> contacts = getJdbcTemplate().query(sql, new ContactRowMapper());
		return contacts;
	}

	public List<Contact> findByProperty(String propertyName, Object propertyValue) {
		String sql = "select * from contacts where "+propertyName+"=?";
		List<Contact> contacts = getJdbcTemplate().query(sql, new ContactRowMapper(),propertyValue);
		return contacts;
	}

}
