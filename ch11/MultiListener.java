import java.awt.*;
import java.awt.event.*;

public class MultiListener {
	private Frame f = new Frame("Test");
	private TextArea ta = new TextArea(6,40);
	private Button b1 = new Button("button 1");
	private Button b2 = new Button("button 2");
	
	public void init(){
		//创建FirstListener监听器的实例
		FirstListener fl = new FirstListener();
		//register two EventListeners on b1
		b1.addActionListener(fl);
		b1.addActionListener(new SecondListener());
		b2.addActionListener(fl);
		f.add(ta);
		Panel p = new Panel();
		p.add(b1);
		p.add(b2);
		f.add(p,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	
	class FirstListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ta.append("the first actionlistener has been acted, the event source is "+e.getActionCommand()+"\n");
			
		}
	}
	class SecondListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ta.append("click "+e.getActionCommand()+" button\n");
		}
	}
	public static void main(String[] args) {
		new MultiListener().init();
	}
}
