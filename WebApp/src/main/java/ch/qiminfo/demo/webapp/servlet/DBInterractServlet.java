package ch.qiminfo.demo.webapp.servlet;

import ch.qiminfo.demo.business.ejb.db.acces.DbAcces;
import ch.qiminfo.demo.database.entities.CoinType;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by patrick-edouard on 3/13/16.
 */
public class DBInterractServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

    @EJB
    DbAcces dbAcces;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html");
        ServletOutputStream out = res.getOutputStream();
        out.println("<HTML>\n");
        out.println("<HEAD>\n");
        out.println("<TITLE>CashDrawer</TITLE>\n");
        out.println("</HEAD>\n");
        out.println("<BODY>\n");
        out.println("<H1>Managing cash in DB</H1>\n");

        out.println("<FORM ACTION=\"http://localhost:8080/WebApp/db\" METHOD=\"POST\">");
        out.println("Adding cash to : ");

        for(CoinType coinType : CoinType.values()){
            out.println("coinType : "+coinType.getCoinTypeString());
            out.println("<INPUT NAME=\""+coinType.getCoinTypeString()+"\"></br>");
        }

        out.println("<input type=\"submit\" value=\"Add those coins !\">");
        out.println("</FORM>");

        out.println("</BODY>\n");
        out.println("</HTML>");
    }



    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {

        Map<String, String> coinsInfo = new HashMap<>();

        for(CoinType coinType : CoinType.values()){
            coinsInfo.put(coinType.getCoinTypeString(), req.getParameter(coinType.getCoinTypeString()));
        }
        dbAcces.addNewCoins(coinsInfo);

        res.setContentType("text/html");
        ServletOutputStream out = res.getOutputStream();

        out.println("<HTML>\n");
        out.println("<HEAD>\n");
        out.println("<TITLE>CashDrawer</TITLE>\n");
        out.println("</HEAD>\n");
        out.println("<BODY>\n");
        out.println("Cash added");
        out.println("</BODY>\n");
        out.println("</HTML>");

    }
}
