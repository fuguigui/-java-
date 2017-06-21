import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.*;

public class CopyPerson {
	Frame f= new Frame("Copy Object");
	Button copy = new Button("copy");
	Button paste = new Button("paste");
	TextField name = new TextField(15);
	TextField age = new TextField(15);
	TextArea ta = new TextArea(3,30);
	
	Clipboard clipboard = new Clipboard("cp");
	public void init(){
		Panel p = new Panel();
		p.add(new Label("name"));
		p.add(name);
		p.add(new Label("age"));
		p.add(age);
		
		f.add(p,BorderLayout.NORTH);
		f.add(ta);
		Panel bp = new Panel();
		
		copy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				copyPerson();
			}
		});
		paste.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					readPerson();
				}
				catch(Exception ee){
					ee.printStackTrace();
				}
			}
		});
		bp.add(copy);
		bp.add(paste);
		f.add(bp,BorderLayout.SOUTH);
		f.addWindowListener( new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		f.pack();
		f.setVisible(true);
	}
	public void copyPerson(){
		Person p = new Person(name.getText(),Integer.parseInt(age.getText()));
		LocalSelection ls = new LocalSelection(p);
		clipboard.setContents(ls, null);
	}
	public void readPerson() throws Exception{
		DataFlavor personFlavor = new DataFlavor("application/x-java-jvm-local-objectref;class=Person");
		if(clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){
			Person p = (Person)clipboard.getData(personFlavor);
			ta.setText(p.toString());
		}
	}
	public static void main(String[] args) {
		new CopyPerson().init();
	}
	class Person{
		private String name;
		private int age;
		Person(String name,int age){
			this.name = name;
			this.age = age;
		}
		public String toString(){
			return "Person∂‘œÛ[name="+name+",age ="+age+" ]";
		}
	}
}
