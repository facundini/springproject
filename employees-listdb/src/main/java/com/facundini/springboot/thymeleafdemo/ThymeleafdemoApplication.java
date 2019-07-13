package com.facundini.springboot.thymeleafdemo;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ThymeleafdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafdemoApplication.class, args);
	}
	
	
	  @Bean
	  public WebSecurityConfigurerAdapter webSecurityConfig(DataSource dataSource) {
	      return new WebSecurityConfigurerAdapter() {
	          @Override
	          protected void configure(HttpSecurity http) throws Exception {
	              http.authorizeRequests()
	              	.antMatchers("/employees/list").permitAll()
	              	.antMatchers("/employees/showFormForAdd").hasRole("ADMIN").and()
	              		.formLogin()
	    			.loginPage("/employees/showFormForLogin")
	    			.loginProcessingUrl("/loginProccess").defaultSuccessUrl("/employees/list")
	    			.permitAll()
	    			.and()
	    			.logout().logoutSuccessUrl("/employees/list").permitAll()
	    			.and().exceptionHandling().accessDeniedPage("/access-denied");
	          }

	          @Override
	          protected void configure(AuthenticationManagerBuilder builder) throws Exception {
	              builder.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username, password, enabled from users where username=?")
	      		.authoritiesByUsernameQuery("select username, authority from authorities where username=?").passwordEncoder(new BCryptPasswordEncoder());
	          }
	      };
	  }

}
