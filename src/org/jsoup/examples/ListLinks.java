package org.jsoup.examples;
import java.awt.Image;
import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import profil.Profil;
import ConnectionURL.searchProfile;

/**
 * Example program to list links from a URL.
 */
public class ListLinks {
	
	private Profil profil ;
	

    	
   public void ListLinks() throws IOException{
	   
	   
    	
        //Validate.isTrue(args.length == 1, "usage: supply url to fetch");
        String url = "https://fr.search.yahoo.com/search;_ylt=AwrBTzAMy7dU9zUAhTtjAQx.;_ylc=X1MDMjExNDcxNjAwMwRfcgMyBGZyA3lmcC10LTIwNARncHJpZANBSWV2V3Z2WFJ1LkRMWm53OXhoWENBBG5fcnNsdAMwBG5fc3VnZwM0BG9yaWdpbgNmci5zZWFyY2gueWFob28uY29tBHBvcwMwBHBxc3RyAwRwcXN0cmwDBHFzdHJsAzIzBHF1ZXJ5A2VkZGVnaGFpIGFtaW5lIGxpbmtlZGluBHRfc3RtcAMxNDIxMzMxMzY4?p=eddeghai+amine+linkedin&fr2=sb-top-fr.search&fr=yfp-t-204&fp=1";
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
        for (Element link : links) {
        	if(link.attr("abs:href").contains("amine-eddeghai"))
        	{
            print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
            
            try {
				searchProfile.searchPeople(link.attr("abs:href"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }}
        
        
        // profil fake
        this.profil = new Profil("PEOC'H1", "Guillaume1", "https://www.linkedin.com/pub/guillaume-peoch/a2/37/513",74, "SSD", "Informatique Reseaux", "Arlington");
        
        
    }
   
   	public Profil getProfil(){
   		return this.profil;
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
