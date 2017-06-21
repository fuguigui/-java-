import java.awt.*;

import javax.swing.Box;
public class CommonComponent {
	Frame f = new Frame("Test");
	Button ok = new Button("Verify");
	CheckboxGroup cbg = new CheckboxGroup();
	Checkbox male = new Checkbox("male",cbg,true);
	Checkbox female = new Checkbox("female",cbg,false);
	Checkbox married = new Checkbox("Is married?",false);//这个box放在那里
	//下拉式选择框架
	Choice colorChooser = new Choice();
	List colorList = new List(6,true);
	TextArea ta = new TextArea(5,20);
	TextField name = new TextField(50);
	
	public void init(){
		colorChooser.add("red");
		colorChooser.add("green");
		colorChooser.add("blue");
		colorList.add("red");
		colorList.add("green");
		colorList.add("blue");
		
		//创建了一个装载了文本框、按钮的panel
		Panel bottom = new Panel();
		bottom.add(name);
		bottom.add(ok);
		//创建了一个装载了下拉框、三个CheckBox的Panel
		Panel checkPanel = new Panel();
		checkPanel.add(colorChooser);
		checkPanel.add(male);
		checkPanel.add(female);
		checkPanel.add(married);
		//创建一个垂直排列组件的Box，盛装多行文本域、Panel
		Box topLeft = Box.createVerticalBox();
		topLeft.add(ta);
		topLeft.add(checkPanel);
		//创建一个垂直排列组件的Box，盛装topLeft,colorList
		Box top = Box.createHorizontalBox();
		top.add(topLeft);
		top.add(colorList);
		//将top Box容器添加到窗口的中间
		f.add(top);
		f.add(bottom, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new CommonComponent().init();
	}
}
