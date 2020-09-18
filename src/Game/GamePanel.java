package Game;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePanel extends JFrame {
	
	GameControl gc = new GameControl();

	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	
	JLabel resultLabel = new JLabel("결과");
	private JLabel guideLabel = new JLabel(gc.situation());
	JTextField answer = new JTextField(10);
	private JLabel scoreLabel = new JLabel(String.valueOf(GameControl.score));
	private JLabel imageLabel = new JLabel(gc.iconImage());
	
	private String userString = answer.getText();
	private String guideString = guideLabel.getText();
	private String imageString = imageLabel.getIcon().toString();
	private String resultString = resultLabel.getText();
	
	
	public String getUserString() {
		return this.userString;
	}
	
	public String getGuideString() {
		return this.guideString;
	}
	
	public String getImageString() {
		return this.imageString;
	}
	
	public String getResultString() {
		return this.resultString;
	}
	
	public void setUserString(String userString) {
		this.answer.setText(userString);
	}
	
	public void setGuideString(String guideString) {
		this.guideLabel.setText(guideString);
	}
	
	public void setImageString(Icon imageIcon) {
		this.imageLabel.setIcon(imageIcon);
	}
	
	public void setResultString(String resultString) {
		this.resultLabel.setText(resultString);
	}
	
	public void setScoreLabel(String score) {
		this.scoreLabel.setText(score);
	}
	
	public GamePanel() {
    	
		this.setTitle("가위바위보");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		guideLabel.setFont(guideLabel.getFont().deriveFont(30.0f));
		
		
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.add(guideLabel);
		panel1.add(imageLabel);
		scoreLabel.setFont(scoreLabel.getFont().deriveFont(30.0f));
		resultLabel.setFont(resultLabel.getFont().deriveFont(30.0f));
		
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel2.add(scoreLabel);
		panel2.add(answer);
		answer.setFont(answer.getFont().deriveFont(50.0f));
		panel2.add(resultLabel);

		
		//왼쪽 오른쪽 합 panel
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
		panel3.add(panel1);
		panel3.add(panel2);
		add(panel3, BorderLayout.CENTER);
		
		setGuideString(gc.situation());
		setScoreLabel(String.valueOf(GameControl.score));
		setImageString(gc.iconImage());
		

		pack();
		setResizable(false);
		setVisible(true);
	}
	
}
