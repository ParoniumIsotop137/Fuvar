package fuvar.stream;

import java.util.List;
import java.util.Scanner;

public class FuvarStreamFoProgram {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		FajlKezeles fajl = new FajlKezeles();

		List<Fuvar> fuvarok = fajl.FajlBeolvasas("F:\\Kurs\\Feladatok\\Fuvar\\fuvar.csv", ";");

		System.out.println("Beolvasás:\n");

		// fuvarok.stream().forEach(System.out::println);
		// sc.nextLine();

		System.out.println("3. feladat: " + fuvarok.size() + " fuvar");
		sc.nextLine();

		long fuvarokSzama = fuvarok.stream().filter(x -> x.getTaxiID() == 6185).count();
		double bevetel = fuvarok.stream().filter(x -> x.getTaxiID() == 6185).mapToDouble(x -> x.getVitelDij()).sum();

		System.out.println("\n4. feladat: " + (int) fuvarokSzama + " fuvar alatt: " + bevetel + "$");

		sc.nextLine();

		Feladatok megold = new Feladatok();
		System.out.println("\n5. feladat:\n");
		megold.FizetesiModok(fuvarok);
		sc.nextLine();

		double merfoldek = fuvarok.stream().mapToDouble(x -> x.getTavolsag()).sum();
		double kiloMeter = merfoldek * 1.6;

		String kiiras = String.format("\n6. feladat %.2f km", kiloMeter);

		System.out.println(kiiras);
		System.out.println("\n7. feladat: Leghosszabb fuvar:\n");
		megold.LeghosszabbFuvar(fuvarok);
		sc.nextLine();
		System.out.println("\n8. feladat:\n");
		megold.HibakKiirasa(fuvarok);

	}

}
