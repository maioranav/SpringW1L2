package it.epicode.be.godfather.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import it.epicode.be.godfather.model.Order;

@Configuration
@PropertySource("classpath:application.properties")
public class OrderConfig {

	@Value("${price.copertocad}") double pp;
	//double pp = 1d;

	@Bean
	public Order order() {
		Order order = new Order();
		order.setOrderno((int)(Math.random() * (10-5+1)) + 5);	
		order.setCostopersona(pp);
		return order;
	}
}
