package com.teatrulnational.database;

import java.io.FileWriter;
import java.util.ArrayList;

import com.teatrulnational.models.Bilet;

public class CsvExporter implements Exporter {

	@Override
	public boolean export() {
		
		TicketDAO td = new TicketDAO();
		ArrayList<Bilet> bilete = td.seeAllTickets();

		try {
			FileWriter writer = new FileWriter("c:\\temp\\csvfile.csv");
			for (Bilet bilet : bilete) {
				writer.append(bilet.getSpectacol().getTitlu());
				writer.append(bilet.getNumar() + "");
				writer.append(bilet.getRand() + "");
				writer.append('\n');
			}
			writer.flush();
			writer.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}
}
