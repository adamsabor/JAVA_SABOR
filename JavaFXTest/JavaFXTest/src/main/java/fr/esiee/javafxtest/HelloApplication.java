package fr.esiee.javafxtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
//la classe Application represente l'application à demarrrer
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //la fenetre principal est personifié par l'objet de type stage
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //scene represente le cadre qui strucuture la fenetre et accuille le panel principal
        //panel principal = root panel
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show(); // permet de rendre visible la fenetre
    }

    public static void main(String[] args) {
        launch();
    }
}