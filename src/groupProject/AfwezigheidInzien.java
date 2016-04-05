package groupProject;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AfwezigheidInzien {
	private String leerling;
	private LocalDate datum;
	private ArrayList<String> afwezigheid = new ArrayList<String>(); 

	public AfwezigheidInzien(String l, LocalDate dat) {
		leerling = l;
		datum = dat;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		boolean gelijkeObjecten = false;

		if (obj instanceof AfwezigheidInzien) {
			AfwezigheidInzien andereAfwezigheid = (AfwezigheidInzien) obj;
			if (this.leerling.equals(andereAfwezigheid.leerling)) {
				gelijkeObjecten = true;
			}
		}
		return gelijkeObjecten;
	}
	
	public void afwezigInzien() throws IOException, FileNotFoundException {
		FileReader fr = new FileReader("src/afmelden.txt");
		BufferedReader br = new BufferedReader(fr);
		String regel = br.readLine();
		while (regel != null) {
			String[] values = regel.split(",");
			String nm = values[0];
			String dat = values[1];
			String p = values[2];
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(dat, formatter);
			if(nm.equals(leerling)){
				if (datum.getMonth() == date.getMonth()){
					String s = nm + " | " + dat + " | " + p ;
					afwezigheid.add(s);
			}}
			regel = br.readLine();
		}
		br.close();
	}
	
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < afwezigheid.size(); i++) {   
		    s = s + afwezigheid.get(i) + "\n";
		}  
		return s;
	}
}
