package com.example.pbapp.service;

import java.util.List;

import com.example.pbapp.domain.Contact;

/**
 * ContactService is responsible for all the Business Related Requirements for user
 * @author arju.yadav
 *
 */
public interface ContactService {

	/**
	 * This method adds the contact
	 * @param contact to be saved
	 */
	public void save(Contact contact);
	/**
	 * This method updates the contact
	 * @param contact to be updated
	 */
	public void update(Contact contact);
	/**
	 * This method deletes the Contact
	 * @param contactId of contact to be deleted
	 */
	public void delete(Integer contactId);
	/**
	 * This method deletes all those contacts records whose id is specified.
	 * @param contactIds to be deleted
	 */
	public void delete(Integer[] contactIds);
	/**
	 * This method returns all user contacts (User who is logged in)
	 * @param userId of logged in user
	 * @return List<Contact> contact list of logged in user
	 */
	public List<Contact> findUserContact(Integer userId);
	/**
	 * This method returns all user contacts based on specified search criteria (User who is logged in)
	 * @param userId of logged in user
	 * @param txt search criteria
	 * @return List<Contact> contact list based on specified search criteria
	 */
	public List<Contact> findUserContact(Integer userId,String txt);
}
