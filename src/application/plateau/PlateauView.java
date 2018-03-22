package application.plateau;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import application.model.Case;
import application.model.Pion;
import application.model.Plateau;
import application.model.Point;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Sphere;
import javafx.util.Duration;

public class PlateauView extends GridPane implements Observer {

	private Plateau plateau;
	private PlateauController pController = new PlateauController(this);
	private CaseView[][] caseViews;
	private ArrayList<PionView> pionViews;

	public PlateauView() {
	}

	public class CaseView extends Label {
		private Case c;

		/**
		 * Accesseur de l'attribut d'instance de type Point de l'attribut
		 * d'instance c. Attention la methode duplique la memoire.
		 * 
		 * @return objet de type Point
		 */
		public Point getPosition() {
			return this.c.getPosition();
		}

		/**
		 * Accesseur de l'attribut d'instance de c. Attention la methode
		 * duplique la memoire.
		 * 
		 * @return Objet de type Case.
		 */
		public Case getCase() {
			return this.c;
		}

		/**
		 * Constructeur .
		 * 
		 * @param c
		 *            : Objet de type Case.
		 */
		public CaseView(Case c) {
			this.c = c;
			this.getStyleClass().add("cell");
			this.getStyleClass().add(PlateauView.this.plateau.isActive(c.getPosition().getX(), c.getPosition().getY())
					? "active" : "inactive");
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					if (CaseView.this.c.isFree()) {
						System.out.print("Case : " + CaseView.this.c.getPosition());
						PlateauView.this.pController.setClickedCase(CaseView.this);
						// Affiche l'etat du plateau.
						// System.out.print(PlateauView.this.plateau.toString());
					}
				}
			});
		}
	}

	public class PionView extends Sphere {

		private Pion pion;

		/**
		 * Constructeur.
		 * 
		 * @param pion
		 *            : objet de type Pion.
		 */
		public PionView(Pion pion) {
			this.pion = pion;
			Color color = pion.type.getColor();
			this.getStyleClass().add("pawn");
			this.setRadius(35.0);
			this.setMaterial(new PhongMaterial(color));
			this.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					// System.out.println("Pion :
					// "+PionView.this.pion.getPosition());
					System.out.println("Pion : " + PionView.this.pion.getPosition());
					PlateauView.this.pController.setClickedPion(PionView.this);
				}
			});
		}

		/**
		 * Accesseur l'attribut de type Point de l'attribut d'instance pion.
		 * Attention la methode duplique la memoire.
		 * 
		 * @return objet de type Point.
		 */
		public Point getPosition() {
			return this.pion.getPosition();
		}

		/**
		 * Accesseur de l'attribut d'instance pion. Attention la methode
		 * duplique la memoire.
		 * 
		 * @return objet de type Pion.
		 */
		public Pion getPion() {
			return this.pion;
		}

		/**
		 * 
		 */
		public void kill() {

		}

	}

	/**
	 * Accesseur de l'attribut d'instance pController. Attention duplique la
	 * memoire.
	 * 
	 * @return objet de type PlateauController.
	 */
	public PlateauController getpController() {
		return pController;
	}

	/**
	 * Modificateur de l'attribut d'instance pController.
	 * 
	 * @param pController
	 *            objet de type pController.
	 */
	public void setpController(PlateauController pController) {
		this.pController = pController;
	}

	/**
	 * Accesseur de l'attribut d'instance plateau. Attention duplique la
	 * memoire.
	 * 
	 * @return objet de type Plateau.
	 */
	public Plateau getPlateau() {
		return plateau;
	}

	/**
	 * Modificateur de l'attribut d'intance plateau.
	 * 
	 * @param plateau
	 *            objet de type Plateau.
	 */
	public void setPlateau(Plateau plateau) {
		if (this.plateau != null)
			this.plateau.deleteObserver(this);
		this.plateau = plateau;
		this.plateau.addObserver(this);
	}

	/**
	 * 
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	/***
	 * Methode initialisant l'affichage du plateau dans le gridPane.
	 */
	public void init() {
		int taille = Plateau.TAILLE;
		this.caseViews = new CaseView[taille][taille];
		this.pionViews = new ArrayList<PionView>();

		for (int i = 0; i < this.caseViews.length; i++) {
			for (int j = 0; j < this.caseViews[i].length; j++) {
				this.caseViews[i][j] = new CaseView(PlateauView.this.plateau.getCase(i, j));
				this.caseViews[i][j].toBack();
				// System.out.print(this.caseViews[i][j].getStyleClass().get(2)
				// +" ");
				if (!PlateauView.this.plateau.isFree(i, j)) {
					PionView p = new PionView(PlateauView.this.plateau.getPion(i, j));
					this.pionViews.add(p);
					this.caseViews[i][j].setGraphic(p);
				}
			}
			System.out.print('\n');
		}

		for (int i = 0; i < this.caseViews.length; i++) {
			this.addRow(i + 1, this.caseViews[i]);
		}
	}

	/**
	 * Methode deplacant le pion pv vers la case c, en utilisat l'animation
	 * TranslateTransition.
	 * 
	 * @param pv
	 *            : objet de type PionView.
	 * @param c
	 *            : objet de type CaseView.
	 */
	public void translate(PionView pv, CaseView c) {
		double y = 80.0 * (c.getPosition().getX() - pv.getPosition().getX());
		double x = 80.0 * (c.getPosition().getY() - pv.getPosition().getY());
		TranslateTransition tr = new TranslateTransition();
		tr.setDuration(Duration.millis(500));
		tr.setNode(pv);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				tr.setFromX(pv.getTranslateX());
				tr.setToX(pv.getTranslateX() + x);
				tr.setFromY(pv.getTranslateY());
				tr.setToY(pv.getTranslateY() + y);
				tr.play();
			}
		});
	}

}
