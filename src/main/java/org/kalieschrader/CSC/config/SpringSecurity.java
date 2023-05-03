package org.kalieschrader.CSC.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity{
	  @Autowired
	    private UserDetailsService userDetailsService;


	    @Bean
	    public static BCryptPasswordEncoder passwordEncoder(){
	        return new BCryptPasswordEncoder();
	    }

	    // configure SecurityFilterChain
	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	        .authorizeHttpRequests()
	        .requestMatchers("/register/**").permitAll()
          .requestMatchers("/login/**").permitAll()
          .requestMatchers("/index**").hasRole("USER")
          .requestMatchers("/spells/**").permitAll()
          .requestMatchers("/css/**").permitAll()
          .requestMatchers("/item/**").permitAll()
          .requestMatchers("/races/**").permitAll()
          .requestMatchers("/weapon/**").permitAll()
          .requestMatchers("/armor/**").permitAll()
          .requestMatchers("/classes/**").permitAll()
          .requestMatchers("/js/**").permitAll()
          .requestMatchers("/deletecheck/**").hasRole("USER")
          .requestMatchers("/diceroller/**").hasRole("USER")
          .requestMatchers("/editpage1/**").hasRole("USER")
          .requestMatchers("/editpage2/**").hasRole("USER")
          .requestMatchers("/page2/**").hasRole("USER")
          .requestMatchers("/page1/**").hasRole("USER")
          .requestMatchers("/userview").hasRole("ADMIN")
          .requestMatchers("/parentInfo/**").permitAll()
          .requestMatchers("/charsheetpage/**").hasRole("USER")
          .requestMatchers("/newcharacterstart/**").hasRole("USER")
          .requestMatchers("/oldcharacterview/**").hasRole("USER")
          .requestMatchers("/images/**").permitAll()
          .requestMatchers("/characterSheet/**").hasRole("USER")
          .requestMatchers("/users").hasRole("USER")
//          .requestMatchers("/users").hasRole("USER")
	                .and()
	                .formLogin(
	                        form -> form
	                                .loginPage("/login")
	                                .loginProcessingUrl("/login")
	                                .defaultSuccessUrl("/index", true)
	                                .permitAll()
	                ).logout(
	                        logout -> logout
	                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	                                .logoutSuccessUrl("/login")
	                                .invalidateHttpSession(true)
	                                .deleteCookies("JSESSIONID")
	                                .permitAll()

	                );
	        return http.build();
	    }

	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
	        builder.userDetailsService(userDetailsService)
	                .passwordEncoder(passwordEncoder());
	    }
	}

