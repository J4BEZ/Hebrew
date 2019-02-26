import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


enum menuMode{
	modeSelect, consonant, vowel, programINF
}

public class forMenu extends JPanel implements ActionListener{
	//스윙 컴포넌트들
	JLabel type, thumbnail;
	
	JComboBox menuList;
	JButton nextQuiz, submit, nextWord, prevWord;
	JRadioButton wordNote, quiz;
	
	JCheckBox showUnderLine;
	
	JTextArea incTitle, incorrectList;
	JTextField submitArea;
	JScrollPane spForIL;
	
	ButtonGroup bGroup;
	
	//기본타입 변수들
	String[] menubar = {"모드를 선택해주세요","자음","모음","프로그램 정보"};
	String wrongList = "";
	
	Color defaultColor = Color.decode("#00B992");
	Color defaultDark = new Color(40,40,40);
	Font defaultFontLar = new Font("나눔바른펜",Font.BOLD,30);
	Font defaultFontBig = new Font("나눔바른펜",Font.BOLD,20);
	Font defaultFontNor = new Font("나눔바른펜",Font.BOLD,15);
	Font defaultFontSma = new Font("나눔바른펜",Font.BOLD,10);
	
	boolean quizOrNote;
	
	//클래스 저장
	quizboard B; forAlphabet fa;
	
	//이넘
	menuMode mode;
	
	forMenu(JFrame quizBoard){
		mode = menuMode.modeSelect;
	}
	
	forMenu(JFrame quizBoard,JPanel forAlphabet){
		this.B = (quizboard)quizBoard;
		this.fa = (forAlphabet)forAlphabet;
		fa.fm = this;//동기화 
		
		mode = menuMode.modeSelect;
		setLayout(null);
		setSize(180,355);
		this.setBorder(BorderFactory.createEtchedBorder());
		
		//메뉴
		menuList = new JComboBox(menubar);
		menuList.setSelectedIndex(0);
		menuList.setBounds(5,5,170,30);
		menuList.setBackground(defaultColor);
		menuList.setForeground(Color.WHITE);
		menuList.setFont(defaultFontBig);
		menuList.addActionListener(this);
		add(menuList);
		
		//썸네일
		thumbnail = new JLabel("יַעְבֵּץ");
		thumbnail.setFont(new Font("Serif",Font.BOLD,30));
		thumbnail.setForeground(defaultColor);
		thumbnail.setBounds(5,300,170,50);
		thumbnail.setVisible(true);
		add(thumbnail);

		//퀴즈 on, off 모드
		wordNote = new JRadioButton("단어장");
		wordNote.setBounds(5,45,70,30);
		wordNote.setFont(defaultFontNor);
		wordNote.addActionListener(this);
		wordNote.setSelected(true);
		wordNote.setVisible(false);
		add(wordNote);
		
		quiz = new JRadioButton("퀴즈");
		quiz.setBounds(80,45,70,30);
		quiz.setFont(defaultFontNor);
		quiz.addActionListener(this);
		quiz.setSelected(false);
		quiz.setVisible(false);
		add(quiz);
		
		bGroup = new ButtonGroup();
		bGroup.add(quiz);bGroup.add(wordNote);
		
		//quizmode
		forQuiz();
		forNote();
		
		this.requestFocus();
		setFocusable(true);
		setVisible(true);
	}
	
	
	//단어장 모드
	public void forNote() {
		//TODO 이전단어 다음단어 버튼만 만들면 될듯?
		//TODO 그 담에 모드에따라 보일지 안보일지 설정
		showUnderLine = new JCheckBox("밑줄 보이기");
		showUnderLine.setFont(defaultFontNor);
		showUnderLine.setBounds(5,220,100,40);
		showUnderLine.addActionListener(this);
		add(showUnderLine);
		
		prevWord = new JButton("이전");
		prevWord.setForeground(defaultColor);
		prevWord.setBackground(Color.WHITE);
		prevWord.setFont(defaultFontNor);
		prevWord.setBounds(5,280,80,40);
		prevWord.addActionListener(this);
		add(prevWord);
		
		nextWord = new JButton("다음");
		nextWord.setForeground(Color.WHITE);
		nextWord.setBackground(defaultColor);
		nextWord.setFont(defaultFontNor);
		nextWord.setBounds(90,280,80,40);
		nextWord.addActionListener(this);
		add(nextWord);
		
		showUnderLine.setVisible(false);
		prevWord.setVisible(false);
		nextWord.setVisible(false);
	}
	
	//퀴즈모드
	public void forQuiz() {
		//오답노트 표시제목
		incTitle = new JTextArea("오답노트");
		incTitle.setFont(defaultFontSma);
		incTitle.setDisabledTextColor(defaultColor);
		incTitle.setBackground(new Color(40,40,40));
		incTitle.setEnabled(false);
		incTitle.setBounds(5,80,170,15);
		add(incTitle);
		
		//오답노트 리스트
		incorrectList = new JTextArea(wrongList);
		incorrectList.setBackground(Color.WHITE);
		incorrectList.setDisabledTextColor(new Color(40,40,40));
		incorrectList.setDragEnabled(true);
		incorrectList.setEditable(false);
		
		//리스트 텍스트창에 스크롤 넣기
		spForIL = new JScrollPane(incorrectList,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
				,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//JFrame의 컨텐트페인에 스크롤페인 등록
		B.getContentPane().add(spForIL);
		spForIL.setBounds(10,100,170,100);
		
		//정답 입력라벨
		type = new JLabel("뜻:");
		type.setForeground(defaultColor);
		//위 사항은 '뜻:', '이름(한글):' '발음:', '수:' 으로 분화될 예정입니다.
		type.setFont(defaultFontNor);
		type.setBounds(5,250,40,30);
		add(type);
		
		//정답 입력 텍스트 필드
		submitArea = new JTextField(15);
		submitArea.setFont(defaultFontNor);
		submitArea.setBounds(5,280,100,25);
		add(submitArea);
		
		//정답 제출 버튼
		submit = new JButton("제출");
		submit.setFont(defaultFontNor);
		submit.setForeground(Color.WHITE);
		submit.setBackground(defaultColor);
		submit.setBounds(110,280,65,24);
		submit.addActionListener(this);
		add(submit);
		
		//다음 퀴즈단어 버튼
		nextQuiz = new JButton("다음 퀴즈");
		nextQuiz.setFont(defaultFontNor);
		nextQuiz.setForeground(Color.WHITE);
		nextQuiz.setBackground(defaultColor);
		nextQuiz.setBounds(5,310,170,40);
		nextQuiz.addActionListener(this);
		add(nextQuiz);
		
		incTitle.setVisible(false);
		incorrectList.setVisible(false);
		spForIL.setVisible(false);
		type.setVisible(false);
		submitArea.setVisible(false);
		submit.setVisible(false);
		nextQuiz.setVisible(false);
	}
	
	public void checkQuizorNote(boolean quizOrNote, menuMode m) {
		
		switch(m) {
		
		case modeSelect:
		case programINF:
			wordNote.setVisible(false);
			quiz.setVisible(false);
			
			incTitle.setVisible(false);
			incorrectList.setVisible(false);
			spForIL.setVisible(false);
			type.setVisible(false);
			submitArea.setVisible(false);
			submit.setVisible(false);
			nextQuiz.setVisible(false);
			
			showUnderLine.setVisible(false);
			prevWord.setVisible(false);
			nextWord.setVisible(false);
			break;
			
		case consonant:
		case vowel:
			wordNote.setVisible(true);
			quiz.setVisible(true);
			
			if(quizOrNote) {
				incTitle.setVisible(true);
				incorrectList.setVisible(true);
				spForIL.setVisible(true);
				type.setVisible(true);
				submitArea.setVisible(true);
				submit.setVisible(true);
				nextQuiz.setVisible(true);
				
				showUnderLine.setVisible(true);
				prevWord.setVisible(false);
				nextWord.setVisible(false);
			}
			else {
				incTitle.setVisible(false);
				incorrectList.setVisible(false);
				spForIL.setVisible(false);
				type.setVisible(false);
				submitArea.setVisible(false);
				submit.setVisible(false);
				nextQuiz.setVisible(false);
				
				showUnderLine.setVisible(true);
				prevWord.setVisible(true);
				nextWord.setVisible(true);
			}
			break;
			
		default:
			break;
		
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		//메뉴 선택바
		if(menuList.getSelectedItem().equals("모드를 선택해주세요")) {
			if(mode != menuMode.modeSelect) {
				fa.Biblekor.setText("<html><center>"+/*SamepleString*/"<br><br>"+"</center></html>");
				mode = menuMode.modeSelect;
			}
			wordNote.setSelected(true);
			showUnderLine.setSelected(false);
			thumbnail.setVisible(true);
		}
		else if(menuList.getSelectedItem().equals("자음")) {
			if(mode != menuMode.consonant) {
				mode = menuMode.consonant;
			}
			thumbnail.setVisible(false);
		}
		else if(menuList.getSelectedItem().equals("모음")) {
			if(mode != menuMode.vowel) {
				mode = menuMode.vowel;
			}
			thumbnail.setVisible(false);
		}
		else if(menuList.getSelectedItem().equals("프로그램 정보")) {
			if(mode != menuMode.programINF) {
				mode = menuMode.programINF;
				wordNote.setSelected(true);
			}
			showUnderLine.setSelected(false);
			thumbnail.setVisible(true);
		}
		//메뉴 동기화
		
		//퀴즈 or 단어장
		if(wordNote.isSelected()) {
			quizOrNote = false;
		}
		else if(quiz.isSelected()) {
			quizOrNote = true;
		}		
		
		if(showUnderLine.isSelected()) {
			fa.showUnderLineBool = true;
		}
		else {
			fa.showUnderLineBool = false;
		}
		
		checkQuizorNote(quizOrNote,mode);
		fa.changeMode(this);
	}
}
