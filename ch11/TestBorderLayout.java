import java.awt.*;

public class TestBorderLayout {
	public static void main(String[] args) {
		Frame f = new Frame("���Դ���");
		f.setLayout(new BorderLayout(30,5));
		f.add(new Button("��"), BorderLayout.SOUTH);
		f.add(new Button("��"),BorderLayout.NORTH);
		
		Panel p = new Panel();
		p.add(new TextField(20));
		p.add(new Button("������"));
		f.add(p);
		f.add(new Button("��"),BorderLayout.EAST);
		f.pack();
		f.setVisible(true);
	}
}
