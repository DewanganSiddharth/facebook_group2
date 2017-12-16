package com.varun.fbproj.DemoFB;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws IOException 
     * @throws JSONException 
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() throws IOException, JSONException {
    	URL url = new URL("http://egov-micro-qa.egovernments.org/pgr/seva?jurisdiction_id=default");
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Content-Type","application/json");
		String data="{ "+ 
			   "RequestInfo"+":{"+  
				      "api_id"+":"+"org.egov.pgr"+","+
				      "ver"+":"+"1.0"+","+
				      "ts"+":"+"21-04-2017 15:55:37"+","+
				      "action"+":"+"POST"+","+
				      "did"+":"+"4354648646"+","+
				      "key"+":"+"xyz"+","+
				      "msg_id"+":"+"654654"+","+
				      "requester_id"+":"+"61"+","+
				      "auth_token"+":"+"a6dd825f-e7b5-4428-a128-cacc28f882aa"+","+
				  " },"+
				   "ServiceRequest"+":"+"{"+  
				      "service_code"+":"+"AOS"+","+
				      "description"+":"+"Garbage Toilet"+","+
				      "address_id"+":"+"258"+","+
				      "lat"+":"+"0"+","+
				      "lng"+":"+"0"+","+
				      "address"+":"+"Near Central area"+","+
				      "service_request_id"+":"+"hack-1"+","+
				      "first_name"+":"+"Kumar"+","+
				      "phone"+":"+"0000000000"+","+
				      "email"+":"+"kumar@ccc.com"+","+
				      "status"+":"+true+","+
				      "service_name"+":"+"Absenteesim of sweepers"+","+
				      "requested_datetime"+":"+""+","+
				      "media_url"+":"+""+","+
				      "tenantId"+":"+"default"+","+
				      "values"+":"+"{"+  
				         "receivingMode"+":"+"Website"+","+
				         "receivingCenter"+":"+""+","+
				         "status"+":"+"REGISTERED"+","+
				         "complainantAddress"+":"+"Near central bus stop"+
				      "}"+
				      "}"+
				      "}";
		
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
    	JSONObject jb = new JSONObject(data);
    	conn.setRequestProperty(key, value);
    	
    	
    	
        return "Got it!";
    }
}
