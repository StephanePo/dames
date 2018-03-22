package application.model;

import application.model.Type;

public class Pion {

	public Type type;
	private Case position;

	/*
	 * public enum Type{ WHITE(Color.WHITE), BLACK(Color.DIMGREY),
	 * REINE(Color.MAROON);
	 * 
	 * private Color color ;
	 * 
	 * /** Construteur.
	 * 
	 * @param c : enumeration de classe Type.
	 */
	/*
	 * private Type(Color c){ this.color = c ; }
	 * 
	 * /** Accesseur de l'attribut d'instance color.
	 * 
	 * @return l'attribut d'instance color.
	 */
	/*
	 * public Color getColor() { return this.color; } }
	 */

	/**
	 * Constructeur initialisant les attributs d'instances type et position.
	 * 
	 * @param type
	 *            : enumeration de classe Type.
	 * @param c
	 *            : objet de type Case.
	 */
	public Pion(Type type, Case c) {
		this.type = type;
		this.position = c;
		c.setPion(this);
	}

	/**
	 * Accesseur de l'attribut d'instance position. Attention la methode
	 * duplique la memoire.
	 * 
	 * @return l'attribut d'instance position.
	 */
	public Point getPosition() {
		return this.position.getPosition();
	}

	/**
	 * Accesseur de l'attribut type de l'objet.
	 * 
	 * @return enumeration de classe Type.
	 */
	public Type getType() {
		return this.type;
	}

	/**
	 * Methode indiquant si le mouvement est possible.
	 * 
	 * @param c
	 *            : objet de type Case.
	 * @return variable primitive de type boolean.
	 */
	public boolean moveOk(Case c) {
		boolean ok = true;
		Point oldP = this.position.getPosition();
		Point newP = c.getPosition();
		switch (this.type) {
		case REINE:
			break;
		case WHITE:
			if ((newP.getX() == oldP.getX() + 1)) {
				ok = (newP.getY() == oldP.getY() + 1) || (newP.getY() == oldP.getY() - 1);
			} else {
				ok = false;
			}
			break;
		case BLACK:
			if ((newP.getX() == oldP.getX() - 1)) {
				ok = (newP.getY() == oldP.getY() + 1) || (newP.getY() == oldP.getY() - 1);
			} else {
				ok = false;
			}
			break;
		}
		return ok;
	}

	/**
	 * Methode changeant la position actuelle du pion.
	 * 
	 * @param c
	 *            objet de type Case.
	 */
	public boolean moveTo(Case c) {
		boolean move = false;
		if (moveOk(c)) {
			c.setPion(this);
			this.position.setPion(null);
			this.position = c;
			move = true;
		}
		return move;
	}

	/**
	 * Methode changeant l'attibut d'instance type en REINE.
	 */
	public void upgrade() {
		this.type = Type.REINE;
	}

	/**
	 * Methode indiquant si le Pion est egale a l'objet mis en parametre.
	 * 
	 * @param obj
	 *            objet de type Object.
	 * @return variable primitive de type boolean.
	 */
	@Override
	public boolean equals(Object obj) {
		boolean res = (obj != null) && (this == obj);
		if (!res) {
			if (obj instanceof Pion) {
				Pion p = (Pion) obj;
				res = this.position == p.position && this.type == p.type;
			}
		}
		return res;
	}

	/**
	 * Methode affichant l'etat de ensemble des attributs d'instance du Pion.
	 * 
	 * @return objet de type String.
	 */
	@Override
	public String toString() {
		String rep = "" + this.type + " " + this.position.getPosition();
		return rep;
	}
}
