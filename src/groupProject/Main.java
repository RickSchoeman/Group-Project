package groupProject;

import java.io.*;

public class Main{

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Klas k1 = new Klas("SIE_V1A");
		Klas k2 = new Klas("SIE_V1B");
		Klas k3 = new Klas("SIE_V1C");
		Klas k4 = new Klas("SIE_V1D");
		Klas k5 = new Klas("SIE_V1E");
		Klas k6 = new Klas("SIE_V1F");
		
		k1.vulKlas();
		System.out.println(k1.toString());
		k2.vulKlas();
		System.out.println(k2.toString());
		k3.vulKlas();
		System.out.println(k3.toString());
		k4.vulKlas();
		System.out.println(k4.toString());
		k5.vulKlas();
		System.out.println(k5.toString());
		k6.vulKlas();
		System.out.println(k6.toString());
		

	}
	
}
