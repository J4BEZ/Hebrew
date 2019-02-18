import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class quizboard extends JFrame implements ActionListener{
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	
	quizboard(){
		//init setting
		setSize(600,400);
		setLocation(screenSize.width/2-300,screenSize.height/2-200);
		setTitle("[Hebraw Alphabet]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); //unable to Resize the frame size.
		
		
		
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
