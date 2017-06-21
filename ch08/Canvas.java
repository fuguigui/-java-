import java.util.*;

abstract class Shape{
	public abstract void draw(Canvas c);
}
class Circle extends Shape{
	public void draw(Canvas c){
		System.out.println("在画布"+c+"画一个圆");
	}
}
class Rectangle extends Shape{
	public void draw(Canvas c){
		System.out.println("在画布"+c+"画一个长方形");
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
		//这个写法就是错的，因为我们不知道<? extends Shape>是什么，所以不能把元素添加进来
		shapeList.add(new Rectangle());
		shapeList.add(new Circle());
		shapeList.add(new Rectangle());
		c.drawAll(shapeList);
	}

}
