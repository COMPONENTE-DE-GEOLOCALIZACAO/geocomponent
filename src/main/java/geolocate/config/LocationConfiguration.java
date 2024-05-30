package geolocate.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;


import geolocate.entities.PresentLocation;
import geolocate.model.PresentLocationFactory;

	
/**
 * @author Lucas Araújo
 * @version 2.0
 * 
 */
public class LocationConfiguration {
	
	
	/**
	 * Determines a location through a given IP address.
	 * 
	 * <p>The IP address can be gathered automatically or manually inserted in the code.
	 * Then, a search will be conducted within the database for a match between a registered address and
	 * the IP address provided.
	 * 
	 * @return a PresentLocation object is returned for the given IP Address.
	 * 
	 */
	public static PresentLocation getLocation() {
		
		try {
			 String path = "src/main/resources/GeoLite2-City.mmdb";

	            File database = new File(path);
	
			InetAddress addr = InetAddress.getByName(getIPAddress()); 
			
			DatabaseReader dbReader = new DatabaseReader.Builder(database).build();
			
			CityResponse response = dbReader.city(addr);
			 	String countryName = response.getCountry().getName();
			    String cityName = response.getCity().getName();
			    String state = response.getLeastSpecificSubdivision().getName();
			    Double lat = response.getLocation().getLatitude();
			    Double longt = response.getLocation().getLongitude();
			    
			    PresentLocation location = PresentLocationFactory.createPresentLocation(countryName, cityName, state, lat, longt);
			    return location;
			    
		} catch (IOException e) {
			e.printStackTrace();
		} catch (GeoIp2Exception e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	/**
	 * This method is responsible for the retrieval of an IP address,
	 * this is achieved by reading the dataflow of a "connection" with the given url,
	 * which returns the host's IP Address.
	 * @return An IP Address is returned as a String. 
	 * @throws Exception If the connection attempt to the default URL isn't successful, a Exception will be thrown.
	 */
	private static String getIPAddress() throws Exception {
		URL whatismyip = new URL("https://checkip.amazonaws.com");
		
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(
					whatismyip.openStream()));
			String ip = in.readLine();
			return ip;
		} finally {
			if (in != null) {
				try {
					in.close();
				}catch(IOException ioe) {
					ioe.printStackTrace();
				}
				
			}
		}
	}
	
	
}
	            
