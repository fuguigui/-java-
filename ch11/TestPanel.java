import java.awt.*;
public class TestPanel {
	public static void main(String[] args) {
		Frame f = new Frame("���Դ���");
		ScrollPane p = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		p.add(new TextField(20));
		p.add(new Button("������"));
		f.add(p);
		f.setBounds(30, 60, 250, 120);
		f.setVisible(true);
	}
}
