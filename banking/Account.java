
import java.util.*;

interface IStatement {
    public String getTitle();
    public void setTitle(String title);
}

class Statement implements IStatement {
    private String title;

    Statement(String title) {
        this.setTitle(title);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

interface IAccount {
    public String getName();
    public void setName(String name);
    public int getBalance();
    public void setBalance(int balance);
    public int getType();
    public String getTypeLabel();
    public void setType(int type);

    // actions
    public void showBalance();
    public void checkMinBalance() throws Exception;
    public void creditBalance(int amount);
    public void debitBalance(int amount) throws Exception;
    public void makeCreditTransaction(int amount);
    public void makeDebitTransaction(int amount) throws Exception;
    public void showStatements();
}

class Account implements IAccount {
    private String name;
    private int balance = 0;
    private int type = 0;
    private int min_balance = 50;
    private ArrayList<Statement> statements = new ArrayList<Statement>();

    Account(String name) throws Exception {
        this.setName(name);
        this.checkMinBalance();
        this.setOpeningBalanceStatement();
    }
    Account(String name, int balance) throws Exception {
        this.setName(name);
        this.setBalance(balance);
        this.checkMinBalance();
        this.setOpeningBalanceStatement();
    }
    Account(String name, int balance, int type) throws Exception {
        this.setName(name);
        this.setBalance(balance);
        this.setType(type);
        this.checkMinBalance();
        this.setOpeningBalanceStatement();
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getBalance() {
        return this.balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getType(){
        return this.type;
    }
    public String getTypeLabel(){
        return this.getType() == 1 ? "Current Account" : "Savings Account";
    }
    public void setType(int type){
        this.type = type;
    }

    public ArrayList<Statement> getStatements() {
        return this.statements;
    }
    public void setStatements(ArrayList<Statement> statements) {
        this.statements = statements;
    }
    public void setStatement(Statement statement) {
        this.getStatements().add(statement);
    }

    public int getMinBalance() {
        return this.min_balance;
    }

    public void showBalance() {
        System.out.println("Balance for " + this.getName() + " is " + this.getBalance());
    }

    public void checkMinBalance() throws Exception {
        if (this.getType() == 0 && this.getBalance() < this.getMinBalance()) {
            throw new Exception("minimum balance " + this.getMinBalance() + " is required.");
        }
    }

    public void creditBalance(int amount) {
        this.setBalance(this.getBalance() + amount);
    }
    public void debitBalance(int amount) throws Exception {
        if (this.getBalance() < amount) throw new Exception("Low balance.");
        this.setBalance(this.getBalance() - amount);
        this.checkMinBalance();
    }
    public void makeCreditTransaction(int amount) {
        this.creditBalance(amount);
        Statement statement = new Statement("credit: " + amount);
        this.statements.add(statement);
    }
    public void makeDebitTransaction(int amount) throws Exception {
        this.debitBalance(amount);
        Statement statement = new Statement("debit: " + amount);
        this.statements.add(statement);
    }
    public void showStatements() {
        System.out.println("*****************************");
        System.out.println("for " + this.getName() + " current balance " + this.getBalance());
        for (Statement statement: this.getStatements()) {
            System.out.println(statement.getTitle());
        }
        System.out.println("*****************************");
    }
    public void setOpeningBalanceStatement() {
        this.setStatement(new Statement("Opening balance " + this.getBalance()));
    }

    public void makeTransfer(Account to, int amount) throws Exception {
        this.debitBalance(amount);
        this.setStatement(new Statement("you transffered " + amount + " to " + to.getName()));
        to.creditBalance(amount);
        to.setStatement(new Statement("you received " + amount + " from " + this.getName()));

    }
}


class Main {
    public static void main(String[] args) {
        try {
            Account aaqib = new Account("Aaquib", 50);
            aaqib.showBalance();
            aaqib.makeCreditTransaction(10);
            Account rashal = new Account("Rashal", 10, 1);
            rashal.showBalance();
            // aaqib.showStatements();
            // aaqib.makeTransfer(rashal, 20);
            // aaqib.showStatements();
            // rashal.showStatements();
            rashal.makeTransfer(aaqib, 20);
            rashal.showStatements();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}