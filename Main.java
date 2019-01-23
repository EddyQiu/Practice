public class Main{

    static Map<Integer,Account>CustomerList = new HashMap<Integer, Account>();

    //Do Create Unique IDs / Psuedo ID generator.
    static int gen_count = 0;

    public static void main(String[] args){
        System.out.println("Testing ... ");
        Account Customer = new Account(
        GenerateId(),
        "Tim", 
        "CONCESSION",
        0);
    
    }

    public static int GenerateId(){
        gen_count += 1;
        return gen_count;
    }

    public static void CreateAccount(int _id, String _name, String _type, Double _amount){
        Account Customer = new Account(_id, _name, _type, _amount);
    }

    public static void DeleteAccount(int _id){
        CustomerList.remove(_id);
    }

}