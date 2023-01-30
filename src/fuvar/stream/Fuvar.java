package fuvar.stream;

import java.time.LocalDateTime;

public class Fuvar {

	private int taxiID;
	private LocalDateTime indulasIdopontja;
	private int idoTartam;
	private double tavolsag;
	private double vitelDij;
	private double borravalo;
	private String fizetesModja;

	public Fuvar(int taxiID, LocalDateTime indulasIdopontja, int idoTartam, double tavolsag, double vitelDij,
			double borravalo, String fizetesModja) {
		this.taxiID = taxiID;
		this.indulasIdopontja = indulasIdopontja;
		this.idoTartam = idoTartam;
		this.tavolsag = tavolsag;
		this.vitelDij = vitelDij;
		this.borravalo = borravalo;
		this.fizetesModja = fizetesModja;
	}

	public int getTaxiID() {
		return taxiID;
	}

	public void setTaxiID(int taxiID) {
		this.taxiID = taxiID;
	}

	public LocalDateTime getIndulasIdopontja() {
		return indulasIdopontja;
	}

	public void setIndulasIdopontja(LocalDateTime indulasIdopontja) {
		this.indulasIdopontja = indulasIdopontja;
	}

	public int getIdoTartam() {
		return idoTartam;
	}

	public void setIdoTartam(int idoTartam) {
		this.idoTartam = idoTartam;
	}

	public double getTavolsag() {
		return tavolsag;
	}

	public void setTavolsag(double tavolsag) {
		this.tavolsag = tavolsag;
	}

	public double getVitelDij() {
		return vitelDij;
	}

	public void setVitelDij(double vitelDij) {
		this.vitelDij = vitelDij;
	}

	public double getBorravalo() {
		return borravalo;
	}

	public void setBorravalo(double borravalo) {
		this.borravalo = borravalo;
	}

	public String getFizetesModja() {
		return fizetesModja;
	}

	public void setFizetesModja(String fizetesModja) {
		this.fizetesModja = fizetesModja;
	}

	@Override
	public String toString() {
		return "Taxi azonosító: " + this.taxiID + ", indulás időpontja: "
				+ ((this.indulasIdopontja.toString()).replace("-", ".").replace("T", " ")) + ", időtartam: "
				+ this.idoTartam + " másodperc, távolság" + this.tavolsag + " mérföld, viteldíj: " + this.vitelDij
				+ "$, borravaló: " + this.borravalo + "$, fizetés módja: " + this.fizetesModja;
	}

}
