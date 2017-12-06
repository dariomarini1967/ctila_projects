package awt;

import java.awt.Checkbox;
import java.awt.List;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import service.Salvataggio;

public class Cartelle
/* gestione delle cartelle; legge tutti i file contenenti le cartelle; */
/* cerca tutte le cartelle che contengono il numero estratto e le mette */
/* in una lista */
{
	int[] arrayNumeri;
	int indiceArray;
	int[] posizioneEstrazione;
	private int quantiEstratti;
	boolean aggiorna;
	List listaUltimeVincite;
	Checkbox deveAggiornare;
	PannelloControlloCartelle pannelloControlloCartelle;

	public Cartelle() {
		int contFile;
		boolean uscita;
		contFile = 0;
		aggiorna = false;
		uscita = false;
		indiceArray = 0;
		listaUltimeVincite = new List();
		pannelloControlloCartelle = new PannelloControlloCartelle();
		posizioneEstrazione = new int[91];
		setQuantiEstratti(0);
		arrayNumeri = new int[300001];
		do {
			try {
				BufferedReader dis = new BufferedReader(new FileReader(
						NumeriEstratti.file.getParent() + "/cart" + contFile + ".txt"));
				leggiFile(dis);
				dis.close();
				contFile++;
			} catch (FileNotFoundException e) {
				uscita = true;
			} catch (IOException e) {
				;
			}
		} while (!uscita);
		System.out.println(contFile);
	}

	void leggiFile(BufferedReader dis) {
		int i;
		String rigaLetta;
		Integer temp;
		rigaLetta = new String();
		rigaLetta = " ";
		for (i = 0; i < 108; i++) {
			try {
				rigaLetta = dis.readLine();
				if (rigaLetta.charAt(0) != ' ') {
					temp = Integer.valueOf(rigaLetta);
					arrayNumeri[indiceArray++] = temp.intValue();
				}

			} catch (EOFException e) {
				;
			} catch (IOException e) {
				;
			}
		}
	}

	public void verificaCartella(int qualeCartella) {
		int riga;
		int colonna;
		int contCinquina = 0;
		int contAmbo = 0;
		int contTerno = 0;
		int contElementi;
		int ultimaEstrazione;
		int ultimaEstrazioneRiga;
		ultimaEstrazione = 0;
		if ((qualeCartella < 0) || (qualeCartella > (indiceArray / 15)))
			return;
		for (riga = 0; riga < 3; riga++) {
			contElementi = 0;
			ultimaEstrazioneRiga = 0;
			for (colonna = (15 * qualeCartella + 5 * riga); colonna < (15
					* qualeCartella + 5 * riga + 5); colonna++) {
				if (posizioneEstrazione[arrayNumeri[colonna]] > 0) {
					contElementi++;
					if (posizioneEstrazione[arrayNumeri[colonna]] > ultimaEstrazioneRiga)
						ultimaEstrazioneRiga = posizioneEstrazione[arrayNumeri[colonna]];
				}
			}
			if (contElementi == 3) {
				if (ultimaEstrazioneRiga > ultimaEstrazione)
					ultimaEstrazione = ultimaEstrazioneRiga;
				contTerno++;
			}
			if (contElementi == 5) {
				if (ultimaEstrazioneRiga > ultimaEstrazione)
					ultimaEstrazione = ultimaEstrazioneRiga;
				contCinquina++;
			}
		}
		pannelloControlloCartelle.stampaRisultato(contTerno,contCinquina, getQuantiEstratti()
				- ultimaEstrazione);
	}

	public void estrazioneAnnullata(int numeroDaAnnullare) {
		int i;
		for (i = 1; i < 91; i++) {
			if (posizioneEstrazione[numeroDaAnnullare] > 0)
				posizioneEstrazione[numeroDaAnnullare]--;
		}
		posizioneEstrazione[numeroDaAnnullare] = 0;
		setQuantiEstratti(getQuantiEstratti() - 1);
		new Salvataggio(posizioneEstrazione);
	}

	public void estrazioneEffettuata(int numeroEstratto) {
		int i;
		setQuantiEstratti(getQuantiEstratti() + 1);
		// System.out.println("Numero estratto "+numeroEstratto);
		posizioneEstrazione[numeroEstratto] = getQuantiEstratti();

		if (aggiorna) {
			listaUltimeVincite.removeAll();
			i = 0;
			do {
				if (numeroEstratto == arrayNumeri[i]) {
					listaUltimeVincite
							.add(new String(String.valueOf(new Integer(
									(int) Math.floor(i / 15 + 1)))));
				}
			} while (++i < indiceArray);
		}
		new Salvataggio(posizioneEstrazione);
	}

	public int getQuantiEstratti() {
		return quantiEstratti;
	}

	public void setQuantiEstratti(int quantiEstratti) {
		this.quantiEstratti = quantiEstratti;
	}

}