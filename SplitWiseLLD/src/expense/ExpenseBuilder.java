package expense;

import group.Group;
import split.Split;
import split.SplitStrategy;
import split.SplitStrategyContext;
import user.User;

import java.util.List;

public abstract class ExpenseBuilder {
    protected Expense expense;

    abstract ExpenseBuilder withExpenseId(String expenseId);

    abstract ExpenseBuilder withDescription(String description);

    abstract ExpenseBuilder withAmount(double expenseAmount);

    abstract ExpenseBuilder withPaidByUser(User paidByUser);

    abstract ExpenseBuilder withExpenseSplitStrategy(SplitStrategyContext splitStrategyContext);

    abstract ExpenseBuilder withSplits(List<Split> splitDetailsList);

    abstract ExpenseBuilder withGroup(Group group);

    Expense build() {
        return expense;
    }
}
