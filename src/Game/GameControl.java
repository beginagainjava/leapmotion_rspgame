package Game;

import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class GameControl {

	public static int score = 0;
	
	
	
	
	LeapControl leapControl = new LeapControl();

	Random rand = new Random();
	private String[] guide = {"�̰� �ֽʽÿ�", "�� �ֽʽÿ�"};

	public Icon iconImage() {

		int rspIndex = rand.nextInt(3);
		ImageIcon[] imageArr = new ImageIcon[3];
		imageArr[0] = new ImageIcon("image\\����.png");
		imageArr[1] = new ImageIcon("image\\����.png");
		imageArr[2] = new ImageIcon("image\\��.png");

		return imageArr[rspIndex];
	}

	public String situation() {

		Boolean situation = rand.nextBoolean();
		int guideIndex = (situation == true) ? 0 : 1;

		return guide[guideIndex];
	}

	public static String success() {

		return "����";
	}

	public static String fail() {

		return "����";
	}

	public static String judgment(String guideString, String imageString ,int userInput) {

		int guideIndex = (guideString == "�̰� �ֽʽÿ�") ? 0 : 1;
		int rpsIndex = (imageString == "image\\����.png" ? 0 : (imageString == "image\\����.png") ? 2 : 5);
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
