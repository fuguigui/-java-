import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.Timer;

public class PinBall {
	private Frame f = new Frame("Ball game");
	Random rand = new Random();
	private MyPanel tableArea = new MyPanel();
	Timer timer;
	private boolean isLose = false;
	private String shape = "";
	
	private final int TABLE_WIDTH = 300;
	private final int TABLE_HEIGHT = 400;
	private final int RACKET_Y = 340;//球拍的垂直位置
	private int RACKET_X = rand.nextInt(200);
	private final int RACKET_HEIGHT = 20;
	private final int RACKET_WIDTH = 60;
	
	//设置小球的相关参数
	private final int BALL_SIZE = 16;
	private int ySpeed = 10;
	private double xyRate = rand.nextDouble() - 0.5;
	private int xSpeed = (int)(ySpeed*xyRate*2);
	private int ballX = rand.nextInt(200)+20;
	private int ballY = rand.nextInt(10)+20;
	

	public void init(){
		tableArea.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));
		f.add(tableArea);
		KeyAdapter keyProcessor = new KeyAdapter(){
			public void keyPressed(KeyEvent ke){
				if(ke.getKeyCode() == KeyEvent.VK_LEFT){
					if(RACKET_X>0)RACKET_X-=10;
				}
				if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
					if(RACKET_X< TABLE_WIDTH - RACKET_WIDTH)
						RACKET_X+=10;
				}
			}
		};
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		f.addKeyListener(keyProcessor);
		tableArea.addKeyListener(keyProcessor);
		//定义事件监听器，用于更新小球位置。
		ActionListener taskPerformer = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(ballX<=0 || ballX >= TABLE_WIDTH - BALL_SIZE){
					xSpeed = -xSpeed;
				}
				//如果小球高度超出了球拍范围，并且横向不再球拍范围之内，游戏结束
				if(ballY >= RACKET_Y-BALL_SIZE &&
						(ballX< RACKET_X || ballX> RACKET_X + RACKET_WIDTH)){
					 timer.stop();
					 isLose = true;
					 tableArea.repaint();
				}
				else if(ballY<=0 ||
						(ballY >=RACKET_Y - BALL_SIZE &&
						ballX > RACKET_X && ballX <= RACKET_X + RACKET_WIDTH)){
					ySpeed = -ySpeed;
				}
				ballY += ySpeed;
				ballX +=xSpeed;
				tableArea.repaint();
			}
		};
		timer = new Timer(50,taskPerformer);
		timer.start();
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new PinBall().init();
	}
	class MyPanel extends Panel{
		public void paint(Graphics g){
			if(isLose){
				g.setColor(new Color(255,0,0));
				g.setFont(new Font("Times", Font.BOLD,30));
				g.drawString("Game over!", 50, 200);
			}
			else{
				g.setColor(new Color(240,240,80));
				g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
				g.setColor(new Color(80,80,200));
				g.fillRect(RACKET_X, RACKET_Y, RACKET_WIDTH, RACKET_HEIGHT);
			}
		}
	}
}
