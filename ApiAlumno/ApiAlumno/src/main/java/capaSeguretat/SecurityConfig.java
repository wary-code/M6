package capaSeguretat;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    
	private HttpSecurity authorizeRequests;

	@SuppressWarnings({ "removal", "deprecation" })
	protected void configure(HttpSecurity http) throws Exception{
        setAuthorizeRequests(http
                .authorizeRequests(requests -> requests
                        .requestMatchers("/api/login").permitAll()
                        .anyRequest().authenticated()));
	}

	public HttpSecurity getAuthorizeRequests() {
		return authorizeRequests;
	}

	public void setAuthorizeRequests(HttpSecurity authorizeRequests) {
		this.authorizeRequests = authorizeRequests;
	}
}