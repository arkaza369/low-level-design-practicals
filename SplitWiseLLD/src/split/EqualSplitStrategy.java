package split;

import java.util.List;

public class EqualSplitStrategy implements SplitStrategy{
    @Override
    public boolean validateSplits(List<Split> splitList, double totalAmount) {
        double amount = totalAmount/splitList.size();
        for(Split split: splitList) {
            if(split.getAmountOwe() != amount) {
                return false;
            }
        }
        return true;
    }
}
