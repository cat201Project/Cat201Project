package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

//import java.io.IOException;

import javafx.event.ActionEvent;

public class FirstStage implements Initializable{

	
	@FXML
    private Label HighScore;

    @FXML
    private TextField Player_Name;
	
	@FXML
    private Button closedButton;
	
    @FXML
    private Button Button_Play;
    
    //Syasya comment
    @FXML
    void ButtonPlay(ActionEvent event) throws Exception{
    	String name = Player_Name.getText();
    	new SecondStage(name);	
    }


    @FXML
    void ButtonExit(ActionEvent event) {
        
        Stage stage = (Stage) closedButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    void PreviewHighScore(ActionEvent event) throws FileNotFoundException{
    	

    	// pass the path to the file as a parameter
        File file = new File("C:\\Users\\nmnor\\eclipse-workspace\\NameScore.txt");
        try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine())
			  HighScore.setText(sc.nextLine());
		}

    	
    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Button_Play.disableProperty().bind(Player_Name.textProperty().isEmpty());
		
	}
}


