import java.awt.*;
import javax.swing.Box;
public class TestBox {
	private Frame f = new Frame("���Դ���");
	private Box horizontal = Box.createHorizontalBox();
	private Box vertical = Box.createVerticalBox();
	public void init(){
		horizontal.add(new Button("ˮƽ��ťһ"));
		horizontal.add(new Button("ˮƽ��ť��"));
		vertical.add(horizontal);
		vertical.add(new Button("��ֱ��ťһ"));
		vertical.add(new Button("��ֱ��ť��"));
		f.add(horizontal,BorderLayout.NORTH);
		f.add(vertical);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new TestBox().init();
	}
}
