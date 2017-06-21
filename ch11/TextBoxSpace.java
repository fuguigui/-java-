import java.awt.*;
import javax.swing.Box;

public class TextBoxSpace {
	private Frame f = new Frame("测试");
	private Box horizontal = Box.createHorizontalBox();
	private Box vertical = Box.createVerticalBox();
	public void init(){
		horizontal.add(new Button("button 1"));
		horizontal.add(Box.createHorizontalGlue());
		horizontal.add(new Button("button 2"));
		//设置水平方向不可拉伸的间距
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(new Button("button3"));
		vertical.add(new Button("vertical button1"));
		vertical.add(Box.createVerticalGlue());
		vertical.add(new Button("vertical button2"));
		vertical.add(Box.createVerticalStrut(10));
		vertical.add(new Button("vertical button3"));
		f.add(horizontal,BorderLayout.NORTH);
		f.add(vertical);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new TextBoxSpace().init();
	}
}
