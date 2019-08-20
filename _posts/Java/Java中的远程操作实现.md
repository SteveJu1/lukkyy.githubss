## Java中的远程操作实现

```java
package Robot_190721;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardEndHandler;

public class App {
    public static void main( String[] args ) throws Exception {
    	Robot robot = new Robot();
    	Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());//截屏
    	final BufferedImage screenImg = robot.createScreenCapture(rect);
    	
    	JFrame jf = new JFrame() {
    		public void paint(Graphics g) {
    			super.paint(g);
    			g.drawImage(screenImg, 0, 0, null);
    		}
    	};
    	jf.setSize(800, 800);  
    	jf.setVisible(true);

    // 	mouseMove 鼠标的输入
    	for(int i=0; i<20; i++) {
    		robot.mouseMove(200, i*50);
    		Thread.sleep(100);
    	}
    	
        // 	KeyEvent 键盘的输入	
    	robot.keyPress(KeyEvent.VK_WINDOWS);
    	String str = "abc";
    	for(int i=0; i<str.length(); i++) {
    		char c = str.charAt(i);
    		System.out.println((int)c);
//    		robot.keyPress(KeyEvent.VK_CAPS_LOCK);
    		robot.keyPress((int)c);
    		Thread.sleep(100);		
    	}
  	
    	for(int i=0; i<20; i++) {		
    		robot.keyPress(KeyEvent.VK_1);
    		Thread.sleep(100);    //按键需要加时间
    	}
//    	
//    	while(true) {
//    		//cmd
//    		int cmd = 1;
//    		if(cmd == 1) {		
//    		}
//    		if(cmd == 2) {
//    			robot.mouseMove(500, 700);
//    			robot.mousePress(3);
//    		}
//    		robot.keyPress(KeyEvent.VK_1);
//    	}
    	
    	
//    	Graphics g = jf.getGraphics();
//    	g.drawImage(screenImg, 0, 0, null);
    }
}

```

