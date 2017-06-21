import java.awt.*;
import java.awt.event.*;

public class TestWindowListener {
	private Frame f = new Frame("Test");
	private TextArea ta = new TextArea(6,40);
	
	public void init(){
		f.addWindowListener(new MyListener());
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}
	
	class MyListener implements WindowListener{
		public void windowActivated(WindowEvent e){
			ta.append("The window has been activated\n");
		}
		public void windowClosed(WindowEvent e){
			ta.append("The window has been successfully closed!\n");
		}
		@Override
		public void windowOpened(WindowEvent e) {
			ta.append("The window is opened for the first time.\n");
			
		}
		@Override
		public void windowClosing(WindowEvent e) {
			ta.append("User is trying to close the window.\n");
		}
		@Override
		public void windowIconified(WindowEvent e) {
			ta.append("The window is been minimized.\n");
		}
		@Override
		public void windowDeiconified(WindowEvent e) {
			ta.append("The window is recovered!\n");
			
		}
		@Override
		public void windowDeactivated(WindowEvent e) {
			ta.append("The window is losing the focus!\n");
		}
	}
	public static void main(String[] args) {
		new TestWindowListener().init();
	}

}
