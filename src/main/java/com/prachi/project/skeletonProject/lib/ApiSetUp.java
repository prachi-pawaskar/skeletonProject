package com.prachi.project.skeletonProject.lib;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import org.apache.log4j.Logger;

import javax.net.ssl.*;
import javax.ws.rs.core.MediaType;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

/**
 * Created by prachi.pawaskar on 07-July-2016.
 */
public class ApiSetUp extends Base {

    // Variables
    public static String apiStatus, apiResponse;

    // Jersey variables for API
    public static Client client ;
    public static WebResource webResource ;
    public static ClientResponse response;

    //Logger defined for class, logs created as per log4j.properties
    private static Logger log = Logger.getLogger(ApiSetUp.class);

    // Method to disable SSL certification validation, call in doGet
    public static void disableCertificateValidation()  throws Exception {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                }};

        // Ignore differences between given hostname and certificate hostname
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) { return true; }
        };

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
        } catch (Exception e) {
        }
    }

    //Method to hit GET type APIs
    public static void doGet(String baseURL, String uri, String queryParam) throws Exception {
        // Disable SSL
        disableCertificateValidation();

        try {
            client = Client.create();

            //Appending uri and queryparams to base URL
            if (queryParam == null || queryParam == ""){
                webResource = client.resource(baseURL + uri);}
            else {webResource = client.resource(baseURL + uri + queryParam);}

            //Logging API to hit
            log.info("Hitting API: " + webResource.toString());
            response = webResource.accept("application/json")
                    .get(ClientResponse.class);

            //Logging apache code if not 200, no exception thrown to handle negative testing
            if (response.getStatus() != 200) {
                log.info("Apache status is not 200-Ok");
            }

            //Logging API apache code and API response
            String output = response.getEntity(String.class);
            log.info("API apache status: " + response.getStatus());
            log.info("API response: " + output);

            //Storing in base.class variables to use for assertions
            apiStatus = Integer.toString(response.getStatus());
            apiResponse = output;

        } catch (Exception e) {

            e.printStackTrace();

        }


    }

    //Method to hit GET type APIs
    public static String doGetWithHttpAuth(String baseURL, String uri, String queryParam, String username, String password) throws Exception {
        // Disable SSL
//        disableCertificateValidation();

        String apiCallStatus, apiCallResponse = null;
        
        try {
            client = Client.create();
            client.addFilter(new HTTPBasicAuthFilter(username, password));


            //Appending uri and queryparams to base URL
            if (queryParam == null || queryParam == ""){
                webResource = client.resource(baseURL + uri);}
            else {webResource = client.resource(baseURL + uri + queryParam);}

            //Logging API to hit
            log.info("Hitting API: " + webResource.toString());
            response = webResource.accept("application/json")
                    .get(ClientResponse.class);

            //Logging apache code if not 200, no exception thrown to handle negative testing
            if (response.getStatus() != 200) {
                log.info("Apache status is not 200-Ok");
            }

            //Logging API apache code and API response
            String output = response.getEntity(String.class);
            log.info("API apache status: " + response.getStatus());
            log.info("API response: " + output);

            //Storing in base.class variables to use for assertions
            apiCallStatus = Integer.toString(response.getStatus());
            apiCallResponse = output;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return apiCallResponse;

    }
}
