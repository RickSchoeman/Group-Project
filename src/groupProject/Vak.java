package groupProject;

import java.io.*;
import java.util.ArrayList;

public class Vak {
	private String leraar;
	private ArrayList<Leraar> deLeraren = new ArrayList<Leraar>();
	
	public Vak( String l) {
		leraar = l;
	}
	
	public String getVakNaam() {
		return leraar;
	}
	
	public String getVakCode() {
		return leraar;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		boolean gelijkeObjecten = false;

		if (obj instanceof Vak) {
			Vak andereVak = (Vak) obj;
			if (this.leraar.equals(andereVak.leraar)) {
				gelijkeObjecten = true;
			}
		}
		return gelijkeObjecten;
	}
	
	public void vulVak() throws IOException, FileNotFoundException{
		FileReader fr = new FileReader("src/rooster_C.txt");
		BufferedReader br = new BufferedReader(fr);
		String regel = br.readLine();
		while (regel != null) {
			String[] values = regel.split(",");
			String lD = values[0];
			String lS = values[1];
			String lE = values[2];
			String l = values[5];
			String nwV = values[3];
			String gbNm = values[4];
			String nwK = values[6];
			if(leraar.equals(gbNm)){
				if(!deLeraren.contains(nwV)){
					Leraar s = new Leraar(nwV, gbNm, nwK, lD, lS, lE, l);
					deLeraren.add(s);
				}
				
			}
			regel = br.readLine();
		}
		br.close();
	}
	
	@Override
	public String toString() {
		String s = leraar + " geeft op de volgende data de volgende vakken: \n";
		for(int i = 0; i < deLeraren.size(); i++) {   
		    s = s + deLeraren.get(i) + "\n";
		}  
		return s;
	}
}
