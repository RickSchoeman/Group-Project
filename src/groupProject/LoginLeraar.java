package groupProject;

import java.io.*;

public class LoginLeraar {
	private String naam;
	private String wachtwoord = "123";
	private String ingevoerdWW;

	public LoginLeraar(String gbnm, String ww) {
		naam = gbnm;
		ingevoerdWW = ww;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		boolean gelijkeObjecten = false;

		if (obj instanceof LoginLeraar) {
			LoginLeraar andereLogin = (LoginLeraar) obj;
			if (this.naam.equals(andereLogin.naam) 
					&& this.wachtwoord.equals(andereLogin.wachtwoord) 
					&& this.ingevoerdWW.equals(andereLogin.ingevoerdWW)) {
				gelijkeObjecten = true;
			}
		}
		return gelijkeObjecten;
	}
	
	
	public boolean checkLogin() throws IOException, FileNotFoundException {
		FileReader fr = new FileReader("src/rooster_C.txt");
		BufferedReader br = new BufferedReader(fr);
		String regel = br.readLine();
		while (regel != null) {
			String[] values = regel.split(",");
			String gevondenNaam = values[4];
			regel = br.readLine();

			if (naam.equals(gevondenNaam)) {
				if (ingevoerdWW.equals(wachtwoord)) {
					return true;
				} 
				
			}}
		br.close();
		return false;
	}
}
