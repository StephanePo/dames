package application.model;

import javafx.scene.paint.Color;

public enum Type {
	WHITE(Color.WHITE), BLACK(Color.DIMGREY), REINE(Color.MAROON);

	private Color color;

	/**
	 * Construteur.
	 * 
	 * @param c
	 *            : enumeration de classe Type.
	 */
	private Type(Color c) {
		this.color = c;
	}

	/**
	 * Accesseur de l'attribut d'instance color.
	 * 
	 * @return l'attribut d'instance color.
	 */
	public Color getColor() {
		return this.color;
	}

}
