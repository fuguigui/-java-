import java.util.*;

abstract class Shape{
	public abstract void draw(Canvas c);
}
class Circle extends Shape{
	public void draw(Canvas c){
		System.out.println("�ڻ���"+c+"��һ��Բ");
	}
}
class Rectangle extends Shape{
	public void draw(Canvas c){
		System.out.println("�ڻ���"+c+"��һ��������");
	}
}
public class Canvas {
	public void drawAll(List<? extends Shape> shapes){
		for(Shape p : shapes){
			p.draw(this);
		}
	}
	public static void main(String[] args) {
		List<Circle> circleList = new ArrayList<Circle>();
		circleList.add(new Circle());
		Canvas c = new Canvas();
		c.drawAll(circleList);
		List<Shape> shapeList = new ArrayList<Shape>();
		//List<? extends Shape> shapeList = new ArrayList<Shape>();
		//���д�����Ǵ�ģ���Ϊ���ǲ�֪��<? extends Shape>��ʲô�����Բ��ܰ�Ԫ����ӽ���
		shapeList.add(new Rectangle());
		shapeList.add(new Circle());
		shapeList.add(new Rectangle());
		c.drawAll(shapeList);
	}

}
