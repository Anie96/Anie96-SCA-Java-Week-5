package sample;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.MotionBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Group group = new Group();
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Test Application");
        primaryStage.setScene(new Scene(group, 400, 300, Color.WHITE));



        //2D-Test
        //rectangle
        Rectangle rect = new Rectangle();
        rect.setX(10);
        rect.setY(30);
        rect.setWidth(100);
        rect.setHeight(100);
        rect.setArcHeight(35);
        rect.setArcWidth(35);
        rect.setFill(Color.RED);



        Rectangle rect2 = new Rectangle(10, 30, 100, 100);
        rect2.setFill(Color.GREEN);
        rect2.setArcHeight(35);
        rect2.setArcWidth(35);

        //line
        Line line = new Line(110,70, 160, 70);
        Line line2 = new Line(110, 80, 160, 80);
        line.setFill(Color.BLACK);
        line2.setFill(Color.YELLOWGREEN);


        //Circle

        Circle circle = new Circle();
        circle.setCenterX(190);
        circle.setCenterY(70);
        circle.setRadius(30);



        //Text
        Text text = new Text("Welcome to JavaFX");
        text.setX(10);
        text.setY(20);
        text.setFont(Font.font("Courier 10 Pitch", FontWeight.BOLD, FontPosture.ITALIC, 20));

        //create Color Adjust Effect and Apply to rect object
        ColorAdjust colorAdjust = new ColorAdjust(0.2, 0.1, 0.3, 0.4);
        rect.setEffect(colorAdjust);

        //Create Motion Blur effect and Add to Line

        MotionBlur motionBlur = new MotionBlur(10, 10);
        line.setEffect(motionBlur);

        //transformation
        Translate translate = new Translate(100, 100);
        rect2.getTransforms().add(translate);


        //rotate animation


RotateTransition rotate = new RotateTransition();
rotate.setByAngle(360);
rotate.setDuration(Duration.millis(1000));
rotate.setAxis(Rotate.Z_AXIS);
rotate.setCycleCount(500);

rotate.setNode(rect);
rotate.play();


        TranslateTransition translateTransition = new TranslateTransition();

        translateTransition.setByX(400);
        translateTransition.setCycleCount(500);
        translateTransition.setDuration(Duration.millis(1000));
        translateTransition.setAutoReverse(true);

        translateTransition.setNode(rect2);
        translateTransition
                .play();



        //events
        //onClick event
        rect2.setOnMouseClicked( new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event){

                translateTransition.pause();
            }


        });

        //test eventfilter
        //add eventHandler - you can create the function seperately
        //you can call the same event handler on different nodes

        //what makes them different?

        group.getChildren().addAll(text, rect, rect2, line, line2, circle);

//        root.getChildrenUnmodifiable().add(group);


        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
