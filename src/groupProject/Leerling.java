package groupProject;


public class Leerling {
	private String leerlingNummer;
	private String gebruikersNaam;
	private String klas;
	
	private Klas mijnKlas;
	
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
}
