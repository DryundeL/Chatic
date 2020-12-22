package sample;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.Timer;
import java.util.concurrent.TimeUnit;


public class Talk {
    private static Label Mes;
    private static Timer timer;
   private static int rowind = 1;
    private static int i = 0;

    public static void Govorilka() {

         String text = Chatic.EnterMessage.getText();
        if (i <= Chatic.countMes) {

            Chatic.countMes +=1;
            i=i+1;
            rowind+=1;
            Mes = new Label(text);
            Mes.setMinSize(100, 20);
            Mes.setMaxSize(180, 150);
            Mes.setWrapText(true);
            Mes.setId("mes");
            GridPane.setHalignment(Mes, HPos.RIGHT);
            GridPane.setValignment(Mes, VPos.CENTER);
            Chatic.grid.add(Mes, 1, Chatic.countMes);

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Test Connection");

            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("Поле для ввода пустое");

            alert.showAndWait();

        }
        if (!text.equals("")) {
            try {

                Bot.sayInReturn(text);
                Chatic.countMes += 1;
                i = i + 1;
                rowind += 1;

                Mes = new Label(Bot.say);
                Mes.setMinSize(100, 20);
                Mes.setMaxSize(180, 150);
                Mes.setWrapText(true);
                Mes.setId("mes");
                GridPane.setHalignment(Mes, HPos.LEFT);
                GridPane.setValignment(Mes, VPos.CENTER);
                Chatic.grid.add(Mes, 0, Chatic.countMes);

            }
            catch (Exception e){
                e.getMessage();
            }
        }
    }
    }


