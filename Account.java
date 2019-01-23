public class Account{

    int id;
    String name;
    String type;
    Double amount;

    public Account(int _id, String _name, String _type, Double _amount){
        this.id = _id;
        this.name = _name;
        this.type = _type.toUpperCase();
        this.amount = _amount;
    }
    // Functions

    public void AddAmount(Double topup){
        if(topup > 0)
            amount += topup;
    }

    // Setters
    public void SetName(String _name){
        this.name = _name;
    }

    public void SetType(String _type){
        this.type = _type;
    }

    //Getters

    public int GetId(){
        return this.id;
    } 

    public String GetName(){
        return this.name;
    }

    public String GetType(){
        return this.type;
    }

    public int GetAmount(){
        return this.amount;
    }






}