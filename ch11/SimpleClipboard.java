import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;

public class SimpleClipboard {
	private Frame f = new Frame("Simple clipboard program");
	private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	private TextArea taCopy = new TextArea(5,20);
	private TextArea taPaste = new TextArea(5,20);
	private Button btCopy = new Button("Copy");
	private Button btPaste = new Button("Paste");
	public void init(){
		Panel p = new Panel();
		p.add(btCopy);
		p.add(btPaste);
		btCopy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				StringSelection contents = new StringSelection(taCopy.getText());
				clipboard.setContents(contents, null);
			}
		});
		btPaste.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){
					try{
						String content = (String)clipboard.getData(DataFlavor.stringFlavor);
						taPaste.append(content);
					}catch(Exception e2){
						e2.printStackTrace();
					}
				}
			}
		});
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(taCopy);
		box.add(taPaste);
		
		f.add(p, BorderLayout.SOUTH);
		f.add(box, BorderLayout.CENTER);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		f.pack();
		f.setVisible(true);
		
	}
	public static void main(String[] args) {
		new SimpleClipboard().init();
	}

}
