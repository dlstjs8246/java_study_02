package kr.or.yi.java_study_02.ch07.tranningEx;

public class Nation {
	private String country;
	private String capital;
	
	public Nation(String captical) {
		this.capital = captical;
	}
	
	public Nation(String country, String capital) {
		this.country = country;
		this.capital = capital;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		Nation other = (Nation) obj;
		return capital.hashCode()==other.capital.hashCode();
	}
	
}
