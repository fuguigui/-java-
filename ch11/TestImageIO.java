import java.awt.*;

import javax.imageio.ImageIO;

public class TestImageIO {
	public static void main(String[] args) {
		String[] readFormat = ImageIO.getReaderFormatNames();
		String[] nonofficial = ImageIO.getReaderFileSuffixes();
		System.out.println("---------Image能读的所有图形文件格式-------");
		for(String tmp : readFormat){
			System.out.println(tmp);
		}
		for(String tmp : nonofficial){
			System.out.println(tmp);
		}
		String [] writeFormat = ImageIO.getWriterFormatNames();
		System.out.println("-----Image能写的所有图形文件格式---------");
		for(String tmp:writeFormat){
			System.out.println(tmp);
		}
	}
}
