package awt;

import window.TabellonePubblico;


public class CasellaEstraibile extends Casella {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1316320420746309924L;
	Cartelle cartelle;
	TabellonePubblico tabellonePubblico;

	public CasellaEstraibile(int numero, Cartelle cartelle , TabellonePubblico tabellonePubblico) {
		super(numero);
		this.addMouseListener(new ControlloMouse(this));
		this.tabellonePubblico= tabellonePubblico;
		this.cartelle = cartelle;
	}

	public void estratto() {
		super.estratto();
		tabellonePubblico.casella[super.numero-1].estratto();
		cartelle.estrazioneEffettuata(super.numero);
	}

	public void nonEstratto() {
		super.nonEstratto();
		tabellonePubblico.casella[super.numero-1].nonEstratto();
		cartelle.estrazioneAnnullata(super.numero);
	}

}
