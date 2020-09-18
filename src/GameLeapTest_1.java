import java.io.IOException;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.FingerList;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.HandList;
import com.leapmotion.leap.Image;
import com.leapmotion.leap.ImageList;
import com.leapmotion.leap.Listener;

public class GameLeapTest_1 extends Listener {

	public void onInit(Controller controller) {
		System.out.println("Initialized");
	}

	public void onConnect(Controller controller) {
		System.out.println("Connected");
		controller.enableGesture(Gesture.Type.TYPE_SWIPE);
		controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
		controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
		controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
	}

	public void onDisconnect(Controller controller) {
		//Note: not dispatched when running in a debugger.
		System.out.println("Disconnected");
	}

	public void onExit(Controller controller) {
		System.out.println("Exited");
	}
	
    public void onFrame(Controller controller) 
    {
    	Frame frame = controller.frame();
    	HandList hands = frame.hands();
    	FingerList fingerlist = frame.fingers();
    	
    	//	손 존재여부
    	boolean handIsEmpty = hands.isEmpty();
    	
    	//	해당 손가락을 펴고 있는지 여부
    	boolean thumb_extended = fingerlist.fingerType(Finger.Type.TYPE_THUMB).get(0).isExtended();
    	boolean index_extended = fingerlist.fingerType(Finger.Type.TYPE_INDEX).get(0).isExtended();
    	boolean middle_extended = fingerlist.fingerType(Finger.Type.TYPE_MIDDLE).get(0).isExtended();
    	boolean ring_extended = fingerlist.fingerType(Finger.Type.TYPE_RING).get(0).isExtended();
    	boolean pinky_extended = fingerlist.fingerType(Finger.Type.TYPE_PINKY).get(0).isExtended();
    	
    	//	펴고 있는 손가락의 개수
    	int fingerCount = fingerlist.extended().count();
    	int userInput = 999; // 나중엔 onframe 밖으로 빼내야 값이 변할듯
    	
    	if(fingerCount == 5) {
    		//	유저입력 "보"
    		userInput = 5;
    		
    	} else if(fingerCount == 0) {
    		//	유저입력 "바위"
    		if(handIsEmpty == true) {
    			userInput = 999;
    		} else {
    			userInput = 0;    			
    		}
    		
    	} else if(fingerCount == 2) {
    		if(thumb_extended && index_extended || 
    				index_extended && middle_extended || 
    				middle_extended && ring_extended ||
    				ring_extended && pinky_extended) {
    		
    			//	유저입력 "가위"
    			userInput = 2;
    			
    		} else {
    			//	해당사항 없음 default로 다음으로 넘어가지 않게한다.
    			userInput = 999;
    			
    		}
    		
    	} else {
    		//	해당사항 없음 default로 다음으로 넘어가지 않게한다.
    		userInput = 999;
    		
    	}
    	
//    	 if(frame.isValid()){
//    		   ImageList images = frame.images();
//    		   for(Image image : images)
//    		   {
//    		     //Processing PImage class
//    		     PImage camera = cameras[image.id()];
//    		     camera = createImage(image.width(), image.height(), RGB);
//    		     camera.loadPixels();
//    		     
//    		     //Get byte array containing the image data from Image object
//    		     byte[] imageData = image.data();
//
//    		     //Copy image data into display object, in this case PImage defined in Processing
//    		     for(int i = 0; i < image.width() * image.height(); i++){
//    		       r = (imageData[i] & 0xFF) << 16; //convert to unsigned and shift into place
//    		       g = (imageData[i] & 0xFF) << 8;
//    		       b = imageData[i] & 0xFF;
//    		       camera.pixels[i] =  r | g | b; 
//    		     }
//    		     
//    		     //Show the image
//    		     camera.updatePixels();
//    		     image(camera, 640 * image.id(), 0);  
//    		   }
//    		} 
    	
    	System.out.println("fingerCount = " +fingerCount + " || HandIsEmpty = " +handIsEmpty);
    	System.out.println(userInput);
    	
    	
    	
    	
    	
    }



	public static void main(String[] args) {

		// Create a sample listener and controller
		GameLeapTest_1 listener = new GameLeapTest_1();
		Controller controller = new Controller();

		// Have the sample listener receive events from the controller
		controller.addListener(listener);

		// Keep this process running until Enter is pressed
		System.out.println("Press Enter to quit...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Remove the sample listener when done
		controller.removeListener(listener);
	}


}
