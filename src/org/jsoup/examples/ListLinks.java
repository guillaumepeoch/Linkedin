package org.jsoup.examples;
import java.awt.Image;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import bean.Profil;
import bean.ResearchBean;


/**
 * Classe traitant les liens et profils Linkedin
 */
public class ListLinks {
	
	private static Logger logger = Logger.getLogger(ListLinks.class);
	
	private Profil profil ;
	
	private String nom ;
	private String prenom ;
	
	// ID du code source Linkedin
	private String TOPCARD = "top-card"; 
	private String ID_IMAGE = "bg-blur-profile-picture"; 
	private String ID_NAME = "name";
	private String ID_TITLE = "headline";
	private String ID_LOCATION = "location";	
	private String ID_CURRENT = "overview-summary-current";
	private String ID_FORMATION = "overview-summary-education";
	
	// Class du code source Linkedin
	private String CLASS_FULLNAME = "full-name";
	private String CLASS_TITLE = "title";
	private String CLASS_LOCALITY = "locality";
	private String CLASS_INDUSTRY = "industry";
	private String CLASS_RELATION = "member-connections";

    	/**
    	 * Recherche et traite le 1er profil Linkedin
    	 * @param Nom
    	 * @param Prenom
    	 * @throws IOException
    	 */
   public ListLinks(String Nom, String Prenom) throws IOException{  
	   logger.debug("IN ListLinks");
	   
    	this.nom = Nom;
    	this.prenom = Prenom;
    	logger.debug("Recherche via : " + nom + " " + prenom);	
    	
    	// Recherche via Yahoo avec les tags Nom, Prenom, Linkedin et Telecom Saint Etienne
    	String url = "https://fr.search.yahoo.com/search;_ylt=AwrBTzAMy7dU9zUAhTtjAQx.;_ylc=X1MDMjExNDcxNjAwMwRfcgMyBGZyA3lmcC10LTIwNARncHJpZANBSWV2V3Z2WFJ1LkRMWm53OXhoWENBBG5fcnNsdAMwBG5fc3VnZwM0BG9yaWdpbgNmci5zZWFyY2gueWFob28uY29tBHBvcwMwBHBxc3RyAwRwcXN0cmwDBHFzdHJsAzIzBHF1ZXJ5A2VkZGVnaGFpIGFtaW5lIGxpbmtlZGluBHRfc3RtcAMxNDIxMzMxMzY4?p="+ Prenom +"+"+ Nom + "+linkedin+telecom+saint+etienne&fr2=sb-top-fr.search&fr=yfp-t-204&fp=1";
    	logger.debug("URL genere : " + url);
    	
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");        

        for (Element link : links)
        {
        	if(link.attr("abs:href").contains("linkedin.com/"))
        	{
        		String UrlLinkedin = link.attr("abs:href");
                foundProfil(UrlLinkedin); 
                break;
        	}        
        }
        logger.debug("OUT ListLinks");
    }
   
   /**
    * Renvoie le profil courant
    * @return
    */
   	public bean.Profil getProfil(){        
   		return this.profil;
   	}
   	
   	/**
   	 * Peuple le profil grace au lien Linkedin
   	 * @param UrlLinkedin
   	 * @throws IOException
   	 */
	public void foundProfil(String UrlLinkedin) throws IOException{        
		logger.debug("IN foundProfil " + UrlLinkedin);
		Document doc = Jsoup.connect(UrlLinkedin).get();
		Element body = doc.body();
		
		//System.out.println("\n body \n\n" + body.toString());
		
		Element top = body.getElementById(TOPCARD);
		
		Element name = top.getElementById(ID_NAME);	
		Element title = top.getElementById(ID_TITLE);
		Element location = top.getElementById(ID_LOCATION);
		Element current = top.getElementById(ID_CURRENT);
		Element formation = top.getElementById(ID_FORMATION);
		Element relation = top.getElementById(ID_NAME);
		
		Elements FN = name.getElementsByClass(CLASS_FULLNAME);
		Elements T = title.getElementsByClass(CLASS_TITLE);
		Elements L = location.getElementsByClass(CLASS_LOCALITY);
		Elements I = location.getElementsByClass(CLASS_INDUSTRY);
		Elements R = top.getElementsByClass(CLASS_RELATION);
		String Img;
		try
		{
			Img = top.getElementById(ID_IMAGE).attr("src");
		}
		catch (Exception e)
		{
			Img = "https://static.licdn.com/scds/common/u/images/themes/katy/ghosts/person/ghost_person_40x40_v1.png";
		}
		Img = Img.replace("shrink_500_500", "shrink_200_200");
		
		String FullName = FN.first().text();
		String Title = "Non Renseigné";
		if(T.size() != 0)
		{
			Title = T.first().text();
		}
		String Locality = "Non Renseigné";
		if(L.size() != 0)
		{
			Locality = L.first().text();
		}
		String Industry = "Non Renseigné";
		if(I.size() != 0)
		{
			Industry = I.first().text();
		}
		String Relation = R.first().text().replace("connections", "");
		
//		System.out.println("\n IMG =>" + Img.toString());//
//		System.out.println("\n Name =>" + FullName.toString());
//		System.out.println("\n Title =>" + Title.toString());
//		System.out.println("\n Locality =>" + Locality.toString());
//		System.out.println("\n Industry =>" + Industry.toString());
//		System.out.println("\n Relation =>" + Relation.toString());

		
		if(FullName.toUpperCase().contains(nom.toUpperCase()))
		{
			logger.debug("Peuplement profil réussi");
			this.profil = new Profil(this.nom.toUpperCase(), this.prenom.toUpperCase(), UrlLinkedin, Relation, Title,Industry,Img, Locality);
			logger.debug(this.profil);
		}
		else
		{
			logger.error("Une erreur est survenue, retour du profil par défaut");
			this.profil = new Profil();
		}	
		logger.debug("OUT foundProfil");
   	}
   
}
