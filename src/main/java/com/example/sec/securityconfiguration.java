package com.example.sec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class securityconfiguration extends WebSecurityConfigurerAdapter{
	@Override
	@Bean
	//hii
	protected UserDetailsService userDetailsService() {
		UserDetails ud1=User.builder()
				 .username("sony")
				 .password("{noop}sony")
				 .roles("USER")
				 .build();
		UserDetails ud2=User.builder()
				 .username("chinnu")
				 .password("{noop}chinnu")
				 .roles("USER","MANAGER")
				 .build();
		UserDetails ud3=User.builder()
				 .username("institute")
				 .password("{noop}institute")
				 .roles("USER","MANAGER","ADMIN")
				 .build();
		return new InMemoryUserDetailsManager(ud1,ud2,ud3);
	}

}
