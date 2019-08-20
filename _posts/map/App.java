package com.yao.qq;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardEndHandler;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Exception {
    	Robot robot = new Robot();
    	//截屏
    	Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
    	final BufferedImage screenImg = robot.createScreenCapture(rect);
    	
    	JWindow jf = new JWindow() {
    		public void paint(Graphics g) {
    			super.paint(g);
    			g.drawImage(screenImg, 0, 0, null);
    		}
    	};
//    	jf.setDefaultCloseOperation(3);
    	jf.setSize(800, 800);
//    	jf.setVisible(true);
    	robot.keyPress(KeyEvent.VK_WINDOWS);
    	String str = "abc".toUpperCase();
//    	for(int i=0; i<str.length(); i++) {
//    		char c = str.charAt(i);
////    		System.out.println((int)c);
//    		robot.keyPress(KeyEvent.VK_CAPS_LOCK);
//    		robot.keyPress((int)c);
//    		Thread.sleep(100);
//    		
//    	}
//    	robot.keyPress(KeyEvent.vk_);
//    	robot.keyPress(KeyEvent.VK_1);
    	
//    	for(int i=0; i<20; i++) {
//    		
//    		robot.keyPress(KeyEvent.VK_1);
//    		Thread.sleep(100);
//    	}
    	
//    	for(int i=0; i<200; i++) {
//    		robot.mouseMove(200, i);
//    		Thread.sleep(100);
//    	}
    	
    	
//    	while(true) {
//    		//cmd
//    		int cmd = 1;
//    		if(cmd == 1) {
//    			
//    			robot.mouseMove(400, 400);
//    			robot.mousePress(1);
//    		}
//    		if(cmd == 2) {
//    			robot.mouseMove(500, 700);
//    			robot.mousePress(3);
//    		}
//    		robot.keyPress(KeyEvent.VK_1);
//    	}
    	
//    	Thread.sleep(1000);
    	
//    	Graphics g = jf.getGraphics();
//    	g.drawImage(screenImg, 0, 0, null);
    }
}
