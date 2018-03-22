package application.model;

public class Case {

	private Pion pion = null;
	private boolean active;
	private final Point position;

	/**
	 * Constructeur initialisant les attributs active et position.
	 * 
	 * @param active
	 *            : indique si la case peut posseder un pion.
	 * @param p
	 *            : Le point de la case.
	 */
	public Case(boolean active, Point p) {
		this.active = active;
		this.position = p;
	}

	/**
	 * Constructeur initialisant les attributs active et position.
	 * 
	 * @param active
	 *            : indique si la case peut posseder un pion.
	 * @param x
	 *            : la position en x du point de la position.
	 * @param y
	 *            : la position en y du point de la position.
	 */
	public Case(boolean active, int x, int y) {
		this.active = active;
		this.position = new Point(x, y);
	}

	/**
	 * Modificateur de l'attributs d'instance pion. Attention : la methode
	 * duplique la memoire.
	 * 
	 * @param pion
	 *            : le pion contenant les valeurs que prendra l'attribut
	 *            d'instance pion.
	 */
	public void setPion(Pion pion) {
		this.pion = pion;
	}

	/**
	 * Methode indiquant si la case contient un pion.
	 * 
	 * @return variable primitive de type boolean.
	 */
	public boolean isFree() {
		return this.pion == null;
	}

	/**
	 * Accesseur de l'attribut d'instance active.
	 * 
	 * @return la valeur de l'attirbut d'instance active.
	 */
	public boolean isActive() {
		return this.active;
	}

	/**
	 * Accesseur de l'attribut d'instance pion. Attention la methode duplique la
	 * memoire.
	 * 
	 * @return l'attribut d'instance pion.
	 */
	public Pion getPion() {
		return this.pion;
	}

	/**
	 * Accesseur de l'attribut d'instance position. Attention la methode
	 * duplique la memoire.
	 * 
	 * @return l'attribut d'instance position.
	 */
	public Point getPosition() {
		return this.position;
	}

	/**
	 * Methode affichant l'etat de l'ensemble des attributs d'instance de
	 * l'objet.
	 * 
	 * @return Objet de type String.
	 */
	@Override
	public String toString() {
		String rep = this.position.toString() + '\n';
		rep += (this.active) ? "Active" + '\n' : "Inactive" + '\n';
		if (this.pion != null) {
			rep += "Pion : " + this.pion + '\n';
		}
		return rep;
	}

}
