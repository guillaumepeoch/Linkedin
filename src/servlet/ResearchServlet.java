package servlet;


import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import profil.Profil;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;

import ejbs.ResearchBean;
import ejbs.ResearchRemote;


@WebServlet("/researchServlet")
public class ResearchServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	private ResearchRemote bean;
	private Profil profil;

	protected void ini() throws NamingException{
		InitialContext ctx = new InitialContext();
		bean = (ResearchRemote) ctx.lookup("ResearchBean");
		System.out.println("ini");


	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Button Search 
		if (request.getParameter("searchBTN") != null) {

			System.out.println("btn1");

			

	        	try {
	        		ini();

	        		System.out.println("SearchBTN");

		        	String nom = request.getParameter("nom");
		            String prenom = request.getParameter("prenom");

		            System.out.println("btn2");
		            
		            this.profil = this.bean.research(nom, prenom);
		            System.out.println("btn3");
		            System.out.println(bean.toString());

		            // profil fake
		            //this.profil = new Profil("PEOC'H", "Guillaume", "https://www.linkedin.com/pub/guillaume-peoch/a2/37/513",74, "SSD", "Informatique Reseaux", "Arlington");
		            
		            
		            System.out.println(this.profil.getNom()); 

		        	//if(bean.succes()){



		        		// Nous envoyons notre uilisateur qui vient de se connecter a friends.jsp
		        		request.setAttribute("profil", profil);

		        		request.getRequestDispatcher("/result.jsp").forward(request, response);


		        		} catch (Exception e) { e.printStackTrace();
		        		}
	        }  


		}

	}












