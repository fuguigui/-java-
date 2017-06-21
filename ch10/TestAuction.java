import java.io.*;
public class TestAuction {
	private double initPrice = 30.0;
	public void bid(String bidPrice) throws AuctionException{
		double d= 0.0;
		try{
			d = Double.parseDouble(bidPrice);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new AuctionException("竞拍价必须是数值，不能包含其他字符！");
		}
		if(initPrice>d){
			throw new AuctionException("竞拍价比起拍价低，不许竞拍！");
		}
		initPrice = d;
	}
	public static void main(String[] args) {
		TestAuction ta = new TestAuction();
		try{
			ta.bid("df");
		}catch(AuctionException ae){
			System.err.println(ae.getMessage());
		}
	}

}
