package personnages;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite, argent);

	}

	public void donner(Commercant beneficiaire) {
		int don = argent / 10;
		parler(beneficiaire.getNom() + " prend ces " + don + " sous.");
		argent = argent - don;
		beneficiaire.recevoir(don);
	}

	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre\r\n" + "marchand!");
		int force = honneur * 2;
		if (force >= adversaire.getReputation()) {
			int gain = adversaire.perdre();
			gagner(gain);
		} else {
			int perte = perdre();
			adversaire.gagner(perte);
		}
	}

	public int perdre() {
		int perte = argent;
		perdreArgent(argent);
		honneur--;
		parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
		return perte;
	}

	public void gagner(int gain) {
		argent = argent + gain;
		honneur++;
		parler("Je t’ai eu petit yakusa!");
	}
}
