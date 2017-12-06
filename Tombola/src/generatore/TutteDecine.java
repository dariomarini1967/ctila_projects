package generatore;


public class TutteDecine {
	private Decina[] arrayDecine;

	public TutteDecine() {
		int i;
		arrayDecine = new Decina[10];
		for (i = 0; i < 9; i++)
			arrayDecine[i] = new Decina(i);
	}

	public Riga scegliCinquina() {
		int i;
		int decinaScelta = 0;
		Riga rigaTemp = new Riga();
		EstrazioneSempreDiversi sceltaDecina = new EstrazioneSempreDiversi(0, 9);
		for (i = 1; i <= 5; i++) {
			decinaScelta = sceltaDecina.scegliNumero();
			// System.out.println("decinaScelta="+decinaScelta);
			int numeroScelto = arrayDecine[decinaScelta].scegliNumero();
			// System.out.println("numeroScelto="+numeroScelto);
			rigaTemp.aggiungi(numeroScelto);
		}
		// rigaTemp.stampa;
		rigaTemp.completa();
		return rigaTemp;
	}

	public Riga scegliCinquina1() {
		int i;

		int primaDecina = 0;
		int ultimaDecina = 4;
		int decinaScelta = 0;
		Riga rigaTemp = new Riga();
		for (i = 1; i <= 5; i++) {
			if (ultimaDecina < 8) {
				decinaScelta = (int) (primaDecina + Math.random()
						* (ultimaDecina - primaDecina));
				ultimaDecina = primaDecina + 4;
			} else
				decinaScelta++;
			// System.out.println(i+" decinaScelta="+decinaScelta);
			primaDecina = decinaScelta + 1;
			// if(ultimaDecina>8)
			// ultimaDecina=8;
			int numeroScelto = arrayDecine[decinaScelta].scegliNumero();
			rigaTemp.aggiungi(numeroScelto);
		}
		// rigaTemp.stampa;
		rigaTemp.completa();
		return rigaTemp;
	}

}
