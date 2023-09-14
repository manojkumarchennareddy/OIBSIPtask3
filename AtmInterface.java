import java.util.*;
 
 class Bank_Account{
    String name;
    String username;
    String password;
    String accountNo;
    float balance = 100000f;
    int transactions = 0;
    String transactionHistory ="";

    //Bank_Account(String name, String username, String password, String accountNo){
    // this.name = name;
    // this.username = username;
    // this.password = password;
    // this.accountNo = accountNo;
    // }
 
    public void register(){
        Scanner sc  = new Scanner(System.in);
        System.out.print("\nENTER YOUR NAME - ");
        this.name = sc.nextLine();
        System.out.print("\nENTER YOUR USERNAME - ");
        this.username = sc.nextLine();
        System.out.print("\nENTER PASSWORD - ");
        this.password = sc.nextLine();
        System.out.print("\nENTER YOUR ACCOUNT NUMBER - ");
        this.accountNo = sc.nextLine();
        System.out.println("\n1Registartion Completed.....");
        System.out.println("Kindly Login.....");
    }
    public boolean login(){
        Scanner sc = new Scanner(System.in);
        boolean isLogin = false;
        while( !isLogin ){
            System.out.print("\nENTER YOR USERNAME - ");
            String Username = sc.nextLine();
            if(Username.equals(username)){
                while( !isLogin ){
                    System.out.print("\nENTER YOUR PASSWORD - ");
                    String Password = sc.nextLine();
                    if(Password.equals(password)){
                        System.out.println("Login Successfully!!!");
                       isLogin = true;
                    }
                    else{
                        System.out.println("INCORRECT PASSWORD!!");
                    }
                }
            }
            else{
                System.out.println("USERNAME NOT FOUND!");
            }
        }
        return isLogin;
    }
    public void withdraw(){
        System.out.print("\nEnter Amount to Withdraw - ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try{
            if(balance >= amount){
                transactions++;
                balance -= amount;
                System.out.println("Withdraw Successfully!");
                String str =  "Rs " + amount + " Withdrawed\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else{
                System.out.println("INSUFFICIENT BALANCE");
            }
        }
        catch(Exception e){
        }
    }
    public void deposit(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Amount to Deposit - ");
        float amount = sc.nextFloat();
        try{
            if(amount <= 100000f){
                transactions++;
                balance += amount;
                System.out.println("Succesfully Deposited!");
                String str =  "Rs " + amount + " Deposited\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else{
                System.out.println("SORRY!  Limit is 100000.00");
            }
        }
        catch(Exception e){
        }
        
    }
    public void transfer(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Receipent's Name - ");
        String receipent = sc.nextLine();
        System.out.print("\nEnter Amount to Transfer - ");
        float amount = sc.nextFloat();
        try{
            if(balance >= amount){
                if(amount <= 50000f){
                    transactions++;
                    balance -= amount;
                    System.out.println("Succesfully Transferred to " + receipent);
                    String str = "Rs " +amount + " Transferred to " + receipent +"\n";
                    transactionHistory = transactionHistory.concat(str);
                }
                else{
                    System.out.println("SORRY! Limit is 50000.00");
                }
            }
            else{
                System.out.println("INSUFFICIENT BALANCE!");
            }
        }
        catch(Exception e){
        }
    }
    public void checkBalance(){
        System.out.println("\n" + balance + "Rs");

    }
    public void transaction_History(){
    
        if(transactions == 0){
            System.out.println("EMPTY!");

        }
        else{
            System.out.println("\n" + transactionHistory);
        }
    }
 }
  public class AtmInterface{
    public static int takeIntegerInput(int limit){
        int input = 0;
        boolean flag = false;
         while(!flag){
            try{
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if(flag && input > limit || input < 1){
                    System.out.println("Choose number between 1 to "+ limit);
                    flag = false;

                }
            }
            catch(Exception e){
                System.out.println("Enter only Integer Value");
                flag = false;
            }
            
         };
         return input;
    }
    public static void main(String [] args){
        System.out.println("******* WELCOME TO OASIS ATM SYSTEM *******");
        System.out.println("1.Register \n2.Exit");
        System.out.print("Enter Your Choice - ");
        int choice = takeIntegerInput(2);
        if(choice == 1){
            Bank_Account ob = new Bank_Account();
            ob.register();
            while(true){
                System.out.println("\n1.Login \n2.Exit");
                System.out.print("\nEnter Your Choice - ");
                int a = takeIntegerInput(2);
                if( a == 1 ){
                    if(ob.login()){
                        System.out.println("\n\n******* WELCOME BACK " + ob.name + " *******\n");
                        boolean isFinished = false;
                        while(!isFinished){
                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                            System.out.print("\nEnter Your Choice - ");
                            int ch = takeIntegerInput(6);
                            switch(ch){
                                case 1:
                                ob.withdraw();
                                break;
                                case 2:
                                ob.deposit();
                                break;
                                case 3:
                                ob.transfer();
                                break;
                                case 4 :
                                ob.checkBalance();
                                break;
                                case 5:
                                ob.transaction_History();
                                break;
                                case 6:
                                isFinished = true;
                                break;
                            }
                        }
                    }
                }
                else{
                    System.exit(0);
                }
            }
        }
        else{
            System.exit(0);
        }
    }
  }
 