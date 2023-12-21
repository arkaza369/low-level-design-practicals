# Splitwise LLD:
## Step1: Functional Requirements:
- Add friends capability.
- Add/manage group.
- Add/manage friends inside a group.
- Manage expenses inside a group or without a group.
- Split the expenses capability.
  [Equal split, unequal split, percentage wise split]
- Balance sheet of each user.
- Balance simplification and settlement with minimum number of transactions.

## Step2: Identify Classes and Objects:

1. Splitwise
2. User
3. UserController[crud operations of User]
4. Group
5. GroupController[crud operations of Group]
6. Split 
7. SplitStrategy - interface
8. SplitStrategyContext
9. PercentageSplitStrategy implements SplitStrategy [percentage split validator]
10. EqualSplitStrategy implements SplitStrategy [equal split validator]
11. ExactSplitStrategy implements SplitStrategy[exact split validator]
12. PercentageExpenseSplit extends Split 
13. EqualExpenseSplit extends Split 
14. ExactExpenseSplit extends Split 
15. Expense 
16. ExpenseBuilder - interface 
17. ExpenseBuilderImpl implements ExpenseBuilder 
18. ExpenseController[crud operations of Expense]


## Step3: Apply Design Patterns:
### Strategy Design Pattern

##### a)To choose expense split strategy.<br>
SplitStrategy - interface<br>
SplitStrategyContext<br>
PercentageSplitStrategy implements SplitStrategy [percentage split validator]<br>
EqualSplitStrategy implements SplitStrategy [equal split validator]<br>
ExactSplitStrategy implements SplitStrategy[exact split validator]<br>

### Builder Design Patten
##### b)To create Expense.<br>
Expense [keep expense meta data]<br>
ExpenseBuilder - interface<br>
ExpenseBuilderImpl implements ExpenseBuilder<br>
ExpenseController[create expense]<br>

## UML
