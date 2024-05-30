package geolocate.entities;


/**
 * Concrete class for representing a PresentLocation
 * @author Lucas Araújo
 */
public class PresentLocation{

	private String countryName;
	private String cityName;
	private String state;
	private Double latitude;
	private Double longitude;
	
	
	
	public PresentLocation() {
		
	}
	
	public PresentLocation(String countryName, String cityName, String state, Double latitude, Double longitude) {
		super();
		this.countryName = countryName;
		this.cityName = cityName;
		this.state = state;
		this.latitude = latitude;
		this.longitude = longitude;
		
	}
	public String getCountryName() {
		return countryName;
	}
	public String getCityName() {
		return cityName;
	}

	public String getState() {
		return state;
	}
	
	
	public Double getLatitude() {
		return latitude;
	}


	public Double getLongitude() {
		return longitude;
	}


	@Override
	public String toString() {
		return "Location [countryName=" + countryName + ", cityName=" + cityName + ", postal=" + ", state="
				+ state + "]";
	}
	
	
}
