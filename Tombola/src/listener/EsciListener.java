package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EsciListener implements ActionListener {

	public EsciListener() {

	}

	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}