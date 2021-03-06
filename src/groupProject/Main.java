package groupProject;

import java.io.*;
import java.time.LocalDate;

public class Main{

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Klas k1 = new Klas("SIE-V1A");
		Klas k2 = new Klas("SIE-V1B");
		Klas k3 = new Klas("SIE-V1C");
		Klas k4 = new Klas("SIE-V1D");
		Klas k5 = new Klas("SIE-V1E");
		Klas k6 = new Klas("SIE-V1F");
		
		Vak v1 = new Vak("Alex Jongman");
		Vak v2 = new Vak("Peter van Rooijen");
		Vak v3 = new Vak("Bart van Eijkelenburg");
		Vak v4 = new Vak("John Smeets");
		Vak v5 = new Vak("Jan Willem Pauw");
		Vak v6 = new Vak("Michiel Blijleven");
		Vak v7 = new Vak("Dick Pronk");
		Vak v8 = new Vak("Peter Schuler");
		
		Rooster v1a = new Rooster("SIE-V1A");
		Rooster v1b = new Rooster("SIE-V1B");
		Rooster v1c = new Rooster("SIE-V1C");
		Rooster v1d = new Rooster("SIE-V1D");
		Rooster v1e = new Rooster("SIE-V1E");
		Rooster v1f = new Rooster("SIE-V1F");
		
		LoginStudent logS1 = new LoginStudent("1682250", "123");
		
		LoginLeraar logL1 = new LoginLeraar("Alex Jongman", "123");
		
		Presentie p1 = new Presentie("1682250", LocalDate.now(), "Present");
		
		Afmelden a1 = new Afmelden("1682250", LocalDate.now(), "Ziek");
		
		Betermelden b1 = new Betermelden("1682250", LocalDate.now(), "Beter");
		
		CheckKlas ck = new CheckKlas("1682250");
		
		PresentieBekijken pb = new PresentieBekijken("1682250", LocalDate.now());
		
		
		
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
		v1.vulVak();
		System.out.println(v1.toString());
		v2.vulVak();
		System.out.println(v2.toString());
		v3.vulVak();
		System.out.println(v3.toString());
		v4.vulVak();
		System.out.println(v4.toString());
		v5.vulVak();
		System.out.println(v5.toString());
		v6.vulVak();
		System.out.println(v6.toString());
		v7.vulVak();
		System.out.println(v7.toString());
		v8.vulVak();
		System.out.println(v8.toString());
		
		v1a.zoekRooster();
		System.out.println(v1a.toString());
		v1b.zoekRooster();
		System.out.println(v1b.toString());
		v1c.zoekRooster();
		System.out.println(v1c.toString());
		v1d.zoekRooster();
		System.out.println(v1d.toString());
		v1e.zoekRooster();
		System.out.println(v1e.toString());
		v1f.zoekRooster();
		System.out.println(v1f.toString());
		
		System.out.println(logS1.checkLogin());
		
		System.out.println(logL1.checkLogin());
		
		p1.meldPresentie();
<<<<<<< HEAD
		if (a1.alAfwezig() == true){
			a1.meldAfwezigheid();
		}
		if(b1.checkMelding() == true && b1.alBeter() == true){
=======
		
			a1.meldAfwezigheid();
		
		
>>>>>>> origin/master
			b1.meldBeter();
		
		
		pb.presentieInzien();
		System.out.println(pb.toString());

	}
}




