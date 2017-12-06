package generatore;


public class Cartella {
	Riga riga1;
	Riga riga2;
	Riga riga3;
	static int contatore;
	private int qualeCartella;

	public Cartella(TutteDecine tutteDecine) {
		riga1 = tutteDecine.scegliCinquina();
		riga2 = tutteDecine.scegliCinquina();
		riga3 = tutteDecine.scegliCinquina();
		ordinaNumeri();
		qualeCartella = contatore + 1;
		contatore++;
	}

	public void stampa() {
		System.out.println("Cartella " + qualeCartella);
		System.out.println();
		riga1.stampa();
		riga2.stampa();
		riga3.stampa();
	}

	private void ordinaNumeri() {
		int i;
		riga1.primoElemento();
		riga2.primoElemento();
		riga3.primoElemento();
		for (i = 0; i < 9; i++) {
			if (riga1.maggiore(riga2))
				riga1.inverti(riga2);
			if (riga1.maggiore(riga3))
				riga1.inverti(riga3);
			if (riga2.maggiore(riga3))
				riga2.inverti(riga3);
			riga1.prossimoElemento();
			riga2.prossimoElemento();
			riga3.prossimoElemento();
		}

	}
}