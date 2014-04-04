package com.line.web.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * 用户角色类，涉及用户的权限
 * @author line
 */
@Entity
@Table(name="role")
public class Role {
	
	private String id;
	
	private String name;
	
	private List<User> users;
	
	public Role(){	
	}
	
//	public Role(String name){
//		this.name = name;
//	}
	
	@Id
	@GeneratedValue(generator="sd")
	@GenericGenerator(name="sd",strategy="uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="name",unique=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@ManyToMany
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
