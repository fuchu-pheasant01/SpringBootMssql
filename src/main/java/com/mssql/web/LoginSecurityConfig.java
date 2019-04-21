package com.mssql.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/").permitAll() //ルートは全ユーザーがアクセス可能。
				.anyRequest().authenticated() //その他のURLは認証が必要
			.and()
			.formLogin() //Form認証
				.loginPage("/login")
				.defaultSuccessUrl("/sqlview") //ログイン成功時のアクセス先html。UserDetailsServiceメソッドを使う場合は要らない。
				.permitAll()
			.and()
			.logout()
				.permitAll();
	}

	@Autowired
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth
			.inMemoryAuthentication()
				.withUser(User.withUsername("admin")
					.passwordEncoder(encoder::encode) //.withDefaultPasswordEncoder()
					.password("passadmin")
					.roles("ADMIN")
					.build())
			.and()
			.inMemoryAuthentication()
				.withUser(User.withUsername("user")
					.passwordEncoder(encoder::encode)
					.password("passuser")
					.roles("USER")
					.build());
	}

	/*@Bean
    @Override
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails user = User.withUsername("user")
                            .passwordEncoder(encoder::encode)
                            .password("password1")
                            .roles("USER")
                            .build();
        UserDetails admin = User.withUsername("admin")
        					.passwordEncoder(encoder::encode)
        					.password("passadmin")
        					.roles("ADMIN")
        					.build();
        //admin = (UserDetails) new InMemoryUserDetailsManager(admin);
        return new InMemoryUserDetailsManager(admin);
    }*/
}
