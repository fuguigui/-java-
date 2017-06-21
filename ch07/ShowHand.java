import java.util.*;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
public class ShowHand {
	//最多玩家数量
	private final int PLAY_NUM = 5;
	private String[] types = {"\4 ","\5 ","\3 ","\6 "};//这是四个特殊字符，控制台会打印出方块、草花、红心、黑桃
	private String[] values = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	
	//card是一局游戏中剩下的扑克牌
	private List<String> cards = new LinkedList<String>();
	//定义所有玩家
	private String[] players = new String[PLAY_NUM];
	//定义所有玩家手上的扑克牌
	private List<String>[] playersCards = new List[PLAY_NUM];
	private int num;
	/*初始化扑克牌，放入52张扑克牌，并且使用shuffle方法将它们随机顺序排放
	 * *
	 */
	public void initCards(){
		for(int i =0;i<types.length;++i){
			for(int j= 0;j<values.length;++j){
				cards.add(types[i]+values[j]);
			}
		}
		Collections.shuffle(cards);
	}
	/*
	 * 初始化玩家
	 */
	public void initPlayer(String ...names){
		if(names.length > PLAY_NUM || names.length<2){
			System.out.println("玩家数量不对");
			return;
		}
		else{
			num = names.length;
			for(int i =0;i<num;++i){
				players[i]=names[i];
			}
		}
	}
	/*
	 * 初始化玩家手上的扑克牌，开始游戏时每个玩家手上的扑克牌为空
	 * 程序使用一个长度为0的LinkedList来表示
	 */
	public void initPlayerCards(){
		for(int i=0;i<players.length;i++){//这个length是多少
			if(players[i]!=null && !players[i].equals("")){
				playersCards[i] = new LinkedList<String>();
			}
		}
	}
	/*
	 * 输出全部扑克牌
	 * 该方法仅作为测试使用
	 */
	public void showAllCards(){
		for(String card: cards){
			System.out.println(card);
		}
	}
	/*
	 * 派扑克牌
	 * @param first 最先派给谁
	 */
	public void deliverCard(String first){
		int firstPos = ArrayUtils.search(players,first);
		//依次给位于指定玩家之后的每个玩家发牌
		for(int i = firstPos;i<num;i++){
			playersCards[i].add(cards.get(0));
			cards.remove(0);
		}
		//依次给位于指定玩家之前的玩家发牌
		for(int i = 0;i<firstPos;i++){
			playersCards[i].add(cards.get(0));
			cards.remove(0);
		}
	}
	/*
	 * 输出玩家手上的扑克牌
	 * 实现该方法时，应该控制每个玩家看不到别人的第一张牌
	 */
	public void showPlayerCards(){
		for(int i =0;i<num;i++){
			//当该玩家不为空时
			if(players[i]!=null){
				System.out.print(players[i]+": ");
				for(String card: playersCards[i]){
					System.out.print(card + "\t");
				}
			}
			System.out.print("\n");
		}
	}
	public static void main(String[] args) {
		ShowHand sh = new ShowHand();
		sh.initPlayer("电脑玩家","悟空");
		sh.initCards();
		sh.initPlayerCards();
		sh.showAllCards();
		System.out.println("-----------");
		sh.deliverCard("悟空");
		sh.showPlayerCards();
		/*
		 * 这个地方需要增加处理：
		 * 1.牌面最大的玩家下注。
		 * 2.其他玩家是否跟注？
		 * 3.游戏是否只剩一个玩家？如果是，则他胜利
		 * 4.如果已经是最后一张扑克牌，则需要比较剩下玩家的牌面大小
		 */
		sh.deliverCard("电脑玩家");
		sh.showPlayerCards();
	}


}
