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
		bw.write(leerling + "," + datum + "," + aanwezigheid);
		bw.newLine();
		bw.close();
	}
}
