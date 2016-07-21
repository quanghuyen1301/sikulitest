import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.sikuli.api.*;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;
import static org.sikuli.api.API.*;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class robot {
	public static String PathImageSeach ;
	public static ScreenRegion s;
	public static URL imageURL;
	public static Target imageTarget;
	public static  ScreenRegion r;
	public static void main(String[] args) throws InterruptedException, IOException  {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48


		String SeachImage = "/hello.png";
		ALT_TAB(robot);
		int timeout = 10;
        do{
            	timeout --;
            s = new DesktopScreenRegion();
        	imageURL = new URL(PathURL(SeachImage)); 
        	
        	imageTarget = new ImageTarget(imageURL);
	        r = s.wait(imageTarget,0);
	       
		        if(r==null){
		        	debug("Seach "+SeachImage+"Not found\n");
		        }else{
			        int pointx = r.getCenter().getX();
			        int pointy = r.getCenter().getY();
			        System.out.println("x,y = " + pointx +" "+pointy);    
			        click(robot,pointx,pointy);
			        typeCharacter(robot,dateFormat.format(date)+" "+dateFormat.format(date)+" "+dateFormat.format(date)+" "+dateFormat.format(date)+" "+dateFormat.format(date));
			        
			        Canvas canvas = new DesktopCanvas();
			        canvas.addLabel(r, SeachImage).display(5);
		        }
		        Thread.sleep(100);
		        System.out.println("" + Runtime.getRuntime().freeMemory());
		        if(timeout == 0)
		        	break;
		        System.gc();
        } while(r ==null);


		SeachImage = "/send.png";
        timeout = 10;
        do{
            	timeout --;
            s = new DesktopScreenRegion();
        	imageURL = new URL(PathURL(SeachImage)); 
        	
        	imageTarget = new ImageTarget(imageURL);
	        r = s.wait(imageTarget,0);
	       
		        if(r==null){
		        	debug("Seach "+SeachImage+"Not found\n");
		        }else{
			        int pointx = r.getCenter().getX();
			        int pointy = r.getCenter().getY();
			        System.out.println("x,y = " + pointx +" "+pointy);    
			        click(robot,pointx,pointy);
			        typeCharacter(robot,SeachImage);
			        
			        Canvas canvas = new DesktopCanvas();
			        canvas.addLabel(r, SeachImage).display(5);
		        }
		        Thread.sleep(100);
		        System.out.println("" + Runtime.getRuntime().freeMemory());
		        if(timeout == 0)
		        	break;
		        System.gc();
        } while(r ==null);




        CTRL_L(robot);
        typeCharacterEnter(robot,"www.facebook.com/khai.tuan.7");
        BufferedImage image = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", new File("screenshot.png"));


	}
 
	

	public static void ChromePrivateMode(Robot robot)
	{
		int delay = 10;
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_N);robot.delay(delay);
		robot.keyRelease(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_SHIFT);
	}
	public static String PathURL(String str)
	{
		return "file:///" + System.getProperty("user.dir").replace('\\', '/') +str;
	}
	public static void debug(String str)
	{
		System.out.println(str);
	}
	public static void ALT_TAB(Robot robot)
	{

	          robot.keyPress(KeyEvent.VK_ALT);
	          robot.delay(100);
			  robot.keyPress(KeyEvent.VK_TAB);
			  robot.delay(100);
			  robot.keyRelease(KeyEvent.VK_TAB);
			  robot.delay(100);
			  robot.delay(100);
	          robot.keyRelease(KeyEvent.VK_ALT);
			  
	}

	public static void CTRL_L(Robot robot)
	{

	          robot.keyPress(KeyEvent.VK_CONTROL);
			  robot.keyPress(KeyEvent.VK_L);
			  robot.delay(100);
			  robot.keyRelease(KeyEvent.VK_L);
	          robot.keyRelease(KeyEvent.VK_CONTROL);
			  
	}

	public static void ALT_F4(Robot robot)
	{

	          robot.keyPress(KeyEvent.VK_ALT);
	          robot.delay(100);
			  robot.keyPress(KeyEvent.VK_F4);
			  robot.delay(100);
			  robot.keyRelease(KeyEvent.VK_F4);
			  robot.delay(100);
			  robot.delay(100);
	          robot.keyRelease(KeyEvent.VK_ALT);
			  
	}
	public static void mouseMove(Robot robot, int x ,int y)
	{
			   robot.mouseMove( x,  y);
	}
	public static void click(Robot robot, int x ,int y)
	{
		mouseMove(robot,x,y);
		click(robot);
	}
	public static void click(Robot robot)
	{
	           robot.mousePress(InputEvent.BUTTON1_MASK);
	           robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	public static void typeCharacterEnter(Robot robot, String letter)
    {
		int delay = 10;
		typeCharacter(robot,letter);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(delay);
        robot.keyRelease(KeyEvent.VK_ENTER );
		
    }
	public static void typeCharacter(Robot robot, String letter)
	      {
		int delay = 10;
		if(letter.endsWith("null"))
		{			
			return;
		}
	     for(int i=0;i<letter.length();i++){
	      try
	      {
	          boolean upperCase = Character.isUpperCase( letter.charAt(i) );
	          String KeyVal=Character.toString(letter.charAt(i));
	          if(KeyVal.endsWith(".")){
		          robot.keyPress(KeyEvent.VK_PERIOD);
		          robot.delay(delay);
		          robot.keyRelease(KeyEvent.VK_PERIOD );
		          continue;
	          }
	          if(KeyVal.endsWith("@")){
		  		robot.keyPress(KeyEvent.VK_SHIFT);robot.delay(delay);
				robot.keyPress(KeyEvent.VK_2);robot.delay(delay);
				robot.keyRelease(KeyEvent.VK_2);robot.delay(delay);
				robot.keyRelease(KeyEvent.VK_SHIFT);robot.delay(delay);
		          continue;
	          }
	          if(KeyVal.endsWith(" ")){
		  		robot.keyPress(KeyEvent.VK_SPACE); 
				robot.keyRelease(KeyEvent.VK_SPACE); 
		          continue;
	          }	          
	          if(KeyVal.endsWith(":")){
				robot.keyPress(KeyEvent.VK_COLON);robot.delay(delay);
				robot.keyRelease(KeyEvent.VK_COLON);robot.delay(delay);
		          continue;
	          }
	          if(KeyVal.endsWith("/")){
				robot.keyPress(KeyEvent.VK_DIVIDE);robot.delay(delay);
				robot.keyRelease(KeyEvent.VK_DIVIDE);robot.delay(delay);
		          continue;
	          }
	          if(KeyVal.endsWith("-")){
				robot.keyPress(KeyEvent.VK_MINUS);robot.delay(delay);
				robot.keyRelease(KeyEvent.VK_MINUS);robot.delay(delay);
		          continue;
	          }
	          String variableName = "VK_" + KeyVal.toUpperCase();
	          Class clazz = KeyEvent.class;
	          Field field = clazz.getField( variableName );
	          int keyCode = field.getInt(null);

	          robot.delay(delay);

	          if (upperCase) robot.keyPress( KeyEvent.VK_SHIFT );

	          robot.keyPress( keyCode );
	          robot.keyRelease( keyCode );

	          if (upperCase) robot.keyRelease( KeyEvent.VK_SHIFT );
	      }
	      catch(Exception e)
	      {
	          System.out.println(e);
	      }
	      }

	  }
}
