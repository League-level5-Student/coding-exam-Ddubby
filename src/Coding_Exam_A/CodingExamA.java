package Coding_Exam_A;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {

	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		String num = JOptionPane.showInputDialog("How many robots?");
		String color = JOptionPane.showInputDialog("Which color? (Red, Green, Blue)");
		String side = JOptionPane.showInputDialog("How many sides? (<0)");

		Thread[] robots = new Thread[Integer.parseInt(num)];
		for (int i = 0; i < robots.length; i++) {
			int x = i;
			robots[i] = new Thread(()->{
				Robot r = new Robot();
				if (color.equals("Red")) {
					r.setPenColor(Color.red);
				} else if (color.contentEquals("Green")) {
					r.setPenColor(Color.green);
				} else {
					r.setPenColor(Color.blue);
				}
				r.penDown();
				r.setSpeed(10);
				r.moveTo(100 + x*100, 100);
				for (int j = 0; j < Integer.parseInt(side); j++) {
					r.turn(360/Integer.parseInt(side));
					r.move(50);
				}

			});
		}
		
		for (int i = 0; i < robots.length; i++) {
			robots[i].start();
		}
		
		
	}

	
}
