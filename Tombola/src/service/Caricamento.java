package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import window.TabelloneControllo;
import awt.Cartelle;
import awt.NumeriEstratti;

public class Caricamento {
	public Caricamento(TabelloneControllo tabellone, Cartelle cartelle) {
		int[] arrayOrdinamento;
		int[] arrayLetto;
		int i;
		BufferedReader dis;
		arrayLetto = new int[91];
		try {
			int a;
			int max;
			max = 0;
			dis = new BufferedReader(new FileReader(NumeriEstratti.file));
			for (a = 1; a < 91; a++) {
				String rigaLetta = dis.readLine();
				Integer temp = Integer.valueOf(rigaLetta);
				arrayLetto[a] = temp.intValue();
				if (arrayLetto[a] > max)
					max = arrayLetto[a];
				// System.out.println(arrayLetto[a]);
			}
			cartelle.setQuantiEstratti(max);
			// dis.close();
		} catch (FileNotFoundException e) {
			System.out.println("NO FILE");
			return;
		} catch (IOException e) {
			System.out.println("IO ERROR");
			return;
		}
		arrayOrdinamento = new int[91];
		for (i = 1; i <= 90; i++) {
			if (arrayLetto[i] > 0)
				arrayOrdinamento[arrayLetto[i]] = i;
		}
		for (i = 1; i <= 90; i++) {
			if (arrayOrdinamento[i] > 0)
				tabellone.casella[arrayOrdinamento[i] - 1].estratto();
		}

	}

}