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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.*;

public class App extends Application{
	
	private Button login, optieL1, optieL2, optieL3, optieS1, optieS2, optieS3;
	private Label logtext, gbrNmtext, wwtext, roosterlabelL, roosterlabelS, presentieNrlabel, PresentieDatumlabel;
	private TextField gbrNm, ww, presentieNr;
	private TextArea  roostertextL, roostertextS;
	private DatePicker presentieDatum;
	Scene root, leraarkeuze, roosterLeraar, presentieLeraar, afwezigLeraar, roosterLeerling, presentieLeerling, afwezigLeerling;
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
		roosterlabelL = new Label();
		roosterlabelL.setMinWidth(500);
		roostertextL = new TextArea();
		roostertextL.setMinSize(500, 700);
		roostertextL.setEditable(false);
		roosterlabelS = new Label();
		roosterlabelS.setMinWidth(500);
		roostertextS = new TextArea();
		roostertextS.setMinSize(500, 700);
		roostertextS.setEditable(false);
		presentieNrlabel = new Label("Student Nr.");
		presentieNr = new TextField();
		presentieDatum = new DatePicker();

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
						Scene leraarkeuze = new Scene(leerling, 600, 800);
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
						Scene leraarkeuze = new Scene(leraar, 600, 800);
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
		optieL1 = new Button("Bekijk Rooster");
		optieL1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Vak v = new Vak(gbrNm.getText());
				try {
					v.vulVak();
					roostertextL.setText(v.toString());
					roosterlabelL.setText(gbrNm.getText() + " heeft het volgende rooster:");
				} catch (IOException e) {
					e.printStackTrace();
				}
				FlowPane roosterL = new FlowPane();
				roosterL.setPadding(new Insets(10,10,10,10));
				roosterL.setVgap(4);
				roosterL.setHgap(4);
				roosterL.setPrefWrapLength(300);
				roosterL.getChildren().addAll(roosterlabelL, roostertextL);
				Scene roosterLeraar = new Scene(roosterL, 600, 800);
				thestage.setScene(roosterLeraar);
				thestage.setTitle("Bekijk Rooster");
				thestage.show();
			}
			});
		optieL2 = new Button("Presentie Melden");
		optieL2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				FlowPane presentieL = new FlowPane();
				presentieL.setPadding(new Insets(10,10,10,10));
				presentieL.setVgap(4);
				presentieL.setHgap(4);
				presentieL.setPrefWrapLength(300);
				presentieL.getChildren().addAll(optieL1, optieL2, optieL3);
				Scene presentieLeraar = new Scene(presentieL, 600, 800);
				thestage.setScene(presentieLeraar);
				thestage.setTitle("Presentie Melden");
				thestage.show();
			}
			});
		
		optieL3 = new Button("Afwezig Melden");
		optieL3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				FlowPane afwezigL = new FlowPane();
				afwezigL.setPadding(new Insets(10,10,10,10));
				afwezigL.setVgap(4);
				afwezigL.setHgap(4);
				afwezigL.setPrefWrapLength(300);
				afwezigL.getChildren().addAll(optieL1, optieL2, optieL3);
				Scene afwezigLeraar = new Scene(afwezigL, 600, 800);
				thestage.setScene(afwezigLeraar);
				thestage.setTitle("Bekijk Rooster");
				thestage.show();
			}
			});
		
		optieS1 = new Button("Bekijk Rooster");
		optieS1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				FlowPane roosterS = new FlowPane();
				roosterS.setPadding(new Insets(10,10,10,10));
				roosterS.setVgap(4);
				roosterS.setHgap(4);
				roosterS.setPrefWrapLength(300);
				roosterS.getChildren().addAll(roosterlabelS, roostertextS);
				Scene roosterLeerling = new Scene(roosterS, 600, 800);
				thestage.setScene(roosterLeerling);
				thestage.setTitle("Bekijk Rooster");
				thestage.show();
			}
			});
		
		optieS2 = new Button("Presentie bekijken");
		optieS2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				FlowPane presentieS = new FlowPane();
				presentieS.setPadding(new Insets(10,10,10,10));
				presentieS.setVgap(4);
				presentieS.setHgap(4);
				presentieS.setPrefWrapLength(300);
				presentieS.getChildren().addAll(optieL1, optieL2, optieL3);
				Scene presentieLeerling = new Scene(presentieS, 600, 800);
				thestage.setScene(presentieLeerling);
				thestage.setTitle("Bekijk Rooster");
				thestage.show();
			}
			});
		
		optieS3 = new Button("Afwezig melden");
		optieS3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				FlowPane afwezigS = new FlowPane();
				afwezigS.setPadding(new Insets(10,10,10,10));
				afwezigS.setVgap(4);
				afwezigS.setHgap(4);
				afwezigS.setPrefWrapLength(300);
				afwezigS.getChildren().addAll(optieL1, optieL2, optieL3);
				Scene afwezigLeerling = new Scene(afwezigS, 600, 800);
				thestage.setScene(afwezigLeerling);
				thestage.setTitle("Bekijk Rooster");
				thestage.show();
			}
			});
		
		
		
		FlowPane root = new FlowPane();
		root.setPadding(new Insets(10,10,10,10));
		root.setVgap(4);
		root.setHgap(4);
		root.setPrefWrapLength(300);
		root.getChildren().addAll(logtext, gbrNmtext, gbrNm, wwtext, ww, login);
		
		Scene scene = new Scene(root, 600, 800);
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		

	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
