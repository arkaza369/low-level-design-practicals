package expense;

import group.Group;
import split.Split;
import split.SplitStrategy;
import split.SplitStrategyContext;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    String expenseId;
    String description;
    double expenseAmount;
    User paidBy;
    SplitStrategyContext splitStrategyContext;
    List<Split> splitDetailsList = new ArrayList<>();
    Group group;
    
    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public User getpaidBy() {
        return paidBy;
    }

    public void setpaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public SplitStrategyContext getSplitStrategyContext() {
        return splitStrategyContext;
    }

    public void setSplitStrategyContext(SplitStrategyContext splitStrategyContext) {
        this.splitStrategyContext = splitStrategyContext;
    }

    public List<Split> getSplitDetailsList() {
        return splitDetailsList;
    }

    public void setSplitDetailsList(List<Split> splitDetailsList) {
        this.splitDetailsList = splitDetailsList;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
