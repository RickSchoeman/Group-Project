package groupProject;


import java.time.LocalDate;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.*;

public class App extends Application{
	
	//Aanmaken van de knoppen, labels, enz.
	
	private Button login, optieL1, optieL2, optieL3, optieL4, optieL5, optieS1, optieS2, optieS3, optieS4, optieS5,  meldPresentie, terugL, terugS, meldAfwezig, uitloggen, vulKlas,
	presentieInzienKnop, meldBeter, afwezigheidInzienKnop;
	private Label logtext, gbrNmtext, wwtext, roosterlabelL, roosterlabelS, presentieKlaslabel, presentieMeldenlabel
	, afwezigRedenlabel, beterPersoonlabel, beterRedenlabel, afwezigLabel, afwezigDatumlabel, 
	presentieInzienLabel, presentieMeldenUitleg, beterDatumlabel, beterLabel, afwezigheidInzienLabel, afwezigheidLabel;
	private TextField gbrNm, presentieKlas, afwezigReden, beterPersoon, beterReden;
	private TextArea  roostertextL, roostertextS, presenties, afwezigheid;
	private DatePicker afwezigDatum, beterDatum, presentieInzienDatum, afwezigheidInzienDatum;
	private ListView<Leerling> presentieLijst;
	private CheckBox present;
	private PasswordField ww;
	private Image inlogFoto, menuFoto;
	private ImageView inlogFotoView, menuFotoView;
	Scene root, leraarkeuze, roosterLeraar, presentieLeraar, afwezigLeraar, roosterLeerling, presentieLeerling, afwezigLeerling;
	Stage thestage;
	
	
	@Override
	public void start(Stage primaryStage) throws IOException{
		
		//Het aanmaken compleet maken
		
		thestage = primaryStage;
		logtext = new Label("Voer uw gegevens in!");
		logtext.setMinWidth(500);
		gbrNmtext = new Label("Gebruikers id");
		gbrNmtext.setMinWidth(100);
		gbrNm = new TextField();
		wwtext = new Label("Wachtwoord");
		wwtext.setMinWidth(100);
		ww = new PasswordField();
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
		presentieMeldenlabel = new Label("Presentie Melden");
		presentieMeldenlabel.setMinWidth(600);
		presentieKlaslabel = new Label("Klas naam:");
		presentieKlaslabel.setMinWidth(300);
		presentieKlas = new TextField();
		presentieKlas.setMinWidth(300);
		meldPresentie = new Button("Meld");
		afwezigReden = new TextField();
		beterReden = new TextField();
		afwezigRedenlabel = new Label("Reden:");
		beterPersoonlabel = new Label("Gebruikers id:");
		beterRedenlabel = new Label("Reden:");
		afwezigReden.setMinWidth(300);
		beterReden.setMinWidth(300);
		afwezigRedenlabel.setMinWidth(300);
		beterPersoonlabel.setMinWidth(300);
		beterRedenlabel.setMinWidth(300);
		afwezigLabel = new Label("Afwezigheid melden.");
		afwezigLabel.setMinWidth(600);
		meldAfwezig = new Button("Meld");
		afwezigDatum = new DatePicker(LocalDate.now());
		afwezigDatum.setMinWidth(300);
		afwezigDatumlabel = new Label("Datum:");
		afwezigDatumlabel.setMinWidth(300);
		uitloggen = new Button("Uitloggen");
		presentieLijst = new ListView<Leerling>();
		presentieLijst.setMinWidth(500);
		vulKlas = new Button("Vul klas");
		present = new CheckBox();
		presentieInzienDatum = new DatePicker(LocalDate.now());
		presentieInzienKnop = new Button("Inzien");
		presentieInzienLabel = new Label("PresentieInzien");
		presenties = new TextArea();
		presentieMeldenUitleg = new Label("Vink aan voor present en en vink niet aan voor niet present:");
		beterDatumlabel = new Label("Datum:");
		beterDatumlabel.setMinWidth(300);
		beterDatum = new DatePicker(LocalDate.now());
		beterDatum.setMinWidth(300);
		meldBeter = new Button("Meld Beter");
		beterLabel = new Label("Beter Melden");
		beterLabel.setMinWidth(600);
		inlogFoto = new Image("file:src/hu-og.png");
		menuFoto = new Image("file:src/user1.png");
		inlogFotoView = new ImageView(inlogFoto);
		menuFotoView = new ImageView(menuFoto);
		afwezigheidInzienDatum = new DatePicker(LocalDate.now());
		afwezigheidInzienDatum.setMaxWidth(300);
		afwezigheidInzienKnop = new Button("Inzien");
		afwezigheidInzienLabel = new Label("Maand van inzien:");
		afwezigheidInzienLabel.setMaxWidth(300);
		afwezigheidLabel = new Label("Afwezigheid inzien");
		afwezigheidLabel.setMinWidth(600);
		afwezigheid = new TextArea();
		
		
		//Knop voor het uitloggen
		
		uitloggen.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				FlowPane root = new FlowPane();
				root.setPadding(new Insets(10,10,10,10));
				root.setVgap(4);
				root.setHgap(4);
				root.setPrefWrapLength(300);
				root.getChildren().addAll(logtext, gbrNmtext, gbrNm, wwtext, ww, login, inlogFotoView);
				Scene scene = new Scene(root, 600, 800);
				primaryStage.setTitle("Login");
				primaryStage.setScene(scene);
				primaryStage.setResizable(false);
				primaryStage.show();
				gbrNm.setText("");
				ww.setText("");
			}});
		
		//Knop voor teruggaan als leraar
		
		terugL = new Button("Terug");
		terugL.setAlignment(Pos.BOTTOM_CENTER);
		terugL.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				FlowPane leraar = new FlowPane();
				leraar.setPadding(new Insets(10,10,10,10));
				leraar.setVgap(4);
				leraar.setHgap(4);
				leraar.setPrefWrapLength(300);
				leraar.getChildren().addAll(optieL1, optieL2, optieL3, optieL4, optieL5, uitloggen, menuFotoView);
				Scene leraarkeuze = new Scene(leraar, 600, 800);
				thestage.setScene(leraarkeuze);
				thestage.setTitle("Leraar");
				thestage.show();
			}});
		
		//Knop voor teruggaan als leerling
		
		terugS = new Button("Terug");
		terugS.setAlignment(Pos.BOTTOM_CENTER);
		terugS.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				FlowPane leerling = new FlowPane();
				leerling.setPadding(new Insets(10,10,10,10));
				leerling.setVgap(4);
				leerling.setHgap(4);
				leerling.setPrefWrapLength(300);
				leerling.getChildren().addAll(optieS1, optieS2, optieS3, optieS4, optieS5, uitloggen, menuFotoView);
				Scene leraarkeuze = new Scene(leerling, 600, 800);
				thestage.setScene(leraarkeuze);
				thestage.setTitle("Leerling");
				thestage.show();
			}});
		
		//Knop voor login
		
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
						leerling.getChildren().addAll(optieS1, optieS2, optieS3, optieS4, optieS5, uitloggen, menuFotoView);
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
						leraar.getChildren().addAll(optieL1, optieL2, optieL3, optieL4, optieL5, uitloggen, menuFotoView);
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
		
		//Knop voor rooster bekijken leraar
		
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
				roosterL.getChildren().addAll(roosterlabelL, roostertextL, terugL);
				Scene roosterLeraar = new Scene(roosterL, 600, 800);
				thestage.setScene(roosterLeraar);
				thestage.setTitle("Bekijk Rooster");
				thestage.show();
			}
			});
		
		//Knop voor presentie melden bekijken leraar
		
		optieL2 = new Button("Presentie Melden");
		optieL2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				presentieLijst.getItems().clear();
				presentieKlas.setText("");
				vulKlas.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
				Klas k1 = new Klas(presentieKlas.getText());
				if(k1.checkKlas() == true){
					try {
						k1.vulKlas();
						presentieLijst.getItems().addAll(k1.getDeLeerlingen());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else{
					presentieMeldenlabel.setText("U heeft een verkeerde klas ingevuld.");
				}
				}});
				meldPresentie.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						String leerling = presentieLijst.getSelectionModel().getSelectedItem().toString();
						String isPresent = "";
						if(present.isSelected()){
							isPresent = "Present";
						}
						else{
							isPresent = "Niet present";
						}
						
						if(!leerling.equals("")){
							Presentie p = new Presentie(leerling, LocalDate.now(), isPresent);
							try {
								p.meldPresentie();
								presentieLijst.getItems().remove(presentieLijst.getSelectionModel().getSelectedItem());
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						else{
							presentieMeldenlabel.setText("Selecteer een leerling");
						}
					}});
				FlowPane presentieL = new FlowPane();
				presentieL.setPadding(new Insets(10,10,10,10));
				presentieL.setVgap(4);
				presentieL.setHgap(4);
				presentieL.setPrefWrapLength(300);
				presentieL.getChildren().addAll(presentieMeldenlabel, presentieKlaslabel, presentieKlas, vulKlas, presentieLijst, presentieMeldenUitleg, present, meldPresentie, terugL);
				Scene presentieLeraar = new Scene(presentieL, 600, 800);
				thestage.setScene(presentieLeraar);
				thestage.setTitle("Presentie Melden");
				thestage.show();
			}
			});
		
		//Knop voor afwezig melden leraar
		
		optieL3 = new Button("Afwezig Melden");
		optieL3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				afwezigDatum.setValue(LocalDate.now());
				afwezigReden.setText("");
				meldAfwezig.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						if(!gbrNm.getText().equals("") && !afwezigReden.getText().equals("")){
							Afmelden a1 = new Afmelden(gbrNm.getText(), afwezigDatum.getValue(), afwezigReden.getText());
							try {
								a1.meldAfwezigheid();
								afwezigLabel.setText("U bent afwezig gemeld");
							} catch (IOException e) {
								e.printStackTrace();
							}
							}
							else{
								afwezigLabel.setText("U heeft de gegevens verkeerd ingevuld");
							}}});
				FlowPane afwezigL = new FlowPane();
				afwezigL.setPadding(new Insets(10,10,10,10));
				afwezigL.setVgap(4);
				afwezigL.setHgap(4);
				afwezigL.setPrefWrapLength(300);
				afwezigL.getChildren().addAll(afwezigLabel, afwezigDatumlabel, afwezigDatum, afwezigRedenlabel, afwezigReden, meldAfwezig, terugL);
				Scene afwezigLeraar = new Scene(afwezigL, 600, 800);
				thestage.setScene(afwezigLeraar);
				thestage.setTitle("Afwezig Melden");
				thestage.show();
			}
			});
		
		//Knop voor beter melden leraar
		
		optieL4 = new Button("Beter Melden");
		optieL4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				beterDatum.setValue(LocalDate.now());
				beterReden.setText("");
				meldBeter.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						if(!gbrNm.getText().equals("") && !beterReden.getText().equals("")){
							Betermelden b1 = new Betermelden(gbrNm.getText(), beterDatum.getValue(), beterReden.getText());
							try {
								b1.meldBeter();
								beterLabel.setText("U bent beter gemeld");
								
							} catch (IOException e) {
								e.printStackTrace();
							}
							}
							else{
								afwezigLabel.setText("U heeft de gegevens verkeerd ingevuld");
							}}});
				FlowPane beterL = new FlowPane();
				beterL.setPadding(new Insets(10,10,10,10));
				beterL.setVgap(4);
				beterL.setHgap(4);
				beterL.setPrefWrapLength(300);
				beterL.getChildren().addAll(beterLabel, beterDatumlabel, beterDatum, beterRedenlabel, beterReden, meldBeter, terugL);
				Scene beterLeraar = new Scene(beterL, 600, 800);
				thestage.setScene(beterLeraar);
				thestage.setTitle("Beter Melden");
				thestage.show();
			}
			});
		
		
		//Afwezigheid inzien Leraar
		
		optieL5 = new Button("Afwezigheid bekijken");
		optieL5.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				afwezigheid.setText("");
				afwezigheidInzienDatum.setValue(LocalDate.now());
				afwezigheidInzienKnop.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						AfwezigheidInzien aI = new AfwezigheidInzien(gbrNm.getText(), afwezigheidInzienDatum.getValue());
						try {
							aI.afwezigInzien();
							afwezigheid.setText(aI.toString());
						} catch (IOException e) {
							e.printStackTrace();
						}
					}});
				
				FlowPane afwezigheidInzienL = new FlowPane();
				afwezigheidInzienL.setPadding(new Insets(10,10,10,10));
				afwezigheidInzienL.setVgap(4);
				afwezigheidInzienL.setHgap(4);
				afwezigheidInzienL.setPrefWrapLength(300);
				afwezigheidInzienL.getChildren().addAll(afwezigheidLabel,afwezigheidInzienLabel, afwezigheidInzienDatum, afwezigheid, afwezigheidInzienKnop, terugL);
				Scene afwezigheidInzienLeraar = new Scene(afwezigheidInzienL, 600, 800);
				thestage.setScene(afwezigheidInzienLeraar);
				thestage.setTitle("Afwezigheid Bekijken");
				thestage.show();
			}
			});
		
		//Knop voor rooster bekijken leerling
		
		optieS1 = new Button("Bekijk Rooster");
		optieS1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				CheckKlas ck = new CheckKlas(gbrNm.getText());
				try {
					roosterlabelS.setText(ck.geefKlas() + " heeft het volgende rooster:");
					Rooster r = new Rooster(ck.geefKlas());
					r.zoekRooster();
					roostertextS.setText(r.toString());
				} catch (IOException e) {

					e.printStackTrace();
				}
				
				FlowPane roosterS = new FlowPane();
				roosterS.setPadding(new Insets(10,10,10,10));
				roosterS.setVgap(4);
				roosterS.setHgap(4);
				roosterS.setPrefWrapLength(300);
				roosterS.getChildren().addAll(roosterlabelS, roostertextS, terugS);
				Scene roosterLeerling = new Scene(roosterS, 600, 800);
				thestage.setScene(roosterLeerling);
				thestage.setTitle("Bekijk Rooster");
				thestage.show();
			}
			});
		
		
		//Knop voor presentie bekijken leerling
		
		optieS2 = new Button("Presentie bekijken");
		optieS2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				presenties.setText("");
				presentieInzienDatum.setValue(LocalDate.now());
				presentieInzienKnop.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						PresentieBekijken pb = new PresentieBekijken(gbrNm.getText(), presentieInzienDatum.getValue());
						try {
							pb.presentieInzien();
							presenties.setText(pb.toString());
						} catch (IOException e) {
							e.printStackTrace();
						}
					}});
				
				FlowPane presentieS = new FlowPane();
				presentieS.setPadding(new Insets(10,10,10,10));
				presentieS.setVgap(4);
				presentieS.setHgap(4);
				presentieS.setPrefWrapLength(300);
				presentieS.getChildren().addAll(presentieInzienLabel, presentieInzienDatum, presenties, presentieInzienKnop, terugS);
				Scene presentieLeerling = new Scene(presentieS, 600, 800);
				thestage.setScene(presentieLeerling);
				thestage.setTitle("Presentie Bekijken");
				thestage.show();
			}
			});
		
		//Knop voor afwezig melden leerling
		
		optieS3 = new Button("Afwezig melden");
		optieS3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				afwezigDatum.setValue(LocalDate.now());
				afwezigReden.setText("");
				meldAfwezig.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						if(!gbrNm.getText().equals("") && !afwezigReden.getText().equals("")){
							Afmelden a1 = new Afmelden(gbrNm.getText(), afwezigDatum.getValue(), afwezigReden.getText());
							try {
								a1.meldAfwezigheid();
								afwezigLabel.setText("U bent afwezig gemeld");
							} catch (IOException e) {
								e.printStackTrace();
							}
							}
							else{
								afwezigLabel.setText("U heeft de gegevens verkeerd ingevuld");
							}}});
				FlowPane afwezigS = new FlowPane();
				afwezigS.setPadding(new Insets(10,10,10,10));
				afwezigS.setVgap(4);
				afwezigS.setHgap(4);
				afwezigS.setPrefWrapLength(300);
				afwezigS.getChildren().addAll(afwezigLabel, afwezigDatumlabel, afwezigDatum, afwezigRedenlabel, afwezigReden, meldAfwezig, terugL);
				Scene afwezigLeerling = new Scene(afwezigS, 600, 800);
				thestage.setScene(afwezigLeerling);
				thestage.setTitle("Afwezig Melden");
				thestage.show();
			}
			});
		
		//Knop voor beter melden leerling
		
		optieS4 = new Button("Beter melden");
		optieS4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				beterDatum.setValue(LocalDate.now());
				beterReden.setText("");
				meldBeter.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						if(!gbrNm.getText().equals("") && !beterReden.getText().equals("")){
							Betermelden b1 = new Betermelden(gbrNm.getText(), beterDatum.getValue(), beterReden.getText());
							try {
								b1.meldBeter();
								beterLabel.setText("U bent beter gemeld");
							} catch (IOException e) {
								e.printStackTrace();
							}
							}
							else{
								afwezigLabel.setText("U heeft de gegevens verkeerd ingevuld");
							}}});
				FlowPane beterS  = new FlowPane();
				beterS.setPadding(new Insets(10,10,10,10));
				beterS.setVgap(4);
				beterS.setHgap(4);
				beterS.setPrefWrapLength(300);
				beterS.getChildren().addAll(beterLabel, beterDatumlabel, beterDatum, beterRedenlabel, beterReden, meldBeter, terugL);
				Scene beterLeerling = new Scene(beterS, 600, 800);
				thestage.setScene(beterLeerling);
				thestage.setTitle("Beter Melden");
				thestage.show();
			}
			});
		
		//Afwezigheid inzien Leraar
		
				optieS5 = new Button("Afwezigheid bekijken");
				optieS5.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						afwezigheid.setText("");
						afwezigheidInzienDatum.setValue(LocalDate.now());
						afwezigheidInzienKnop.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {
								AfwezigheidInzien aI = new AfwezigheidInzien(gbrNm.getText(), afwezigheidInzienDatum.getValue());
								try {
									aI.afwezigInzien();
									afwezigheid.setText(aI.toString());
								} catch (IOException e) {
									e.printStackTrace();
								}
							}});
						
						FlowPane afwezigheidInzienS = new FlowPane();
						afwezigheidInzienS.setPadding(new Insets(10,10,10,10));
						afwezigheidInzienS.setVgap(4);
						afwezigheidInzienS.setHgap(4);
						afwezigheidInzienS.setPrefWrapLength(300);
						afwezigheidInzienS.getChildren().addAll(afwezigheidLabel, afwezigheidInzienLabel, afwezigheidInzienDatum, afwezigheid, afwezigheidInzienKnop, terugL);
						Scene afwezigheidInzienLeerling = new Scene(afwezigheidInzienS, 600, 800);
						thestage.setScene(afwezigheidInzienLeerling);
						thestage.setTitle("Afwezigheid Bekijken");
						thestage.show();
					}
					});
		
		
		//Het inlogscherm
		
		FlowPane root = new FlowPane();
		root.setPadding(new Insets(10,10,10,10));
		root.setVgap(4);
		root.setHgap(4);
		root.setPrefWrapLength(300);
		root.getChildren().addAll(logtext, gbrNmtext, gbrNm, wwtext, ww, login, inlogFotoView);
		
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
