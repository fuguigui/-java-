import java.awt.*;

import javax.imageio.ImageIO;

public class TestImageIO {
	public static void main(String[] args) {
		String[] readFormat = ImageIO.getReaderFormatNames();
		String[] nonofficial = ImageIO.getReaderFileSuffixes();
		System.out.println("---------Image�ܶ�������ͼ���ļ���ʽ-------");
		for(String tmp : readFormat){
			System.out.println(tmp);
		}
		for(String tmp : nonofficial){
			System.out.println(tmp);
		}
		String [] writeFormat = ImageIO.getWriterFormatNames();
		System.out.println("-----Image��д������ͼ���ļ���ʽ---------");
		for(String tmp:writeFormat){
			System.out.println(tmp);
		}
	}
}
