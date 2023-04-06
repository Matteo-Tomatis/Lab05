package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.db.DizionarioDAO;

public class Model {
	
	private DizionarioDAO d=new DizionarioDAO();
	
	public Map<String, Boolean> anagramma(String parola) {
		Map<String, Boolean> soluzione = new HashMap<>();
		String[] parziale = new String[2];
		parziale[0]="";
		parziale[1]="";
		
		calcolaAnagramma(parola, parziale, 0, soluzione);
		return soluzione;
	}

	private void calcolaAnagramma(String parola, String[] parziale, int L, Map<String, Boolean> soluzione) {
		
		if(parziale[1].length()==1) {
			parziale[0]+=parziale[1];
			soluzione.put(parziale[0], false);
			return;
		}
		
		for(int i=0; i<parola.length(); i++) {
			
			parziale[0]+=parola.charAt(i);
			int lunghezza = parziale[0].length();
			
			
			parziale[1]="";
			
			for(int j=0; j<parola.length(); j++) {
				if(i!=j)
					parziale[1]+=parola.charAt(j);
			}
			
			calcolaAnagramma(parziale[1], parziale, L+1, soluzione);
			
			parziale[0]=parziale[0].substring(0, lunghezza-1);
			parziale[1]="";
		}
	}
	
	public void checkParola(Map<String, Boolean> anagrammi) {
		for(String s : anagrammi.keySet()) {
			boolean b = d.findOut(s);
			anagrammi.put(s, b);
		}
	}
}
