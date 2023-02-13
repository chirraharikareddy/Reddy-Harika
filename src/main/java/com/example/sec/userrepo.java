package com.example.sec;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface userrepo extends JpaRepository<ouruser, Integer>{
	@Query("select u from ouruser u where u.name=?1")
	public abstract ouruser getUserName(String username);
	@Query("select r from ouruser u join u.roles r where u.name=?1")
	public abstract List<role> getroles(String username);

}
