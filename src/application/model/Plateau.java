package application.model;

import java.util.Observable;

import application.model.Type;

public class Plateau extends Observable {

	public static int TAILLE = 8;

	private Case[][] cases;

	/**
	 * Constructeur initialsant le plateau avec les cases contenant les pion en
	 * debut de partie. L'attribut d'instance cases est un tableau 2D carre avec
	 * 64 cases. Les cases blanches sont disposees sur les trois premieres
	 * lignes et les noires sur les trois derniere.
	 */
	public Plateau() {
		this.cases = new Case[8][8];
		boolean active = true;

		for (int i = 0; i < cases.length; i++) {
			active = !active;
			for (int j = 0; j < cases[i].length; j++) {
				this.cases[i][j] = new Case(active, i, j);
				if (i < 3 && active) {
					this.cases[i][j].setPion(new Pion(Type.WHITE, this.cases[i][j]));
				} else if (i >= 5 && active) {
					this.cases[i][j].setPion(new Pion(Type.BLACK, this.cases[i][j]));
				}
				active = !active;
			}
		}
	}

	/**
	 * Accesseur de l'attribut d'instance cases.
	 * 
	 * @return un tableau d'objet de type Case.
	 */
	public Case[][] getCases() {
		return this.cases;
	}

	/**
	 * Accesseur d'une case de l'attribut Cases correspondant a la position mis
	 * dans des parametres. Attention la methode duplique la memoire.
	 * 
	 * @param x
	 *            : variable primitive de type int.
	 * @param y
	 *            : variable primitive de type int.
	 * @return objet de type Case.
	 */
	public Case getCase(int x, int y) {
		return this.cases[x][y];
	}

	/**
	 * Methode indiquant si la case demandee est active.
	 * 
	 * @param x
	 *            : variable primitive de type int.
	 * @param y
	 *            : variable primitive de type int.
	 * @return variable primitive de type boolean.
	 */
	public boolean isActive(int x, int y) {
		return this.cases[x][y].isActive();
	}

	/**
	 * Methode indiquant si la case demandee est libre.
	 * 
	 * @param x
	 *            : variable primitive de type int.
	 * @param y
	 *            : variable primitive de type int.
	 * @return variable primitive de type boolean.
	 */
	public boolean isFree(int x, int y) {
		return this.cases[x][y].isFree();
	}

	/**
	 * Accesseur donnant le pion correspondant a la position mis dans des
	 * parametres.
	 * 
	 * @param x
	 *            : variable primitive de type int.
	 * @param y
	 *            : variable primitive de type int.
	 * @return objet de type Pion.
	 */
	public Pion getPion(int x, int y) {
		return this.cases[x][y].getPion();
	}

	/**
	 * Methode permettant le deplacement d'un a travers deux points.
	 * 
	 * @param depart
	 *            objet de type Point.
	 * @param arrive
	 *            objet de type Point.
	 * @return variable primitive de type boolean.
	 */
	public boolean move(Point depart, Point arrive) {
		boolean move = false;
		if (depart.getX() < 8 && depart.getY() < 8 && arrive.getY() < 8 && arrive.getX() < 8 && depart.getX() > 0
				&& depart.getY() > 0 && arrive.getY() > 0 && arrive.getX() > 0) {
			if (this.getCase(depart.getX(), depart.getY()).getPion() != null) {
				move = this.getCase(depart.getX(), depart.getY()).getPion()
						.moveTo(this.getCase(arrive.getX(), arrive.getY()));
			}
		}
		return move;
	}

	/**
	 * Methode affichant les la composition des cases du plateau.
	 * 
	 * @return objet de type String.
	 */
	@Override
	public String toString() {
		String affichage = "";
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[i].length; j++) {
				if (this.cases[i][j].isActive() && this.cases[i][j].getPion() != null) {
					affichage += "pion" + '\t';
				} else {
					affichage += "vide" + '\t';
				}

			}
			affichage += '\n';
		}
		return affichage;
	}

}
