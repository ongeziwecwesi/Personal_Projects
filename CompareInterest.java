
package compareinterest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CompareInterest extends Application {

     TextField tfLoanAmount=new TextField(); // Accepts Loan Amount using text field
     TextField tfLoan_Period=new TextField(); // Accepts Loan Period usng text field
     TextArea txtArea=new TextArea();        // Show interest rate  and payment

   public void start(Stage primaryStage) throws Exception {
       
      // size of a textArea and textfield
      tfLoan_Period.setPrefColumnCount(2); 
      tfLoanAmount.setPrefColumnCount(7);
      txtArea.setPrefColumnCount(40);
      txtArea.setPrefHeight(300);
      txtArea.setPrefWidth(400);
      

      // Button to show result
      Button btnshow=new Button("Show Result");
      
      // HBox layout add controls  Text Field,Button and Label for message
      HBox hbox=new HBox();      
      hbox.setAlignment(Pos.CENTER);
      hbox.getChildren().addAll(new Label("Loan amount ")
              ,tfLoanAmount,new Label("No Of Years ")
              , tfLoan_Period,btnshow);


      
      BorderPane pan=new BorderPane();
      pan.setTop(hbox);
      pan.setCenter(txtArea);

     
      Scene scene = new Scene(pan);
      primaryStage.setTitle("Compare Loans with various Interests Rates"); // title of the stage
      primaryStage.setScene(scene);     
      primaryStage.show(); 

      // event handler for button 
      btnshow.setOnAction(new EventHandler<ActionEvent>() 
          {
                  @Override
              public void handle(ActionEvent event)
            {
String output="";  // output to be displayed on text area
       
       //variable declaration
       Double monthly_Interest_Rate;
       Double monthly_Payment;
       Double final_Amount;

       output+= "Interest Rate    Monthly Payment        Total Payment\n";

       //The monthly and total payments for each interest rate starting from 5% to 8% with an increment of 1/4
       for(double i=5.0;i <=8.0 ;i+=0.25){
       
           //calculating interest rate
           monthly_Interest_Rate=i/(100*12);
           
           //calculating monthly payments
           monthly_Payment=Double.parseDouble(tfLoanAmount.getText())*(monthly_Interest_Rate *Math.pow(1+monthly_Interest_Rate,Double.parseDouble(tfLoan_Period.getText())*12)/
                   ( Math.pow(1+monthly_Interest_Rate,Double.parseDouble(tfLoan_Period.getText())*12 )-1));

           //calculating final amount after the number of years you took the loan
           final_Amount = monthly_Payment*12*Double.parseDouble(tfLoan_Period.getText());
           
           //display results in a table form
           output    +=String.format("%-24.3f%-34.2f%-8.2f\n",i,monthly_Payment,final_Amount );
       }
               txtArea.setText(output); 
            }

        }); 
   } 

   public static void main(String args[]){
      launch(args);
   }   

}