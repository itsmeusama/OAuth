package com.usama.oauthserver.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration extends GlobalAuthenticationConfigurerAdapter{
	PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Kapeesan")
									 .password(passwordEncoder
				                     .encode("12345"))
		                             .roles("ADMIN","USER")
		                             .authorities("CAN_READ").and()
		                             
		                             .withUser("usama")
		                             .password(passwordEncoder.encode("123"))
		                             .roles("ADMIN","USER")
		                             .authorities("CAN_READ");
	}

	
}
