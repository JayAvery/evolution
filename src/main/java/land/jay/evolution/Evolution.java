package land.jay.evolution;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Evolution extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Evolution");
        
        HBox root = new HBox();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        Pane creatureHolderA = new Pane();
        creatureHolderA.setPrefWidth(500);
        creatureHolderA.setPrefHeight(500);
        creatureHolderA.setStyle("-fx-border-color: black");
        root.getChildren().add(creatureHolderA);
        
        Group creatureNodeA = new Group();
        creatureHolderA.getChildren().add(creatureNodeA);
        
        Creature creatureA = new Creature();
        creatureA.draw(creatureNodeA);
        
        Pane creatureHolderB = new Pane();
        creatureHolderB.setPrefWidth(500);
        creatureHolderB.setPrefHeight(500);
        creatureHolderB.setStyle("-fx-border-color: black");
        root.getChildren().add(creatureHolderB);
        
        Group creatureNodeB = new Group();
        creatureHolderB.getChildren().add(creatureNodeB);
        
        Creature creatureB = new Creature();
        creatureB.draw(creatureNodeB);

        stage.show();
    }
}
