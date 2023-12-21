package split;

import user.User;

import java.util.List;

public class PercentageExpenseSplit extends Split {
    double percentage;

    public PercentageExpenseSplit(User user, double amountOwe, double percentage) {
        super(user, amountOwe);
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
