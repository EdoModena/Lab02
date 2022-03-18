package it.polito.tdp.alien.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Model {
	Map<String,LinkedList<String>> dizionario= new HashMap<String,LinkedList<String>>();

	public void add(String testo) {
		String array[]=testo.split(" ");
		if(array[0].matches("[a-z]+") && array[1].matches("[a-z]+")) {
			if(dizionario.containsKey(array[0])) {
				dizionario.get(array[0]).add(array[1]);
			}
			else {
				dizionario.put(array[0], new LinkedList<String>());
				dizionario.get(array[0]).add(array[1]);
			}
		}
		else
			throw new RuntimeException("Errore in inserimento parola");
	}

	public LinkedList<String> print(String testo) {
		if(!dizionario.keySet().contains(testo))
			throw new RuntimeException("Parola non esistente");
		else
			return dizionario.get(testo);
	}

	
}
