package travels;

import java.util.*; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


public class Main{

    static Map<Integer,Account>CustomerList = new HashMap<Integer, Account>();

    //Holds the current count of the latest id 
    static int gen_count = 0;

    public static void main(String[] args){
        System.out.println("Welcome to Travels");

        CreateAccount(
        "Tim", 
        "SENIOR",
        0.0);

        CreateAccount(
        "Bob", 
        "Adult",
        17.30);

        CustomerList.get(1).SetName("Greg");
        CustomerList.get(1).AddAmount(10.0);
        PrintAll();
    }

    // Temporarily generates unique ID and increments each time an account is created
    public static int GenerateId(){
        gen_count += 1;
        return gen_count;
    }

    // Creates an account
    public static void CreateAccount(String _name, String _type, Double _amount){
        Account Customer = new Account(GenerateId(), _name, _type, _amount);
        CustomerList.put(Customer.id, Customer);
    }

    // Deletes an account
    public static void DeleteAccount(int _id){
        CustomerList.remove(_id);
    }

    // TESTING
    //Print all entries
    public static void PrintAll(){
        Iterator it = CustomerList.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, Account> pair = (Map.Entry)it.next();
            Account temp = pair.getValue();
            System.out.println(temp.GetId() + " / " + temp.GetName() + " / " + temp.GetType() + " / $" + temp.GetAmount());
        }
    }

    // Print X amount of entries
    public static void PrintX(int _count){
        int count = 0;
        Iterator it = CustomerList.entrySet().iterator();
        while(it.hasNext() && count < _count){
            count++;
            Map.Entry<Integer, Account> pair = (Map.Entry)it.next();
            Account temp = pair.getValue();
            System.out.println(temp.GetId() + " / " + temp.GetName() + " / " + temp.GetType() + " / $" + temp.GetAmount());
        }
    }

}