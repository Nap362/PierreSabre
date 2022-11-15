package personnages;

import java.util.*;

public class Traitre extends Samourai{
	private int niveauTraitrise=0;
	
	public Traitre(String seigneur, String nom, String boissonFavorite, int argent) {
		super(seigneur, nom, boissonFavorite, argent);

	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître et mon niveau de traîtrise est : " + niveauTraitrise + ". Chut !");
	}
	
	public void ranconner(Commercant commercant) {
		if (niveauTraitrise<3) {
			int argentRanconner = commercant.getArgent()*2/10;
			commercant.perdreArgent(argentRanconner);
			gagnerArgent(argentRanconner);
			niveauTraitrise++;
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi " + argentRanconner + " sous ou gare à toi !");
			commercant.parler("Tout de suite grand " + getNom() + ".");
		}
		else {
			parler("Mince, je ne peux plus ranconner personne sinon un samourai risque de me démasquer !");
		}
	}
	
	public void faireLeGentil() {
		if (nbConnaissance<1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
		}
		else {
			Random random = new Random();
			int i = random.nextInt(nbConnaissance);
			Humain ami = memoire[i];
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + ami.getNom() + ".");
			int don = argent/20;
			parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant " + don + " sous.");
			ami.gagnerArgent(don);
			perdreArgent(don);
			ami.parler("Merci " + getNom() + ". Vous êtes quelqu'un de bien.");
			if (niveauTraitrise>0) {
				niveauTraitrise--;
			}
		}
	}
}
