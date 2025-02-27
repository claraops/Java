package biblio;

import java.util.*;

public class Revues extends Document {
	
	private int mois;
    private int années;
    
	public Revues(int numEnregistrement, String titre, int mois, int années) {
		super(numEnregistrement, titre);
		this.mois = mois;
		this.années = années;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getAnnées() {
		return années;
	}

	public void setAnnées(int années) {
		this.années = années;
	}

	@Override
	public String toString() {
		return "Revues [mois=" + mois + ", années=" + années + "]";
	}
    
    

}
