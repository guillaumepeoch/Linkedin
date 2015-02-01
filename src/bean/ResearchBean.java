package bean;
import org.jsoup.examples.ListLinks;

public class ResearchBean{

	/***
	 * 
	 * @param nom de l'utilisateur à rechercher
	 * @param prenom de l'utilisateur à rechercher
	 * @return renvoie le profil du premier lien Linkedin trouvé (Profil Default si null)
	 */
	public Profil research(String nom, String prenom) {
		
		
		
		Profil profil = new Profil();		
		ListLinks listLinks;
		try {
			// Recherche
			listLinks = new ListLinks(nom, prenom);
			
			// Recuperation du profil
			profil = listLinks.getProfil();			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return profil;
	}
}
