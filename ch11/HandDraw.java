import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

public class HandDraw {
	private final int AREA_WIDTH = 500;
	private final int AREA_HEIGHT=400;
	//preX和preY保存了上一次鼠标拖动事件的鼠标坐标
	private int preX = -1;
	private int preY = -1;
	
	private Frame f = new Frame("Simple hand draw program");
	private DrawPanel drawArea = new DrawPanel();
	private String shape = "";
	//用于保存画笔颜色
	private Color foreColor = new Color(255,0,0);
	
	//定义一个右键菜单由于设置画笔颜色
	PopupMenu pop = new PopupMenu();
	MenuItem redItem = new MenuItem("red");
	MenuItem greenItem = new MenuItem("green");
	MenuItem blueItem = new MenuItem("blue");
	
	//定义一个BufferedImage对象
	BufferedImage image = new BufferedImage(AREA_WIDTH,AREA_HEIGHT,BufferedImage.TYPE_INT_RGB);
	//获取Image对象的Graphics
	Graphics g = image.getGraphics();
	
	class DrawPanel extends Panel{
		public void paint(Graphics g){
			g.drawImage(image, 0, 0, null);
		}
	}
	
	public void init(){
		//定义右键菜单的事件监听器
		ActionListener menuListener =  new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand().equals("green")){
					foreColor = new Color(0,255,0);
				}
				if(e.getActionCommand().equals("red")){
					foreColor = new Color(255,0,0);
				}
				if(e.getActionCommand().equals("blue")){
					foreColor = new Color(0,0,255);
				}
			}
		};
		//为单个菜单项添加监听器
		redItem.addActionListener(menuListener);
		greenItem.addActionListener(menuListener);
		blueItem.addActionListener(menuListener);
		//将菜单项组合成右键菜单
		pop.add(redItem);
		pop.add(blueItem);
		pop.add(greenItem);
		
		//将菜单项添加到drawArea对象中去
		drawArea.add(pop);
		g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
		drawArea.setPreferredSize(new Dimension(AREA_WIDTH,AREA_HEIGHT));
		drawArea.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				if(preX>0 && preY < 0){
					g.setColor(foreColor);
					g.drawLine(preX, preY, e.getX(), e.getY());
				}
				preX = e.getX();
				preY = e.getY();
				drawArea.repaint();
			}
		});
		drawArea.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				//弹出右键菜单
				if(e.isPopupTrigger()){
					pop.show(drawArea, e.getX(), e.getY());
				}
				//松开鼠标键时，把上一次鼠标拖动事件的x,y坐标设为-1
				preX = -1;
				preY = -1;
			}
		});
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		f.add(drawArea);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new HandDraw().init();
	}
}
