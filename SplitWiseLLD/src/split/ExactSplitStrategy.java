package split;

import java.util.List;

public class ExactSplitStrategy implements SplitStrategy{
    @Override
    public boolean validateSplits(List<Split> splitList, double totalAmount) {
        double amount = 0;
        for(Split split: splitList) {
            amount += split.getAmountOwe();
        }
        if(amount != totalAmount)return false;
        return true;
    }
}
