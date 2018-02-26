package com.demo.graduationuser.user.entity;

//import com.baomidou.mybatisplus.annotations.TableField;
//import com.baomidou.mybatisplus.activerecord.Model;
//import java.io.Serializable;
//
///**
// * <p>
// *
// * </p>
// *
// * @author cl
// * @since 2018-02-25
// */
//public class User extends Model<User> {
//
//    private static final long serialVersionUID = 1L;
//
//	private String id;
//	private String name;
//	@TableField("nick_name")
//	private String nickName;
//	private String password;
//	private String sex;
//	private Integer age;
//	private String email;
//	private String phone;
//	private String status;
//	@TableField("head_url")
//	private String headUrl;
//
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getNickName() {
//		return nickName;
//	}
//
//	public void setNickName(String nickName) {
//		this.nickName = nickName;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getSex() {
//		return sex;
//	}
//
//	public void setSex(String sex) {
//		this.sex = sex;
//	}
//
//	public Integer getAge() {
//		return age;
//	}
//
//	public void setAge(Integer age) {
//		this.age = age;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public String getHeadUrl() {
//		return headUrl;
//	}
//
//	public void setHeadUrl(String headUrl) {
//		this.headUrl = headUrl;
//	}
//
//	@Override
//	protected Serializable pkVal() {
//		return this.id;
//	}
//
//	@Override
//	public String toString() {
//		return "User{" +
//			"id=" + id +
//			", name=" + name +
//			", nickName=" + nickName +
//			", password=" + password +
//			", sex=" + sex +
//			", age=" + age +
//			", email=" + email +
//			", phone=" + phone +
//			", status=" + status +
//			", headUrl=" + headUrl +
//			"}";
//	}
//}

import com.demo.graduationuser.common.BaseDomain;

import javax.persistence.*;

public class User extends BaseDomain{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select uuid()")
	private String id;

	private String name;

	@Column(name = "nick_name")
	private String nickName;

	private String password;

	private String sex;

	private Integer age;

	private String email;

	private String phone;

	private String status;

	@Column(name = "head_url")
	private String headUrl;

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return nick_name
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return head_url
	 */
	public String getHeadUrl() {
		return headUrl;
	}

	/**
	 * @param headUrl
	 */
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
}