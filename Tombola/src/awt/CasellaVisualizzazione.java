package awt;

public class CasellaVisualizzazione extends Casella {
	
	private static final long serialVersionUID = -1316320420746309924L;
	Cartelle cartelle;

	public CasellaVisualizzazione(int numero, Cartelle cartelle) {
		super(numero);
		this.cartelle = cartelle;
	}

	public void estratto() {
		super.estratto();
	}

	public void nonEstratto() {
		super.nonEstratto();
	}

}
