import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class quizboard extends JFrame implements ActionListener, MouseListener{
	//toolkit area
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	//for preferred size
	
	//Swing Var Area

	JLabel hebrew, hebName, hebPron, hebNum;//for Hebrew Alphabet
	JButton Next;//for next button
	
	
	//Number Area
	
	
	//기본타입을 위한 공간
	
	//외부 클래스들
	forMenu f = new forMenu();
	
	quizboard(){
		//init setting
		setSize(600,400);
		setLayout(null);
		setLocation(screenSize.width/2-300,screenSize.height/2-200);
		setTitle("히브리어 알파벳");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); //크기 변경 불가능
		
		//메뉴 부분을 위해서
		f.setLocation(5,5);
		add(f);
		
		//히브리어 '알파벳' 위한 공간
		hebrew = new JLabel("א");
		add(hebrew);
		
		
		
		addMouseListener(this);
		this.requestFocus();
		setFocusable(true);
		setVisible(true);
	}
	
	public void underline(Graphics g) {
		//g.drawLine(arg0, arg1, arg2, arg3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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