package com.java.config;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.endpoint.AbstractOAuth2AuthorizationGrantRequest;
import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;

import com.java.entity.Account;
import com.java.service.AccountService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AccountService accountService;
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    // Cung cấp dữ liệu đăng nhập
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Lấy username, password, roles -> userDetail
        auth.userDetailsService(username -> {
            try {
                // tìm kiếm user
                Account user = accountService.getById(username);

                // Lấy password và mã hõa
                String password = bCryptPasswordEncoder.encode(user.getMatKhau());

                System.out.println(username);
                System.out.println(password);

                // Lấy vai trò người dùng đưa vào mảng
                String[] roles = user.getPhanQuyen().stream()
                        .map(er -> er.getVaiTro().getMaVT())
                        .collect(Collectors.toList()).toArray(new String[0]);
                return User.withUsername(username).password(password).roles(roles).build();
            } catch (NoSuchElementException e) {
                throw new UsernameNotFoundException(username + "not found");
            }
        });
    }

    // Phân quyền sử dụng
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeHttpRequests()

                // địa chỉ bắt đầu bằng cart -> bắt buộc phải đăng nhập
                .antMatchers("/oauth2/**").permitAll()
                .antMatchers("/cart/**").authenticated()
//		.antMatchers("/admin/**").hasAnyRole("STAF","DIRE")
//		.antMatchers("/rest/authorities").hasRole("DIRE")
                .anyRequest().permitAll();

//		Đăng nhập từ google
        http.oauth2Login()
//		form login
                .loginPage("/security/login/form")
      
//		login thành công bằng 
                .defaultSuccessUrl("/oauth2/login/success", true)
                .failureUrl("/oauth2/login/error")

//      địa chỉ login bằng mạng xã hội		
                .authorizationEndpoint() // Authorization Request
                .baseUri("/oauth2/authorization")
                .authorizationRequestRepository(getRepository())

                .and().tokenEndpoint()// Authorization Response
                .accessTokenResponseClient(getToken());

        http.formLogin()
                // địa chỉ dẫn đến trang login
                .loginPage("/security/login/form")

                // địa chỉ form login submit tới
                .loginProcessingUrl("/security/login")

                //
                .defaultSuccessUrl("/security/login/success", false)
                .failureUrl("/security/login/error");

        http.rememberMe()
                .tokenValiditySeconds(86400);

        // đăng nhập r nhưng chưa được cấp quyền
        // -> unauthoried
        http.exceptionHandling()
                .accessDeniedPage("/security/unauthoried");

        // đăng xuất
        http.logout()
                .logoutUrl("/security/logoff")
                .logoutSuccessUrl("/security/logoff/success");
    }
    
    

    // Mã hóa password
    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Lưu thông tin đăng nhập trước khi gửi lên server
    @Bean
    public AuthorizationRequestRepository<OAuth2AuthorizationRequest> getRepository() {
        return new HttpSessionOAuth2AuthorizationRequestRepository();
    }

    // Token từ server trả về
    @Bean
    public OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> getToken() {
        return new DefaultAuthorizationCodeTokenResponseClient();
    }

    // Cho phép truy xuất RESP API từ bên ngoài (domain khác)
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.POST.OPTIONS, "/**");
    }

}
