import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ZoomImageGUI {

	Frame f = new Frame("Test");
	FileDialog d1 = new FileDialog(f,"choose the file to be opened",FileDialog.LOAD);
	FileDialog d2 = new FileDialog(f,"choose the path to save the file",FileDialog.SAVE);
	Button b1 = new Button("Open the file");
	Button b2 = new Button("Save the file");
	private final int WIDTH = 80;
	private final int HEIGHT = 60;
	BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	Graphics g= image.getGraphics();
	File readFile;
	File writeFile;
	
	public void zoom()throws Exception{
		Image srcImage = ImageIO.read(readFile);
		g.drawImage(srcImage, 0, 0, WIDTH, HEIGHT, null);
		writeFile = new File(System.currentTimeMillis()+".jpg");
		ImageIO.write(image, "jpeg", writeFile);
	}
	public void init(){
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				d1.setVisible(true);
				System.out.println(d1.getDirectory()+d1.getFile());
			}
		});
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				d2.setVisible(true);
				System.out.println(d2.getDirectory()+d2.getFile());
			}
		});
		f.add(b1);
		f.add(b2,BorderLayout.SOUTH);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
			
		});
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestFileDialog().init();
	}
}
