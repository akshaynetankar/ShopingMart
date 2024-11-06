package com.shoppingMart.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/auth/register", "/auth/*"
                                        , "/auth/login").permitAll()
                                .anyRequest().authenticated()
                ).sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));// Stateless session management

        return http.build();
    }
}

//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//
//        httpSecurity.authorizeHttpRequests(auth -> auth.requestMatchers("auth/register", "auth/login")
//                        .permitAll().anyRequest()
//                        .authenticated())
////                .authenticationManager(null)
////                .addFilter(null)
////                .addFilter(null)
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//    }




/*
{  private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;
    public static final String[] PUBLIC_URLS = {"/user/save", "/h2-console/**", "/user/status"};
    // STEP 1 : configuration of spring security  @Bean  protected SecurityFilterChain configure(HttpSecurity http) throws Exception
// {    AuthenticationManagerBuilder authenticationManagerBuilder =        http.getSharedObject(AuthenticationManagerBuilder.class);
// Pass service object that is implementing UserDetailsService and password encoder
// authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(passwordEncoder);  ecurity    http.csrf(AbstractHttpConfigurer::disable);
// Disabled default frame    http.headers(        (headers) -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
// return http.authorizeHttpRequests(            (auth) -> auth.requestMatchers(PUBLIC_URLS).permitAll().anyRequest().authenticated())
// Pass authenticationManager        .authenticationManager(authenticationManager)        // Configure UserAuthenticationFilter
// .addFilter(getAuthenticationFilter(authenticationManager))        // Configure AuthorizationFilter
// .addFilter(new AuthorizationFilter(authenticationManager))        // TO make session stateless
// .sessionManagement(            (session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
// .build();  }  UserAuthenticationFilter getAuthenticationFilter(AuthenticationManager authenticationManager)
// {    // Create UserAuthenticationFilter class implementing UsernamePasswordAuthenticationFilter
// UserAuthenticationFilter userAuthenticationFilter =        new UserAuthenticationFilter(authenticationManager, userService);
// Define login custom login page    userAuthenticationFilter.setFilterProcessesUrl("/user/login");
// return userAuthenticationFilter;  }}

*/
