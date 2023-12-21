package balancesheet;

import split.Split;
import user.User;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {

    //this function is responsible for updating the balance sheet of the user who paid the expense
    public void updateExpenseBalanceSheet(User paidBy, List<Split> splitDetails, double totalExpenseAmount){
        //take the balance sheet of user who made the payment
        ExpenseBalanceSheet userExpenseBalanceSheet = paidBy.getUserExpenseBalanceSheet();
        //traverse the split list , take user details who owe the amount, to the user who made the payment.
        for(Split split : splitDetails) {
            User userOwe = split.getUser();
            ExpenseBalanceSheet oweUserExpenseBalanceSheet = userOwe.getUserExpenseBalanceSheet();
            double oweAmount = split.getAmountOwe();
            //if current user is the one who made the payment, add amount to it's total expense
            if(paidBy.getUserId().equals(userOwe.getUserId())){
                userExpenseBalanceSheet.setTotalExpense(userExpenseBalanceSheet.getTotalExpense()+oweAmount);
            }
            else {
                //update the balance of user who made the payment, add this amount to this user's total get back.
                userExpenseBalanceSheet.setTotalGetBack(userExpenseBalanceSheet.getTotalGetBack() + oweAmount);
                //now inside paid user's balance map, update the current user get back amount entry .
                // As current user owe this amount to the user who made the payment.
                Balance userOweBalance;
                if(userExpenseBalanceSheet.getUserVsBalance().containsKey(userOwe.getUserId())) {
                    userOweBalance = userExpenseBalanceSheet.getUserVsBalance().get(userOwe.getUserId());
                }
                else {
                    userOweBalance = new Balance();
                    userExpenseBalanceSheet.getUserVsBalance().put(userOwe.getUserId(), userOweBalance);
                }
                userOweBalance.setGetBack(userOweBalance.getGetBack() + oweAmount);
            }
            //now update the balance sheet of the user who owe amount, to the user who made the payment
            oweUserExpenseBalanceSheet.setTotalOwe(oweUserExpenseBalanceSheet.getTotalOwe() + oweAmount);
            oweUserExpenseBalanceSheet.setTotalExpense(oweUserExpenseBalanceSheet.getTotalExpense() + oweAmount);
            //now inside current user's balance map, update the paid user's amount entry .
            //As current user owe this amount to the user who made the payment, we need to update owe amount entry.
            Balance userPaidBalance;
            if(oweUserExpenseBalanceSheet.getUserVsBalance().containsKey(paidBy.getUserId())){
                userPaidBalance = oweUserExpenseBalanceSheet.getUserVsBalance().get(paidBy.getUserId());
            }
            else{
                userPaidBalance = new Balance();
                oweUserExpenseBalanceSheet.getUserVsBalance().put(paidBy.getUserId(), userPaidBalance);
            }
            userPaidBalance.setOwe(userPaidBalance.getOwe() + oweAmount);
        }
        //update total payment done by the user who paid the expense
        userExpenseBalanceSheet.setTotalPayment(userExpenseBalanceSheet.getTotalPayment() + totalExpenseAmount);
    }

    public void showUserBalanceSheet(User user){

        System.out.println("---------------------------------------");
        System.out.println("Balance sheet of user : " + user.getUserId());

        ExpenseBalanceSheet userExpenseBalanceSheet =  user.getUserExpenseBalanceSheet();
        System.out.println("Total Expense: " + userExpenseBalanceSheet.getTotalExpense());
        System.out.println("Total GetBack: " + userExpenseBalanceSheet.getTotalGetBack());
        System.out.println("Total Owe: " + userExpenseBalanceSheet.getTotalOwe());
        System.out.println("Total Paymnet Made: " + userExpenseBalanceSheet.getTotalPayment());

        for(Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getUserVsBalance().entrySet()){
            String userID = entry.getKey();
            Balance balance = entry.getValue();
            System.out.println("userID:" + userID + " You Get Back:" + balance.getGetBack() + " You Owe:" + balance.getOwe());
        }

        System.out.println("---------------------------------------");

    }
        public void showSimplifiedUserBalanceSheet(User user){
        ExpenseBalanceSheet userExpenseBalanceSheet =  user.getUserExpenseBalanceSheet();
        Map<String, Double>balanceMap = null;
        for(Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getUserVsBalance().entrySet()){
            String userID = entry.getKey();
            Balance balance = entry.getValue();
            double amount_owe_user = balanceMap.getOrDefault(user, 0.0) + balance.getOwe();
            //giver: user, receiver:userID
            balanceMap.merge(String.valueOf(user), -amount_owe_user, Double::sum);
            balanceMap.merge(String.valueOf(userID), amount_owe_user, Double::sum);
            double amount_getback_user = balanceMap.getOrDefault(user, 0.0) + balance.getGetBack();
            //giver: userID, receiver:user
            balanceMap.merge(String.valueOf(user), amount_getback_user, Double::sum);
            balanceMap.merge(String.valueOf(userID), -amount_getback_user, Double::sum);
        }
        List<Simplify.Transaction> minTransactionsAfterSimplify = new Simplify(balanceMap).simplify();
        int noOfTransactions = minTransactionsAfterSimplify.size();
        System.out.println("Min number of Transactions: " + noOfTransactions);
        for (Simplify.Transaction t : minTransactionsAfterSimplify) {
            System.out.println(t.user1 + " " + t.transType + " " + t.user2 + " " + t.amount);
        }
    }
}



