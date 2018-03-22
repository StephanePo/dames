package application.model;

public class Point {

	private int x;
	private int y;

	/**
	 * Constructeur initialisant les attributs d'instances x et y.
	 * 
	 * @param x
	 *            : variable primitive de type int.
	 * @param y
	 *            : variable primitive de type int.
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Accesseur de l'attribut d'instance x.
	 * 
	 * @return valeur de l'attribut d'instance x de type int.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Accesseur de l'attribut d'instance y.
	 * 
	 * @return valeur de l'attribut d'instance y de type int.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Modificateur de l'attribut d'instance x.
	 * 
	 * @param x
	 *            : variable primitive de type int.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Modificateur de l'attribut d'instance y.
	 * 
	 * @param y
	 *            : variable primitive de type int.
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Methode affichant les deux attributs d'instance du Point.
	 * 
	 * @return objet de type String.
	 */
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}

}
