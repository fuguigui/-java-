import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TestFileDialog {
	Frame f = new Frame("Test");
	FileDialog d1 = new FileDialog(f,"choose the file to be opened",FileDialog.LOAD);
	FileDialog d2 = new FileDialog(f,"choose the path to save the file",FileDialog.SAVE);
	Button b1 = new Button("Open the file");
	Button b2 = new Button("Save the file");
	
	public void init(){
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				d1.setVisible(true);
				System.out.println(d1.getDirectory()+d1.getFile());
			}
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				d2.setVisible(true);
				System.out.println(d2.getDirectory()+d2.getFile());
			}
		});
		f.add(b1);
		f.add(b2,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestFileDialog().init();
	}
}
