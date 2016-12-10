package mum.edu.cs544;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery(
						"select  user_name,password ,1 as enabled from user_credential where user_name=? ")
				.authoritiesByUsernameQuery("select  user_name,authority from user_credential where user_name=? ");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/cardservice","/categoryList","/brandList","/search","/cart","/addToCart",
				"/card/form","/card/checkout","/resources/images/**").permitAll().anyRequest().authenticated().

				and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();
	}

	// for query based multiple user authorization

	// "select u1.userName, u2.authority from user_credentail u1, authorities u2
	// where u1.member_name = u2.member_name and u1.member_name =?");

	/*
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception {
	 * auth.inMemoryAuthentication().withUser("admin").password("admin").roles(
	 * "USER"); }
	 */
}
