package ejbs;

import javax.ejb.Remote;

import profil.Profil;

@Remote
public interface ResearchRemote {
public Profil research(String nom, String prenom);
//public boolean succes();
}
