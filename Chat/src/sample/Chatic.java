package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;

import javax.swing.*;
import java.awt.*;
import java.beans.Visibility;

public class Chatic {
    public static Stage primaryStage = new Stage();
    public static TextArea EnterMessage = new TextArea();
    public static GridPane grid = new GridPane();
        public static GridPane grid1 = new GridPane();
       public static ScrollPane sc = new ScrollPane();
    public static Button arrow1 = new Button("→");
 public static int countMes = 1;
    public static void Chat() {

BorderPane root = new BorderPane();

     //grid.setGridLinesVisible(true);
        grid.setHgap(100);
        grid.setVgap(10);
        ColumnConstraints column1 = new ColumnConstraints();

       // column1.setPercentWidth(90);
        grid.getColumnConstraints().addAll(column1);
        grid.setPadding(new Insets(20, 20, 20, 20));

        //КНОПУЛЕЧКА "←"
            HBox hbBtn = new HBox(120);
        Button arrow = new Button("←");

        arrow.setId("arrow");




        //LABEL "НАЗВАНИЕ ЧАТИКА"
        Label NameChat = new Label("Чат банка");
        NameChat.setId("Label");

            hbBtn.getChildren().addAll(arrow,NameChat);
        root.setTop(hbBtn);
        BorderPane.setAlignment(hbBtn, Pos.TOP_CENTER);

        //LABEL1 "СООБЩЕНИЕ"
        Label Mes1 = new Label("Пользователь1\nСообщение\nЗдрасьте");
        Mes1.setMinSize(50, 20);
        Mes1.setMaxSize(180, 150);
        Mes1.setWrapText(true);
        Mes1.setId("mes");
            grid.add(Mes1, 0, 1);
            root.setCenter(grid);
       //BorderPane.setAlignment(grid, Pos.TOP_CENTER);


    /*    //LABEL2 "СООБЩЕНИЕ"
       Label Mes2 = new Label("Пользователь2\nСообщение\nПриветули");
        Mes2.setMinSize(100, 20);
        Mes2.setMaxSize(180, 150);
        Mes2.setWrapText(true);
        Mes2.setId("mes");
        GridPane.setHalignment(Mes2, HPos.RIGHT);
        GridPane.setValignment(Mes2, VPos.CENTER);
        grid.add(Mes2, 0, 2);

        //LABEL3 "СООБЩЕНИЕ"
        Label Mes3 = new Label("Пользователь3\nСообщение кенгонрпамвсыакперногшдщлгонрпавуакперногшлгорнпеа");
        Mes3.setId("mes");
        Mes3.setMinSize(50, 20);
        Mes3.setMaxSize(180, 150);
        Mes3.setWrapText(true);
        GridPane.setHalignment(Mes3, HPos.LEFT);
        GridPane.setValignment(Mes3, VPos.CENTER);
        grid.add(Mes3, 0, 3);

        //LABEL4 "СООБЩЕНИЕ"
        Label Mes4 = new Label("Пользователь4\nСообщение апролдорпекаувцукапенгонрпекавпролдщлорпав");
        Mes4.setId("mes");
        Mes4.setMinSize(50, 20);
        Mes4.setMaxSize(180, 150);
        Mes4.setWrapText(true);
        GridPane.setHalignment(Mes4, HPos.RIGHT);
        GridPane.setValignment(Mes4, VPos.CENTER);
        grid.add(Mes4, 0, 4);

        //LABEL5 "СООБЩЕНИЕ"
        Label Mes5 = new Label("Пользователь5\nСообщение вапролджлорпавывакперногшлдщждлорпавы");
        Mes5.setId("mes");
        Mes5.setMinSize(50, 20);
        Mes5.setMaxSize(180, 150);
        Mes5.setWrapText(true);
        GridPane.setHalignment(Mes5, HPos.LEFT);
        GridPane.setValignment(Mes5, VPos.CENTER);
        grid.add(Mes5, 0, 5);

        //LABEL6 "СООБЩЕНИЕ"
        Label Mes6 = new Label("Пользователь6\nСообщение проглдорпавыапролджлорпавыапролдбльотрпакуапро");
        Mes6.setId("mes");
        Mes6.setMinSize(50, 20);
        Mes6.setMaxSize(180, 150);
        Mes6.setWrapText(true);
      //  Mes6.setVisible(false);
        GridPane.setHalignment(Mes6, HPos.RIGHT);
        GridPane.setValignment(Mes6, VPos.CENTER);
        grid.add(Mes6, 0, 6);
*/

       //EDIT "ВВОД СООБЩЕНИЯ"

        EnterMessage.setMaxSize(370, 10);
        EnterMessage.setWrapText (true);
        EnterMessage.setId("field");
       // root.setBottom(EnterMessage);
       // BorderPane.setAlignment(EnterMessage, Pos.TOP_LEFT);


        //КНОПУЛЕЧКА "→"

        HBox hbBtn1 = new HBox(25);
        arrow1.setId("arrow1");
       // hbBtn.setAlignment(Pos.BASELINE_RIGHT);
        //hbBtn.getChildren().add(arrow1);
       hbBtn1.getChildren().addAll(EnterMessage,arrow1);
       root.setBottom(hbBtn1);


        sc.setMinSize(450,500);
        sc.setContent(grid);
        sc.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        sc.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
            sc.setStyle("-fx-background-color:transparent;");

        root.setCenter(sc);

        EnterMessage.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                        if (event.getCode()== KeyCode.ENTER){
                        Talk.Govorilka();
                        EnterMessage.clear();
                                try {
                                        Robot rb=new Robot();
                                        rb.keyPress(8);
                                        rb.keyRelease(8);

                                }
                                catch (AWTException ex) {System.err.println("Robot error");};


                        }
                }

        });
        arrow1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                        Talk.Govorilka();
                        EnterMessage.clear();
                }
        });

        Scene scene = new Scene(root, 450, 600);
        sc.vvalueProperty().bind(grid.heightProperty());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Чат сотрудников");
        scene.getStylesheets().add(0, "sample/ForChatic.css");
        primaryStage.show();


    }
}