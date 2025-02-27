package biblio;

import java.util.*;

public class Dictionnaire extends Document {
	
	private String langue;
	
    public Dictionnaire(int numEnregistrement, String titre, String langue) {
		super(numEnregistrement, titre);
		this.langue = langue;
	}
    
	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	@Override
	public String toString() {
		return "Dictionnaire [langue=" + langue + "]";
	}
    
    

}
