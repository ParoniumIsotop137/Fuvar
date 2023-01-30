package fuvar.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Feladatok {

	public void FizetesiModok(List<Fuvar> fuvarok) {

		Map<String, Integer> fizetesiModok = new HashMap<String, Integer>();

		for (Fuvar fuvar : fuvarok) {
			fizetesiModok.put(fuvar.getFizetesModja(), 0);
		}

		for (Map.Entry<String, Integer> item : fizetesiModok.entrySet()) {

			for (Fuvar fuvar : fuvarok) {

				if (fuvar.getFizetesModja().equals(item.getKey())) {
					item.setValue((item.getValue() + 1));
				}
			}

		}
		for (Map.Entry<String, Integer> item : fizetesiModok.entrySet()) {
			System.out.println(item.getKey() + ", " + item.getValue());
		}

	}

	public void LeghosszabbFuvar(List<Fuvar> fuvarok) {

		int leghosszabb = fuvarok.stream().mapToInt(x -> x.getIdoTartam()).max().getAsInt();

		int i = 0;

		while (i < fuvarok.size() && fuvarok.get(i).getIdoTartam() != leghosszabb) {
			i++;
		}

		String tavolsag = String.format("%.1f ", ((fuvarok.get(i).getTavolsag()) * 1.6));

		if (i < fuvarok.size()) {
			System.out.println("Fuvar hossza: " + leghosszabb + " másodperc\nTaxi azonosító: "
					+ fuvarok.get(i).getTaxiID() + "\nMegtett távolság: " + tavolsag + " km\nViteldíj: "
					+ fuvarok.get(i).getVitelDij() + "$");
		}
	}

	public void HibakKiirasa(List<Fuvar> fuvarok) {

		List<Fuvar> hibasFuvarok = new ArrayList<Fuvar>();

		for (Fuvar fuvar : fuvarok) {
			if (fuvar.getIdoTartam() > 0 && fuvar.getVitelDij() > 0 && fuvar.getTavolsag() == 0.0) {
				hibasFuvarok.add(fuvar);
			}
		}

		FajlKezeles fajl = new FajlKezeles();
		fajl.HibasFuvarokKiirasa(hibasFuvarok, "F:\\Kurs\\Feladatok\\Fuvar\\hibak.txt", ";");

	}

}
