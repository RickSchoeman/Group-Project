package groupProject;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		Klas k1 = new Klas("SIE_V1A");
		k1.vulKlas();
		System.out.println(k1.toString());
	}
	
}
