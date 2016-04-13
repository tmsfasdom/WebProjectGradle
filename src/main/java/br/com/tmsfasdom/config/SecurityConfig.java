package br.com.tmsfasdom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.com.tmsfasdom.business.ProvedorAutenticacao;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//@Autowired
	//private ProvedorAutenticacao authProvider;

	//@Override
	//protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	//	auth.authenticationProvider(authProvider);
	//}

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password("dba").roles("ADMIN", "DBA");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/rest/**").permitAll().antMatchers("/")
				.access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')").antMatchers("/admin/**")
				.access("hasRole('ADMIN')").antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')").and()
				.formLogin().and().exceptionHandling().accessDeniedPage("/Access_Denied");

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/soap/**");
	}
}
