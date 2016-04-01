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
		
		FileReader fr = new FileReader("src/klassen.txt");
		BufferedReader br = new BufferedReader(fr);
		String regel = br.readLine();
		while (regel != null) {
			String[] values = regel.split(",");
			String lnr = values[0] + " ";
			String gbNm = values[3]+ " " + values[2] + " " + values[1];
			String k = " " + values[4];
			Leerling s = new Leerling(lnr, gbNm, k);
			alleLeerlingen.add(s);
			System.out.printf("%s %s %s %n", lnr, gbNm, k);
			regel = br.readLine();
			
			
			FileReader fr2 = new FileReader("src/SIE_V1A.txt");
			BufferedReader br2 = new BufferedReader(fr);
			String regel2 = br.readLine();
			while(regel2 != null){
				String[] values2 = regel.split(",");
				String lnr2 = values[0] + " ";
				String gbNm2 = values[3]+ " " + values[2] + " " + values[1];
				String k2 = " " + values[4];
				if(alleLeerlingen.contains(lnr2)){
					Leerling s2 = new Leerling(lnr2, gbNm2, k2);
					deLeerlingen.add(s2);
					System.out.printf("%s %s %s %n", lnr2, gbNm2, k2);
					regel = br.readLine();
				}
			}
		}
		br.close();
		
	}
	
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < deLeerlingen.size(); i++) {   
		    s = s + deLeerlingen.get(i) + "\n";
		}  
		return s;
	}
}
