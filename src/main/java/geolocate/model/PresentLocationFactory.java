package geolocate.model;

import geolocate.entities.PresentLocation;

public class PresentLocationFactory {
		
	public static PresentLocation createPresentLocation(String countryName, String cityName, String state, Double latitude, Double longt) {
		return new PresentLocation(countryName, cityName, state, latitude, longt);
	}
}
