package it.epicode.be.godfather;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.epicode.be.godfather.config.OrderConfig;
import it.epicode.be.godfather.config.TableConfig;
import it.epicode.be.godfather.model.Order;
import it.epicode.be.godfather.model.OrderStatus;
import it.epicode.be.godfather.model.Table;

@SpringBootTest
class GodFatherPizzaApplicationTests {
	
	static AnnotationConfigApplicationContext ac;

	@Test
	void contextLoads() {
	}
	
	
	@BeforeAll
	public static void beforeTest() {
		ac = new AnnotationConfigApplicationContext();
	    ac.register(OrderConfig.class);
	    ac.register(TableConfig.class);
	    ac.refresh();
	}
	
	@Test
	public void testTableGen() {
	    Table tab = (Table) ac.getBean("table");
	    tab.setMaxp(8);
	    assertThat(tab.getTableno() > 0);
	}
	
	@Test
	public void testOrderGen() {
	    Order ord = (Order) ac.getBean("order");
	    ord.setPersone(6);
	    ord.setStatus(OrderStatus.INCORSO);
	   assertThat(ord.getOrderno() > 0);
	}
	
	@AfterAll
	public static void afterAllTests() {
	    ac.close();
	}
	
	

}
