package ch.qiminfo.cashdrawer.client.worker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * Created by patrick-edouard on 3/12/16.
 */
public class HttpWorker implements Runnable{

    public static final String WEB_APP_URL = "http://localhost:8080/WebApp/index";
    private HttpPost httpPost;
    private HttpClient httpClient;

    private double price;
    private double amountPaid;

    public HttpWorker(){
        httpClient = HttpClients.createDefault();
    }

    private void sendCoinRequest(){

        try {
            httpPost = new HttpPost(WEB_APP_URL);

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("AmountPaid", amountPaid+""));
            params.add(new BasicNameValuePair("Price", price + ""));

            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            HttpResponse httpResponse = null;

            httpResponse = httpClient.execute(httpPost);

            HttpEntity entity = httpResponse.getEntity();
            String httpResponseStr = EntityUtils.toString(entity, "UTF-8");

            logResponse(httpResponseStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void logResponse(String htmlResponse){
        // Log to see coins and so on

        if(htmlResponse.contains("Error")){
            System.out.println("Error paying : ");
        }

        System.out.println(htmlResponse.substring(htmlResponse.indexOf("<BODY>")+"<BODY>".length(),htmlResponse.indexOf("</BODY>")));

    }

    public void run() {
        sendCoinRequest();
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
