/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hw1_134831;

/**
 * Name: Al Ruheil Mohammed Ali Al Ruheili
 * ID: 134831
 * 
 * pseudo-code:
 *  input: number of table lines
 *  output: a table showing off the line number, first point, second point, distance between then and the equation of the function
 *  
 *      steps:
 *          -importing Point2D.Double (we want points with double values), Random, and Scanner
 *          -initializing a boolean variable to control the loop
 *          -creating a scanner object to get an input from user
 *          -creating a do loop (makes our program run at least once [runs again if the input is negative])
 *          -displaying a prompt message to get the input
 *              -if the input does not contain an integer [print an error message, then quit the loop]
 *              -if the input has an integer, check weather its positive or negative
 *                  -if negative decline it, then loop again
 *                  -if positive create objects of type Random and Point2D.Double
 *          -print a header for the table, then print lines based of user input
 *          -randomize the first and second points from 0 to 100 
 *          -initialize a double value [m] to represent slope: m = [y2 - y1] / [x2 - x1]
 *          -initialize a double value [b], b = y - [m]x
 *          -initialize an equation variable with type string to store the final equation as a string
 *              -if the points has similar x values, equation is x = x1
 *              -if the points has similar y values, equation is y = y1
 *              -else: the equation is: y = [m]x + [b]
 *          -print the table line by line
 *          -
 *          -
 *          -
 * 
 * 
 *  
 */

 //importing Point2D.Double, Random, and Scanner
import java.awt.geom.Point2D.Double;
import java.util.Random;
import java.util.Scanner;

public class HW1_134831 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean positiveInt = true; //initializing a boolean variable to control the loop
        Scanner input = new Scanner(System.in); //creating a scanner object to get an input from user
        
        //creating a do loop (makes our program run at least once)
        do{
            //displaying a prompt message to get the input
            System.out.print("Please enter how many lines you want to generate: ");
            
            //if the input does not contain an integer
            if(!input.hasNextInt()){
                //print an error message
                System.out.println("Error: It is not integer value...Exit");
                break; //quit the loop
                
            }else{ //if the input has an integer
                int lines =  input.nextInt(); //defines the input from the user as integer

                //check weather its positive or negative
                if(lines <= 0){ //if negative decline it
                    System.out.println("Error: Enter integer value > 0... Try Again!");
                    positiveInt = false; //then loop again

                }else{ //if positive
                    //create objects of type Random and Point2D.Double
                    Random rnd = new Random();
                    Double first = new Double();
                    Double second = new Double();
                    
                    //print a header for the table
                    System.out.printf("%-20s%-40s%-40s%-20s%-20s", "Line No.", "P1(x1,y1)", "P2(x2, y2)", "Distance", "Line Equation");
                    System.out.println("");
                    for(int i = 0; i < 140; i++)
                        System.out.print("*");
                        
                    System.out.println("");

                    //print lines based of user input
                    for(int i = 1; i <= lines; i++){
                        //randomize the first and second points from 0 to 100 
                        first.setLocation(rnd.nextDouble(100), rnd.nextDouble(100));
                        second.setLocation(rnd.nextDouble(100), rnd.nextDouble(100));

                        //intialize a double value [m] to represent slope: m = [y2 - y1] / [x2 - x1]
                        double m = (second.getY() - first.getY()) / (second.getX() - first.getX());
                        //intialize a double value [b], b = y - [m]x
                        double b = first.getY() - m * first.getX();

                        String equation; //intialize an equation variable with type string to store the final equation as a string
                        //if the points has similar x values, equation is x = x1
                        if(first.getX() == second.getX()){
                            equation = String.format("x = " + first.getX());
                            
                        //if the points has similar y values, equation is y = y1    
                        }else if(first.getY() == second.getY()){
                            equation = String.format("y = " + first.getY());;

                        }else{ //any condition else: the equation is: y = [m]x + [b]
                            if(b > 0){
                                equation = String.format("%s%2.2f%s%s%2.2f","y = " ,m ,"x" ," + " ,b);
                            }else{
                                equation = String.format("%s%2.2f%s%s%2.2f","y = " ,m ,"x" ," - " ,Math.abs(b));
                            }
                            
                        }
                        
                        
                        //print the table line by line
                        String pointOne = String.format("%s%2.2f%s%2.2f%s", "P1(", first.getX(), ", ", first.getY(), ")");
                        String pointTwo = String.format("%s%2.2f%s%2.2f%s", "P2(", second.getX(), ", ", second.getY(), ")");
                        System.out.printf("%-20d%-40s%-40s%-20.2f%-20s", i, pointOne, pointTwo, first.distance(second), equation);
                        System.out.println("");
                    }
                    
                    break;
                }
            }
        }while(!positiveInt); //runs again if the input is negative
        
        
        
    }
    
}
