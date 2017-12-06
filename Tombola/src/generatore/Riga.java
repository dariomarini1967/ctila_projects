package generatore;


public class Riga {
	private int[] caselle;
	private int elementoCorrente;

	public Riga() {
		int i;
		caselle = new int[9];
		for (i = 0; i < 9; i++)
			caselle[i] = -1;
	}

	public void aggiungi(int elemento) {
		if (elemento == 90)
			caselle[8] = 90;
		else
			caselle[(int) Math.floor(elemento / 10.0)] = elemento;
	}

	public void completa() {
	}

	public int getNumero() {
		return caselle[elementoCorrente];
	}

	public void stampa() {
		int i;
		int valore;
		for (i = 0; i < 9; i++) {
			valore = caselle[i];
			if (valore > 0) {
				if (valore > 9)
					System.out.print(valore + " ");
				else
					System.out.print(" " + valore + " ");
			} else
				System.out.print("   ");
		}
		System.out.println();
	}

	public void primoElemento() {
		elementoCorrente = 0;
	}

	public void prossimoElemento() {
		elementoCorrente++;
	}

	public boolean maggiore(Riga daConfrontare) {
		int elemento1;
		int elemento2;
		elemento1 = caselle[elementoCorrente];
		elemento2 = daConfrontare.caselle[elementoCorrente];
		if ((elemento1 == -1) || (elemento2 == -1))
			return false;
		else {
			if (elemento1 > elemento2)
				return true;
		}
		return false;
	}

	public void inverti(Riga daScambiare) {
		int temp;
		temp = caselle[elementoCorrente];
		caselle[elementoCorrente] = daScambiare.caselle[elementoCorrente];
		daScambiare.caselle[elementoCorrente] = temp;
	}

}