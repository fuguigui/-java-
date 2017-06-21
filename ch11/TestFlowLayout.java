import java.awt.*;
import java.awt.Frame;
public class TestFlowLayout {
	public static void main(String[] args) {
		Frame f = new Frame("²âÊÔ´°¿Ú");
		f.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		
		for(int i = 0;i<10;i++){
			f.add(new Button("°´Å¥"+i));
		}
		f.pack();
		f.setVisible(true);
	}
}
