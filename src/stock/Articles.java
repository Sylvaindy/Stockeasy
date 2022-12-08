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
	
	public boolean estDansMagasin(Articles magasin[], int NbArticles, Articles articles) { //Stockage//
		boolean test = false;
		for (int i=0;i<NbArticles;i++) {
			if (magasin[i].getNom()==articles.getNom()) {
				test=false;
				return test;
			}
		}
		return test;
	}
	
	public void Maj(Articles magasin[], Articles articles) {
		int i = 0;
		while (magasin[i].getNom()!=articles.getNom()) {
			i += 1;
		}
		int quantite = magasin[i].getQuantite() + articles.getQuantite();
		  
	}

}
