/**
 * @author John Tyler Gafford
 * September 20th 2016
 * jtg2246@email.vccs.edu
 * This program is used to take your Height and convert
 * it from feet, inches, or centimeters to any of the three
 */

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.text.DecimalFormat;


public class Conversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a;
		int b;
		int c;
		int t;
		int w;
		int h;
		Point loc;
		double d;
		double e;
		int height;
		int width;
		String value1;
		String value2;
		String value3;
		
		height = 150;
		width = 600;
		t = 0;
		
		GraphicsDevice res = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		w = res.getDisplayMode().getWidth();
		h = res.getDisplayMode().getHeight();
		
		System.out.println(w);
		System.out.println(h);
		
		loc = new Point(0, (h/2)-150);
		System.out.println(loc);
		
		DecimalFormat dformat = new DecimalFormat("#.00");
		//Setting up loop to prompt user if they want to convert height
		while (t != 1){
		JOptionPane box = new JOptionPane("Do you want to convert your height?"
				, JOptionPane.PLAIN_MESSAGE
				, JOptionPane.YES_NO_OPTION
				,null
				,null
				, "Convert?");
		JDialog dialog = box.createDialog(null, "Convert?");
		dialog.setLocation(loc);
		dialog.setSize(width, height);
		dialog.isAlwaysOnTop();
		dialog.setVisible(true);
		
		
		t = (int) box.getValue();
		
		//Closing program if they select no
		while (t != 0){
			System.exit(0);
		}
		
		//Prompting user input for input unit
		Object[] options1 = {"FEET!",
							"INCHES!",
							"CENTIMETERS!"};
		
		JOptionPane box1 = new JOptionPane("How would you like to input your height?"
				, JOptionPane.PLAIN_MESSAGE
				, JOptionPane.YES_NO_CANCEL_OPTION
				, null
				, options1
				, "Feet?");
		JDialog dialog1 = box1.createDialog(null, "Units?");
		dialog1.setLocation(loc);
		dialog1.setSize(width, height);
		dialog1.isAlwaysOnTop();
		dialog1.setVisible(true);
		
		
		value1 = (String) box1.getValue();
		
		
		//User chose feet as input unit
		if(value1.matches("FEET!")){
			
			//Prompting user to chose what unit to convert to
			Object[] options2 = {"INCHES!",
								"CENTIMETERS!"};
			JOptionPane box2 = new JOptionPane("Do you want to convert to INCHES or CENTIMETERS?"
					, JOptionPane.PLAIN_MESSAGE
					, JOptionPane.YES_NO_OPTION
					, null
					, options2
					, "INCHES or CENTIMETERS?");
			JDialog dialog2 = box2.createDialog(null, "Units?");
			dialog2.setLocation(loc);
			dialog2.setSize(width, height);
			dialog2.isAlwaysOnTop();
			dialog2.setVisible(true);
			
			
			value2 = (String) box2.getValue();
			
			//User chose to convert to inches
			if(value2.matches("INCHES!")){
				
				//Prompting user input for height in feet
				JOptionPane input1 = new JOptionPane("Input your height in "
						+ "feet with a \"-\" between the foot length and inch length with "
						+ "foot value coming first.");
				input1.setWantsInput(true);
				JDialog output1 = input1.createDialog(null, "Input your height");
				output1.setLocation(loc);
				output1.setSize(width, height);
				output1.isAlwaysOnTop();
				output1.setVisible(true);
				
				
				value3 = (String) input1.getInputValue();
				
				Scanner fi = new Scanner(value3);
				fi.useDelimiter(Pattern.compile("-"));
				a = fi.nextInt();
				b = fi.nextInt();
				
				//Converting feet to inches
				c = a*12 + b;
				
				//Displaying height in inches
				JOptionPane result1 = new JOptionPane("Your height is " + dformat.format(c) + " inches");
				JDialog output2 = result1.createDialog(null, "Your height in inches.");
				output2.setLocation(loc);
				output2.setSize(width, height);
				output2.isAlwaysOnTop();
				output2.setVisible(true);
				
				fi.close();
			}
			
			
			//User chose to convert to centimeters
			if(value2.matches("CENTIMETERS!")) {
				
				//Prompting user for height in feet
				JOptionPane input1 = new JOptionPane("Input your height in "
						+ "feet with a \"-\" between the foot length and inch length with "
						+ "foot value coming first.");
				input1.setWantsInput(true);
				JDialog output1 = input1.createDialog(null, "Input your height");
				output1.setLocation(loc);
				output1.setSize(width, height);
				output1.isAlwaysOnTop();
				output1.setVisible(true);
				
				
				value3 = (String) input1.getInputValue();
				
				Scanner fi = new Scanner(value3);
				fi.useDelimiter(Pattern.compile("-"));
				a = fi.nextInt();
				b = fi.nextInt();
				
				//Converting feet to centimeters
				d = (a * 12 + b) * 2.54;
				
				
				JOptionPane result1 = new JOptionPane("Your height is " + dformat.format(d) + " centimeters");
				JDialog output2 = result1.createDialog(null, "Your height in centimeters.");
				output2.setLocation(loc);
				output2.setSize(width, height);
				output2.isAlwaysOnTop();
				output2.setVisible(true);
				
				fi.close();
			}
		}
		
		//User chooses inches for height input
		if(value1.matches("INCHES!")){
			
			//Prompting user for conversion unit
			Object[] options2 = {"FEET!",
								"CENTIMETERS!"};
			JOptionPane box2 = new JOptionPane("Do you want to convert to FEET or CENTIMETERS?"
					, JOptionPane.PLAIN_MESSAGE
					, JOptionPane.YES_NO_OPTION
					, null
					, options2
					, "INCHES or CENTIMETERS?");
			JDialog dialog2 = box2.createDialog(null, "Units?");
			dialog2.setLocation(loc);
			dialog2.setSize(width, height);
			dialog2.isAlwaysOnTop();
			dialog2.setVisible(true);
			value2 = (String) box2.getValue();
			
			//User chose to convert to feet
			if(value2.matches("FEET!")){
				
				//prompting for height in inches
				JOptionPane input1 = new JOptionPane("Input your height in inches.");
				input1.setWantsInput(true);
				JDialog output1 = input1.createDialog(null, "Input your height");
				output1.setLocation(loc);
				output1.setSize(width, height);
				output1.isAlwaysOnTop();
				output1.setVisible(true);
				
				
				value3 = (String) input1.getInputValue();
				
				Scanner fi = new Scanner(value3);
				fi.useDelimiter(Pattern.compile("-"));
				d = fi.nextDouble();
				
				//Converting inches to feet
				e = d % 12;
				a = (int) (d / 12);
				
				
				JOptionPane result1 = new JOptionPane("Your height is " + a + " foot "
						 + e + " inches");
				JDialog output2 = result1.createDialog(null, "Your height in feet.");
				output2.setLocation(loc);
				output2.setSize(width, height);
				output2.isAlwaysOnTop();
				output2.setVisible(true);
				
				fi.close();
				
			}
			
			//User chose to convert to centimeters
			if(value2.matches("CENTIMETERS!")){
				
				//Prompting user for height in inches
				JOptionPane input1 = new JOptionPane("Input your height in inches.");
				input1.setWantsInput(true);
				JDialog output1 = input1.createDialog(null, "Input your height");
				output1.setLocation(loc);
				output1.setSize(width, height);
				output1.isAlwaysOnTop();
				output1.setVisible(true);
				
				
				value3 = (String) input1.getInputValue();
				
				Scanner fi = new Scanner(value3);
				fi.useDelimiter(Pattern.compile("-"));
				d = fi.nextDouble();
				
				//Converting inches to centimeters
				d = d * 2.54;
				
				JOptionPane result1 = new JOptionPane("Your height is " + dformat.format(d) + " centimeters");
				JDialog output2 = result1.createDialog(null, "Your height in centimeters.");
				output2.setLocation(loc);
				output2.setSize(width, height);
				output2.isAlwaysOnTop();
				output2.setVisible(true);
				
				fi.close();
			}
		}
		
		
		//User chooses centimeters for height input
		if(value1.matches("CENTIMETERS!")){
			
			//Prompting user for conversion unit
			Object[] options2 = {"FEET!",
								"INCHES!"};
			JOptionPane box2 = new JOptionPane("Do you want to convert to FEET or INCHES?"
					, JOptionPane.PLAIN_MESSAGE
					, JOptionPane.YES_NO_OPTION
					, null
					, options2
					, "INCHES or INCHES?");
			JDialog dialog2 = box2.createDialog(null, "Units?");
			dialog2.setLocation(loc);
			dialog2.setSize(width, height);
			dialog2.isAlwaysOnTop();
			dialog2.setVisible(true);
			
			value2 = (String) box2.getValue();
			
			//User chose to convert to feet
			if(value2.matches("FEET!")){
					
					//Prompting user for height in centimeters
					JOptionPane input1 = new JOptionPane("Input your height in centimeters.");
					input1.setWantsInput(true);
					JDialog output1 = input1.createDialog(null, "Input your height");
					output1.setLocation(loc);
					output1.setSize(width, height);
					output1.isAlwaysOnTop();
					output1.setVisible(true);
					
					
					value3 = (String) input1.getInputValue();
					
					Scanner fi = new Scanner(value3);
					fi.useDelimiter(Pattern.compile("-"));
					d = fi.nextDouble();
					
					//Converting centimeters to feet
					e = (d / 2.54) % 12;
					a = (int) ((d / 2.54) / 12);
					
					JOptionPane result1 = new JOptionPane("Your height is " + a + " foot "
							+ e + " inches.");
					JDialog output2 = result1.createDialog(null, "Your height in feet.");
					output2.setLocation(loc);
					output2.setSize(width, height);
					output2.isAlwaysOnTop();
					output2.setVisible(true);
					
					fi.close();
			}
			
			if(value2.matches("INCHES!")){
				
				//Prompting user for height in centimeters
				JOptionPane input1 = new JOptionPane("Input your height in centimeters.");
				input1.setWantsInput(true);
				JDialog output1 = input1.createDialog(null, "Input your height");
				output1.setLocation(loc);
				output1.setSize(width, height);
				output1.isAlwaysOnTop();
				output1.setVisible(true);
				
				
				value3 = (String) input1.getInputValue();
				
				Scanner fi = new Scanner(value3);
				fi.useDelimiter(Pattern.compile("-"));
				d = fi.nextDouble();
				
				//Converting centimeters to feet
				d = (d / 2.54);
				
				JOptionPane result1 = new JOptionPane("Your height is " + dformat.format(d) + " inches");
				JDialog output2 = result1.createDialog(null, "Your height in feet.");
				output2.setLocation(loc);
				output2.setSize(width, height);
				output2.isAlwaysOnTop();
				output2.setVisible(true);
				
				fi.close();
			}
			}
		}
	}
}
