package fuvar.stream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FajlKezeles {

	public List<Fuvar> FajlBeolvasas(String fajlnev, String elvalaszto) {

		List<Fuvar> adatok = new ArrayList<Fuvar>();

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev), "UTF-8"));

			br.readLine();

			while (br.ready()) {

				String[] db = br.readLine().split(elvalaszto);

				Fuvar f = new Fuvar(Integer.parseInt(db[0]), LocalDateTime.parse((db[1].replace(" ", "T"))),
						Integer.parseInt(db[2]), Double.parseDouble((db[3]).replace(",", ".")),
						Double.parseDouble((db[4]).replace(",", ".")), Double.parseDouble((db[5]).replace(",", ".")),
						db[6]);

				adatok.add(f);

			}

			br.close();

		} catch (Exception e) {
			System.err.println("Hiba történt az adatok beolvasásakor!");
		}

		return adatok;
	}

	public void HibasFuvarokKiirasa(List<Fuvar> hibasFuvarok, String fajlnev, String elvalaszto) {

		List<LocalDateTime> idoPontok = hibasFuvarok.stream().map(x -> x.getIndulasIdopontja()).sorted()
				.collect(Collectors.toList());

		try {

			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fajlnev), "UTF-8");

			for (LocalDateTime indulasIdeje : idoPontok) {
				for (Fuvar fuvar : hibasFuvarok) {
					if (indulasIdeje.isEqual(fuvar.getIndulasIdopontja())) {
						String kiir = String.valueOf(fuvar.getTaxiID()) + elvalaszto
								+ String.valueOf(((fuvar.getIndulasIdopontja()).toString()).replace("T", " "))
								+ elvalaszto + String.valueOf(fuvar.getIdoTartam()) + elvalaszto
								+ String.valueOf(fuvar.getTavolsag()) + elvalaszto + String.valueOf(fuvar.getVitelDij())
								+ elvalaszto + String.valueOf(fuvar.getBorravalo()) + elvalaszto
								+ fuvar.getFizetesModja();
						out.write(kiir + "\n");
					}
				}
			}

			out.close();

		} catch (Exception e) {
			System.err.println("Hiba történt az adatok mentése közben!");
		}

		System.out.println("8. feladat: hibak.txt");
	}

}
