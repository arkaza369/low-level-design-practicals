package balancesheet;

import java.util.*;

public class Simplify {
    Map<String, Double> userVsBalance;

    public Simplify(Map<String, Double> userVsBalance) {
        this.userVsBalance = userVsBalance;
    }
    class Transaction {
        String user1;
        String user2;
        String transType;
        double amount;

        Transaction(String user1, String user2, String transType, double amount) {
            this.user1 = user1;
            this.user2 = user2;
            this.transType = transType;
            this.amount = amount;
        }
    }
    public List<Transaction> simplify() {
        List<Transaction> ans = new ArrayList<>();
        //prepare two max heaps, put all +ve amount in credit(user who get back), all -ve amount in debit(user who owe)
        PriorityQueue<Map.Entry<String, Double>> credit = new PriorityQueue<>(Comparator.comparingDouble(Map.Entry::getValue));
        PriorityQueue<Map.Entry<String, Double>> debit = new PriorityQueue<>(Comparator.comparingDouble(Map.Entry::getValue));

        for (Map.Entry<String, Double> balance : userVsBalance.entrySet()) {
            String user = balance.getKey();
            double amount = balance.getValue();
            Map.Entry<String, Double> entry;
            if (amount > 0) {
                entry = new AbstractMap.SimpleEntry<>(user, amount);
                credit.offer(entry);
            } else if (amount < 0) {
                entry = new AbstractMap.SimpleEntry<>(user, -amount);
                debit.offer(entry);
            }
        }
//pop top elements from both heaps and make the transaction from debit to credit.
        while (!credit.isEmpty() && !debit.isEmpty()) {
            Map.Entry<String, Double> creditValue = credit.poll();
            Map.Entry<String, Double> debitValue = debit.poll();

            if (creditValue.getValue() > debitValue.getValue()) {
                double amountLeft = creditValue.getValue() - debitValue.getValue();
                Transaction t = new Transaction(debitValue.getKey(), creditValue.getKey(), "owes", debitValue.getValue());
                ans.add(t);
                Map.Entry<String, Double> entry = new AbstractMap.SimpleEntry<>(creditValue.getKey(), amountLeft);
                credit.offer(entry);
            } else if (creditValue.getValue() < debitValue.getValue()) {
                double amountLeft = debitValue.getValue() - creditValue.getValue();
                Transaction t = new Transaction(debitValue.getKey(), creditValue.getKey(), "owes", creditValue.getValue());
                ans.add(t);
                Map.Entry<String, Double> entry = new AbstractMap.SimpleEntry<>(debitValue.getKey(), amountLeft);
                debit.offer(entry);
            } else {
                Transaction t = new Transaction(debitValue.getKey(), creditValue.getKey(), "owes", creditValue.getValue());
                ans.add(t);
            }
        }
        return ans;
    }
}
