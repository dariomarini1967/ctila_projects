package awt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PannelloListener implements ActionListener {
	FinestraControllo finestracontrollo;

	public PannelloListener(FinestraControllo finestracontrollo) {
		this.finestracontrollo = finestracontrollo;
	}

	public void actionPerformed(ActionEvent e) {

		// insert code here

		int intero;
		Integer temp;
		if (e.getSource() == finestracontrollo.deveAggiornare) {
			// nonDeveAggiornare.setVisible(true);
			finestracontrollo.cartelle.aggiorna = finestracontrollo.deveAggiornare
					.getState();

		}

		if (e.getSource() == finestracontrollo.inputNumero) {
			try {
				temp = Integer.valueOf(finestracontrollo.inputNumero.getText());
				intero = temp.intValue();
			} catch (NumberFormatException ee) {
				intero = 0;
			}
			finestracontrollo.inputNumero.setText("");
			finestracontrollo.cartelle.aggiorna = finestracontrollo.deveAggiornare
					.getState();

			if ((Math.abs(intero) >= 1) && (Math.abs(intero) <= 90)) {
				if (intero > 0){
					finestracontrollo.tabellone.casella[intero - 1].estratto();
					finestracontrollo.tabellonePubblico.casella[intero - 1].estratto();
				}
				else{
					finestracontrollo.tabellone.casella[-intero - 1]
							.nonEstratto();
					finestracontrollo.tabellonePubblico.casella[-intero - 1]
					        							.nonEstratto();
				}
			}

		}
		if (e.getSource() == finestracontrollo.cartelle.pannelloControlloCartelle.inputCartella) {
			try {
				temp = Integer
						.valueOf(finestracontrollo.cartelle.pannelloControlloCartelle.inputCartella
								.getText());
				intero = temp.intValue();
			} catch (NumberFormatException ee) {
				intero = -1;
			}
			finestracontrollo.cartelle.pannelloControlloCartelle.inputCartella
					.setText("");
			finestracontrollo.cartelle.verificaCartella(intero - 1);

		}

	}
}