package personnages;

public class Commercant extends Humain{

	public Commercant(String nom, int argent) {
		super(nom,"thé", argent);
	}
	
	public int seFaireExtorquer() {
		int vol = argent;
		parler("J’ai tout perdu! Le monde est trop injuste...");
		perdreArgent(argent);
		return vol;
	}
	
	public void recevoir(int argent) {
		gagnerArgent(argent);
		String texte = argent + " sous ! Je te remercie généreux donateur!";
		parler(texte);
	}

}
