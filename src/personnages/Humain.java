package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int argent;
	
	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom=nom;
		this.boissonFavorite=boissonFavorite;
		this.argent=argent;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getArgent() {
		return argent;
	}
	
	private void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}
	
	public void direBonjour() {
		String texte = "Bonjour ! Je m'appelle " + nom + "et j'aime boire du " + boissonFavorite;
		parler(texte);
	}
	
	public void boire() {
		String texte = "Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !";
		parler(texte);
	}
	
	private void gagnerArgent(int gain) {
		argent = argent + gain;
	}
	
	private void perdreArgent(int perte) {
		argent = argent - perte;
	}
	
	public void acheter(String bien, int prix) {
		if (prix<=argent) {
			String texte ="J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous";
			parler(texte);
			perdreArgent(prix);
		}
		else {
			String texte ="Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix + " sous";
			parler(texte);
		}
	}
	
	

}
