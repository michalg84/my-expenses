package dev.galka.config;

import dev.galka.service.user.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor
public class WebConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private final UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/register", "/login/error", "/table/transaction").permitAll()

                //                .antMatchers("/save").hasAnyAuthority("ADMIN")
                //                .antMatchers("/user/**").hasRole("USER")

                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and().headers().frameOptions().sameOrigin()
                .and()
                .csrf()
                .disable()       //wyłącznie tokena
                //                .and()
                .formLogin()
                .loginPage("/login")
                //                .loginProcessingUrl("/transaction/list")
                .failureForwardUrl("/login/error")
                .successForwardUrl("/user/account")
                .passwordParameter("password")
                .usernameParameter("username")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("remember-me")
                .logoutSuccessUrl("/login")
                .permitAll()
                .and()
                .rememberMe();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl)
                .passwordEncoder(bCryptPasswordEncoder);
    }
}
