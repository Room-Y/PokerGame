import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author: Java_cmr
 * @Date: 2023/1/3 - 14:24
 */
public class PokerGame {
    static HashMap<Integer, String> hm = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();

    //准备牌
    //静态代码块，随着类的加载而加载，只会执行一次
    static{
        String[] color = {"♦","♣","♥","♠"};
        String[] number = {"3","4","5","6", "7","8","9","10","J","Q","K","A","2"};
        int specialNum = 0;
        for(String n : number){
            for(String c : color){
                list.add(specialNum);
                hm.put(specialNum++, c+n);
            }
        }
        list.add(specialNum);
        hm.put(specialNum++, "小王");
        list.add(specialNum);
        hm.put(specialNum, "大王");
        System.out.println(hm);
    }

    public PokerGame(){
        //洗牌
        Collections.shuffle(list);

        //发牌
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();
        TreeSet<Integer> lord = new TreeSet<>();

        for(int i = 0; i < list.size(); i++){
            Integer tmp = list.get(i);
            if(i <= 2) {
                lord.add(tmp);
            }
            else if(i % 3 == 0){
                player1.add(tmp);
            }
            else if(i % 3 == 1){
                player2.add(tmp);
            }
            else{
                player3.add(tmp);
            }
        }

        //看牌
        lookPoker("底牌", lord);
        lookPoker("玩家一", player1);
        lookPoker("玩家二", player2);
        lookPoker("玩家三", player3);

    }

    public void lookPoker(String name, TreeSet<Integer> list){
        System.out.print(name + ": ");
        list.forEach(i -> {
            System.out.print(hm.get(i) + " ");
        });
        System.out.println();
    }

}
