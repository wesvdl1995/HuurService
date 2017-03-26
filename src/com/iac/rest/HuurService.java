package com.iac.rest;

import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/")
public class HuurService {

	private Building building;
	
	public HuurService(){
		if (this.building == null){
			this.building = new Building("testbuilding", new ArrayList<Kamer>());
			
			building.addKamer(new Kamer(0,0,0,1,0.00,"Lobby"));
			
			building.addKamer(new Kamer(1,1,4,0,50.00,"Room"));
			building.addKamer(new Kamer(1,2,4,0,50.00,"Room"));
			building.addKamer(new Kamer(1,3,4,0,50.00,"Room"));
			building.addKamer(new Kamer(1,4,4,0,50.00,"Room"));
			
			building.addKamer(new Kamer(2,5,8,0,60.00,"Room"));
			building.addKamer(new Kamer(2,6,8,0,60.00,"Room"));
			building.addKamer(new Kamer(2,7,8,0,80.00,"Room"));
			building.addKamer(new Kamer(2,8,8,0,80.00,"Room"));
		}

	}
	
	@GET
	@Path("/getKamers")
	@Produces("application/json")
	public String getKamers(){
		
		JsonArrayBuilder jb = Json.createArrayBuilder();
        for (Kamer k : building.getListOfKamers()) {
            JsonObjectBuilder jpb = Json.createObjectBuilder().
                add("verdiepingNr",   k.getVerdiepingNr()).
                add("kamerNr", 		  k.getKamerNr()).
                add("aantalPersonen", k.getAantalPersonen()).
                add("bezet", 		  k.getBezet()).
                add("prijs", 		  k.getPrijs()).
		        add("omschrijving",   k.getOmschrijving());
            jb.add(jpb);
        }
	    return jb.build().toString();      
	}
	
	@GET
	@Path("/getKamer/{nr}")
	@Produces("application/json")
	public String getKamer(@PathParam("nr") int nr){
		JsonArrayBuilder jb = Json.createArrayBuilder();
		boolean bool = false;
        for (Kamer k : building.getListOfKamers()) {
        	if (k.getKamerNr() == nr){
	            JsonObjectBuilder jpb = Json.createObjectBuilder().
	                add("verdiepingNr",   k.getVerdiepingNr()).
	                add("kamerNr", 		  k.getKamerNr()).
	                add("aantalPersonen", k.getAantalPersonen()).
			        add("bezet", 		  k.getBezet()).
			        add("prijs", 		  k.getPrijs()).
			        add("omschrijving",   k.getOmschrijving());
	            jb.add(jpb);
	            bool = true;
        	}
        }
        if (bool == false){
        	JsonObjectBuilder jpb = Json.createObjectBuilder().
	                add("error", "Kamer '"+nr+"' bestaat niet!");
        	jb.add(jpb);
        }
	    return jb.build().toString();
	}
	
	@GET
	@Path("/huurKamer")
	@Produces("application/json")
	public String huurKamer(@QueryParam("kamer") int nr){
		JsonArrayBuilder jb = Json.createArrayBuilder();
		boolean bool = false;
        for (Kamer k : building.getListOfKamers()) {
        	if (k.getKamerNr() == nr){
        		bool = true;
        		if (k.getBezet() == 0){
        			k.setBezet(1);
		            JsonObjectBuilder jpb = Json.createObjectBuilder().
		                add("verdiepingNr",   k.getVerdiepingNr()).
		                add("kamerNr", 		  k.getKamerNr()).
		                add("aantalPersonen", k.getAantalPersonen()).
				        add("bezet", 		  k.getBezet()).
				        add("prijs", 		  k.getPrijs()).
				        add("omschrijving",   k.getOmschrijving()).
				        add("info", "Kamer '"+nr+"' is verhuurd!");
		            jb.add(jpb);
        		}
        		else {
                	JsonObjectBuilder jpb = Json.createObjectBuilder().
        	                add("error", "Kamer '"+nr+"' is al verhuurd!");
                	jb.add(jpb);
        		}
        	}
        }
        if (bool == false){
        	JsonObjectBuilder jpb = Json.createObjectBuilder().
	                add("error", "Kamer '"+nr+"' bestaat niet!");
        	jb.add(jpb);
        }
	    return jb.build().toString();
	}	
	
	@GET
	@Path("/verlaatKamer")
	@Produces("application/json")
	public String verlaatKamer(@QueryParam("kamer") int nr){
		JsonArrayBuilder jb = Json.createArrayBuilder();
		boolean bool = false;
        for (Kamer k : building.getListOfKamers()) {
        	if (k.getKamerNr() == nr){
        		bool = true;
        		if (k.getBezet() == 1){
        			k.setBezet(0);
		            JsonObjectBuilder jpb = Json.createObjectBuilder().
		                add("verdiepingNr",   k.getVerdiepingNr()).
		                add("kamerNr", 		  k.getKamerNr()).
		                add("aantalPersonen", k.getAantalPersonen()).
				        add("bezet", 		  k.getBezet()).
				        add("prijs", 		  k.getPrijs()).
				        add("omschrijving",   k.getOmschrijving()).
				        add("info", "Kamer '"+nr+"' is niet meer bezet!");
		            jb.add(jpb);
        		}
        		else {
                	JsonObjectBuilder jpb = Json.createObjectBuilder().
        	                add("error", "Kamer '"+nr+"' is nog niet verhuurd!");
                	jb.add(jpb);
        		}
        	}
        }
        if (bool == false){
        	JsonObjectBuilder jpb = Json.createObjectBuilder().
	                add("error", "Kamer '"+nr+"' bestaat niet!");
        	jb.add(jpb);
        }
	    return jb.build().toString();
	}
	
	
	@GET
	@Path("/setAanbieding")
	@Produces("application/json")
	public String setAanbieding(@QueryParam("percentage") int percentage){
		
		JsonArrayBuilder jb = Json.createArrayBuilder();
        for (Kamer k : building.getListOfKamers()) {
        	k.setPrijs(  k.getPrijs() - ((k.getPrijs()/100)*percentage)  );
            JsonObjectBuilder jpb = Json.createObjectBuilder().
                add("verdiepingNr",   k.getVerdiepingNr()).
                add("kamerNr", 		  k.getKamerNr()).
                add("aantalPersonen", k.getAantalPersonen()).
                add("bezet", 		  k.getBezet()).
                add("prijs", 		  k.getPrijs()).
		        add("omschrijving",   k.getOmschrijving());
            jb.add(jpb);
        }
	    return jb.build().toString();      
	}
	
	
	
}
