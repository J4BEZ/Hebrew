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
	
	
	//String Area
	
	
	quizboard(){
		//init setting
		setSize(600,400);
		setLayout(null);
		setLocation(screenSize.width/2-300,screenSize.height/2-200);
		setTitle("[Hebrew Alphabet]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); //unable to Resize the frame size.
		
		//for Hebrew Alphabet
		hebrew = new JLabel("א");
		hebrew.setBounds(30,30,100,100);
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
