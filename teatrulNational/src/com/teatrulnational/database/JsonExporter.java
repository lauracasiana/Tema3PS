package com.teatrulnational.database;

import java.io.FileWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.teatrulnational.models.Bilet;

public class JsonExporter implements Exporter{

	@SuppressWarnings("unchecked")
	@Override
	public boolean export(){
		
		TicketDAO td = new TicketDAO();
		ArrayList<Bilet> bilete = td.seeAllTickets();
		
		JSONArray jbilete = new JSONArray();
		for (Bilet bilet : bilete) {
			JSONObject obj = new JSONObject();
			obj.put("Spectacol",bilet.getSpectacol().getTitlu() );
			obj.put("Numar", bilet.getNumar());
			obj.put("Rand",bilet.getNumar());
			
			jbilete.add(obj);
			
		}
		try{
			FileWriter writer = new FileWriter("c:\\temp\\jsonfile.txt"); 
			writer.write(jbilete.toJSONString());
			
			writer.flush();
			writer.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
