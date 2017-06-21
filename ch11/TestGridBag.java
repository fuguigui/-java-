import java.awt.*;
public class TestGridBag {
	private Frame  f = new Frame("���Դ���");
	private GridBagLayout gb = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	private Button[] bs = new Button[10];
	public void init(){
		f.setLayout(gb);
		for(int i = 0;i<bs.length;++i){
			bs[i] = new Button("��ť"+i);
		}
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		addButton(bs[0]);
		addButton(bs[1]);
		addButton(bs[2]);
		//���gbc���Ƶ���������Ϊ��������һ����
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		addButton(bs[3]);
		gbc.weightx = 0;
		addButton(bs[4]);
		//Ϊʲôbs[4]�����ť�Զ�ռ��һ���أ�
		gbc.gridwidth = 2;
		addButton(bs[5]);
		gbc.gridwidth =1;
		gbc.gridheight = 2;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		addButton(bs[6]);
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		gbc.weighty = 1;
		addButton(bs[7]);
		gbc.weighty = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		addButton(bs[8]);
		addButton(bs[9]);
		f.pack();
		f.setVisible(true);
	}
	private void addButton(Button bt){
		gb.setConstraints(bt, gbc);
		f.add(bt);
	}
	public static void main(String[] args) {
		new TestGridBag().init();
	}

}
