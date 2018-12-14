package sample;

import cards.Deck;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import player.Hand;

import java.io.FileInputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GameManager gameManager = GameManager.getInstance();
        gameManager.startGame(100);

        FXMLLoader loader  = new FXMLLoader();

        //fxml file path
        String fxmlDocPath = "src/sample/Main.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

        //create anchor path
        AnchorPane root = (AnchorPane) loader.load(fxmlStream);

        Controller controller = loader.getController();


        //create scene
        Scene initialScene = new Scene(root);


        initialScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(initialScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
