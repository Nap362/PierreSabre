package personnages;



public class Humain {
	public static final int NB_MAX_CONNAISSANCE = 30;
	protected String nom;
	private String boissonFavorite;
	protected int argent;
	protected Humain[] memoire = new Humain[NB_MAX_CONNAISSANCE];
	protected int nbConnaissance = 0;

	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}

	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonFavorite);
	}

	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}

	protected void gagnerArgent(int gain) {
		argent = argent + gain;
	}

	protected void perdreArgent(int perte) {
		argent = argent - perte;
	}

	public void acheter(String bien, int prix) {
		if (prix <= argent) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous");
			perdreArgent(prix);
		} else {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix
					+ " sous");
		}
	}
	
	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		autreHumain.repondre(this);
		memoriser(autreHumain);		
	}
	
	private void memoriser(Humain humain) {
		if (nbConnaissance<NB_MAX_CONNAISSANCE) {
			memoire[nbConnaissance]=humain;
			nbConnaissance++;
		}
		else {
			for (int i=1;i<NB_MAX_CONNAISSANCE;i++) {
				memoire[i-1]=memoire[i];
			}
			memoire[nbConnaissance-1]=humain;
		}
	}
	
	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
		
	}
	
	public void listerConnaissance() {
		int i = 0;
		String texte = "Je connais beaucoup de monde dont : ";
		while (i<nbConnaissance) {
			texte += memoire[i].getNom();
			if (i<nbConnaissance-1) {
				texte +=", ";
			}
			i++;
		}
		parler(texte);
	}

}
