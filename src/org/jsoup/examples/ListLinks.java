package org.jsoup.examples;
import java.awt.Image;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import bean.Profil;


/**
 * Example program to list links from a URL.
 */
public class ListLinks {
	
	private Profil profil ;
	private String nom ;
	private String prenom ;
	
	private String TOPCARD = "top-card"; 
	private String ID_IMAGE = "bg-blur-profile-picture"; 
	private String ID_NAME = "name";
	private String ID_TITLE = "headline";
	private String ID_LOCATION = "location";	
	private String ID_CURRENT = "overview-summary-current";
	private String ID_FORMATION = "overview-summary-education";
	
	private String CLASS_FULLNAME = "full-name";
	private String CLASS_TITLE = "title";
	private String CLASS_LOCALITY = "locality";
	private String CLASS_INDUSTRY = "industry";
	private String CLASS_RELATION = "member-connections";



    	
   public ListLinks(String Nom, String Prenom) throws IOException{  
	   
    	this.nom = Nom;
    	this.prenom = Prenom;
        //Validate.isTrue(args.length == 1, "usage: supply url to fetch");
        String url = "https://fr.search.yahoo.com/search;_ylt=AwrBTzAMy7dU9zUAhTtjAQx.;_ylc=X1MDMjExNDcxNjAwMwRfcgMyBGZyA3lmcC10LTIwNARncHJpZANBSWV2V3Z2WFJ1LkRMWm53OXhoWENBBG5fcnNsdAMwBG5fc3VnZwM0BG9yaWdpbgNmci5zZWFyY2gueWFob28uY29tBHBvcwMwBHBxc3RyAwRwcXN0cmwDBHFzdHJsAzIzBHF1ZXJ5A2VkZGVnaGFpIGFtaW5lIGxpbmtlZGluBHRfc3RtcAMxNDIxMzMxMzY4?p="+ Prenom +"+"+ Nom + "+linkedin+telecom+saint+etienne&fr2=sb-top-fr.search&fr=yfp-t-204&fp=1";
        print("Fetching %s...", url);

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");
        
        
        
        //Elements media = doc.select("[src]");
        //Elements imports = doc.select("link[href]");

        /*print("\nMedia: (%d)", media.size());
        for (Element src : media) {
            if (src.tagName().equals("img"))
                print(" * %s: <%s> %sx%s (%s)",
                        src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"),
                        trim(src.attr("alt"), 20));
            else
                print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
        }

        print("\nImports: (%d)", imports.size());
        for (Element link : imports) {
            print(" * %s <%s> (%s)", link.tagName(),link.attr("abs:href"), link.attr("rel"));
        }*/


        print("\nLinks: (%d)", links.size());

        for (Element link : links)
        {
        	if(link.attr("abs:href").contains("linkedin.com/"))
        	{
        		String UrlLinkedin = link.attr("abs:href");
                foundProfil(UrlLinkedin); 
                break;
        	}        
        }
        
		//this.profil = new Profil("PEOC'H1", "Guillaume1", "https://www.linkedin.com/pub/guillaume-peoch/a2/37/513",74, "SSD", "Informatique Reseaux","https://media.licdn.com/mpr/mpr/shrink_200_200/p/7/005/08f/00f/2ea68cb.jpg", "Arlington");
  
    }
   
   	public bean.Profil getProfil(){        
   		return this.profil;
   	}
   	
	public void foundProfil(String UrlLinkedin) throws IOException{        
		//this.profil = new Profil("PEOC'H1", "Guillaume1", "https://www.linkedin.com/pub/guillaume-peoch/a2/37/513",74, "SSD", "Informatique Reseaux","https://media.licdn.com/mpr/mpr/shrink_200_200/p/7/005/08f/00f/2ea68cb.jpg", "Arlington");
		
		System.out.println("GOTO " + UrlLinkedin);
		Document doc = Jsoup.connect(UrlLinkedin).get();
		Element body = doc.body();
		
		System.out.println("\n body \n\n" + body.toString());
		
		Element top = body.getElementById(TOPCARD);
		

		
		//Element name = top.getElementById(ID_NAME);	
		Element title = top.getElementById(ID_TITLE);
		Element location = top.getElementById(ID_LOCATION);
		Element current = top.getElementById(ID_CURRENT);
		Element formation = top.getElementById(ID_FORMATION);
		//Element relation = top.getElementById(ID_NAME);
		
//		System.out.println("\n name \n\n" + name.toString());
//		System.out.println("\n title \n\n" + title.toString());
//		System.out.println("\n location \n\n" + location.toString());
//		System.out.println("\n current \n\n" + current.toString());
//		System.out.println("\n formation \n\n" + formation.toString());
		

		
		//Elements FN = name.getElementsByClass(CLASS_FULLNAME);
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
		//String FullName = FN.first().text();
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
		System.out.println("\n IMG =>" + Img.toString());
		//System.out.println("\n Name =>" + FullName.toString());
		System.out.println("\n Title =>" + Title.toString());
		System.out.println("\n Locality =>" + Locality.toString());
		System.out.println("\n Industry =>" + Industry.toString());
		System.out.println("\n Relation =>" + Relation.toString());
		//System.out.println(doc.body().toString());
	//	if(FullName.toUpperCase().contains(nom.toUpperCase()))
		//{
			this.profil = new Profil(this.nom.toUpperCase(), this.prenom.toUpperCase(), UrlLinkedin, Relation, Title,Industry,Img, Locality);
		//}
		//else
	//	{
		//	this.profil = new Profil();
		//}		
   	}
	

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
}
