package balancesheet;

import java.util.HashMap;
import java.util.Map;

//this class is responsible for generating expense sheet of a particular user.
public class ExpenseBalanceSheet {
    Map<String, Balance> userVsBalance;
    double totalExpense;

    double totalPayment;

    double totalOwe;
    double totalGetBack;

    public ExpenseBalanceSheet(){
        userVsBalance = new HashMap<>();
        totalExpense = 0;
        totalOwe = 0;
        totalGetBack = 0;
    }


    public Map<String, Balance> getUserVsBalance() {
        return userVsBalance;
    }

    public void setUserVsBalance(Map<String, Balance> userVsBalance) {
        this.userVsBalance = userVsBalance;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getTotalOwe() {
        return totalOwe;
    }

    public void setTotalOwe(double totalOwe) {
        this.totalOwe = totalOwe;
    }

    public double getTotalGetBack() {
        return totalGetBack;
    }

    public void setTotalGetBack(double totalGetBack) {
        this.totalGetBack = totalGetBack;
    }
}
