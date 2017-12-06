package generatore;


public class Decina extends EstrazioneSempreDiversi {
	private int qualeDecina;

	public Decina(int qualeDecina) {

		if (qualeDecina == 8)
			super.inizializza(0, 11);
		else {
			if (qualeDecina == 0)
				super.inizializza(1, 9);
			else
				super.inizializza(0, 10);
		}
		this.qualeDecina = qualeDecina;
	}

	public int scegliNumero() {
		return super.scegliNumero() + 10 * qualeDecina;
	}
}