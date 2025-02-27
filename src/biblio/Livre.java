package biblio;

import java.util.*;

public class Livre extends Document implements Imprimable  {
	
	private String auteur;
	private int nbrePage;
	
	
	public Livre(int numEnregistrement, String titre, String auteur, int nbrePage) {
		super(numEnregistrement, titre);
		this.auteur = auteur;
		this.nbrePage = nbrePage;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public int getNbrePage() {
		return nbrePage;
	}

	public void setNbrePage(int nbrePage) {
		this.nbrePage = nbrePage;
	}
	
	 @Override
	    public void imprimer() {
	        System.out.println("Imprimession des document suivant seront:  " + this.toString());
	    }

	@Override
	public String toString() {
		return "Livre [auteur=" + auteur + ", nbrePage=" + nbrePage + "]";
	}
	
	


	

}
