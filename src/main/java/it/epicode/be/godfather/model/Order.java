package it.epicode.be.godfather.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@Data
public class Order {
	
	private int orderno;
	private Table table;
	private List<MenuItem> orderlist = new ArrayList<>();
	private OrderStatus status;
	private int persone;
	private double costopersona;
	
	@Override
	public String toString() {
		double tot = 0.00d;
		String report = "\n Order No. " + orderno
				+ "\n " + table
				+ "\n Status = " + status
				+ "\n Persone = " + persone
				+ "\n Coperto cad.: " + costopersona;
		for (int i = 0; i < orderlist.size(); i++) {
			report += "\n - " + orderlist.get(i).getName() + " - " + orderlist.get(i).getPrice() + "€";
			tot += orderlist.get(i).getPrice();
		}
		tot += costopersona * persone;
		report += "\n Totale: " + tot + "€\n\n";
		return report;
	}
	
	

}
