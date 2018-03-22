package application;

import application.model.Plateau;
import application.plateau.PlateauView;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class DameController {

	@FXML
	StackPane stackPane;

	private PlateauView pView;

	/**
	 * 
	 */
	public void initialize() {
		this.pView = new PlateauView();
		stackPane.getChildren().add(pView);
		Plateau p = new Plateau();
		this.pView.setPlateau(p);
		pView.init();
	}

}
