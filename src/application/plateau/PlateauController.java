package application.plateau;

public class PlateauController {

	private PlateauView pView;
	private PlateauView.PionView clicked = null;

	/**
	 * Constructeur initialise l'attribut d'instance PlateauView.
	 * 
	 * @param pView
	 *            : objet de type PlateauView.
	 */
	public PlateauController(PlateauView pView) {
		this.pView = pView;
	}

	/**
	 * Modificateur de l'attribut d'instance clicked. S'utilise lorsque
	 * l'utilisateur clique sur un pion.
	 * 
	 * @param clickedPion
	 */
	public void setClickedPion(PlateauView.PionView clickedPion) {
		this.clicked = clickedPion;
	}

	/**
	 * Methode deplacant le pion contenu dans l'attribut d'instance click vers
	 * la case selectionnee.
	 * 
	 * @param clikedCase
	 */
	public void setClickedCase(PlateauView.CaseView clikedCase) {
		if (this.clicked != null) {
			System.out.println("MoveTo " + clikedCase.getCase().getPosition() + " : "
					+ this.clicked.getPion().moveOk(clikedCase.getCase()));
			if (this.clicked.getPion().moveOk(clikedCase.getCase())) {
				this.pView.translate(this.clicked, clikedCase);
				clikedCase.getCase().setPion(this.clicked.getPion());
				this.clicked.getPion().moveTo(clikedCase.getCase());
			}
			this.clicked = null;
		}

	}

}
