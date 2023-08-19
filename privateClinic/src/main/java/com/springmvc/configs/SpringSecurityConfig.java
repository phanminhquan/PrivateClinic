package com.springmvc.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.text.SimpleDateFormat;
import java.util.Properties;

@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
        "com.springmvc.repository",
        "com.springmvc.service"
})
@PropertySource("classpath:configs.properties")

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private Environment env;

    @Value("${cloudinary.cloud_name}")
    private String cloudName;
    @Value("${cloudinary.api_id}")
    private String apiKey;
    @Value("${cloudinary.api_secret}")
    private String apiSecret;
    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret,
                "secure", true));
        return cloudinary;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/admin/login").usernameParameter("username").passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/").failureUrl("/admin/login?error");
        http.logout().logoutSuccessUrl("/admin/login");
        http.exceptionHandling().accessDeniedPage("/admin/login?accessDenied");
        http.authorizeRequests().antMatchers("/").hasAnyAuthority("ADMIN","DOCTOR","NURSE")
                .antMatchers("/admin/bacsi").hasAnyAuthority("ADMIN")
                .antMatchers("/admin/add_bacsi").hasAnyAuthority("ADMIN")
                .antMatchers("/admin/add_yta").hasAnyAuthority("ADMIN")
                .antMatchers("/admin/yta").hasAnyAuthority("ADMIN")
                .antMatchers("/admin/add_thuoc").hasAnyAuthority("ADMIN")
                .antMatchers("/admin/thuoc").hasAnyAuthority("ADMIN")
                .antMatchers("/admin/register").hasAnyAuthority("ADMIN");

        http.csrf().disable();


    }
    @Bean
    SimpleDateFormat simpleDateFormat(){
        return  new SimpleDateFormat("yyyy-MM-dd");
    }
    @Bean
    public JavaMailSenderImpl configureJavaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setUsername("nhatnguyenn0802@gmail.com");
        javaMailSender.setPassword("axjiolgzsmfbxbju");
        javaMailSender.setPort(587);
        javaMailSender.setDefaultEncoding("UTF-8");
        Properties mailProp = new Properties();
        mailProp.put("mail.smtp.starttls.enable",true);
        mailProp.put("mail.smtp.ssl.trust","smtp.gmail.com");
        javaMailSender.setJavaMailProperties(mailProp);
        return javaMailSender;
    }
}
