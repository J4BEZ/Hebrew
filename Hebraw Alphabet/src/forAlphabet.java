import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//히브리어 부터 해보자
public class forAlphabet extends JPanel implements ActionListener{
	
	//스윙 컴포넌트들
	JLabel menuIntro, Biblekor;
	
	JLabel hebAlpha, hebName0, hebName, hebNum, hebProEng, hebProKor, hebVol, hebMean;
	JLabel BorderforAlpha;
	
	JLabel nickname;

	JCheckBox showLine;
	
	JTextPane hebDiscription, progDiscription;
	JScrollPane spForheb, spForprog;
	
	
	BufferedImage logo = null;
		
	//폰트 및 색깔
	Color forUnderLine = Color.decode("#A4AAA7");
	
	Font fontForHebAlp = new Font("Serif",Font.PLAIN,180);
	Font fontForSmlAlp = new Font("Serif",Font.PLAIN,30);
	
	//기타 배열 등
	boolean showUnderLineBool = false;
	String programInform;
	
	//클래스 저장
	quizboard B;
	forMenu fm;
	
	
	forAlphabet(JFrame quizBoard, JPanel forMenu){
		this.B = (quizboard)quizBoard; this.fm = (forMenu)forMenu;
		setLayout(null);
		setSize(390,355);
		this.setBorder(BorderFactory.createEtchedBorder());
		
		forMainMenu();
		forWordMode();
		programInform();
		
		this.requestFocus();
		setFocusable(true);
		setVisible(true);
	}
	
	public void forMainMenu() {
		menuIntro = new JLabel("<html><center>환영합니다 :D</center></html>");
		menuIntro.setFont(fm.defaultFontLar);
		menuIntro.setForeground(fm.defaultColor);
		menuIntro.setBounds(120,60,390,60);
		add(menuIntro);
		

		
		//개꿀팁! JLabel 줄 바꿈은 HTML로 가능
		Biblekor = new JLabel();
		Biblekor.setFont(fm.defaultFontBig);
		Biblekor.setHorizontalAlignment(SwingConstants.CENTER);
		Biblekor.setVerticalAlignment(SwingConstants.CENTER);
		Biblekor.setForeground(fm.defaultDark);
		Biblekor.setBounds(10,120,370,200);
		add(Biblekor);
		
	
	}
	
	public void forWordMode() {
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
	
	/////////////////////////////////////////////////////////////
	//알파벳 관련 정보를 저장해두는 텍스트 영역(?_?)
	hebDiscription = new JTextPane();//TODO
	hebDiscription.setText("테스트\n\n\n\n\n\n\n");
	hebDiscription.setFont(fm.defaultFontNor);
	hebDiscription.setBackground(Color.WHITE);
	hebDiscription.setDisabledTextColor(new Color(40,40,40));
	hebDiscription.setDragEnabled(true);
	hebDiscription.setEditable(false);

	//텍스트 영역에 스크롤 바 달기
	spForheb = new JScrollPane(hebDiscription,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	B.getContentPane().add(spForheb);
	spForheb.setBounds(190,220,390,140);
	////////////////////////////////////////////////////////////
	hebAlpha.setVisible(false);
	hebName0.setVisible(false);
	BorderforAlpha.setVisible(false);
	hebNum.setVisible(false);
	hebName.setVisible(false);
	hebProEng.setVisible(false);
	hebProKor.setVisible(false);
	hebMean.setVisible(false);
	hebVol.setVisible(false);
	spForheb.setVisible(false);
	////////////////////////////////////////////////////////////
	}
	
	public void programInform() {
		try {
			logo = ImageIO.read(new File("logo.png"));
		}catch(IOException e) {
			System.out.println("오류:: 로고이미지가 분실되었습니다.");
		}
		//닉네임 레이블
		nickname = new JLabel("J4BEZ");
		nickname.setFont(fm.defaultFontLar);
		nickname.setForeground(fm.defaultColor);
		nickname.setBounds(80,155,100,50);
		add(nickname);
		
		//프로그램 정보
		//TODO 여기 부분 JTextPane이용해서 글자체 변경 등 넣기
		programInform = "<프로그램 정보>\n네 재물과 네 소산물의 처음 익은 열매로 여호와를 공경하라(잠언 3:9)"
				+ "\n자바를 공부하고나서\n가장 처음으로 다듬어보는 프로그램을\n하나님께 드립니다"
				+ "\n신학을 공부하시는 학우분들이나\n히브리어 공부를 하시는 분들께\n조금이라도 도움이 되길 바래요:D";
		progDiscription = new JTextPane();
		progDiscription.setText(programInform);
		progDiscription.setFont(fm.defaultFontNor);
		progDiscription.setBackground(new Color(40,40,40));
		progDiscription.setForeground(fm.defaultColor);
		progDiscription.setDragEnabled(true);
		progDiscription.setEditable(false);
		
		spForprog = new JScrollPane(progDiscription,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		B.getContentPane().add(spForprog);
		spForprog.setBounds(360,8,220,352);
		
		nickname.setVisible(false);
		spForprog.setVisible(false);
	}
	
	
	
	public void changeMode(forMenu fm) {
		if(fm!=null)
			switch(fm.mode){
			case modeSelect:
				////////메뉴 인트로 관련///////////
				menuIntro.setVisible(true);
				Biblekor.setVisible(true);
				/////////////////////////////				
				
				////단어장 &퀴즈 관련/////
				hebAlpha.setVisible(false);
				hebName0.setVisible(false);
				BorderforAlpha.setVisible(false);
				hebNum.setVisible(false);
				hebName.setVisible(false);
				hebProEng.setVisible(false);
				hebProKor.setVisible(false);
				hebMean.setVisible(false);
				hebVol.setVisible(false);
				spForheb.setVisible(false);
				////////////////////
				
				///////프로그램 정보관련/////////////
				nickname.setVisible(false);
				spForprog.setVisible(false);
				///////////////////////////////
			break;
			
			case consonant:
			case vowel:
				////////메뉴 인트로 관련///////////
				menuIntro.setVisible(false);
				Biblekor.setVisible(false);
				/////////////////////////////
				///////프로그램 정보관련/////////////
				nickname.setVisible(false);
				spForprog.setVisible(false);
				///////////////////////////////
				if(fm.quizOrNote) {
					hebAlpha.setVisible(false);
					hebName0.setVisible(false);
					BorderforAlpha.setVisible(false);
					hebNum.setVisible(false);
					hebName.setVisible(false);
					hebProEng.setVisible(false);
					hebProKor.setVisible(false);
					hebMean.setVisible(false);
					hebVol.setVisible(false);
					spForheb.setVisible(false);
				}
				else {
				hebAlpha.setVisible(true);
				hebName0.setVisible(true);
				BorderforAlpha.setVisible(true);
				hebNum.setVisible(true);
				hebName.setVisible(true);
				hebProEng.setVisible(true);
				hebProKor.setVisible(true);
				hebMean.setVisible(true);
				hebVol.setVisible(true);
				spForheb.setVisible(true);
					
				}
			break;
			
			case programINF:
			////////메뉴 인트로 관련///////////
			menuIntro.setVisible(false);
			Biblekor.setVisible(false);
			/////////////////////////////
			////단어장 &퀴즈 관련/////
			hebAlpha.setVisible(false);
			hebName0.setVisible(false);
			BorderforAlpha.setVisible(false);
			hebNum.setVisible(false);
			hebName.setVisible(false);
			hebProEng.setVisible(false);
			hebProKor.setVisible(false);
			hebMean.setVisible(false);
			hebVol.setVisible(false);
			spForheb.setVisible(false);
			////////////////////
			///////프로그램 정보관련/////////////
			nickname.setVisible(true);
			spForprog.setVisible(true);
			///////////////////////////////
			break;
			
			
			default:
				System.out.println("에러: 등록되지 않은 모드입니다");
				break;
		}
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);//없으면 이상한 일 일어나요
		Graphics2D g2d = (Graphics2D)g;
		if(fm!=null) {
			switch(fm.mode) {
			case modeSelect:
				this.setSize(390,355);
				break;
			case consonant://흰네모와 밑줄은 자음/모음 일 경우에만 표시됩니다.
			case vowel://(이 외의 다른 레이블들도 모드에따라 나타나거나 안보이도록 설정할거에요)
				if(!fm.quizOrNote) {
					this.setSize(390,210);
					underLine(g2d);
				}
				else {
					this.setSize(390,355);
				}
				break;
			case programINF:
				this.setSize(160,200);
				g2d.setColor(forUnderLine);
				g2d.setStroke(new BasicStroke(3));
				g2d.setColor(Color.white);
				g2d.fillRect(0, 0, 160, 200);
				g2d.drawImage(logo, 5, 5, 155, 155, 0, 0, 150, 150, this);
				break;
			default:
				break;
			}
		}
		repaint();
	}
	
	
	public void underLine(Graphics2D g2d) {
		//흰 네모를 만들구요
		g2d.setColor(Color.WHITE);
		g2d.fillRect(210, 10, 170, 190);
		g2d.setStroke(new BasicStroke(2));
		g2d.setColor(forUnderLine);
		
		if(showUnderLineBool) {//밑줄 표시를 할경우 밑줄을 그려줘요
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
