package ejbs;

import javax.ejb.Stateful;

import org.jsoup.examples.ListLinks;

import profil.Profil;


@Stateful(name="ResearchEJB",mappedName="ResearchBean")
public class ResearchBean implements ResearchRemote{
	


	@Override
	public Profil research(String nom, String prenom) {
		
		ListLinks listLinks = new ListLinks();
		
		Profil profil = listLinks.getProfil();
		
		return profil;
	}




}
