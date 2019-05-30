package com.example.pbapp.domain;
/**
 * This Contact model is used as a data traveller from layer to layer
 * @author arju.yadav
 *
 */

public class Contact extends Person {

	/**
	 * user id 
	 */
	private Integer userid;
	/**
	 * group of contact
	 */
	private String group_name;
	/**
	 * remark for contact
	 */
	private String remark;
	
	/**
	 * contact created by
	 */
	private String created_by;
	/**
	 * contact updated by
	 */
	private String updated_by;
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}
	
}
