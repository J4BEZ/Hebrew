import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//히브리어 부터 해보자
public class forAlphabet extends JPanel implements ActionListener{
	
	//스윙 컴포넌트들
	JLabel hebAlpha, hebName0, hebName, hebNum, hebProEng, hebProKor, hebVol, hebMean;
	JLabel BorderforAlpha;
	JCheckBox showLine;
	
	JTextArea hebDiscription;
	JScrollPane spForheb;
	
	//폰트 및 색깔
	Color forUnderLine = Color.decode("#A4AAA7");
	
	Font fontForHebAlp = new Font("Serif",Font.PLAIN,180);
	Font fontForSmlAlp = new Font("Serif",Font.PLAIN,30);
	
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
		
		///////////////*단어장 모드 일 경우*////////////////////////////////
		//히브리어 알파벳
		hebAlpha = new JLabel("א‬");
		hebAlpha.setFont(fontForHebAlp);
		hebAlpha.setForeground(fm.defaultColor);
		hebAlpha.setBounds(250,-20,170,195);
		//hebAlpha.setHorizontalAlignment(SwingConstants.RIGHT);
		add(hebAlpha);
		//히브리어 알파벳의 히브리어 이름
		hebName0 = new JLabel("אָלֶף");
		hebName0.setFont(fontForSmlAlp);
		hebName0.setForeground(new Color(40,40,40));
		hebName0.setBounds(280,155,100,50);
		hebName0.setHorizontalAlignment(SwingConstants.RIGHT);
		add(hebName0);
		//네모 경계선
		BorderforAlpha = new JLabel();
		BorderforAlpha.setBounds(205,5,180,200);
		BorderforAlpha.setBorder(BorderFactory.createEtchedBorder());
		add(BorderforAlpha);
		////////////////////
		//히브리어 index
		hebNum = new JLabel("1.");
		hebNum.setFont(fm.defaultFontLar);
		hebNum.setForeground(fm.defaultDark);
		hebNum.setBounds(5,15,60,40);
		add(hebNum);
		//히브리어 이름
		hebName = new JLabel("알레프(\"\'Alef\")");
		hebName.setFont(fm.defaultFontBig);
		hebName.setForeground(fm.defaultColor);
		hebName.setBounds(65,20,200,30);
		add(hebName);
		//히브리어 발음
		hebProEng = new JLabel("소리값 표기: (묵음)");
		hebProEng.setFont(fm.defaultFontBig);
		hebProEng.setForeground(fm.defaultDark);
		hebProEng.setBounds(10,65,180,30);
		add(hebProEng);
		
		hebProKor = new JLabel("한글 소리값: 초성의 'ㅇ'");
		hebProKor.setFont(fm.defaultFontBig);
		hebProKor.setForeground(fm.defaultDark);
		hebProKor.setBounds(10,95,180,30);
		add(hebProKor);
		
		//알파벳의 뜻
		hebMean = new JLabel("뜻: 황소");
		hebMean.setFont(fm.defaultFontBig);
		hebMean.setForeground(fm.defaultDark);
		hebMean.setBounds(10,130,180,30);
		add(hebMean);
		
		//히브리어 수량
		hebVol = new JLabel("수량: 1");
		hebVol.setFont(fm.defaultFontBig);
		hebVol.setForeground(fm.defaultDark);
		hebVol.setBounds(10,165,180,30);
		add(hebVol);
		
		//알파벳 관련 팁(?_?)
		hebDiscription = new JTextArea("");
		hebDiscription.setFont(fm.defaultFontNor);
		hebDiscription.setBackground(Color.WHITE);
		hebDiscription.setDisabledTextColor(new Color(40,40,40));
		hebDiscription.setDragEnabled(true);
		hebDiscription.setEditable(false);
		
		//스크롤
		spForheb = new JScrollPane(hebDiscription,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		if(fm.B!=null){
			fm.B.getContentPane().add(spForheb);
		}
		spForheb.setBounds(200,220,370,120);
		//TODO 아 뭐가 문제지 진짜
		////////////////////////////////////////////////////////////
		
		
		this.requestFocus();
		setFocusable(true);
		setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);//없으면 이상한 일 일어나요
		Graphics2D g2d = (Graphics2D)g;
		if(fm!=null) {//아 이거 왜 안돼
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
		g2d.fillRect(210, 10, 170, 190);
		g2d.setStroke(new BasicStroke(2));
		g2d.setColor(forUnderLine);
		
		if(showUnderLineBool) {
			g2d.drawLine(220, 55, 370, 55);
			g2d.drawLine(220, 100, 370, 100);
			g2d.drawLine(220, 145, 370, 145);
			//g2d.drawLine(20, 190, 170, 190);
		}
	repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
