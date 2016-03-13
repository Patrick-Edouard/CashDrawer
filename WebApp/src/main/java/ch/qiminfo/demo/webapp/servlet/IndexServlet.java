package ch.qiminfo.demo.webapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.qiminfo.demo.business.ejb.CoinsComputing;
import ch.qiminfo.demo.business.ejb.exception.NotPaidEnoughException;
import ch.qiminfo.demo.database.entities.exception.NotEnoughCoinsException;
import ch.qiminfo.demo.database.entities.Coin;

/**
 * Created by patrick-edouard on 3/10/16.
 */
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	CoinsComputing coinsComputing;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	
        res.setContentType("text/html");
        ServletOutputStream out = res.getOutputStream();
        out.println("<HTML>\n");
        out.println("<HEAD>\n");
        out.println("<TITLE>CashDawler</TITLE>\n");
        out.println("</HEAD>\n");
        out.println("<BODY>\n");
        out.println("<H1>Hello, what do you want to pay?</H1>\n");
        
        out.println("<FORM ACTION=\"http://localhost:8080/WebApp/index\" METHOD=\"POST\">");
        out.println("Amount paid : ");
        out.println("<INPUT NAME=\"AmountPaid\">");
        out.println("Price : ");
        out.println("<INPUT NAME=\"Price\">");
        out.println("<input type=\"submit\" value=\"Give my money back\">");
        out.println("</FORM>");
        
        out.println("</BODY>\n");
        out.println("</HTML>");
    }
    
    
    
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
    	double payedAmount = Double.parseDouble(req.getParameter("AmountPaid"));
        double price = Double.parseDouble(req.getParameter("Price"));

        res.setContentType("text/html");
        ServletOutputStream out = res.getOutputStream();
        
        out.println("<HTML>\n");
        out.println("<HEAD>\n");
        out.println("<TITLE>Bonjour</TITLE>\n");
        out.println("</HEAD>\n");
        out.println("<BODY>\n");
    	
    	List<Coin> coins;
    	
		try {
			coins = coinsComputing.getMoney(price, payedAmount);
			
			for(Coin coin : coins){
	    		out.println(coin.toString()+"</br>");
	    	}
			
		} catch (NotEnoughCoinsException e) {
            out.println("Error:");
			out.println(e.getMessage());
			e.printStackTrace();
		} catch (NotPaidEnoughException ex){
            out.println("Error:");
            out.print(ex.getMessage());
        }

		out.println("</BODY>\n");
        out.println("</HTML>");
    	
    }
}
