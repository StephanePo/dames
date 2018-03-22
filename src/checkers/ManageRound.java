package checkers;

/**
 * Cette classe sert à gérer les tours de jeux, qui dois jouer quand
 * @author stephane
 *
 */
public class ManageRound {
	
	// Nombre de déplacement de pièces sur le plateau
	private int roundNumber;
	private boolean roundInit = true;
	private boolean whiteRound = true;
	
	public ManageRound(boolean whiteRound, boolean roundInit) {
		this.whiteRound = whiteRound;
		this.roundInit = roundInit;
		roundNumber = 0;
	}

	public ManageRound(boolean whiteRound) {
		this.whiteRound = whiteRound;
		this.roundInit = true;
		roundNumber = 0;
	}
	
	public ManageRound() {
		this.whiteRound = true;
		this.roundInit = true;
		roundNumber = 0;
	}

	public boolean isWhite_round() {
		return whiteRound;
	}

	public void changeWhite_round() {
		this.whiteRound = !this.whiteRound;
	}

	public boolean isRoundInit() {
		return roundInit;
	}

	public void setRoundInit(boolean roundInit) {
		this.roundInit = roundInit;
	}
	

	public int getRoundNumber() {
		return roundNumber;
	}

	public void incRoundNumber() {
		this.roundNumber++;
	}
	
	
}
