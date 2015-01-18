package servlet;


import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
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

}












