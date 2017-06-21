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

	//����λͼ�������̡����ӡ�����
	BufferedImage table;
	BufferedImage black;
	BufferedImage white;
	//������ƶ�ʱ���ѡ���
	BufferedImage selected;
	//�������̵Ĵ�С
	private static int BOARD_SIZE = 15;
	//�������̿��߶��ٸ�����
	private final int TABLE_WIDTH = 535;
	private final int TABLE_HEIGHT = 536;
	//�����������������ֵ����������֮��ı���
	private final int RATE = TABLE_WIDTH / BOARD_SIZE;
	//�����������������ֵ����������֮��ı���
	private final int X_OFFSET = 5;
	private final int Y_OFFSET = 6;
	//����һ����ά�������䵱 ����
	private String[][] board = new String[BOARD_SIZE][BOARD_SIZE];
	
	//��Ϸ����
	JFrame f = new JFrame("��������Ϸ");
	ChessBoard chessBoard = new ChessBoard();
	
	//��ǰѡ�е������
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
