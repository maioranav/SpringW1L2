package it.epicode.be.godfather.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import it.epicode.be.godfather.config.MenuConfig;
import it.epicode.be.godfather.config.OrderConfig;
import it.epicode.be.godfather.config.TableConfig;
import it.epicode.be.godfather.model.MenuItem;
import it.epicode.be.godfather.model.Order;
import it.epicode.be.godfather.model.OrderStatus;
import it.epicode.be.godfather.model.Table;
import it.epicode.be.godfather.model.TableStatus;

@Component
public class OrderRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		newOrder();

	}

	public static void newOrder() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
	    ac.register(MenuConfig.class);
	    ac.register(OrderConfig.class);
	    ac.register(TableConfig.class);
	    ac.refresh();
	    List<MenuItem> olist = new ArrayList<>();
	    olist.add((MenuItem) ac.getBean("pizzaMargherita"));
	    olist.add((MenuItem) ac.getBean("drinkLemonade"));
	    Table tab = (Table) ac.getBean("table");
	    tab.setMaxp(8);
	    Order o1 = (Order) ac.getBean("order");
	    o1.setOrderlist(olist);
	    o1.setPersone(6);
	    o1.setTable(tab);
	    tab.setStatus(TableStatus.OCCUPATO);
	    o1.setStatus(OrderStatus.INCORSO);
	    System.out.println(o1);
	    ac.close();
	}
	
}
