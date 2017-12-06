package awt;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

import listener.EsciListener;
import window.TabelloneControllo;
import window.TabellonePubblico;

public class FinestraControllo extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1395511859809792546L;
	TabelloneControllo tabellone;
	TabellonePubblico tabellonePubblico;
	Cartelle cartelle;
	TextField inputNumero;
	TextField inputCartella;
	PannelloListener pannellolistener;
	Checkbox deveAggiornare;
	Button nonDeveAggiornare;
	BottEsci bottEsci;

	public FinestraControllo(TabelloneControllo tabellone,TabellonePubblico tabellonePubblico, Cartelle cartelle) {
		super("Controllo");
		setSize(new Dimension(250, 450));
		setLocation(800, 30);
		setLayout(new FlowLayout());
		setBackground(new Color(200, 200, 200));
		inputNumero = new TextField(3);
		pannellolistener = new PannelloListener(this);
		bottEsci = new BottEsci("      Esci      ");
		bottEsci.addActionListener(new EsciListener());
		add(new Label("Numero estratto", Label.CENTER));
		inputNumero.addActionListener(pannellolistener);
		add(inputNumero);
		this.tabellone = tabellone;
		this.tabellonePubblico=tabellonePubblico;
		this.cartelle = cartelle;
		add(new Label(""));
		cartelle.pannelloControlloCartelle.setSize(new Dimension(130, 200));
		add(cartelle.pannelloControlloCartelle);
		cartelle.pannelloControlloCartelle.inputCartella
				.addActionListener(pannellolistener);
		add(cartelle.listaUltimeVincite);
		add(new Label(""));
		add(deveAggiornare = new Checkbox("Aggiorna lista"));
		bottEsci.setSize(150, 40);
		add(bottEsci);
	}

}