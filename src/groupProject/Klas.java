package groupProject;

import java.util.ArrayList;
import java.io.*;

public class Klas {
	private String klasCode;
	private ArrayList<Leerling> alleLeerlingen;
	private ArrayList<Leerling> deLeerlingen;
	
	public Klas(String kC) {
		klasCode = kC;
	}
	
	public String getKlasCode() {
		return klasCode;
	}
	
	public void vulKlas()throws IOException, FileNotFoundException{
		
		FileReader fr = new FileReader("src/SIE_V1A.txt");
		BufferedReader br = new BufferedReader(fr);
		String regel = br.readLine();
		while (regel != null) {
			String[] values = regel.split(",");
			String lnr = values[0] + " ";
			String gbNm = values[3]+ " " + values[2] + " " + values[1];
			String k = " " + values[4];
			Leerling s = new Leerling(lnr, gbNm, k);
			deLeerlingen.add(s);
			System.out.printf("%s %s %s %n", lnr, gbNm, k);
			regel = br.readLine();
			
		}
		br.close();
		
	}
	
	@Override
	public String toString() {
		String s = klasCode+ " :\n";
		if(deLeerlingen != null){
			for(int i = 0; i < deLeerlingen.size(); i++) {   
			    s = s + deLeerlingen.get(i) + "\n";
			}  
		}
		else{
			s = s + "De arrayList geeft null.";
		}
		
		return s;
	}
}
