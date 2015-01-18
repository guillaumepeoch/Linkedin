package bean;

import java.io.IOException;

import javax.ejb.Stateful;

import org.jsoup.examples.ListLinks;



public class ResearchBean{

	public Profil research(String nom, String prenom) {
		Profil profil = new Profil();
		ListLinks listLinks;
		try {
			listLinks = new ListLinks(nom, prenom);
			profil = listLinks.getProfil();			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return profil;
	}
}
