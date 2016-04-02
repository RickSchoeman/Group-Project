package groupProject;

import java.io.*;

public class Afmelden {
	private String persoon;
	private String datum;
	private String reden;
	

	public Afmelden(String p, String dat, String r) {
		persoon = p;
		datum = dat;
		reden = r;
	}
	

	public void meldPresentie() throws IOException, FileNotFoundException {

		FileWriter fw = new FileWriter("src/afmelden.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(persoon + ", Ziek, " + datum + ", " + reden);
		bw.newLine();
		bw.close();
	}
}