import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TestCardLayout {
	Frame f = new Frame("测试窗口");
	String [] names = {"first","second","third","fourth","fifth"};
	Panel pl = new Panel();
	CardLayout  c = new CardLayout();
	public void init(){
		pl.setLayout(c);
		for(int i = 0 ;i<names.length;++i){
			pl.add(names[i], new Button(names[i]));
		}
		Panel p = new Panel();
		Button previous=  new Button("previous");
		previous.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				c.previous(pl);
			}
		});
		Button next = new Button("next");
		next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				c.next(pl);
			}
		});
		//控制显示第一张的按钮
		Button first = new Button("first");
		first.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				c.first(pl);
			}
		});
		Button last =  new Button("last");
		last.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				c.last(pl);
			}
		});
		p.add(previous);
		p.add(next);
		p.add(first);
		p.add(last);
		f.add(pl);
		f.add(p, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new TestCardLayout().init();
	}
}
