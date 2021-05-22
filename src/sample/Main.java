//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    private boolean buttonPressed = false;
    private boolean completed = false;
    private boolean gameOne = false;
    private boolean gameTwo = false;
    private boolean gameThree = false;
    private int scoreFor1 = 0;
    private int scoreFor2 = 0;
    private int scoreFor3 = 0;

    public void start(Stage stage) throws Exception {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("sample.fxml"));
        Controller controller = new Controller();
        HBox hboxTop = new HBox();
        HBox hboxBottom = new HBox();
        VBox vboxCenter = new VBox();
        Button btn1to10 = new Button("1-10");
        Button btn1to100 = new Button("1-100");
        Button btn1To1000 = new Button("1-1000");
        Button btnRetry = new Button("Retry");
        hboxTop.getChildren().addAll(new Node[]{btn1to10, btn1to100, btn1To1000, btnRetry});
        Label title = new Label("Guess the number");
        Label tellLabel = new Label("Select a difficulty");
        TextField input = new TextField();
        input.setPrefWidth(60.0D);
        input.setMaxWidth(60.0D);
        Button guessBtn = new Button("Guess");
        vboxCenter.setSpacing(30.0D);
        vboxCenter.getChildren().addAll(new Node[]{title, tellLabel, input, guessBtn});
        new GridPane();
        Label guessesBox = new Label("HIGHER or LOWER\n");
        Label textField = new Label("    Guesses:\n");
        Label score = new Label("High Score: ");
        guessesBox.setTextFill(Color.WHITE);
        textField.setTextFill(Color.WHITE);
        score.setTextFill(Color.WHITE);
        textField.setTranslateX(-40.0D);
        guessesBox.setTranslateX(-10.0D);
        score.setTranslateX(30.0D);
        input.setStyle("-fx-border-style: solid inside");
        input.setStyle("-fx-border-color: red");
        hboxBottom.getChildren().addAll(new Node[]{textField, guessesBox, score});
        hboxBottom.setAlignment(Pos.TOP_CENTER);
        hboxBottom.setPadding(new Insets(10.0D, 10.0D, 10.0D, 10.0D));
        hboxBottom.setSpacing(5.0D);
        hboxBottom.setBackground(new Background(new BackgroundFill[]{new BackgroundFill(Color.rgb(66, 69, 74), CornerRadii.EMPTY, Insets.EMPTY)}));
        BorderPane layout = new BorderPane();
        hboxTop.setSpacing(10.0D);
        layout.setTop(hboxTop);
        hboxTop.setAlignment(Pos.TOP_CENTER);
        layout.setCenter(vboxCenter);
        vboxCenter.setAlignment(Pos.CENTER);
        title.setFont(Font.font("Candara Light", 20.0D));
        title.setTranslateY(0.0D);
        btn1to10.setOnAction((event) -> {
            if (!this.completed) {
                this.gameOne = true;
                this.gameTwo = false;
                this.gameThree = false;
                this.buttonPressed = true;
                controller.setDifficulty("1-10");
                tellLabel.setText("Input a number between: " + controller.getDifficulty());
                score.setText("High Score for 1-10: " + String.valueOf(this.scoreFor1));
                controller.setRandomNum(1, 9);
            }

        });
        btn1to100.setOnAction((event) -> {
            if (!this.completed) {
                this.gameOne = false;
                this.gameTwo = true;
                this.gameThree = false;
                this.buttonPressed = true;
                controller.setDifficulty("1-100");
                tellLabel.setText("Input a number between: " + controller.getDifficulty());
                score.setText("High Score for 1-100: " + String.valueOf(this.scoreFor2));
                controller.setRandomNum(1, 99);
            }

        });
        btn1To1000.setOnAction((event) -> {
            if (!this.completed) {
                this.gameOne = false;
                this.gameTwo = false;
                this.gameThree = true;
                this.buttonPressed = true;
                controller.setDifficulty("1-1000");
                tellLabel.setText("Input a number between: " + controller.getDifficulty());
                score.setText("High Score for 1-1000: " + String.valueOf(this.scoreFor3));
                controller.setRandomNum(1, 999);
            }

        });
        btnRetry.setOnAction((actionEvent) -> {
            this.completed = false;
            this.buttonPressed = false;
            controller.setDifficulty("Select a difficulty");
            tellLabel.setText(controller.getDifficulty());
            controller.deleteGuesses();
            textField.setText("Guesses:\n" + controller.getGuesses().toString());
            guessesBox.setText("HIGHER or LOWER\n");
        });
        guessBtn.setOnAction((actionEvent) -> {
            if (this.buttonPressed) {
                int inputNum = Integer.parseInt(input.getText());
                controller.setHighScore();
                controller.setGuesses(inputNum);
                String var10001 = controller.higherOrLower(inputNum);
                guessesBox.setText("HIGHER or LOWER\n    " + var10001);
                textField.setText("Guesses:\n" + controller.getGuesses().toString());
                if (controller.equalRandomNum()) {
                    tellLabel.setText("You've got the right answer\n      Please press 'Retry'");
                    this.buttonPressed = false;
                    this.completed = true;
                    if (this.gameOne) {
                        this.scoreFor1 = controller.getHighScore(this.scoreFor1);
                        score.setText("High Score for 1-10: " + String.valueOf(this.scoreFor1));
                    } else if (this.gameTwo) {
                        this.scoreFor2 = controller.getHighScore(this.scoreFor2);
                        score.setText("High Score for 1-100: " + String.valueOf(this.scoreFor2));
                    } else if (this.gameThree) {
                        this.scoreFor3 = controller.getHighScore(this.scoreFor3);
                        score.setText("High Score for 1-1000: " + String.valueOf(this.scoreFor3));
                    }
                }
            }

        });
        layout.setBottom(hboxBottom);
        stage.setWidth(500.0D);
        stage.setHeight(350.0D);
        Scene scene = new Scene(layout);
        stage.setTitle("Guess The Number Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
