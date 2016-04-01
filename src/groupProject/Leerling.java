package groupProject;


public class Leerling {
	private String leerlingNummer;
	private String gebruikersNaam;
	private String klas;
	
	public Leerling(String lnr,String gbNm, String k) {
		leerlingNummer = lnr;
		gebruikersNaam = gbNm;
		klas = k;
	}
	
	public String getGebruikersNaam() {
		return gebruikersNaam;
	}
	
	public String getKlas() {
		return klas;
	}
	
	public void setKlas(String klas) {
		this.klas = klas;
	}
	
	
	
	@Override
	public String toString() {
		String s = leerlingNummer + gebruikersNaam + klas;
		return s;
	}
}
