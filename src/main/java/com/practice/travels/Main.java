package com.practice.travels;

import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Main{

    static Map<Integer,Account>CustomerList = new HashMap<Integer, Account>();

    //Holds the current count of the latest id 
    static int gen_count = 0;

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
        System.out.println("Welcome to Travels: "+args[0]);
    }

    @RequestMapping("/create")
    public void createAccount(@RequestParam(value="name", required=true) String _name, 
                                    @RequestParam(value="type", required=true) String _type,
                                        @RequestParam(value="amount", required=true) Double _amount){

        Account newAcc = CreateAccount(_name, _type, _amount);
        System.out.println(newAcc.GetId() + " / " + newAcc.GetName() + " / " + newAcc.GetType() + " / $" + newAcc.GetAmount());
    }

    // Temporarily generates unique ID and increments each time an account is created
    public static int GenerateId(){
        gen_count += 1;
        return gen_count;
    }

    // Creates an account
    public static Account CreateAccount(String _name, String _type, Double _amount){
        Account Customer = new Account(GenerateId(), _name, _type, _amount);
        CustomerList.put(Customer.id, Customer);
        return Customer;
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