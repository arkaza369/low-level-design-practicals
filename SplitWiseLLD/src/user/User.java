package user;

import balancesheet.ExpenseBalanceSheet;

public class User {
    String userId;
    String userName;
    ExpenseBalanceSheet userExpenseBalanceSheet;

    public User(String id, String userName){
        this.userId = id;
        this.userName = userName;
        userExpenseBalanceSheet = new ExpenseBalanceSheet();
    }
    public String getUserId() {
        return userId;
    }

    public ExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return userExpenseBalanceSheet;
    }

}
