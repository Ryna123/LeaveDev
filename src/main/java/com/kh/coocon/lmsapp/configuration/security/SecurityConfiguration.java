package com.kh.coocon.lmsapp.configuration.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomSuccessHandler customSuccessHandler;

	@Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

	/**
	 * For remember me configuration
	 */
	@Autowired
	DataSource dataSource;

	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }
     
     
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/home", "/admin/**").permitAll().antMatchers("/users/**")
				.access("hasRole('ADMIN') or hasRole('USER') or hasRole('HR')").antMatchers("/admin/**")
				.access("hasRole('ADMIN') or hasRole('HR')").antMatchers("/db/**").access("hasRole('DIRECTOR')")

				.and().formLogin().loginPage("/login").successHandler(customSuccessHandler).usernameParameter("ssoId")
				.passwordParameter("password").and().rememberMe().rememberMeParameter("remember-me")
				.tokenRepository(persistentTokenRepository()).and().exceptionHandling()
				.accessDeniedPage("/Access_Denied").and().csrf().disable();

	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl impl = new JdbcTokenRepositoryImpl();
		impl.setDataSource(dataSource);
		return impl;
	}
}