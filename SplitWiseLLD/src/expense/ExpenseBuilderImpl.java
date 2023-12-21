package expense;

import group.Group;
import split.Split;
import split.SplitStrategyContext;
import user.User;

import java.util.List;

public class ExpenseBuilderImpl extends ExpenseBuilder{
    public ExpenseBuilderImpl() {
        expense = new Expense();
    }

    @Override
    ExpenseBuilder withExpenseId(String expenseId) {
        expense.expenseId = expenseId;
        return this;
    }

    @Override
    ExpenseBuilder withDescription(String description) {
        expense.description = description;
        return this;
    }

    @Override
    ExpenseBuilder withAmount(double expenseAmount) {
        expense.expenseAmount = expenseAmount;
        return this;
    }

    @Override
    ExpenseBuilder withPaidByUser(User paidByUser) {
        expense.paidBy = paidByUser;
        return this;
    }

    @Override
    ExpenseBuilder withExpenseSplitStrategy(SplitStrategyContext splitStrategyContext) {
        expense.splitStrategyContext = splitStrategyContext;
        return this;
    }

    @Override
    ExpenseBuilder withSplits(List<Split> splitDetailsList) {
        expense.splitDetailsList = splitDetailsList;
        return this;
    }

    @Override
    ExpenseBuilder withGroup(Group group) {
        expense.group = group;
        return this;
    }
}
