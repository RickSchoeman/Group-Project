package groupProject;



public class Leraar {
	private String vak;
	private String gebruikersNaam;
	private String klas;
	private String lesDatum;
	private String lesStart;
	private String lesEind;
	private String locatie;

	
	public Leraar(String nwV, String gbNm, String nwK, String lD, String lS, String lE, String l) {
		vak = nwV;
		gebruikersNaam = gbNm;
		klas = nwK;
		lesDatum = lD;
		lesStart = lS;
		lesEind = lE;
		locatie = l;
	}
	
	public String getGebruikersNaam() {
		return gebruikersNaam;
	}

	
	@Override
	public String toString() {
		String s =lesDatum + " | " + lesStart + " | " + lesEind + " | " + locatie + " | " + klas + " | " + vak + " | " + gebruikersNaam ;
		return s;
	}
}
