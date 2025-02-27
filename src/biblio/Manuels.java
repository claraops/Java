package biblio;

import java.util.*;

public class Manuels extends Livre {
	
	private String niveauScolaire;
	
    public Manuels(int numEnregistrement, String titre, String auteur, int nbrePage, String niveauScolaire) {
		super(numEnregistrement, titre, auteur, nbrePage);
		this.niveauScolaire = niveauScolaire;
	}

	public String getNiveauScolaire() {
		return niveauScolaire;
	}

	public void setNiveauScolaire(String niveauScolaire) {
		this.niveauScolaire = niveauScolaire;
	}

	@Override
	public String toString() {
		return "Manuels [niveauScolaire=" + niveauScolaire + "]";
	}
    
    

}
