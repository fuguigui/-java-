import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Gobang {

	//三个位图代表棋盘、黑子、白子
	BufferedImage table;
	BufferedImage black;
	BufferedImage white;
	//当鼠标移动时候的选择框
	BufferedImage selected;
	//定义棋盘的大小
	private static int BOARD_SIZE = 15;
	//定义棋盘宽、高多少个像素
	private final int TABLE_WIDTH = 535;
	private final int TABLE_HEIGHT = 536;
	//定义棋盘坐标的像素值和棋盘数组之间的比率
	private final int RATE = TABLE_WIDTH / BOARD_SIZE;
	//定义棋盘坐标的像素值和棋盘数组之间的比率
	private final int X_OFFSET = 5;
	private final int Y_OFFSET = 6;
	//定义一个二维数组来充当 棋盘
	private String[][] board = new String[BOARD_SIZE][BOARD_SIZE];
	
	//游戏窗口
	JFrame f = new JFrame("五子棋游戏");
	ChessBoard chessBoard = new ChessBoard();
	
	//当前选中点的坐标
	private int selectedX = -1;
	private int selectedY = -1;
	public void init() throws IOException{
		table = ImageIO.read(new File ("image/board.jpg"));
		black = ImageIO.read(new File("image/black.jpg"));
		white = ImageIO.read(new File("image/white.jpg"));
		selected = ImageIO.read(new File("image/selected.jpg"));
		
		for(int i = 0;i<BOARD_SIZE;++i){
			for(int j = 0;j<BOARD_SIZE;++j){
				board[i][j]="#";
			}
		}
		chessBoard.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));
		chessBoard.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				int xPos = (int)((e.getX() - X_OFFSET)/RATE);
				int yPos = (int)((e.getY()-Y_OFFSET)/RATE);
				board[xPos][yPos] = "#";
				chessBoard.repaint();
			}
			public void mouseExited (MouseEvent e){
				selectedX = -1;
				selectedY = -1;
				chessBoard.repaint();
			}
		});
		chessBoard.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseMoved(MouseEvent e){
				selectedX = (e.getX() - X_OFFSET)/RATE;
				selectedY = (e.getY() - Y_OFFSET)/RATE;
				chessBoard.repaint();
			}
		});
		f.add(chessBoard);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args) throws Exception {
		Gobang gb = new Gobang();
		gb.init();
	}
	class ChessBoard extends JPanel{
		public void paint(Graphics g){
			g.drawImage(table, 0, 0, null);
			if(selectedX >=0 && selectedY >=0){
				g.drawImage(selected, selectedX*RATE+X_OFFSET, selectedY*RATE+Y_OFFSET, null);
			}
			for(int i =0;i<BOARD_SIZE;i++){
				for(int j =0;j<BOARD_SIZE;j++){
					if(board[i][j].equals("#")){
						g.drawImage(black, i*RATE+X_OFFSET, j*RATE+Y_OFFSET, null);
					}
				}
			}
		}
	}
}
