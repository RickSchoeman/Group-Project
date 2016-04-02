package groupProject;

import java.io.*;
import java.time.LocalDate;

public class Betermelden {
	private String persoon;
	private LocalDate datum;
	private String reden;
	

	public Betermelden(String p, LocalDate dat, String r) {
		persoon = p;
		datum = dat;
		reden = r;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		boolean gelijkeObjecten = false;

		if (obj instanceof Betermelden) {
			Betermelden anderepersoon = (Betermelden) obj;
			if (this.persoon.equals(anderepersoon.persoon)) {
				gelijkeObjecten = true;
			}
		}
		return gelijkeObjecten;
	}
	
	public boolean checkMelding() throws IOException, FileNotFoundException {
		FileReader fr = new FileReader("src/afmelden.txt");
		BufferedReader br = new BufferedReader(fr);
		String regel = br.readLine();
		while (regel != null) {
			String[] values = regel.split(",");
			String gevondenPersoon = values[0];
			regel = br.readLine();
			if (persoon.equals(gevondenPersoon)){
				return true;
			}
		}
		br.close();
		return false;
		}	

	public void meldPresentie() throws IOException, FileNotFoundException {

		FileWriter fw = new FileWriter("src/betermelden.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(persoon + "," + datum + "," + reden);
		bw.newLine();
		bw.close();
	}
}