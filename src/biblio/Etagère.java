package biblio;

import java.util.List;
import java.util.ArrayList;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class Etagère {
	
	 private int capacitéMax;
	 private List<Document> documents;
	 
	 
	 
	 public Etagère(int capacitéMax) {
		this.capacitéMax = capacitéMax;
		this.documents = new ArrayList<>();
	}

	public Etagère() {
	}

	public boolean ajouterDocument(Document doc) {
		 if (documents.size() < capacitéMax) {
	            documents.add(doc);
	            return true;
	        }
		return false;
	}

	public Document rechercherDocument(int numeroEnregistrement) {
		 for (Document doc : documents) {
	            if (doc.getNumEnregistrement() == numeroEnregistrement) {
	                return doc;
	            }
	        }
	        return null;
	}
	
	public void triEtagere() {
	    Collections.sort(documents, Comparator.comparing(Document::getTitre));
	}
	
	public void imprimer() {
	    for (Document doc : documents) {
	        if (doc instanceof Imprimable) {
	            ((Imprimable) doc).imprimer();
	        }
	    }
	}

	@Override
	public String toString() {
		return "Etagère [capacitéMax=" + capacitéMax + ", documents=" + documents + "]";
	}
	
	

}
