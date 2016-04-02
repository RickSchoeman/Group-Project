package groupProject;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.*;

public class App extends Application{
	
	private Button login, optieL1, optieL2, optieL3, optieS1, optieS2, optieS3;
	private Label logtext, gbrNmtext, wwtext;
	private TextField gbrNm, ww;
	Scene root, leraarkeuze;
	Stage thestage;
	
	
	@Override
	public void start(Stage primaryStage) throws IOException{
		thestage = primaryStage;
		logtext = new Label("Voer uw gegevens in!");
		logtext.setMinWidth(500);
		gbrNmtext = new Label("Gebruikers id");
		gbrNmtext.setMinWidth(100);
		gbrNm = new TextField();
		wwtext = new Label("Wachtwoord");
		wwtext.setMinWidth(100);
		ww = new TextField();
		login = new Button("Login");
		

		login.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				LoginStudent logS1 = new LoginStudent(gbrNm.getText(), ww.getText());
				LoginLeraar logL1 = new LoginLeraar(gbrNm.getText(), ww.getText());
				try {
					if(logS1.checkLogin() == true){
						System.out.println("U bent ingelogd.");
						FlowPane leerling = new FlowPane();
						leerling.setPadding(new Insets(10,10,10,10));
						leerling.setVgap(4);
						leerling.setHgap(4);
						leerling.setPrefWrapLength(300);
						leerling.getChildren().addAll(optieS1, optieS2, optieS3);
						Scene leraarkeuze = new Scene(leerling, 350, 195);
						thestage.setScene(leraarkeuze);
						thestage.setTitle("Leerling");
						thestage.show();
					}
					else if(logL1.checkLogin() == true){
						System.out.println("U bent ingelogd.");
						FlowPane leraar = new FlowPane();
						leraar.setPadding(new Insets(10,10,10,10));
						leraar.setVgap(4);
						leraar.setHgap(4);
						leraar.setPrefWrapLength(300);
						leraar.getChildren().addAll(optieL1, optieL2, optieL3);
						Scene leraarkeuze = new Scene(leraar, 350, 195);
						thestage.setScene(leraarkeuze);
						thestage.setTitle("Leraar");
						thestage.show();
					}
					else{
						logtext.setText("De gegevens zijn verkeerd!");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			});
		optieL1 = new Button("Optie 1");
		optieL2 = new Button("Optie 2");
		optieL3 = new Button("Optie 3");
		optieS1 = new Button("Optie 1");
		optieS2 = new Button("Optie 2");
		optieS3 = new Button("Optie 3");
		
		
		FlowPane root = new FlowPane();
		root.setPadding(new Insets(10,10,10,10));
		root.setVgap(4);
		root.setHgap(4);
		root.setPrefWrapLength(300);
		root.getChildren().addAll(logtext, gbrNmtext, gbrNm, wwtext, ww, login);
		
		
		FlowPane leraar = new FlowPane();
		leraar.setPadding(new Insets(10,10,10,10));
		leraar.setVgap(4);
		leraar.setHgap(4);
		leraar.setPrefWrapLength(300);
		leraar.getChildren().addAll(optieL1, optieL2, optieL3);
		
		Scene leraarkeuze = new Scene(leraar, 350, 195);
		
		
		Scene scene = new Scene(root, 350, 195);
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		

	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
