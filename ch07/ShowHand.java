import java.util.*;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
public class ShowHand {
	//����������
	private final int PLAY_NUM = 5;
	private String[] types = {"\4 ","\5 ","\3 ","\6 "};//�����ĸ������ַ�������̨���ӡ�����顢�ݻ������ġ�����
	private String[] values = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	
	//card��һ����Ϸ��ʣ�µ��˿���
	private List<String> cards = new LinkedList<String>();
	//�����������
	private String[] players = new String[PLAY_NUM];
	//��������������ϵ��˿���
	private List<String>[] playersCards = new List[PLAY_NUM];
	private int num;
	/*��ʼ���˿��ƣ�����52���˿��ƣ�����ʹ��shuffle�������������˳���ŷ�
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
	 * ��ʼ�����
	 */
	public void initPlayer(String ...names){
		if(names.length > PLAY_NUM || names.length<2){
			System.out.println("�����������");
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
	 * ��ʼ��������ϵ��˿��ƣ���ʼ��Ϸʱÿ��������ϵ��˿���Ϊ��
	 * ����ʹ��һ������Ϊ0��LinkedList����ʾ
	 */
	public void initPlayerCards(){
		for(int i=0;i<players.length;i++){//���length�Ƕ���
			if(players[i]!=null && !players[i].equals("")){
				playersCards[i] = new LinkedList<String>();
			}
		}
	}
	/*
	 * ���ȫ���˿���
	 * �÷�������Ϊ����ʹ��
	 */
	public void showAllCards(){
		for(String card: cards){
			System.out.println(card);
		}
	}
	/*
	 * ���˿���
	 * @param first �����ɸ�˭
	 */
	public void deliverCard(String first){
		int firstPos = ArrayUtils.search(players,first);
		//���θ�λ��ָ�����֮���ÿ����ҷ���
		for(int i = firstPos;i<num;i++){
			playersCards[i].add(cards.get(0));
			cards.remove(0);
		}
		//���θ�λ��ָ�����֮ǰ����ҷ���
		for(int i = 0;i<firstPos;i++){
			playersCards[i].add(cards.get(0));
			cards.remove(0);
		}
	}
	/*
	 * ���������ϵ��˿���
	 * ʵ�ָ÷���ʱ��Ӧ�ÿ���ÿ����ҿ��������˵ĵ�һ����
	 */
	public void showPlayerCards(){
		for(int i =0;i<num;i++){
			//������Ҳ�Ϊ��ʱ
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
		sh.initPlayer("�������","���");
		sh.initCards();
		sh.initPlayerCards();
		sh.showAllCards();
		System.out.println("-----------");
		sh.deliverCard("���");
		sh.showPlayerCards();
		/*
		 * ����ط���Ҫ���Ӵ���
		 * 1.�������������ע��
		 * 2.��������Ƿ��ע��
		 * 3.��Ϸ�Ƿ�ֻʣһ����ң�����ǣ�����ʤ��
		 * 4.����Ѿ������һ���˿��ƣ�����Ҫ�Ƚ�ʣ����ҵ������С
		 */
		sh.deliverCard("�������");
		sh.showPlayerCards();
	}


}
