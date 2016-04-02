package groupProject;

import java.io.*;

public class Presentie {
	private String leerlingNr;
	private String datum;

	public Presentie(String lNr, String dat) {
		leerlingNr = lNr;
		datum = dat;
	}

	public void meldPresentie() throws IOException, FileNotFoundException {

		FileWriter fw = new FileWriter("src/presentie.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(leerlingNr + " was op " + datum + " afwezig bij de les.");
		bw.newLine();
		bw.close();
	}
}
