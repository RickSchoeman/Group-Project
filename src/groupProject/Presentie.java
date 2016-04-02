package groupProject;

import java.io.*;
import java.time.LocalDate;

public class Presentie {
	private String leerlingNr;
	private LocalDate datum;

	public Presentie(String lNr, LocalDate dat) {
		leerlingNr = lNr;
		datum = dat;
	}

	public void meldPresentie() throws IOException, FileNotFoundException {

		FileWriter fw = new FileWriter("src/presentie.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(leerlingNr + "," + datum);
		bw.newLine();
		bw.close();
	}
}
