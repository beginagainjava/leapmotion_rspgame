package Game;

import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class GameControl {

	public static int score = 0;
	
	
	
	
	LeapControl leapControl = new LeapControl();

	Random rand = new Random();
	private String[] guide = {"이겨 주십시오", "져 주십시오"};

	public Icon iconImage() {

		int rspIndex = rand.nextInt(3);
		ImageIcon[] imageArr = new ImageIcon[3];
		imageArr[0] = new ImageIcon("image\\바위.png");
		imageArr[1] = new ImageIcon("image\\가위.png");
		imageArr[2] = new ImageIcon("image\\보.png");

		return imageArr[rspIndex];
	}

	public String situation() {

		Boolean situation = rand.nextBoolean();
		int guideIndex = (situation == true) ? 0 : 1;

		return guide[guideIndex];
	}

	public static String success() {

		return "성공";
	}

	public static String fail() {

		return "실패";
	}

	public static String judgment(String guideString, String imageString ,int userInput) {

		int guideIndex = (guideString == "이겨 주십시오") ? 0 : 1;
		int rpsIndex = (imageString == "image\\바위.png" ? 0 : (imageString == "image\\가위.png") ? 2 : 5);
		Boolean result = false;

		if(guideIndex == 0) {

			switch (rpsIndex) {
			case 0:
				if(userInput == 5) {					
					result = true;
					break;
				} else {
					result = false;
					break;
				}

			case 2:
				if(userInput == 0) {					
					result = true;
					break;		
				} else {
					result = false;
					break;
				}

			case 5:
				if(userInput == 2) {
					result = true;
					break;
				} else {
					result = false;
					break;
				}
			}

		} else {
			switch (rpsIndex) {
			case 0:
				if(userInput == 2) {
					result = true;
					break;
				} else {
					result = false;
					break;
				}

			case 2:
				if(userInput == 5) {
					result = true;
					break;		
				} else {
					result = false;
					break;
				}


			case 5:
				if(userInput == 0) {
					result = true;
					break;
				} else {
					result = false;
					break;
				}

			}	

		}

		if(result) {
			return success();
		} else {
			return fail();
		}

	}
	
}
