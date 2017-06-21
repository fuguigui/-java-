import java.awt.*;
import java.awt.event.*;

public class TestDialog {
	Frame f = new Frame();
	Dialog d1 = new Dialog(f,"model dialog",true);
	Dialog d2 = new Dialog(f,"non-model dialog",false);
	Button b1 = new Button("Open the model dialog");
	Button b2 = new Button("Open the non-model dialog");
	
	public void init(){
		d1.setBounds(20, 30, 300, 400);
		d2.setBounds(40,60,300,400);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				d1.setVisible(true);
				d1.addWindowListener(new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						System.exit(0);
					}
				});
			}
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				d2.setVisible(true);
				d2.addWindowListener(new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						System.exit(0);
					}
				});
			}
		});
		f.add(b1);
		f.add(b2, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new TestDialog().init();
	}
}
