package com.springmvc.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
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
@Order(2)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private Environment env;


    @Value("dexbjwfjg")
    private String cloudName;
    @Value("575344324738563")
    private String apiKey;
    @Value("ibnB7XPQZBtyfTNsvr5KYTVwKzY")
    private String apiSecret;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
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
        http.authorizeRequests().antMatchers("/").hasAnyAuthority("ADMIN", "DOCTOR", "NURSE")
                .antMatchers("/admin/bacsi",
                        "/admin/add_bacsi",
                        "/admin/add_yta",
                        "/admin/yta",
                        "/admin/add_thuoc",
                        "/admin/thuoc",
                        "/admin/register",
                        "/catruc",
                        "/catruc/{iddate}/{id}",
                        "/catruc/edit/{id}",
                        "/admin/addcatruc/{id}",
                        "/admin/catruc/addct",
                        "/admin/addcatruc",
                        "/catruc/nhanvien").hasAnyAuthority("ADMIN")
                .antMatchers("/phieukham",
                        "/admin/benhnhan/{id}",
                        "/admin/pdf",
                        "/lichsukham").hasAnyAuthority("DOCTOR")
                .antMatchers("/admin/dskham",
                        "/admin/dskhamhomnay",
                        "/api/ctdskham/havenotaccepted",
                        "/mail",
                        "/lichkham/acceptOrDenny",
                        "/api/listhistory/{id}",
                        "/api/denny/{id}",
                        "/admin/pay").hasAnyAuthority("NURSE");

        http.csrf().disable();


    }

    @Bean
    SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    @Bean
    public JavaMailSenderImpl configureJavaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setUsername("nhatnguyenn0802@gmail.com");
        javaMailSender.setPassword("axjiolgzsmfbxbju");
        javaMailSender.setPort(587);
        javaMailSender.setDefaultEncoding("UTF-8");
        Properties mailProp = new Properties();
        mailProp.put("mail.smtp.starttls.enable", true);
        mailProp.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        javaMailSender.setJavaMailProperties(mailProp);
        return javaMailSender;
    }

}
