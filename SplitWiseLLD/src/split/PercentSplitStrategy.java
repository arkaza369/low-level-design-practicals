package split;

import java.util.List;

public class PercentSplitStrategy implements SplitStrategy{

    @Override
    public boolean validateSplits(List<Split> splitList, double totalAmount) {
        double total_percentage = 100;
        double sum_percentage = 0;
        for(int i=0;i<splitList.size();i++){
            PercentageExpenseSplit percentageSplit = (PercentageExpenseSplit) splitList.get(i);
            sum_percentage += percentageSplit.getPercentage();
        }
        if(sum_percentage != total_percentage)return false;
        return true;

    }
}
