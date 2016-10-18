/**
 * @author John Tyler Gafford
 * September 27th 2016
 * jtg2246@email.vccs.edu
 * This program is used to take your Height and convert
 * it from feet, inches, or centimeters to any of the three
 */

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class Conversionfx extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		double w;
		double h;
		int l;
		double w2;
		double h2;
		double in;
		double in2;
		
		double out;
		double out2;
		String a;
		String b;
		String c;
		String d;
		String reg;
		
		GraphicsDevice res = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		w = res.getDisplayMode().getWidth();
		h = res.getDisplayMode().getHeight();
		
		h2 = 250;
		h = (h/2) - (h2/2 + h2/5);
		w2 = 700;
		w = w - w2;
		l = 1;
		
		//Setting  format for outputs
		//dformat shows up to 2 decimal places
		DecimalFormat dformat = new DecimalFormat("#.00");
		//dformat1 shows no decimal places
		DecimalFormat dformat1 = new DecimalFormat("#0");
		
		while(l != 0){
			//Using FX for user input if they want to use the program
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.getDialogPane().setStyle("-fx-font-size: 20;");
			alert.setTitle("Convert your height.");
			alert.setHeaderText(null);
			alert.setContentText("Do you want to convert your height?");
			alert.getDialogPane().setPrefWidth(w2);
			alert.getDialogPane().setPrefHeight(h2);
			alert.setX(w);
			alert.setY(h);
			ButtonType yes = new ButtonType("Yes");
			ButtonType no = new ButtonType("No", ButtonData.CANCEL_CLOSE);
			alert.getButtonTypes().setAll(yes, no);
			Optional<ButtonType> result =  alert.showAndWait();
			
			//Setting up values for loop
			if(result.get() == yes){
				l = 1;
			}
			if(result.get() == no){
				System.exit(0);
			}
		
			//Setting up FX for user input through dropdown box
			//Input units
			List<String> inputunits = new ArrayList<>();
			inputunits.add("Inches");
			inputunits.add("Feet");
			inputunits.add("Centimeters");
		
			ChoiceDialog<String> dialog = new ChoiceDialog<>("Inches", inputunits);
			dialog.getDialogPane().setStyle("-fx-font-size:20;");
			dialog.setTitle("Convert your height.");
			dialog.setHeaderText(null);
			dialog.setContentText("Choose an unit to input your height in:");
			dialog.getDialogPane().setPrefWidth(w2);
			dialog.getDialogPane().setPrefHeight(h2);
			dialog.setX(w);
			dialog.setY(h);
			Optional<String> result1 = dialog.showAndWait();
		
			a = result1.get();
			
			//Input units are inches
			if(a.matches("Inches")){
				
				
				List<String> conunints = new ArrayList<>();
				conunints.add("Feet");
				conunints.add("Centimeters");
			
				ChoiceDialog<String> dialog1 = new ChoiceDialog<>("Feet", conunints);
				dialog1.getDialogPane().setStyle("-fx-font-size:20;");
				dialog1.setTitle("Convert your height.");
				dialog1.setHeaderText(null);
				dialog1.setContentText("Choose an unit to convert your height to:");
				dialog1.getDialogPane().setPrefWidth(w2);
				dialog1.getDialogPane().setPrefHeight(h2);
				dialog1.setX(w);
				dialog1.setY(h);
				Optional<String> result2 = dialog1.showAndWait();
			
				b = result2.get();
				
				//Converting from inches to Feet
				if(b.matches("Feet")){
					TextInputDialog text = new TextInputDialog("Height");
					text.getDialogPane().setStyle("-fx-font-size:20;");
					text.setTitle("Input your Height");
					text.setHeaderText(null);
					text.setContentText("Input your height in inches:");
					text.getDialogPane().setPrefWidth(w2);
					text.getDialogPane().setPrefHeight(h2);
					text.setX(w);
					text.setY(h);

					Optional<String> input = text.showAndWait();
					reg = input.get();
					Scanner scan = new Scanner(reg);
					scan.useDelimiter(Pattern.compile("-"));
					in = scan.nextDouble();
					scan.close();
					
					out = (int) in/12;
					out2 = in%12;
					
					Alert height = new Alert(AlertType.INFORMATION);
					height.getDialogPane().setStyle("-fx-font-size: 20;");
					height.setTitle("Your Height");
					height.setHeaderText(null);
					height.setContentText("Your are " + dformat1.format(out) + " foot " + dformat.format(out2) + " inches tall.");
					height.getDialogPane().setPrefWidth(w2);
					height.getDialogPane().setPrefHeight(h2);
					height.setX(w);
					height.setY(h);
					
					height.showAndWait();
				}	
				
				//Converting inches to centimeters
				if(b.matches("Centimeters")){
					TextInputDialog text = new TextInputDialog("Height");
					text.getDialogPane().setStyle("-fx-font-size:20;");
					text.setTitle("Input your Height");
					text.setHeaderText(null);
					text.setContentText("Input your height in inches:");
					text.getDialogPane().setPrefWidth(w2);
					text.getDialogPane().setPrefHeight(h2);
					text.setX(w);
					text.setY(h);

					Optional<String> input = text.showAndWait();
					reg = input.get();
					Scanner scan = new Scanner(reg);
					scan.useDelimiter(Pattern.compile("-"));
					in = scan.nextDouble();
					scan.close();
					
					out = in*2.54;
					
					Alert height = new Alert(AlertType.INFORMATION);
					height.getDialogPane().setStyle("-fx-font-size: 20;");
					height.setTitle("Your Height");
					height.setHeaderText(null);
					height.setContentText("Your are " + dformat.format(out) + " centimeters tall.");
					height.getDialogPane().setPrefWidth(w2);
					height.getDialogPane().setPrefHeight(h2);
					height.setX(w);
					height.setY(h);
					
					height.showAndWait();
					
				}
			}	
			
			//Input units are feet
			if(a.matches("Feet")){
				List<String> conunints1 = new ArrayList<>();
				conunints1.add("Inches");
				conunints1.add("Centimeters");
			
				ChoiceDialog<String> dialog1 = new ChoiceDialog<>("Inches", conunints1);
				dialog1.getDialogPane().setStyle("-fx-font-size:20;");
				dialog1.setTitle("Convert your height.");
				dialog1.setHeaderText(null);
				dialog1.setContentText("Choose an unit to convert your height to:");
				dialog1.getDialogPane().setPrefWidth(w2);
				dialog1.getDialogPane().setPrefHeight(h2);
				dialog1.setX(w);
				dialog1.setY(h);
				Optional<String> result2 = dialog1.showAndWait();
			
				c = result2.get();
				
				//Converting from feet to inches
				if(c.matches("Inches")){	
					TextInputDialog text = new TextInputDialog("Height");
					text.getDialogPane().setStyle("-fx-font-size:20;");
					text.setTitle("Input your Height");
					text.setHeaderText("Input your height in feet with a \"-\" "
						+ "between the foot length and the inche length "
						+ "with the foot value coming first.");
					text.setContentText("Input your height in feet:");
					text.getDialogPane().setPrefWidth(w2);
					text.getDialogPane().setPrefHeight(h2);
					text.setX(w);
					text.setY(h);

					Optional<String> input = text.showAndWait();
					reg = input.get();
					Scanner scan = new Scanner(reg);
					scan.useDelimiter(Pattern.compile("-"));
					in = scan.nextDouble();
					in2 = scan.nextDouble();
					scan.close();
					
					out = in*12 + in2;
					
					Alert height = new Alert(AlertType.INFORMATION);
					height.getDialogPane().setStyle("-fx-font-size: 20;");
					height.setTitle("Your Height");
					height.setHeaderText(null);
					height.setContentText("Your are " + dformat.format(out) + "  inches tall");
					height.getDialogPane().setPrefWidth(w2);
					height.getDialogPane().setPrefHeight(h2);
					height.setX(w);
					height.setY(h);
					
					height.showAndWait();
					
				}	
				
				//Converting from feet to centimeters
				if(c.matches("Centimeters")){
					TextInputDialog text = new TextInputDialog("Height");
					text.getDialogPane().setStyle("-fx-font-size:20;");
					text.setTitle("Input your Height");
					text.setHeaderText("Input your height in feet with a \"-\" "
						+ "between the foot length and the inche length "
						+ "with the foot value coming first.");
					text.setContentText("Input your height in feet:");
					text.getDialogPane().setPrefWidth(w2);
					text.getDialogPane().setPrefHeight(h2);
					text.setX(w);
					text.setY(h);

					Optional<String> input = text.showAndWait();
					reg = input.get();
					Scanner scan = new Scanner(reg);
					scan.useDelimiter(Pattern.compile("-"));
					in = scan.nextDouble();
					in2 = scan.nextDouble();
					scan.close();
					
					out = ((in * 12 + in2) * 2.54);
					
					Alert height = new Alert(AlertType.INFORMATION);
					height.getDialogPane().setStyle("-fx-font-size: 20;");
					height.setTitle("Your Height");
					height.setHeaderText(null);
					height.setContentText("Your are " + dformat.format(out) + " centimeters tall");
					height.getDialogPane().setPrefWidth(w2);
					height.getDialogPane().setPrefHeight(h2);
					height.setX(w);
					height.setY(h);
					
					height.showAndWait();
					
				}
			}
			
			//Input units are centimeters
			if(a.matches("Centimeters")){
				List<String> conunints2 = new ArrayList<>();
				conunints2.add("Inches");
				conunints2.add("Feet");
			
				ChoiceDialog<String> dialog1 = new ChoiceDialog<>("Inches", conunints2);
				dialog1.getDialogPane().setStyle("-fx-font-size:20;");
				dialog1.setTitle("Convert your height.");
				dialog1.setHeaderText(null);
				dialog1.setContentText("Choose an unit to convert your height to:");
				dialog1.getDialogPane().setPrefWidth(w2);
				dialog1.getDialogPane().setPrefHeight(h2);
				dialog1.setX(w);
				dialog1.setY(h);
				Optional<String> result2 = dialog1.showAndWait();
			
				d = result2.get();
				
				//Converting from centimeters to inches
				if(d.matches("Inches")){
					TextInputDialog text = new TextInputDialog("Height");
					text.getDialogPane().setStyle("-fx-font-size:20;");
					text.setTitle("Input your height");
					text.setHeaderText(null);
					text.setContentText("Input your height in centimeters");
					text.getDialogPane().setPrefWidth(w2);
					text.getDialogPane().setPrefHeight(h2);
					text.setX(w);
					text.setY(h);

					Optional<String> input = text.showAndWait();
					reg = input.get();
					Scanner scan = new Scanner(reg);
					scan.useDelimiter(Pattern.compile("-"));
					in = scan.nextDouble();
					scan.close();
					
					out = (in / 2.54);
					
					Alert height = new Alert(AlertType.INFORMATION);
					height.getDialogPane().setStyle("-fx-font-size: 20;");
					height.setTitle("Your Height");
					height.setHeaderText(null);
					height.setContentText("Your are " + dformat.format(out) + " inches tall");
					height.getDialogPane().setPrefWidth(w2);
					height.getDialogPane().setPrefHeight(h2);
					height.setX(w);
					height.setY(h);
					
					height.showAndWait();
					
				}		
				
				//Converting from centimeters to feet
				if(d.matches("Feet")){	
					TextInputDialog text = new TextInputDialog("Height");
					text.getDialogPane().setStyle("-fx-font-size:20;");
					text.setTitle("Input your Height");
					text.setHeaderText(null);
					text.setContentText("Input your height in centimeters");
					text.getDialogPane().setPrefWidth(w2);
					text.getDialogPane().setPrefHeight(h2);
					text.setX(w);
					text.setY(h);

					Optional<String> input = text.showAndWait();
					reg = input.get();
					Scanner scan = new Scanner(reg);
					scan.useDelimiter(Pattern.compile("-"));
					in = scan.nextDouble();
					scan.close();
					
					out = (in / 2.54) % 12;
					out2 = (int) (in / 2.54) / 12;
					
					Alert height = new Alert(AlertType.INFORMATION);
					height.getDialogPane().setStyle("-fx-font-size: 20;");
					height.setTitle("Your Height");
					height.setHeaderText(null);
					height.setContentText("Your are " + dformat1.format(out2) + " foot " + dformat.format(out) + " inches tall.");
					height.getDialogPane().setPrefWidth(w2);
					height.getDialogPane().setPrefHeight(h2);
					height.setX(w);
					height.setY(h);
					
					height.showAndWait();
					
				}
			}
		}
	}
}