package kr.or.yi.java_study_02.ch07.tranningEx;

public class Location {
	private String city;
	private int longitude;
	private int ratitude;
	public Location(String city, int longitude, int ratitude) {
		this.city = city;
		this.longitude = longitude;
		this.ratitude = ratitude;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	public int getRatitude() {
		return ratitude;
	}
	public void setRatitude(int ratitude) {
		this.ratitude = ratitude;
	}
	@Override
	public String toString() {
		return String.format("%s, %s, %s", city, longitude, ratitude);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		Location other = (Location) obj;
		return city.hashCode()==other.city.hashCode();
	}
	
}
