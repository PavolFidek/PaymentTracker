package com.vpa.sem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   private UserDetailsService userDetailsService;

   @Bean
   public BCryptPasswordEncoder bCryptPasswordEncoder() {
       return new BCryptPasswordEncoder();
   }

   @Override
   protected void configure(HttpSecurity httpSecurity) throws Exception {
       httpSecurity
               .authorizeRequests()
                   .antMatchers("/dashboard").permitAll()
                   .anyRequest().authenticated()
                   .and()
               .formLogin()
                   .loginPage("/userLogin")
                   //.loginProcessingUrl("/login")
                   .permitAll()
                   .and()
               .logout()
                   .permitAll();

       httpSecurity.csrf().disable();
   }

//    @Bean
//    public AuthenticationManager customAuthenticationManager() throws Exception {
//        return authenticationManager();
//    }

   @Autowired
   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       // auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
       auth.inMemoryAuthentication().withUser("pavol").password("heslo").roles("USER");
   }
}
