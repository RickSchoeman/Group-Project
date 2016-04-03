package groupProject;
	
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
	
public class PresentieBekijken {
	private String leerling;
	private LocalDate datum;
	private ArrayList<String> presenties = new ArrayList<String>(); 

	public PresentieBekijken(String l, LocalDate dat) {
		leerling = l;
		datum = dat;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		boolean gelijkeObjecten = false;

		if (obj instanceof PresentieBekijken) {
			PresentieBekijken anderePresentie = (PresentieBekijken) obj;
			if (this.leerling.equals(anderePresentie.leerling)) {
				gelijkeObjecten = true;
			}
		}
		return gelijkeObjecten;
	}
	
	public void presentieInzien() throws IOException, FileNotFoundException {
		FileReader fr = new FileReader("src/presentie.txt");
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
					presenties.add(s);
			}}
			regel = br.readLine();
		}
		br.close();
	}
	
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < presenties.size(); i++) {   
		    s = s + presenties.get(i) + "\n";
		}  
		return s;
	}
}
