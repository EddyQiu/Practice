public class Account{

    String name
    String type
    Double amount

    public Account(String _name, String _type, int _amount){
        this.name = _name;
        this.type = _type.toUpperCase();
        this.amount = _amount;
    }

    public void CreateAccount(String _name, String _type, int _amount){
        Account Customer = new Account(_name, _type, _amount);
    }

    public void UpdateAccount(){

    }

    public void DeleteAccount(){


    }

    public String GetName(){
        return this.name;
    }






}