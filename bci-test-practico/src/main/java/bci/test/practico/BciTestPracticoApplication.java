package bci.test.practico;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import bci.test.practico.configuracion.token.JWTAuthorizationFilter;



@SpringBootApplication
public class BciTestPracticoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BciTestPracticoApplication.class, args);
	}
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/").permitAll().and()
            .authorizeRequests().antMatchers("/console/**").permitAll();
			http.csrf().disable();
			http.headers().frameOptions().disable();
		}
	}
}
