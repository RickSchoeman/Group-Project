package groupProject;

import java.io.*;
import java.time.LocalDate;

public class Afmelden {
	private String persoon;
	private LocalDate datum;
	private String reden;
	

	public Afmelden(String p, LocalDate dat, String r) {
		persoon = p;
		datum = dat;
		reden = r;
	}
	

	public void meldAfwezigheid() throws IOException, FileNotFoundException {

		FileWriter fw = new FileWriter("src/afmelden.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(persoon + "," + datum + "," + reden);
		bw.newLine();
		bw.close();
	}
}