import java.util.*; 

public class Main{

    static Map<Integer,Account>CustomerList = new HashMap<Integer, Account>();

    //Holds the current count of the latest id 
    static int gen_count = 0;

    public static void main(String[] args){
        System.out.println("Testing ... ");

        CreateAccount(
        "Tim", 
        "CONCESSION",
        0.0);

        CustomerList.get(1).SetName("Greg");
        System.out.println(CustomerList.get(1).GetType());
    
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

}