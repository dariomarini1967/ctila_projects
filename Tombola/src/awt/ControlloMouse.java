package awt;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ControlloMouse implements MouseListener {

	Casella casella;

	public ControlloMouse(Casella casella) {

		this.casella = casella;
	}

	public void mouseClicked(MouseEvent e) {
		casella.cliccatoSuCasella();
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

}
// end class