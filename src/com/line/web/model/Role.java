package com.line.web.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * 用户角色类，涉及用户的权限
 * @author line
 */
@Entity
@Table(name="role")
public class Role implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	//角色名
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
	@ManyToMany(mappedBy="roles")
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
