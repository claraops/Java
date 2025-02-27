package biblio;

import java.util.List;
import java.util.*;

public class Bibliothèque {
	
	private List<Etagère> etageres;
	
	public Bibliothèque() {
        this.etageres = new ArrayList<>(); // Initialisation de la liste
    }
	
	 public void ajouterEtagere(Etagère etagere) {
		 etageres.add(etagere);
	 }
	 
	 public boolean ajouterDocument(Document doc) {
		 for (Etagère etagere : etageres) {
	            if (etagere.ajouterDocument(doc)) {
	                return true;
	            }
	        }
	        return false;
	 }

	   
	 public Document rechercherDocument(int numEnregistrement) {
		 for (Etagère etagere : etageres) {
	            Document doc = etagere.rechercherDocument(numEnregistrement);
	            if (doc != null) {
	                return doc;
	            }
	        }
	        return null; 
	 }


}
