package groupProject;

import java.io.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		ArrayList<Leerling> leerlingen= new ArrayList<Leerling>();
		Klas k1 = new Klas("SIE_V1A");
		Klas k2 = new Klas("SIE_V1B");
		Klas k3 = new Klas("SIE_V1C");
		Klas k4 = new Klas("SIE_V1D");
		Klas k5 = new Klas("SIE_V1E");
		Klas k6 = new Klas("SIE_V1F");
		
		
		FileReader fr = new FileReader("src/"+k1.getKlasCode()+".txt");
		BufferedReader br = new BufferedReader(fr);
		String regel = br.readLine();
		while (regel != null) {
			String[] values = regel.split(",");
			String lnr = values[0] + " ";
			String gbNm = values[3]+ " " + values[2] + " " + values[1];
			String k = " " +k1.getKlasCode();
			Leerling s = new Leerling(lnr, gbNm, k);
			leerlingen.add(s);

			regel = br.readLine();
		}
		br.close();
		String s = k1.getKlasCode() + " bevat de volgende leerlingen: \n";
		for(int i = 0; i < leerlingen.size(); i++) {   
		    s = s + leerlingen.get(i) + "\n";
		}  
		System.out.println(s);
		
		
	}
	
}
