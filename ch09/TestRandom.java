import java.util.Random;

public class TestRandom {
	public static void main(String[] args) {
		Random r1 = new Random(50);
		System.out.println("第一个种子为50的Random对象");
		System.out.println("r1.nextBoolean():\t"+r1.nextBoolean());
		System.out.println("r1.nextInt()\t"+r1.nextInt());
		System.out.println("r1.nextDouble()\t"+r1.nextDouble());
		System.out.println("有范围的nextInt()\t"+r1.nextInt(70));

		Random r2 = new Random(50);
		System.out.println("第二个种子为50的Random对象");
		System.out.println("r2.nextBoolean():\t"+r2.nextBoolean());
		System.out.println("r2.nextInt()\t"+r2.nextInt());
		System.out.println("r2.nextDouble()\t"+r2.nextDouble());
		System.out.println("有范围的nextInt()\t"+r2.nextInt(70));
	}
}
