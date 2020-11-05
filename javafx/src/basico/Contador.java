package basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Contador extends Application{
	
	private int contador = 0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Label labelPrincipal = new Label("Contador");
		labelPrincipal.getStyleClass().add("labelPrincipal");
		
		Label labelNumero = new Label("0");
		labelNumero.getStyleClass().add("labelNumeroZero");
		
		Button botaoDecremento = new Button("-");
		botaoDecremento.getStyleClass().add("botoes");
		botaoDecremento.setOnAction(e -> {
			contador--;
			obterEstilo(labelNumero);
			labelNumero.setText(Integer.toString(contador));
		});
		
		Button botaoIncremento = new Button("+");
		botaoIncremento.getStyleClass().add("botoes");
		botaoIncremento.setOnAction(e -> {
			contador++;
			obterEstilo(labelNumero);
			labelNumero.setText(Integer.toString(contador));
		});
		
		HBox boxBotoes = new HBox();
		boxBotoes.setAlignment(Pos.CENTER);
		boxBotoes.setSpacing(10);
		boxBotoes.getChildren().add(botaoDecremento);
		boxBotoes.getChildren().add(botaoIncremento);
		
		VBox boxPrincipal = new VBox();
		boxPrincipal.getStyleClass().add("boxPrincipal");
		boxPrincipal.setAlignment(Pos.CENTER);
		boxPrincipal.setSpacing(10);
		boxPrincipal.getChildren().add(labelPrincipal);
		boxPrincipal.getChildren().add(labelNumero);
		boxPrincipal.getChildren().add(boxBotoes);
		
		String caminhoCss = getClass().getResource("/basico/Contador.css").toExternalForm();
		
		Scene cenaPrincipal = new Scene(boxPrincipal, 350, 350);
		cenaPrincipal.getStylesheets().add(caminhoCss);
		cenaPrincipal.getStylesheets().add("https://fonts.googleapis.com/css2?family=Oswald");
		
		primaryStage.setResizable(false);
		primaryStage.setScene(cenaPrincipal);
		primaryStage.show();
	}
	
	void obterEstilo(Label label) {
		if (contador > 0) {
			label.getStyleClass().removeAll("labelNumeroNegativo");			
			label.getStyleClass().removeAll("labelNumeroZero");			
			label.getStyleClass().add("labelNumeroPositivo");			
		} else if (contador < 0) {
			label.getStyleClass().removeAll("labelNumeroPositivo");			
			label.getStyleClass().removeAll("labelNumeroZero");			
			label.getStyleClass().add("labelNumeroNegativo");			
		} else {
			label.getStyleClass().removeAll("labelNumeroNegativo");			
			label.getStyleClass().removeAll("labelNumeroPositivo");			
			label.getStyleClass().add("labelNumeroZero");			
		}	
	}

	public static void main(String[] args) {
		launch(args);
	}
}
