package groupProject;

import java.io.*;

public class Betermelden {
	private String persoon;
	private String datum;
	private String reden;
	

	public Betermelden(String p, String dat, String r) {
		persoon = p;
		datum = dat;
		reden = r;
	}
	
	public boolean checkLogin() throws IOException, FileNotFoundException {
		FileReader fr = new FileReader("src/afmelden.txt");
		BufferedReader br = new BufferedReader(fr);
		String regel = br.readLine();
		while (regel != null) {
			String[] values = regel.split(",");
			String gevondenPersoon = values[0];
			regel = br.readLine();
			if (persoon == gevondenPersoon){
				return true;
			}
			else{
				continue;
			}
		}
		br.close();
		return false;
		}	

	public void meldPresentie() throws IOException, FileNotFoundException {

		FileWriter fw = new FileWriter("src/betermelden.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(persoon + ", Beter, " + datum + ", " + reden);
		bw.newLine();
		bw.close();
	}
}