package stock;

public class Articles {
	private int NbArticles=0;
	private Articles[] magasin;
	private Articles[] comparaison;
	private String nom;
	private int quantite;
	private float prix;
	private float prixAchat;
	
	public Articles(String nom, int quantite, float prix, float prixAchat) {
		this.nom = nom;
		this.quantite = quantite;
		this.prix = prix;
		this.prixAchat = prixAchat;
	}
	
	public String getNom() {
		return nom;
	}
	
	
	public int getQuantite() {
		return quantite;
	}
	
	public float getPrix() {
		return prix;
	}
	
	public float getPrixAchat() {
		return prixAchat;
	}
	
	public void magasin(int NbArticles) {
		magasin = new Articles[NbArticles];
	}
	
	public void comparaison(int NbArticles) {
		comparaison = new Articles[NbArticles];
	}
	
	public boolean estDansMagasin(Articles articles,Articles tab[], int NbArticles) { //Stockage//
		for (int i=0;i<NbArticles;i++) {
			if (tab[i].getNom()==nom) {
				return true;
			}
		}
		return false;
	}
	
	public void remplir(Articles tab[], Articles articles, Articles tab2[]) {
		if (estDansMagasin(articles ,tab, NbArticles)==false) {
			tab[NbArticles]=articles;
			NbArticles+=1;
		}
		else {
			int i=0;
			while (tab[i].getNom()!=articles.getNom()) {
				i+=1;
			}
			quantite += tab[i].getQuantite();
			tab[i]=articles;
		}
		tab2=tab;
	}
	
	public void vider(Articles tab2[], Articles articles) {
		int i=0;
		while (tab2[i].getNom()!=articles.getNom()) {
			i+=1;
		}
		quantite += tab2[i].getQuantite();
		tab2[i]=articles;
		prevention(tab2);
	}
	
	public void prevention(Articles tab[]) {
		for (int i=0;i<NbArticles;i++) {
			int quantite_temp = tab[i].getQuantite();
			if (quantite_temp==0) {
				System.out.println(tab[i].getNom() + "en rupture de stock");	
			}
			if (quantite_temp<25){
				System.out.println("Il reste seulment " + tab[i].getQuantite() + " de " + tab[i].getNom());
			}
		}
		
	}
	private void plusVendu(Articles tab[], Articles tab2[]) {
		 int max=tab[0].getQuantite() - tab2[0].getQuantite();
		 int e=0;
		 for (int i=1;i<NbArticles;i++) {
			 if (tab[i].getQuantite() - tab2[i].getQuantite()>max) {
				 max=tab[i].getQuantite() - tab2[i].getQuantite();
				 e = i;
			 }
		 }
		 System.out.println("L'article le plus vendu est " + tab[e].getNom());
	 }
	 
	 private void moinsVendu(Articles tab[], Articles tab2[]) {
		 int min=tab[0].getQuantite() - tab2[0].getQuantite();
		 int e=0;
		 for (int i=1;i<NbArticles;i++) {
			 if (tab[i].getQuantite() - tab2[i].getQuantite()<min) {
				 min=tab[i].getQuantite() - tab2[i].getQuantite();
				 e=i;
			 }
		 }
		 System.out.println("L'article le moins vendu est " + tab[e].getNom());
	 }
	 
	 private void plusRentable(Articles tab[], Articles tab2[]) {
		 float max=0;
		 int e =0;
		 for (int i=0;i<NbArticles;i++) {
			 int nb_vente = tab[i].getQuantite() - tab2[i].getQuantite();
			 if (max<nb_vente*tab[i].getPrix() - tab[i].getQuantite()*tab[i].getPrixAchat()) {
				 max = nb_vente * tab[i].getPrix();
				 e = i;
			 }
		 }
		 System.out.println("L'article le plus rentable est " + tab[e].getNom());
	 }
	 
	 private void moinsRentable(Articles tab[], Articles tab2[]) {
		 float min=0;
		 int e =0;
		 for (int i=0;i<NbArticles;i++) {
			 int nb_vente = tab[i].getQuantite() - tab2[i].getQuantite();
			 if (min>nb_vente*tab[i].getPrix() - tab[i].getQuantite()*tab[i].getPrixAchat()) {
				 min = nb_vente * tab[i].getPrix();
				 e = i;
			 }
		 }
		 System.out.println("L'article le moins rentable est " + tab[e].getNom());
	 }
	 
	 public void comparer(Articles tab[], Articles tab2[]) {
		 plusVendu(tab, tab2);
		 moinsVendu(tab, tab2);
		 plusRentable(tab, tab2);
		 moinsRentable(tab, tab2);
	 }
	 
//	 public Articles creerArticles(String name, int combien, float prix, float prix_achat) {
//		 String nomArticle = name;
//		 Articles nomArticle = new Articles (name, combien, prix, prix_achat);
//		 return nomArticle;
//	 }
	 
	 public static void main(String[] args) {
		 
	 }
}
