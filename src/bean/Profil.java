package bean;

import java.awt.Image;

/***
 * 
 * Bean Profil
 *
 */
public class Profil {
	
	private String nom;
	private String prenom;
	private String urlLinkedin;
	private String nombreContact;
	private String entreprise;
	private String secteurActivites;
	private String photoLinkedin;
	private String region;
	
	public Profil() {
		nom = "Default";
		prenom = "Default";
		urlLinkedin = "http://www.google.com";
		nombreContact = "0";
		entreprise = "Default";
		secteurActivites = "Default";
		photoLinkedin = "https://static.licdn.com/scds/common/u/images/themes/katy/ghosts/person/ghost_person_40x40_v1.png";
		region = "Default";		
	}
	


	public Profil(String nom, String prenom, String urlLinkedin,
			String nombreContact, String entreprise, String secteurActivites,
			String photoLinkedin, String region) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.urlLinkedin = urlLinkedin;
		this.nombreContact = nombreContact;
		this.entreprise = entreprise;
		this.secteurActivites = secteurActivites;
		this.photoLinkedin = photoLinkedin;
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
	public String getNombreContact() {
		return nombreContact;
	}
	public void setNombreContact(String nombreContact) {
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
	public String getPhotoLinkedin() {
		return photoLinkedin;
	}
	public void setPhotoLinkedin(String photoLinkedin) {
		this.photoLinkedin = photoLinkedin;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
}
