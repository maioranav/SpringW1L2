package it.epicode.be.godfather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.epicode.be.godfather.model.Table;
import it.epicode.be.godfather.model.TableStatus;

@Configuration
public class TableConfig {

	@Bean
	public Table table() {
		Table table = new Table();
		table.setMaxp(5);
		table.setStatus(TableStatus.LIBERO);
		table.setTableno((int)(Math.random() * (10-5+1)) + 5);
		return table;
	}
}
