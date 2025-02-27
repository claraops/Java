package biblio;

import java.util.*;

public class Roman extends Livre {
	
	private int prixLitteraire;
	
    public Roman(int numEnregistrement, String titre, String auteur, int nbrePage, int prixLitteraire) {
		super(numEnregistrement, titre, auteur, nbrePage);
		this.prixLitteraire = prixLitteraire;
	}

	
	public int getPrixLitteraire() {
		return prixLitteraire;
	}

	public void setPrixLitteraire(int prixLitteraire) {
		this.prixLitteraire = prixLitteraire;
	}

	@Override
	public String toString() {
		return "Roman [prixLitteraire=" + prixLitteraire + "]";
	}
	
	

}
