//package my.web.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
//
////@Configuration
////@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("LEARNER")
//                .and()
//                .withUser("admin").password("password").roles("ADMIN")
//                .and()
//                .withUser("worker1").password("123").roles("TEACHER");;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                    .antMatchers("/", "/public/**").permitAll()
//                    .antMatchers("/admin/**").hasAnyRole("ADMIN")
//                    .antMatchers("/te/**").hasAnyRole("TEACHER")
//                    .antMatchers("/learner/**").hasAnyRole("LEARNER")
//                    .anyRequest().authenticated();
//        http.formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//             .logout()
//                .permitAll()
//             .and()
//                .rememberMe().key("myKey").tokenValiditySeconds(300);
//    }
//
//}
//
//class SpringSecurityInit extends AbstractSecurityWebApplicationInitializer {
//    //Field
//
//    //Constructor
//
//    //Function
//
//    //Getter and Setter
//}