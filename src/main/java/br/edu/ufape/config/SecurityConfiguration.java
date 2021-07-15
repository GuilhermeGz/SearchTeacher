package br.edu.ufape.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.edu.ufape.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Autowired
	MyUserDetailsService userDetailService;
	
		//authenticatin SETUP
	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception{
				
		auth.userDetailsService(userDetailService);
		
	}
	  
	
	//authorization SETUP
	
	@Override
	protected void configure (HttpSecurity http) throws Exception{
	
	/*	http.authorizeRequests()
          .antMatchers("/", "/home").permitAll(); 
		http.authorizeRequests()
          .antMatchers("/resources/**").permitAll();
		http.authorizeRequests()
          .antMatchers( "/admin/**").hasAnyAuthority("ADMIN");

        //....
		//....
		*/
		
		http.csrf().disable();
		
		http.authorizeRequests()
        .antMatchers( "/api/**").hasAnyAuthority("ADMIN");
		http.authorizeRequests()
        .antMatchers( "/professor/**").hasAnyAuthority("ADMIN");
		http.authorizeRequests()
        .antMatchers( "/formacao/**").hasAnyAuthority("ADMIN");
		http.authorizeRequests()
        .antMatchers( "/instituicao/**").hasAnyAuthority("ADMIN");
		http.authorizeRequests()
        .antMatchers( "/areamenor/**").hasAnyAuthority("ADMIN");
		http.authorizeRequests()
        .antMatchers( "/atividadedesenvolvida/**").hasAnyAuthority("ADMIN");
		http.authorizeRequests()
        .antMatchers( "/home").permitAll();
		http.authorizeRequests()
        .antMatchers( "/").permitAll();

        http.formLogin().loginPage("/login")
        .defaultSuccessUrl("/professor/");
        
        http.logout().logoutSuccessUrl("/login?logout").permitAll();
       
		
	 
	}
	
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
	
	
} 
