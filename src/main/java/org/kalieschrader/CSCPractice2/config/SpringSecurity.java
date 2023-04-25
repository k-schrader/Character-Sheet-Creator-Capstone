package org.kalieschrader.CSCPractice2.config;


import org.kalieschrader.CSCPractice2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
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
          .requestMatchers("/index**").permitAll()
          .requestMatchers("/spells/**").permitAll()
          .requestMatchers("/css/**").permitAll()
          .requestMatchers("/item/**").permitAll()
          .requestMatchers("/races/**").permitAll()
          .requestMatchers("/weapon/**").permitAll()
          .requestMatchers("/armor/**").permitAll()
          .requestMatchers("/classes/**").permitAll()
          .requestMatchers("/js/**").permitAll()
          .requestMatchers("/page2/**").permitAll()
          .requestMatchers("/page1/**").permitAll()
          .requestMatchers("/parentInfo/**").permitAll()
          .requestMatchers("/charsheetpage/**").permitAll()
          .requestMatchers("/newcharacterstart/**").permitAll()
          .requestMatchers("/oldcharacterview/**").permitAll()
          .requestMatchers("/images/**").permitAll()
          .requestMatchers("/characterSheet/**").permitAll()
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


//@Autowired
//private UserService userService;
//
//@Bean
//public BCryptPasswordEncoder passwordEncoder(){
// return new BCryptPasswordEncoder();
//}
//
//    // configure SecurityFilterChain
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/register/**").permitAll()
//                .requestMatchers("/login/**").permitAll()
//                .requestMatchers("/index**").permitAll()
//                .requestMatchers("/spells/**").permitAll()
//                .requestMatchers("/css/**").permitAll()
//                .requestMatchers("/item/**").permitAll()
//                .requestMatchers("/races/**").permitAll()
//                .requestMatchers("/weapon/**").permitAll()
//                .requestMatchers("/armors/**").permitAll()
//                .requestMatchers("/classes/**").permitAll()
//                .requestMatchers("/js/**").permitAll()
//                .requestMatchers("/page2/**").permitAll()
//                .requestMatchers("/images/**").permitAll()
//                .requestMatchers("/users").hasRole("ADMIN")
////                .requestMatchers("/users").hasRole("USER")
//                .and()
//                .formLogin(
//                        form -> form
//                                .loginPage("/login")
//                                .defaultSuccessUrl("/index", true)
//                                .permitAll()
//                                .failureUrl("/login.html?error=true")
////                                
//                ).logout(
//                        logout -> logout
//                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                                .permitAll()
//
//                );
//        return http.build();
//    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
//        builder.userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }
//}