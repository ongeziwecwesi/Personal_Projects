package Mileage;
    
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Mileage extends Application {

//Declare the variables 
        double distance,litres,kilometers_per_litre;
        
        Text label1 = new Text("Distance(km) ");
        TextField tfkilo=new TextField();
        Text label2 = new Text(" Fuel(litres) ");
        TextField tflitre=new TextField();
        Text label3 = new Text("KM/L ");
        TextField tfkpl=new TextField();
        
@Override
public void start(Stage primaryStage) throws Exception {
    
      GridPane pan=new GridPane();
      
      //Setting size for the pane  
      pan.setMinSize(300, 150);
      
       //Setting the vertical gaps between the columns 
      pan.setVgap(5);
      
        // Button to show result
         Button calculate=new Button("Calculate");
         
         pan.setAlignment(Pos.CENTER);
    
         //Arranging all the nodes in the grid using columns and rows
      pan.add(label1, 0, 0); 
      pan.add(tfkilo, 3, 0); 
      pan.add(label2, 0, 1);       
      pan.add(tflitre, 3, 1); 
      pan.add(calculate, 2, 2); 
      pan.add(label3, 3, 3);
      pan.add(tfkpl, 2, 3); 

      Scene scene = new Scene(pan);
     
        //Add the event to the button.
        calculate.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
    
                distance = Double.parseDouble(tfkilo.getText());
                litres = Double.parseDouble(tflitre.getText());
                
                kilometers_per_litre = distance/litres;
                tfkpl.setText(""+String.format("%.2f", kilometers_per_litre));
            }
        } );
        
 
     
        //Set the stage title.
        primaryStage.setTitle("Miles Per Gallon Calculator App");
        primaryStage.setScene(scene);
        primaryStage.show();
        }

        //Define the main method and launch the application.
        public static void main(String[] args) {
            launch(args);
        }
}
