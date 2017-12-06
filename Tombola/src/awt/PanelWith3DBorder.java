package awt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;

public class PanelWith3DBorder extends Panel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4006173480525602744L;

	public PanelWith3DBorder() {
		super();
	}

	public void paint(Graphics g) {

		Color bg = getBackground();
		g.setColor(bg);

	}
}
