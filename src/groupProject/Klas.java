package groupProject;

import java.util.ArrayList;
import java.io.*;

public class Klas {
	private String klasCode;
	private ArrayList<Leerling> deLeerlingen = new ArrayList<Leerling>();
	
	public Klas(String kC) {
		klasCode = kC;
	}
	
	public String getKlasCode() {
		return klasCode;
	}
	
	public void vulKlas() throws IOException, FileNotFoundException {
		FileReader fr = new FileReader("src/"+klasCode+".txt");
		BufferedReader br = new BufferedReader(fr);
		String regel = br.readLine();
		while (regel != null) {
			String[] values = regel.split(",");
			String lnr = values[0] + " ";
			String gbNm = values[3]+ " " + values[2] + " " + values[1];
			String k = " " +klasCode;
			Leerling s = new Leerling(lnr, gbNm, k);
			deLeerlingen.add(s);

			regel = br.readLine();
		}
		br.close();
		
		
	}
	@Override
	public String toString() {
		String s = klasCode + " bevat de volgende leerlingen: \n";
		for(int i = 0; i < deLeerlingen.size(); i++) {   
		    s = s + deLeerlingen.get(i) + "\n";
		}  
		return s;
	}
}
