import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;

public class SimpleMenu {
	private Frame f = new Frame("Test the menu");
	private MenuBar mb = new MenuBar();
	Menu file = new Menu("File");
	Menu edit = new Menu("Edit");
	MenuItem newItem = new MenuItem("Create");
	MenuItem saveItem = new MenuItem("Save");
	//create exitItem and add shortcut Ctrl+X to it
	MenuItem exitItem = new MenuItem("Exit", new MenuShortcut(KeyEvent.VK_X));
	CheckboxMenuItem autoWrap = new CheckboxMenuItem("Auto change the line");
	MenuItem copyItem = new MenuItem("Copy");
	MenuItem pasteItem = new MenuItem("Paste");
	Menu format = new Menu("Format");
	//create commentItem menu, add Ctrl+Shift+/ to it
	MenuItem commentItem = new MenuItem("Comment",new MenuShortcut(KeyEvent.VK_SLASH,true));
	MenuItem cancelItem = new MenuItem("Cancel the comment");
	private TextArea ta = new TextArea(6,40);
	
	public void init(){
		ActionListener menuListener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String cmd = e.getActionCommand();
				ta.append("Click "+ cmd + " menu\n");
				if(cmd.equals("Exit")) System.exit(0);
			}
		};
		commentItem.addActionListener(menuListener);
		exitItem.addActionListener(menuListener);
		//add menuitems  to menu File
		file.add(newItem);
		file.add(saveItem);
		file.add(exitItem);
		//add menuitems to menu Edit
		edit.add(autoWrap);
		//use the method addSeparator to add separator to the menu
		edit.addSeparator();
		edit.add(copyItem);
		edit.add(pasteItem);
		edit.add(new MenuItem("-"));//another way to separate the menu
		edit.add(format);
		//add menu items to the menu format
		format.add(commentItem);
		format.add(cancelItem);
		
		//add menu file, edit to the menubar mb
		mb.add(file);
		mb.add(edit);
		
		//set the menu bar to the frame f
		f.setMenuBar(mb);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				ta.append("The user is trying to close the window!\n");
				System.exit(0);
			}
		});
		f.add(ta);
		f.pack();
		f.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new SimpleMenu().init();
	}
}
