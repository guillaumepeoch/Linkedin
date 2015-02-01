package servlet;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;

import org.apache.log4j.Logger;
import org.jsoup.examples.ListLinks;

import bean.Profil;
import bean.ResearchBean;




@WebServlet(name="researchServlet", urlPatterns = {"/"})
public class ResearchServlet extends HttpServlet{
	private static Logger logger = Logger.getLogger(ResearchServlet.class);
	

	private static final long serialVersionUID = 1L;

	private static String VUE = "/WEB-INF/index.jsp";
	private static String RESULT = "/WEB-INF/result.jsp";
	private static String NAMESAVE = "save.csv";

	private ResearchBean bean;
	private Profil profil;

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		 logger.debug("IN doGET");
			this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 logger.debug("IN doPost");
		 
		if (request.getParameter("searchBTN") != null) {
			 logger.debug("IN searchBTN");
			try {

				bean = new ResearchBean();

				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");

				profil = this.bean.research(nom, prenom);
				if(profil == null)
				{
					profil = new Profil();
				}
				
				// Sauvegarde du profil dans la request pour y acceder en jsp
				request.setAttribute("profil", profil);
				 logger.debug("OUT searchBTN");
				 
				this.getServletContext().getRequestDispatcher(RESULT).forward(request, response);

			}
			catch (Exception e)
			{ 
				logger.error("Une exception est survenue dans searchBTN : " + e.getMessage());
				e.printStackTrace();
				this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
			}
		}  
		
		if (request.getParameter("saveBTN") != null) {
			
			try
			{
				 logger.debug("IN saveBTN");
				if(!profil.getNom().equals("Default") && !profil.getPrenom().equals("Default")) {
					saveProfil(profil);				
				}
				 logger.debug("OUT saveBTN");
			}
			catch(Exception e)
			{
				logger.error("Une exception est survenue dans saveBTN : " + e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
			}
		}
		
	}

	/**
	 * Sauvegarde le profil dans un fichier CSV sur le getHomeDirectory
	 * @param profil
	 */
	void saveProfil(Profil profil) {

		 logger.debug("IN saveProfil ");
		
		boolean dejaEcrit = false;
		FileSystemView filesys = FileSystemView.getFileSystemView(); 
		String Path = filesys.getHomeDirectory() + File.separator + NAMESAVE;
		System.out.println(Path);
		try
		{
			       
			File fichier =  new File(Path);
			fichier.createNewFile();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		try{

			BufferedReader br = new BufferedReader(new FileReader(Path));
			String ligne;
			while ((ligne = br.readLine()) != null && !dejaEcrit) {
				if(!ligne.trim().equals(""))
				{
					String[] elements = ligne.split(",");

					// On supprime les espaces en début de mot
					for(int e = 0; e < elements.length; e++) {
						elements[e] = elements[e].trim();
					}
					if(elements[0].equals(profil.getNom()) && elements[1].equals(profil.getPrenom())
							&& elements[2].equals(profil.getUrlLinkedin()) )
					{
						dejaEcrit = true;
					}
				}
			}
			br.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		if(!dejaEcrit) {
			try {
				
				BufferedWriter writer = new BufferedWriter(new FileWriter(Path, true));
				String result = profil.getNom() + "," + profil.getPrenom() + "," + profil.getUrlLinkedin() + "\n" ;
				writer.write(result);
				writer.close();
				
				logger.debug("Ecriture fichier terminée");
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else {
			logger.debug("Profil déjà sauvegardé");
		}
		
		 logger.debug("OUT saveProfil ");
		
	}

}












