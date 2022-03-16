package it.polito.tdp.alien.model;

import java.util.HashMap;
import java.util.Map;

public class Model {
	Map<String,String> dizionario= new HashMap<String,String>();

	public boolean add(String testo) {
		String array[]=testo.split(" ");
		if(array[0].matches("[a-z]+") && array[1].matches("[a-z]+")) {
			dizionario.put(array[0], array[1]);
			return true;
		}
		else
			throw new RuntimeException("Errore in inserimento parola");
	}

	public String print(String testo) {
		if(!dizionario.keySet().contains(testo))
			throw new RuntimeException("Parola non esistente");
		else
			return dizionario.get(testo);
	}

	
}
