import java.awt.*;
import java.awt.Frame;
public class TestFlowLayout {
	public static void main(String[] args) {
		Frame f = new Frame("���Դ���");
		f.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		
		for(int i = 0;i<10;i++){
			f.add(new Button("��ť"+i));
		}
		f.pack();
		f.setVisible(true);
	}
}
