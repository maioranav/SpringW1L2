package it.epicode.be.godfather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Table {
	
	private int tableno;
	private TableStatus status;
	private int maxp;
	

}
