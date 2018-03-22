package checkers.model;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import static checkers.CheckersApp.TILE_SIZE;

import checkers.view.PieceType;

public class Piece extends StackPane {

	private PieceType type;

	private double mouseX, mouseY;
	private double oldX, oldY;
	// Nombre de mouvement que la pièce a effectué
	private int nbMove = 0;

	public PieceType getType() {
		return type;
	}

	public double getOldX() {
		return oldX;
	}

	public double getOldY() {
		return oldY;
	}

	public Piece(PieceType type, int x, int y) {
		this.type = type;

		move(x, y);

		Ellipse bg = new Ellipse(TILE_SIZE * 0.3125, TILE_SIZE * 0.26);
		bg.setFill(Color.BLACK);

		bg.setStroke(Color.BLACK);
		bg.setStrokeWidth(TILE_SIZE * 0.03);

		bg.setTranslateX((TILE_SIZE - TILE_SIZE * 0.3125 * 2) / 2);
		bg.setTranslateY((TILE_SIZE - TILE_SIZE * 0.26 * 2) / 2 + TILE_SIZE * 0.07);

		Ellipse ellipse = new Ellipse(TILE_SIZE * 0.3125, TILE_SIZE * 0.26);
		ellipse.setFill(type == PieceType.RED
				? Color.valueOf("#c40003") : Color.valueOf("#fff9f4"));

		ellipse.setStroke(Color.BLACK);
		ellipse.setStrokeWidth(TILE_SIZE * 0.03);

		ellipse.setTranslateX((TILE_SIZE - TILE_SIZE * 0.3125 * 2) / 2);
		ellipse.setTranslateY((TILE_SIZE - TILE_SIZE * 0.26 * 2) / 2);

		getChildren().addAll(bg, ellipse);

		setOnMousePressed(e -> {
			mouseX = e.getSceneX();
			mouseY = e.getSceneY();
		});

		setOnMouseDragged(e -> {
			if ((this.getType() == PieceType.WHITE && checkers.CheckersApp.mngRound.isWhite_round()) ||
					(this.getType() == PieceType.RED && !checkers.CheckersApp.mngRound.isWhite_round())) 
				relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
		});
	}
	
	

	public void move(int x, int y) {
		oldX = x * TILE_SIZE;
		oldY = y * TILE_SIZE;
		relocate(oldX, oldY);
	}
	
	

	public void abortMove() {
		relocate(oldX, oldY);
	}

	public int getNbMove() {
		return nbMove;
	}

	/**
	 * Increment (de 1) l'attribut nb Move
	 * @param nbMove
	 */
	public void incNbMove() {
		this.nbMove++;
	}

}
