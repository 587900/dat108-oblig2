package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Kongeresultat
 */
@WebServlet("/sok")
public class Kongeresultat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String aarString = request.getParameter("aar");
		if (aarString == null) {
//			response.sendError(400, "Bad request.");
			response.sendRedirect("index.html");
			return;
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Søk etter konge</title>");
		out.println("</head>");
		out.println("<body>");
		try {
			int aar = Integer.parseInt(aarString);
			Konge k = Konger.norske.stream()
					.filter(konge -> (konge.getKongeFraAar() <= aar && konge.getKongeTilAar() >= aar)).findFirst()
					.orElse(null);

			if (k == null) {
				out.println("Jeg vet ikke om noen konger for dette årstallet.");
			} else {
				out.println("<img src=\"" + k.getBilde() + "\"></img><br />");
				out.println("Konge i år " + aar + " var " + k.toString());
			}
		} catch (NumberFormatException e) {
			out.println("Skriv et tall.");
		}
		out.println("<br /><a href=\"index.html\">Nytt søk</a>");
		out.println("</body>");
		out.println("</html>");
	}
}
