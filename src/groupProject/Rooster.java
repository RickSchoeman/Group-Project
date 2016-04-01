package groupProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Rooster {
	private String klasCode;
	private ArrayList<String> hetRooster = new ArrayList<String>();
	
	public Rooster(String kC) {
		klasCode = kC;
	}
	
	public String getKlasCode() {
		return klasCode;
	}
	
	public void zoekRooster() throws IOException, FileNotFoundException {
		FileReader fr = new FileReader("src/rooster_C.txt");
		BufferedReader br = new BufferedReader(fr);
		String regel = br.readLine();
		while (regel != null) {
			String[] values = regel.split(",");
			String lD = values[0];
			String lS = values[1];
			String lE = values[2];
			String l = values[5];
			String v = values[3];
			String g = values[4];
			String k = values[6];
			String s = lD + " | " + lS + " | " + lE + " | " + l + " | " + k + " | " + v + " | " + g ;
			if(klasCode.equals(k)){
				hetRooster.add(s);
			}
			regel = br.readLine();
		}
		br.close();
		
		
	}
	@Override
	public String toString() {
		String s = klasCode + " Heeft het volgende rooster: \n";
		for(int i = 0; i < hetRooster.size(); i++) {   
		    s = s + hetRooster.get(i) + "\n";
		}  
		return s;
	}
}
