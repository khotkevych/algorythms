
// Given a set of coin denominators, find the minimum number of coins to give a certain amount of change.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoinDenominators {

    private List<Integer> denominators;

    private CoinDenominators(List<Integer> denominators) {
        this.denominators = denominators;
        this.denominators.sort(Collections.reverseOrder());
    }

    private List<Integer> giveChange(int amount) {
        List<Integer> coins = new ArrayList<>();
        int i = 0;
        while (amount != 0) {
            if (amount >= denominators.get(i)) {
                coins.add(denominators.get(i));
                amount -= denominators.get(i);
            } else {
                i++;
            }
        }
        return coins;
    }

    public static void main(String[] args) {
        CoinDenominators coinDenominators = new CoinDenominators(Arrays.asList(50, 25, 10, 5, 2, 1));
        System.out.println(coinDenominators.giveChange(76));
        System.out.println(coinDenominators.giveChange(186));
        System.out.println(coinDenominators.giveChange(25));
        System.out.println(coinDenominators.giveChange(24));
        System.out.println(coinDenominators.giveChange(2));
    }

}
