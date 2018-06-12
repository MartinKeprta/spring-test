package org.dimatech.configuration;

import org.dimatech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.Resource;

/**
 * Created by Sam.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true)
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Resource(name = "userService")
	private UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/vendor/**", "/dist/**").permitAll()
				.antMatchers("/register*").anonymous()
				.antMatchers("/confirm*").anonymous()
				.antMatchers("/login*").anonymous()
				.antMatchers("/", "/index", "/**", "/logout").authenticated();
		http.formLogin()
				// указываем страницу с формой логина
				.loginPage("/login")
				// указываем action с формы логина
				.loginProcessingUrl("/login")
				// указываем URL при неудачном логине
				.failureUrl("/login?error")
				// Указываем параметры логина и пароля с формы логина
				.usernameParameter("username")
				.passwordParameter("password")
				// даем доступ к форме логина всем
				.successForwardUrl("/game")
				.permitAll();
		http.logout()
				// указываем URL при удачном логауте
				.logoutSuccessUrl("/login")
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				// разрешаем делать логаут всем
				.permitAll()
				// делаем не валидной текущую сессию
				.invalidateHttpSession(true);
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}