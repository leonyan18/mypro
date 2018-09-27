package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**手动配置*/
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER","ADMIN");
        /**通过数据源配置*/
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, true " +
                                "from user where username =?")
                .authoritiesByUsernameQuery(
                        "select username ,'ROLE_USER' " +
                                "from user where username=?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
          /**默认表单认证 提交到/login*/
        http.formLogin()
//                    .loginPage("/login")//表单提交位置
                .and()
                .logout()
                .logoutUrl("/logout")
                    .logoutSuccessUrl("/")//退出的位置
                .and()
                .rememberMe()
                    .tokenValiditySeconds(2419200)//有效时间 单位秒
                    .key("key")//默认为SpringSecured
                .and()
                /**拦截请求*/
                .authorizeRequests()
                    .antMatchers("/user/**").authenticated()//问/user/**的需要认证
                    .antMatchers(HttpMethod.POST,"/pizza").authenticated()//向/pizza的post方法的需要认证
                    .anyRequest().permitAll()//其他都允许
                .and()
                .requiresChannel()
                    .antMatchers("/").requiresInsecure();//requiresSecure 需要https
    }
}
