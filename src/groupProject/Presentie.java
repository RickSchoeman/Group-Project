package groupProject;

import java.io.*;
import java.time.LocalDate;

public class Presentie {
	private String leerling;
	private LocalDate datum;
	private String aanwezigheid;

	public Presentie(String l, LocalDate dat, String a) {
		leerling = l;
		datum = dat;
		aanwezigheid = a;
	}

	public void meldPresentie() throws IOException, FileNotFoundException {

		FileWriter fw = new FileWriter("src/presentie.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		String[] values = leerling.split(" | ");
		String nr = values[0];
		bw.write(nr + "," + datum + "," + aanwezigheid);
		bw.newLine();
		bw.close();
	}
}
