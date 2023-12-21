package split;

import java.util.List;

public class SplitStrategyContext {
    SplitStrategy splitStrategy;
    public void setSplitStrategy(SplitStrategy splitStrategy){
        this.splitStrategy = splitStrategy;
    }
    public boolean validateSplits(List<Split>splitList, double totalAmount){
        return splitStrategy.validateSplits(splitList, totalAmount);
    }
}
