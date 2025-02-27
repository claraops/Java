package biblio;

import java.util.*;


public class TestBiblio {

	public static void main(String[] args) {
		
		 Document livre1 = new Livre(1, "Le Petit Prince", "Antoine de Saint-Exupéry", 96);
	        Document roman1 = new Roman (2,"save me", "inconnu", 328, 50);
	        Document manuel1 = new Manuels(3, "Mathématiques", "Jean Dupont", 200, "baccalaureat");
	        Document revue1 = new Revues (4, "Science et Vie", 10, 2023);
	        Document dictionnaire1 = new Dictionnaire(5, "Larousse", "Français");

	        // Création d'une étagère
	        Etagère etagere1 = new Etagère(10);
	        etagere1.ajouterDocument(livre1);
	        etagere1.ajouterDocument(roman1);
	        etagere1.ajouterDocument(manuel1);
	        etagere1.ajouterDocument(revue1);
	        etagere1.ajouterDocument(dictionnaire1);
	        
	        // Tri des documents par titre
	        etagere1.triEtagere();
	        System.out.println("\n ------Étagère triée:----- \n" + etagere1);

	        // Impression des documents imprimables
	        System.out.println("\n -------Impression des documents imprimables :--------");
	        System.out.println("");
	        etagere1.imprimer();

	        // Création de la bibliothèque
	        Bibliothèque bibliotheque = new Bibliothèque();
	        bibliotheque.ajouterEtagere(etagere1);

	        // Recherche d'un document
	        Document docTrouver = bibliotheque.rechercherDocument(4);
	        if (docTrouver != null) {
	            System.out.println("\n ----------Document trouvé : ----------- \n" + docTrouver);
	        } else {
	            System.out.println("\n ----------Document non trouvé. -----------  \n");
	        }
	        
	        
	     // Affichage de la bibliothèque
	        System.out.println(bibliotheque);

	      
	    }
	

}
