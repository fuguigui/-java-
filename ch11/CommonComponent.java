import java.awt.*;

import javax.swing.Box;
public class CommonComponent {
	Frame f = new Frame("Test");
	Button ok = new Button("Verify");
	CheckboxGroup cbg = new CheckboxGroup();
	Checkbox male = new Checkbox("male",cbg,true);
	Checkbox female = new Checkbox("female",cbg,false);
	Checkbox married = new Checkbox("Is married?",false);//���box��������
	//����ʽѡ����
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
		
		//������һ��װ�����ı��򡢰�ť��panel
		Panel bottom = new Panel();
		bottom.add(name);
		bottom.add(ok);
		//������һ��װ��������������CheckBox��Panel
		Panel checkPanel = new Panel();
		checkPanel.add(colorChooser);
		checkPanel.add(male);
		checkPanel.add(female);
		checkPanel.add(married);
		//����һ����ֱ���������Box��ʢװ�����ı���Panel
		Box topLeft = Box.createVerticalBox();
		topLeft.add(ta);
		topLeft.add(checkPanel);
		//����һ����ֱ���������Box��ʢװtopLeft,colorList
		Box top = Box.createHorizontalBox();
		top.add(topLeft);
		top.add(colorList);
		//��top Box������ӵ����ڵ��м�
		f.add(top);
		f.add(bottom, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new CommonComponent().init();
	}
}
