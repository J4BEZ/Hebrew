import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//히브리어 부터 해보자
public class forAlphabet extends JPanel implements ActionListener{
	
	//스윙 컴포넌트들
	JLabel hebAlpha, hebName, hebPronounce, hebNum, hebMean;
	JLabel BorderforAlpha;
	JCheckBox showLine;
	
	//폰트 및 색깔
	Color defaultColor = Color.decode("#00B992");
	Color forUnderLine = Color.decode("#A4AAA7");
	Font fontForHebAlp = new Font("Serif",Font.PLAIN,180);
	
	//기타 배열 등
	boolean showUnderLineBool = false;
	
	//클래스 저장
	quizboard B;
	forMenu fm;
	
	
	forAlphabet(JFrame quizBoard, JPanel forMenu){
		this.B = (quizboard)quizBoard; this.fm = (forMenu)forMenu;
		setLayout(null);
		setSize(390,355);
		this.setBorder(BorderFactory.createEtchedBorder());
		
		////////////////////////////////////////////////////////////
		//히브리어 알파벳
		hebAlpha = new JLabel("ל");
		hebAlpha.setFont(fontForHebAlp);
		hebAlpha.setForeground(defaultColor);
		hebAlpha.setBounds(50,-15,170,190);
		//hebAlpha.setHorizontalAlignment(SwingConstants.RIGHT);
		add(hebAlpha);
		
		BorderforAlpha = new JLabel();
		BorderforAlpha.setBounds(5,5,180,200);
		BorderforAlpha.setBorder(BorderFactory.createEtchedBorder());
		add(BorderforAlpha);
		////////////////////////////////////////////////////////////
		
		
		this.requestFocus();
		setFocusable(true);
		setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);//없으면 이상한 일 일어나요
		Graphics2D g2d = (Graphics2D)g;
		if(fm!=null) {//아 이거 왜 안되지
			switch(fm.mode) {
			case modeSelect:
				break;
			case consonant:
			case vowel:
				underLine(g2d);
				break;
			case programINF:
				break;
			default:
				break;
			
			}
		}
		repaint();
	}
	
	public void underLine(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);
		g2d.fillRect(10, 10, 170, 190);
		g2d.setStroke(new BasicStroke(2));
		g2d.setColor(forUnderLine);
		
		if(showUnderLineBool) {
			g2d.drawLine(20, 55, 170, 55);
			g2d.drawLine(20, 100, 170, 100);
			g2d.drawLine(20, 145, 170, 145);
			g2d.drawLine(20, 190, 170, 190);
		}
	repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
