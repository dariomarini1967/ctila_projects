package window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;

import awt.Cartelle;
import awt.Casella;
import awt.CasellaVisualizzazione;



public class TabellonePubblico extends Frame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5087788685790287432L;
	public Casella[] casella;
	Cartelle cartelle;
	boolean aggiorna;

	public TabellonePubblico(Cartelle cartelle) {
		super("  Gestione Tombola  ");
		this.cartelle = cartelle;
		casella = new CasellaVisualizzazione[90];
		setSize(new Dimension(1000, 750));
		setLayout(new GridLayout(9, 10, 3, 3));
		setBackground(new Color(200, 200, 200));
		int cifra;
		for (cifra = 1; cifra <= 90; cifra++) {
			casella[cifra - 1] = new CasellaVisualizzazione(cifra, cartelle);
			add(casella[cifra - 1]);
		}
	}
}
