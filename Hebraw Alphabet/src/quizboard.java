import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class quizboard extends JFrame implements ActionListener, MouseListener{
	//toolkit area
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	//for preferred size
	
	//Swing Var Area
	
	//Number Area
	
	//기본타입을 위한 공간
	
	//외부 클래스들
	forMenu fm = new forMenu(this);
	forAlphabet fa = new forAlphabet(this,fm);
	
	
	quizboard(){ 
		fm = new forMenu(this,fa);
		//init setting
		setSize(600,400);
		setLayout(null);
		setLocation(screenSize.width/2-300,screenSize.height/2-200);
		setTitle("히브리어 알파벳 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); //크기 변경 불가능
		
		//메뉴 부분을 위해서
		fm.setLocation(5,5);
		add(fm);
		
		//단어장 표시부분을 위해서
		fa.setLocation(190,5);
		add(fa);
		
		
		addMouseListener(this);
		this.requestFocus();
		setFocusable(true);
		setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent e) {
		System.out.println("X Coord:"+e.getX()+", Y Coord:"+e.getY());
	}
	public void mouseReleased(MouseEvent arg0) {}
}
