package Project;
import java.util.Scanner;
import java.io.*;
import java.util.HashMap;
import java.util.Date;




 class Account {
    private int customerNumber;
    private int pinNumber;
    public double checkingBalance=0;
    public double savingBalance=0;
   Scanner in=new Scanner(System.in);
   public int setCustomerNumber(int customerNumber)
   {
    this.customerNumber=customerNumber;
    return customerNumber;
   }

   public int getCustomerNumber(){
    return customerNumber;
   }

   public int setPinNumber(int pinNumber)
   {
    this.pinNumber=pinNumber;
    return pinNumber;
   }

   public int getPinNumber(){
    return pinNumber;
   }

public double calcCheckingWithdraw(double amount)
{
    checkingBalance=(checkingBalance-amount);
    return checkingBalance;
}

public double calcSavingWithdraw(double amount)
{
    savingBalance=(savingBalance-amount);
    return savingBalance;
}

public double calcCheckingDeposit(double amount)
{
    checkingBalance=(checkingBalance+amount);
    return checkingBalance;
}

public double calcSavingDeposit(double amount)
{
    savingBalance=(savingBalance+amount);
    return savingBalance;
}



public void getCheckingWithdrawInput()
{
    System.out.println("Current Account Balance: " +checkingBalance);
    System.out.println("Amount you want to withdraw from Current Account:");
    double amount=in.nextDouble();

    if((checkingBalance-amount)>=0){
        calcCheckingWithdraw(amount);
        System.out.println("New Current Account Balnace: "+checkingBalance);
    }else{
        System.out.println("Invalid Amount." + "\n");
    }
}

public void getSavingWithdrawInput()
{
    System.out.println("Saving Account Balance: " +savingBalance);
    System.out.println("Amount you want to withdraw from Saving Account:");
    double amount=in.nextDouble();

    if((savingBalance-amount)>=0){
        calcSavingWithdraw(amount);
        System.out.println("New Saving Account Balnace: "+savingBalance);
    }else{
        System.out.println("Invalid Amount." + "\n");
    }
}


public void getCheckingDepositInput()
{
    System.out.println("Current Account Balance: " +checkingBalance);
    System.out.println("Amount you want to Deposit to Current Account:");
    double amount=in.nextDouble();

    if((checkingBalance+amount)>=0){
        calcCheckingDeposit(amount);
        System.out.println("New Current Account Balnace: "+checkingBalance);
    }else{
        System.out.println("Invalid Amount ." + "\n");
    }
}


public void getSavingDepositInput()
{
    System.out.println("Saving Account Balance: " +savingBalance);
    System.out.println("Amount you want to Deposit from Saving Account:");
    double amount=in.nextDouble();

    if((savingBalance+amount)>=0){
        calcSavingDeposit(amount);
        System.out.println("New Saving Account Balnace: "+savingBalance);
    }else{
        System.out.println("Invalid Amount." + "\n");
    }
}



}

class option extends Account {
    Date date = new Date();
    Scanner sc = new Scanner(System.in);
    //first int for customer number and second for pin
    HashMap<Integer,Integer> data = new HashMap<Integer,Integer>();

    public void getlogin() throws IOException {
         int x = 1;
         do {
              try {
                data.put(12345,6543);
                data.put(45678,5432);

                System.out.println("WELCOME TO THE ATM PROJECT!");
                System.out.println("Enter your Customer Number");
                setCustomerNumber(sc.nextInt());

                System.out.println("Enter Your Pin ");
                setPinNumber(sc.nextInt());
              }
              catch(Exception e)
              {
                System.out.println("invalid Character");
                x=2;
              }
            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if(data.containsKey(cn) && data.get(cn)==pn)
            {
               getAccountType();
            }
            else{
                System.out.println("Wrong Pin Or Id ");
            }
            }while(x==1);
         }
    
    public void getAccountType()
    {
        System.out.println("Select The Account You Want To Acces");
        System.out.println("Type 1  ---  Current Account");
        System.out.println("Type 2  ---  Saving Account");
        System.out.println("Type 3 ---  Exit");

        int selection = sc.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2 :
                getSaving();
                break;
            case 3 :
                System.out.println("Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("You have Entered a Wrong Choice");
                
                break;

        }
    }
    int z = 1;
    public void getChecking()
    {
        System.out.println("Current Account: ");
        System.out.println(" Type 1 -  View Balance ");
        System.out.println(" Type 2 -  Withdraw Funds ");
        System.out.println(" Type 3 -  Deposit Funds");
        System.out.println(" Type 4 -  Exit");

        int selection = sc.nextInt();
        FileWriter f = null;
        try {
            f = new FileWriter("currentTransactions.txt" , true);
            if (z==1) {
                int x = getCustomerNumber();
                f.write( "Customer id - " +x + " logged into current Account on "+date.toString());
                f.write("\n");
                z++;
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("exception found");
        }
        switch (selection) {
            case 1:
                System.out.println("Current Account Balance: "+ checkingBalance);//checking balance
                //FileWriter f = null;
                try {
                 //   f = new FileWriter("ti.txt");
                    f.write("balance in your account is     ");
                    f.write(checkingBalance + " ");
                    f.close();
                } catch (Exception e) {
                    System.out.println("exception found");
                }
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                try {
                 //   f = new FileWriter("ti.txt");
                    f.write("After withdrawing, balance in your account is - ");
                    f.write(checkingBalance + " ");
                    f.write("\n");
                    f.close();
                } catch (Exception e) {
                    System.out.println("exception found");
                }
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                try {
                //    f = new FileWriter("ti.txt");
                    f.write("After depositing, balance in your account is - ");
                    f.write(checkingBalance + " ");
                    f.write("\n");
                    f.close();
                } catch (Exception e) {
                    System.out.println("exception found");
                }
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice");
                getChecking(); 
                break;
        }
    }
    int c=1;
    public void getSaving()
    {
        System.out.println("Saving Account: ");
        System.out.println(" Type 1 -  View Balance ");
        System.out.println(" Type 2 -  Withdraw Funds ");
        System.out.println(" Type 3 -  Deposit Funds");
        System.out.println(" Type 4 -  Exit");

        int selection = sc.nextInt();

        FileWriter f = null;
        try {
            f = new FileWriter("savingTransactions.txt" , true);
            if (c==1) {
                int x = getCustomerNumber();
                f.write( "Customer id - " +x + " logged into saving Account on "+date.toString());
                f.write("\n");
                c++;
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("exception found");
        }
        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: "+ savingBalance);//checking balance
                //FileWriter f = null;
                try {
                 //   f = new FileWriter("ti.txt");
                    f.write("Balance in your account is - "+savingBalance+"\n"   );
                    
                    f.close();
                } catch (Exception e) {
                    System.out.println("exception found");
                }
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                try {
                 //   f = new FileWriter("ti.txt");
                    f.write("After withdrawing balance in your account is  -  ");
                    f.write(savingBalance + " ");
                    f.write("\n");
                    f.close();
                } catch (Exception e) {
                    System.out.println("exception found");
                }
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                try {
                //    f = new FileWriter("ti.txt");
                    f.write("After depositing  balance in your account is - ");
                    f.write(savingBalance + " ");
                    f.write("\n");
                    f.close();
                } catch (Exception e) {
                    System.out.println("exception found");
                }
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice");
                getSaving(); 
                break;
        }
    }
} 


 public class ATM extends option{
public static void main(String [] args) throws IOException{
    option f1= new option();
    f1.getlogin();
}


}