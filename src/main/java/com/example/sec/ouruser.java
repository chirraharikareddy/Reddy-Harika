package com.example.sec;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="user")
public class ouruser {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String password;
	@ManyToMany
	@JoinTable(name="user_role"
	,joinColumns = {@JoinColumn(name="uid")}
	,inverseJoinColumns = {@JoinColumn(name="rid")})
	private List<role> roles;
	

}
