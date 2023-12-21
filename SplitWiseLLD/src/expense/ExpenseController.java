package expense;

import balancesheet.BalanceSheetController;
import group.Group;
import split.*;
import user.User;

import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController;

    public ExpenseController() {
        balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<Split> splitDetails, SplitStrategyContext splitStrategyContext, User paidByUser, Group group){

        splitStrategyContext.validateSplits(splitDetails,expenseAmount);
        Expense expense = new ExpenseBuilderImpl().withExpenseId(expenseId)
                .withDescription(description)
                .withAmount(expenseAmount)
                .withPaidByUser(paidByUser)
                .withExpenseSplitStrategy(splitStrategyContext)
                .withSplits(splitDetails)
                .withGroup(group)
                .build();

        balanceSheetController.updateExpenseBalanceSheet(paidByUser, splitDetails, expenseAmount);

        return expense;
    }


}
