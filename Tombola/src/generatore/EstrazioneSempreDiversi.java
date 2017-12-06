package generatore;

public class EstrazioneSempreDiversi
/*
 * estrae un numero da primoElemento a primoElemento+maxIndice, escludendo il
 * numero
 */
/* dall'estrazione successiva, bello no? */
{
	int[] arrayNumeri;
	private int maxIndice;
	private int primoElemento;

	public EstrazioneSempreDiversi() {
	}

	public EstrazioneSempreDiversi(int primoElemento, int maxIndice) {
		inizializza(primoElemento, maxIndice);
	}

	public void inizializza(int primoElemento, int maxIndice) {
		this.maxIndice = maxIndice;
		this.primoElemento = primoElemento;
		arrayNumeri = new int[maxIndice + 1];
		int i;
		for (i = 1; i <= maxIndice; i++)
			arrayNumeri[i] = i;
	}

	public int scegliNumero()
	/* sceglie il numero, restituisce 0 se non si possono piu' */
	/* estrarre numeri */
	{
		int i;
		int qualeIndice;
		int qualeNumero;
		if (maxIndice == 0)
			return 0;
		qualeIndice = primoElemento
				+ (int) Math.round(Math.random() * (maxIndice - 1));
		qualeNumero = arrayNumeri[qualeIndice];
		for (i = qualeIndice; i < maxIndice; i++)
			arrayNumeri[i] = arrayNumeri[i + 1];
		maxIndice--;
		return qualeNumero;
	}
}