package groupProject;

import java.io.*;
import java.time.format.DateTimeFormatter;
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
	
	public boolean alAfwezig() throws IOException, FileNotFoundException {
		FileReader fr = new FileReader("src/afmelden.txt");
		BufferedReader br = new BufferedReader(fr);
		String regel = br.readLine();
		while (regel != null) {
			String[] values = regel.split(",");
			String CheckPersoon = values[0];
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(values[1], formatter);
			regel = br.readLine();
			if (regel == ""){
			return true;
			}
			else if (persoon.equals(CheckPersoon) && datum.isAfter(date)){ 	
				return true;
				}
				
			}
				
		br.close();
		return false;	
		}

	public void meldAfwezigheid() throws IOException, FileNotFoundException {

		FileWriter fw = new FileWriter("src/afmelden.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(persoon + "," + datum + "," + reden);
		bw.newLine();
		bw.close();
	}
}