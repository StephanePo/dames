package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;

import application.model.Case;
import application.model.Plateau;
import application.model.Point;
import application.model.Pion;
import application.model.Type;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = (VBox) FXMLLoader.load(getClass().getResource("Dame.fxml"));
			Scene scene = new Scene(root, 640, 640);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("DameFX");
			primaryStage.show();
			// primaryStage.sizeToScene();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Activer le jeux.
		launch(args);

		// Test modification du plateau.
		/*
		 * Plateau plateau = new Plateau();
		 * System.out.println(plateau.toString());
		 * 
		 * System.out.println(plateau.move(new Point(2, 1), new Point(3, 2)));
		 * System.out.println(plateau.toString());
		 * 
		 * System.out.println(plateau.getCase(2, 1).toString());
		 * System.out.println(plateau.getCase(3, 2).toString());
		 */

		// Test mouvement des cases.
		// Les pions se deplace bien dans les cases.
		// Pour verifier les deux mouvements remplacer la couleur du pion et les
		// piont des cases.
		/*
		 * Point p1 = new Point(0,1); Point p2 = new Point(1,2); Case c1 = new
		 * Case(true, p2); Case c2 = new Case(true, p1); Pion pion = new
		 * Pion(Type.BLACK, c1);
		 * 
		 * System.out.println(c1); System.out.println(pion);
		 * System.out.println(pion.moveTo(c2));
		 * System.out.println(pion.toString() + '\n'); System.out.println(c1);
		 * System.out.println(c2);
		 */

	}
}
