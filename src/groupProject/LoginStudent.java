package groupProject;

import java.io.*;

public class LoginStudent {
	private String leerlingNr;
	private String wachtwoord = "123";
	private String ingevoerdWW;

	public LoginStudent(String gbnm, String ww) {
		leerlingNr = gbnm;
		ingevoerdWW = ww;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		boolean gelijkeObjecten = false;

		if (obj instanceof LoginStudent) {
			LoginStudent andereLogin = (LoginStudent) obj;
			if (this.leerlingNr.equals(andereLogin.leerlingNr) 
					&& this.wachtwoord.equals(andereLogin.wachtwoord) 
					&& this.ingevoerdWW.equals(andereLogin.ingevoerdWW)) {
				gelijkeObjecten = true;
			}
		}
		return gelijkeObjecten;
	}
	
	
	public boolean checkLogin() throws IOException, FileNotFoundException {
		FileReader fr = new FileReader("src/klassen.txt");
		BufferedReader br = new BufferedReader(fr);
		String regel = br.readLine();
		while (regel != null) {
			String[] values = regel.split(",");
			String gevondenNr = values[0];
			regel = br.readLine();

			if (leerlingNr.equals(gevondenNr)) {
				if (ingevoerdWW.equals(wachtwoord)) {
					return true;
				} 
				else {
					return false;
				}
			} 
			else {
				return false;
			}
		}
		br.close();
		return false;
	}
}
