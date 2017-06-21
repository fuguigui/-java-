import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventQs {
	private Frame f = new Frame("Test Events");
	private Button ok = new Button("ok?");
	private TextField tf = new TextField(30);
	
	public void init(){
		ok.addActionListener(new OKListener());
		f.add(tf);
		f.add(ok, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	
	class OKListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println("User click the ok button");
			tf.setText("Hello World");
		}
	}
	public static void main(String[] args) {
		new EventQs().init();
	}
}
