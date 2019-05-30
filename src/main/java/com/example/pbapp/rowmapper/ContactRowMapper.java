package com.example.pbapp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.pbapp.domain.Contact;

public class ContactRowMapper implements RowMapper<Contact> {

	public Contact mapRow(ResultSet rs, int count) throws SQLException {
		Contact contact = new Contact();
		contact.setId(rs.getInt("id"));
		contact.setUserid(rs.getInt("userid"));
		contact.setName(rs.getString("name"));
		contact.setPhone(rs.getString("phone"));
		contact.setGroup_name(rs.getString("group_name"));
		contact.setAddress(rs.getString("address"));
		contact.setEmail(rs.getString("email"));
		contact.setRemark(rs.getString("remark"));
		return contact;
	}

}
