package awt;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;

public class PannelloControlloCartelle extends PanelWith3DBorder {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7801936887772922058L;
	
	TextField inputCartella;
	boolean aggiorna;
	Label risultatoCartella;
	Label quandoEstratto;

	public PannelloControlloCartelle() {
		super();
		setBackground(new Color(200, 200, 200));
		setLayout(new GridLayout(6, 1));
		add(new Label(""));
		add(new Label("Controllo cartelle", Label.CENTER));
		add(inputCartella = new TextField(4));
		add(risultatoCartella = new Label("", Label.CENTER));
		add(quandoEstratto = new Label("", Label.CENTER));
		add(new Label(""));
		stampaRisultato(0, 0, 0);
	}

	public void stampaRisultato(int terniVincenti,int cinquineVincenti, int estrazioniTrascorse) {
		String messaggio;
		if (estrazioniTrascorse == 0)
			messaggio = new String("Ultima estrazione");
		else {
			if (estrazioniTrascorse == 1)
				messaggio = new String("1 Estrazione fa");
			else
				messaggio = new String(String.valueOf(new Integer(
						estrazioniTrascorse)) + " Estrazioni fa");
		}
		switch (cinquineVincenti) {
		case 0:
			risultatoCartella.setText("Nessuna cinquina");
			quandoEstratto.setText("");
			break;
		case 1:
			risultatoCartella.setText("1 cinquina");
			quandoEstratto.setText(messaggio);
			break;
		case 2:
			risultatoCartella.setText("2 cinquine");
			quandoEstratto.setText(messaggio);
			break;
		case 3:
			risultatoCartella.setText("TOMBOLA!!");
			quandoEstratto.setText(messaggio);
			break;
		}
	}

}