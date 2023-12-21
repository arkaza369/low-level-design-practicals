package split;

import java.util.List;

public interface SplitStrategy {
    public boolean validateSplits(List<Split> splitList, double totalAmount);
}
