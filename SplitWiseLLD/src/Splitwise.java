import balancesheet.BalanceSheetController;
import group.Group;
import group.GroupController;
import split.*;
import user.User;
import user.UserController;

import java.util.ArrayList;
import java.util.List;

public class Splitwise {

    UserController userController;
    GroupController groupController;

    BalanceSheetController balanceSheetController;
    SplitStrategyContext splitStrategyContext;

    Splitwise(){
        userController = new UserController();
        groupController = new GroupController();
        balanceSheetController = new BalanceSheetController();
        splitStrategyContext = new SplitStrategyContext();
    }

    public void init(){

        setUserAndGroup();

        //add members to the group
        Group group = groupController.getGroup("G1001");
        group.addMember(userController.getUser("U2001"));
        group.addMember(userController.getUser("U3001"));

        //create an expense inside a group
        List<Split> splits = new ArrayList<>();
        Split split1 = new EqualExpenseSplit(userController.getUser("U1001"), 300);
        Split split2 = new EqualExpenseSplit(userController.getUser("U2001"), 300);
        Split split3 = new EqualExpenseSplit(userController.getUser("U3001"), 300);
        splits.add(split1);
        splits.add(split2);
        splits.add(split3);

        splitStrategyContext.setSplitStrategy(new EqualSplitStrategy());
        group.createExpense("Exp1001", "Breakfast", 900, splits, splitStrategyContext, userController.getUser("U1001"),group);

        List<Split> splits2 = new ArrayList<>();
        Split splits2_1 = new ExactExpenseSplit(userController.getUser("U1001"), 400);
        Split splits2_2 = new ExactExpenseSplit(userController.getUser("U2001"), 100);
        splits2.add(splits2_1);
        splits2.add(splits2_2);

        splitStrategyContext.setSplitStrategy(new ExactSplitStrategy());
        group.createExpense("Exp1002", "Lunch", 500, splits2, splitStrategyContext, userController.getUser("U2001"),group);

        List<Split> splits3 = new ArrayList<>();
        Split splits3_1 = new PercentageExpenseSplit(userController.getUser("U1001"), 400,50);
        Split splits3_2 = new PercentageExpenseSplit(userController.getUser("U2001"), 400,50);
        splits3.add(splits3_1);
        splits3.add(splits3_2);

        splitStrategyContext.setSplitStrategy(new PercentSplitStrategy());
        group.createExpense("Exp1003", "Dinner", 800, splits3, splitStrategyContext, userController.getUser("U2001"),group);

        for(User user : userController.getAllUsers()) {
            //show balance sheet before simplification
            balanceSheetController.showUserBalanceSheet(user);
            //show balance sheet after simplification
            balanceSheetController.showSimplifiedUserBalanceSheet(user);
        }
    }

    public void setUserAndGroup(){
        //onboard user to splitwise app
        addUsersToSplitwiseApp();
        //create a group by user1
        User user1 = userController.getUser("U1001");
        groupController.createNewGroup("G1001", "Outing", user1);
    }
    private void addUsersToSplitwiseApp(){
        User user1 = new User("U1001", "User1");
        User user2 = new User ("U2001", "User2");
        User user3 = new User ("U3001", "User3");

        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);
    }
}


