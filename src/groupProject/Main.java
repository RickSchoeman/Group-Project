package groupProject;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException, FileNotFoundException {

		FileReader fr = new FileReader("src/klassen.txt");
		BufferedReader br = new BufferedReader(fr);
		String regel = br.readLine();
		while (regel != null) {
			String[] values = regel.split(",");
			String lnr = values[0];
			String gbNm = values[3]+ " " + values[2] + " " + values[1];
			String k = values[4];
			Leerling s = new Leerling(lnr, gbNm, k);
			System.out.printf("%s %s %s %n", lnr, gbNm, k);
			regel = br.readLine();
		}
		br.close();

	}

}
