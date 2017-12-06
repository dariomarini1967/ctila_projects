import service.CaricamentoIniziale;
import window.TabelloneControllo;
import window.TabellonePubblico;
import awt.Cartelle;
import awt.FinestraControllo;

class GestioneEstrazioni {
	public static void main(String argv[]) throws java.io.IOException {
		Cartelle cartelle;
		FinestraControllo finestraControllo;
		cartelle = new Cartelle();
		TabellonePubblico tabellonePubblico = new TabellonePubblico(cartelle);
		TabelloneControllo tabellone = new TabelloneControllo(cartelle,tabellonePubblico);
	
		finestraControllo = new FinestraControllo(tabellone,tabellonePubblico, cartelle);
		tabellone.setVisible(true);
		tabellonePubblico.setVisible(true);
		finestraControllo.setVisible(true);
		new CaricamentoIniziale(tabellone, cartelle);
	}
}


