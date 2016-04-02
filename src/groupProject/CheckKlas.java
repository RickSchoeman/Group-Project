package groupProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckKlas {
	private String leerlingNr;
	
	public CheckKlas(String lNr) {
		leerlingNr = lNr;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		boolean gelijkeObjecten = false;
		if (obj instanceof CheckKlas) {
			CheckKlas andereNr = (CheckKlas) obj;
			if (this.leerlingNr.equals(andereNr.leerlingNr)) {
				gelijkeObjecten = true;
			}
		}
		return gelijkeObjecten;
	}
	
	public String geefKlas() throws IOException{
		String klas = "";
		FileReader fr = new FileReader("src/klassen.txt");
		BufferedReader br = new BufferedReader(fr);
		String regel = br.readLine();
		while (regel != null) {
			String[] values = regel.split(",");
			String nr = values[0];
			String k = values[4];

			if(leerlingNr.equals(nr)){
				klas = k;
			}
			regel = br.readLine();
		}
		br.close();
		
		return klas;
	}
}
