import java.awt.*;

import javax.swing.*;

public class forMenu extends JPanel{
	//스윙 컴포넌트들
	JComboBox menuList;
	JButton Next;
	
	//기본타입 변수들
	String[] menubar = {"모드를 선택해주세요","자음",};
	Color defaultColor = Color.decode("#00B992");
	Font defaultFont = new Font("나눔바른펜",Font.BOLD,20);
	
	forMenu(){
		
		setLayout(null);
		setSize(180,355);
		this.setBorder(BorderFactory.createEtchedBorder());
		
		//메뉴
		menuList = new JComboBox(menubar);
		menuList.setSelectedIndex(0);
		menuList.setBounds(5,5,170,30);
		menuList.setBackground(defaultColor);
		menuList.setForeground(Color.WHITE);
		menuList.setFont(defaultFont);
		add(menuList);
		
		
		//
		
	}
}
