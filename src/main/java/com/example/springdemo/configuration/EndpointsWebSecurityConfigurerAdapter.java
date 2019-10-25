package com.example.springdemo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * Health care Service security configurations password is encoded with {@link BCryptPasswordEncoder}
 */
@Configuration
@EnableWebSecurity
public class EndpointsWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Value("${credentials.patient.username}")
    private String patientUsername;

    @Value("${credentials.patient.password}")
    private String patientPassword;

    @Value("${credentials.patient.role}")
    private String patientRole;

    @Value("${credentials.caregiver.username}")
    private String caregiverUsername;

    @Value("${credentials.caregiver.password}")
    private String caregiverPassword;

    @Value("${credentials.caregiver.role}")
    private String caregiverRole;

    @Value("${credentials.doctor.username}")
    private String doctorUsername;

    @Value("${credentials.doctor.password}")
    private String doctorPassword;

    @Value("${credentials.doctor.role}")
    private String doctorRole;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().passwordEncoder(getPasswordEncoder()).dataSource(dataSource)
                .usersByUsernameQuery("select username as principal, password as credentials, true from user where username = ?")
                .authoritiesByUsernameQuery("select username as principal, role as role from user where username = ?")
                .rolePrefix("ROLE_");
    }

    private PasswordEncoder getPasswordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers(HttpMethod.GET).permitAll()
                .antMatchers("/healthcare/doctor/**").hasRole(doctorRole).anyRequest().permitAll()
                .antMatchers("/healthcare/patient/**").hasRole(patientRole).anyRequest().permitAll()
                .antMatchers("/healthcare/caregiver/**").hasRole(caregiverRole).anyRequest().permitAll()
                .antMatchers("/healthcare/login").hasAnyRole(doctorRole, patientRole, caregiverRole).anyRequest().permitAll()
                .and()
                .httpBasic();
    }
}
