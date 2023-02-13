package com.example.sec;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ouruserdetailsservice implements UserDetailsService{
	@Autowired
	private userrepo userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("user name given::"+username);
		ouruser ouruser =userrepo.getUserName(username);
		if(ouruser!=null)
		{
			log.info("user details ::"+ouruser.getName()+"::"+ouruser.getPassword());
		}
		List<role> roles=userrepo.getroles(username);
		log.info("role objects::"+roles);
		String[] strroles=new String[roles.size()];
		for(int i=0;i<roles.size();i++)
		{
			strroles[i] =roles.get(i).getName();
		}
		log.info("role strings::"+roles);
		UserDetails ud=User.builder()
				.username(ouruser.getName())
				.password("{noop}"+ouruser.getPassword())
				.roles(strroles)
				.build();
		return ud;
	}

}
