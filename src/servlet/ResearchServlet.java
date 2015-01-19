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

import bean.Profil;
import bean.ResearchBean;




@WebServlet(name="researchServlet", urlPatterns = {"/"})
public class ResearchServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;

	private static String VUE = "/WEB-INF/index.jsp";
	private static String RESULT = "/WEB-INF/result.jsp";
	private static String RESULT_ERROR = "/WEB-INF/resultError.jsp";
	private static String INITIALPATH = "save.csv";

	private ResearchBean bean;
	private Profil profil;

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Button Search 
		if (request.getParameter("searchBTN") != null) {

			System.out.println("btn1");



			try {

				bean = new ResearchBean();
				//bean = (ResearchRemote) ctx.lookup("ResearchBean");
				System.out.println("SearchBTN");

				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");

				System.out.println("btn2");

				profil = this.bean.research(nom, prenom);
				if(profil == null)
				{
					profil = new Profil();
				}
				System.out.println("btn3");
				System.out.println(profil.getNom());

				//if(bean.succes()){
				
				if(!profil.getNom().equals("Default") && !profil.getPrenom().equals("Default")) {
					saveProfil(profil);
				}

				// Nous envoyons notre uilisateur qui vient de se connecter a friends.jsp
				request.setAttribute("profil", profil);

				this.getServletContext().getRequestDispatcher(RESULT).forward(request, response);

			}
			catch (Exception e)
			{ 
				e.printStackTrace();
			}
		}  


	}

	void saveProfil(Profil profil) {

		boolean dejaEcrit = false;
		try
		{
			File fichier = new File(INITIALPATH);

			fichier.createNewFile();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		try{

			BufferedReader br = new BufferedReader(new FileReader(INITIALPATH));
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
				
				BufferedWriter writer = new BufferedWriter(new FileWriter(INITIALPATH, true));
				String result = profil.getNom() + "," + profil.getPrenom() + "," + profil.getUrlLinkedin() + "\n" ;
				writer.write(result);
				writer.close();
				System.out.println("Ecriture fichier terminée");
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Déjà sauvegardé");
		}
	}

}












