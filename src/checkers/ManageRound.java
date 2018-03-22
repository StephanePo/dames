package checkers;

/**
 * Cette classe sert à gérer les tours de jeux, qui dois jouer quand
 *
 */
public class ManageRound {
	
	// Nombre de déplacement de pièces sur le plateau
	private int moveNumber;
	private boolean whiteRound = true;
	
	public ManageRound(boolean whiteRound) {
		this.whiteRound = whiteRound;
		moveNumber = 0;
	}
	
	public ManageRound() {
		this.whiteRound = true;
		moveNumber = 0;
	}

	public boolean isWhite_round() {
		return whiteRound;
	}

	public void changeWhite_round() {
		this.whiteRound = !this.whiteRound;
	}	

	public int getMoveNumber() {
		return moveNumber;
	}

	public void incMoveNumber() {
		this.moveNumber++;
	}
	
	
}
