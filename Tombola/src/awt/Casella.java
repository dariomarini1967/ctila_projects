package awt;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;


public class Casella extends Canvas
/* implementazione della casella di una cartella o del tabellone; */
/* visualizza una X se il numero della casella e' stato estratto */
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3576345303917524086L;
	int numero;
	String s;
	boolean segnata;

	public Casella(int numero) {
		this.numero = numero;
		validate();
		s = new String(String.valueOf(new Integer(numero)));
		segnata = false;
	}

	public void estratto() {
		segnata = true;
		repaint();
	}

	public void nonEstratto() {
		segnata = false;
		repaint();
	}

	public void paint(Graphics g) {
		Dimension d = getSize();
		FontMetrics f = g.getFontMetrics();
		Font font = g.getFont();
		g.setColor(Color.black);
		
		
		g.setFont(new Font(font.getName(), font.getStyle(), 35));
		g.drawString(s, (d.width - f.stringWidth(s)) / 2-10,
				10 + (d.height - f.getHeight()) / 2);
		if (segnata) {
		/*	g.setColor(Color.red);
			g.drawLine(d.width, 0, 0, d.height);
			g.drawLine(0, 0, d.width, d.height);*/
			Color coloreCasella = new Color(255, 0, 0);
			this.setBackground(coloreCasella);
			 font = g.getFont();
			g.setColor(Color.white);
			g.setFont(new Font(font.getName(), font.getStyle(), 35));
			g.drawString(s, (d.width - f.stringWidth(s)) / 2-10,
					10 + (d.height - f.getHeight()) / 2);
		}else{
			Color coloreCasella = new Color(192, 192, 192);
			this.setBackground(coloreCasella);
		}
		// System.out.println((d.height-f.getHeight())/2);
		Color bg = getBackground();
		g.setColor(bg);
		g.draw3DRect(0, 0, d.width - 1, d.height - 1, true);
		g.draw3DRect(3, 3, d.width - 7, d.height - 7, false);
	}

	public void cliccatoSuCasella() {
		if (!segnata)
			estratto();
		else
			nonEstratto();

	}
}// end class Casella