import javax.swing.*;
import java.awt.*;
//히브리어 부터 해보자
public class forAlphabet extends JPanel{
	
	//스윙 컴포넌트들
	JLabel hebAlpha, hebName, hebPronounce, hebNum, hebMean;
	
	//폰트 및 색깔
	Color defaultColor = Color.decode("#00B992");
	Color forUnderLine = Color.decode("#A4AAA7");
	Font fontForHebAlp = new Font("Serif",Font.PLAIN,180);
	
	//클래스 저장
	quizboard B;
	forMenu fm;
	
	
	
	forAlphabet(JFrame quizBoard, JPanel forMenu){
		this.B = (quizboard)quizBoard; this.fm = (forMenu)forMenu;
		setLayout(null);
		setSize(390,355);
		this.setBorder(BorderFactory.createEtchedBorder());
		
		//히브리어 알파벳
		hebAlpha = new JLabel("ל");
		hebAlpha.setFont(fontForHebAlp);
		hebAlpha.setForeground(defaultColor);
		hebAlpha.setBounds(0,-70,170,300);
		hebAlpha.setHorizontalAlignment(SwingConstants.RIGHT);
		add(hebAlpha);
		
		
		this.requestFocus();
		setFocusable(true);
		setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(forUnderLine);
		underLine(g2d);
	}
	
	public void underLine(Graphics2D g2d) {
		g2d.drawLine(20, 15, 200, 15);
		g2d.drawLine(20, 80, 200, 80);
		g2d.drawLine(20, 145, 200, 145);
		g2d.drawLine(20, 210, 200, 210);
	}

}
