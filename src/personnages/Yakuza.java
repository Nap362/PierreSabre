package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 4;

	public Yakuza(String nom, String boissonFavorite, int argent, String clan) {
		super(nom, boissonFavorite, argent);
		this.clan = clan;
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de " + clan + ".");
	}

	public int getReputation() {
		return reputation;
	}

	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int gain = victime.seFaireExtorquer();
		gagnerArgent(gain);
		reputation++;
		parler("J’ai piqué les " + gain + " sous de " + victime.getNom() + ", ce qui me fait " + argent
				+ " sous dans ma poche. Hi ! Hi !");
	}

	public int perdre() {
		int perte = argent;
		perdreArgent(argent);
		reputation--;
		parler("J’ai perdu mon duel et mes " + perte + " sous, snif... J'ai déshonoré le clan de " + clan + ".");
		return perte;
	}

	public void gagner(int gain) {
		argent = argent + gain;
		reputation++;
		parler("Ce ronin pensait vraiment battre " + nom + " du clan de " + clan + " ? Je l'ai dépouillé de ses " + gain
				+ " sous.");
	}

}
