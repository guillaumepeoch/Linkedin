package profil;

import java.awt.Image;

public class Profil {
	
	private String nom;
	private String prenom;
	private String urlLinkedin;
	private int nombreContact;
	private String entreprise;
	private String secteurActivites;
	private Image photoLinkedin;
	private String region;
	
	

	
	
	
	
	public Profil() {

		
	}
	


	public Profil(String nom, String prenom, String urlLinkedin,
			int nombreContact, String entreprise, String secteurActivites,
			/*Image photoLinkedin,*/ String region) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.urlLinkedin = urlLinkedin;
		this.nombreContact = nombreContact;
		this.entreprise = entreprise;
		this.secteurActivites = secteurActivites;
		//this.photoLinkedin = photoLinkedin;
		this.region = region;
	}

	@Override
	public String toString() {
		return "Profil [nom=" + nom + ", prenom=" + prenom + ", urlLinkedin="
				+ urlLinkedin + ", nombreContact=" + nombreContact
				+ ", entreprise=" + entreprise + ", secteurActivites="
				+ secteurActivites + ", photoLinkedin=" + photoLinkedin
				+ ", region=" + region + "]";
	}



	public String getNom() {
		return nom;
	}
	

	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getUrlLinkedin() {
		return urlLinkedin;
	}
	public void setUrlLinkedin(String urlLinkedin) {
		this.urlLinkedin = urlLinkedin;
	}
	public int getNombreContact() {
		return nombreContact;
	}
	public void setNombreContact(int nombreContact) {
		this.nombreContact = nombreContact;
	}
	public String getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}
	public String getSecteurActivites() {
		return secteurActivites;
	}
	public void setSecteurActivites(String secteurActivites) {
		this.secteurActivites = secteurActivites;
	}
	public Image getPhotoLinkedin() {
		return photoLinkedin;
	}
	public void setPhotoLinkedin(Image photoLinkedin) {
		this.photoLinkedin = photoLinkedin;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	

}
