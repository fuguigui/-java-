import java.awt.*;
import java.awt.event.*;

public class TestPopupMenu {
	private Frame f= new Frame("Test the popup menu");
	private TextArea ta = new TextArea(6,50);
	PopupMenu pop = new PopupMenu();
	MenuItem copyItem = new MenuItem("Copy");
	MenuItem pasteItem = new MenuItem("Paste");
	Menu format = new Menu("Format");
	//create commentItem menu, add Ctrl+Shift+/ to it
	MenuItem commentItem = new MenuItem("Comment",new MenuShortcut(KeyEvent.VK_SLASH,true));
	MenuItem cancelItem = new MenuItem("Cancel the comment");
	
	public void init(){
		ActionListener menuListener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String cmd = e.getActionCommand();
				ta.append("Click "+ cmd + " menu\n");
				if(cmd.equals("Exit")) System.exit(0);
			}
		};
		commentItem.addActionListener(menuListener);
		pop.add(copyItem);
		pop.add(pasteItem);
		pop.add(new MenuItem("-"));
		pop.add(format);
		
		format.add(commentItem);
		format.add(cancelItem);
		
		final Panel p = new Panel();
		p.setPreferredSize(new Dimension(300,160));
		p.add(pop);
		p.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				if(e.isPopupTrigger())
					pop.show(p, e.getX(), e.getY());
			}
		});
		f.add(p);
		f.add(ta, BorderLayout.NORTH);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				ta.append("The user is trying to close the window.\n");
				System.exit(0);
			}
		});
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new TestPopupMenu().init();
	}
}
