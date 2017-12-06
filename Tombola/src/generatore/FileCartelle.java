package generatore;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileCartelle {
	int contatoreCartelle;
	int contatorePagine;
	String qualeDir;
	DataOutputStream fos;

	public FileCartelle(String qualeDir) {
		this.qualeDir = qualeDir;
	}

	public void scriviSuFile(Cartella qualeCartella) {
		try {
			if (contatoreCartelle == 0) {
				if (contatorePagine > 0)
					fos.close();
				fos = new DataOutputStream(new FileOutputStream(qualeDir
						+ "/cart" + contatorePagine + ".txt"));
			}
			scriviRiga(qualeCartella.riga1);
			scriviRiga(qualeCartella.riga2);
			scriviRiga(qualeCartella.riga3);
			contatoreCartelle++;
			if (contatoreCartelle == 4) {
				contatoreCartelle = 0;
				contatorePagine++;
			}
		} catch (FileNotFoundException e) {
			System.err.println("Errore: " + e);
		} catch (IOException e) {
			System.err.println("Errore: " + e);
		}
	}

	public void scriviRiga(Riga qualeRiga) {
		int i;
		int numero;
		Integer temp;
		try {
			qualeRiga.primoElemento();
			for (i = 0; i < 9; i++) {
				numero = qualeRiga.getNumero();
				// System.out.println("Numero="+numero);
				if (numero == -1)
					fos.writeBytes(" ");
				else {
					temp = new Integer(numero);
					fos.writeBytes(temp.toString());
				}
				fos.writeByte(13);
				fos.writeByte(10);
				qualeRiga.prossimoElemento();
			}
		} catch (IOException e) {
			System.err.println("Errore: " + e);
		}
	}
}


