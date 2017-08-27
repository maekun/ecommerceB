package jp.co.rakus.ecommerce_b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	

	@Override
	//以下に記載したパスはセキュリティ対象外
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/**","/fonts/**","/img/**","/js/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//ログアウト状態でもリクエストを許可するパスを指定
		http.authorizeRequests()
			.antMatchers("/**").permitAll()
			.anyRequest().authenticated();
		http.formLogin()
			.loginProcessingUrl("/login")
			.loginPage("/loginform")
			.failureUrl("/loginform?error=true")
			.defaultSuccessUrl("/top/",false)
			.usernameParameter("email").passwordParameter("password")
			.and();
		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/loginform")
			.deleteCookies("JSESSIONID")
            .invalidateHttpSession(true).permitAll();
	}
	
	@Configuration
	static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter{
		@Autowired
		UserDetailsService userDetailsService;
		
		
		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService)
				.passwordEncoder(new StandardPasswordEncoder());
		}
	}
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new StandardPasswordEncoder();
	}
}
