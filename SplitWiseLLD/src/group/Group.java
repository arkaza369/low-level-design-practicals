package group;

import expense.Expense;
import expense.ExpenseController;
import split.Split;
import split.SplitStrategyContext;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String groupId;
    String groupName;
    List<User> groupMembers;

    List<Expense> expenseList;

    ExpenseController expenseController;

    Group() {
        groupMembers = new ArrayList<>();
        expenseList = new ArrayList<>();
        expenseController = new ExpenseController();
    }

    //add member to group
    public void addMember(User member) {
        groupMembers.add(member);
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<Split> splitDetails, SplitStrategyContext splitStrategyContext, User paidBy, Group group) {

        Expense expense = expenseController.createExpense(expenseId, description, expenseAmount, splitDetails, splitStrategyContext, paidBy, this);
        expenseList.add(expense);
        return expense;

    }
};
