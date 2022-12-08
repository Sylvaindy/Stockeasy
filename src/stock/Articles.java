package stock;

public class Articles {
	private int NbArticles=0;
	private Articles[] magasin = new Articles[NbArticles];
	private String nom;
	private int quantite;
	
	public Articles(String nom, int quantite) {
		this.nom = nom;
		this.quantite = quantite;
	}
	
	public String getNom() {
		return nom;
	}
	
	
	public int getQuantite() {
		return quantite;
	}
	
	public boolean estDansMagasin(Articles magasin[], int NbArticles, Articles articles) {
		for (int i=0;i<NbArticles;i++) {
			if (magasin[i]==nom) {
				return true;
			}
		}
	}

}
