package window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;

import awt.Cartelle;
import awt.Casella;
import awt.CasellaEstraibile;


public class TabelloneControllo extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5823660892150673263L;
	public Casella[] casella;
	Cartelle cartelle;
	boolean aggiorna;
	TabellonePubblico tabellonePubblico;

	public TabelloneControllo(Cartelle cartelle, TabellonePubblico tabellonePubblico) {
		super("Gestione estrazioni tombola - Tabellone di controllo");
		this.cartelle = cartelle;
		this.tabellonePubblico=tabellonePubblico;
		casella = new CasellaEstraibile[90];
		setSize(new Dimension(750, 550));
		setLayout(new GridLayout(9, 10, 3, 3));
		setBackground(new Color(200, 200, 200));
		int cifra;
		for (cifra = 1; cifra <= 90; cifra++) {
			casella[cifra - 1] = new CasellaEstraibile(cifra, cartelle,tabellonePubblico);
			add(casella[cifra - 1]);
		}
	}
}