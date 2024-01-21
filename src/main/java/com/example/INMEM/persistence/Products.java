package com.example.INMEM.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This indicates that this class is an entity( Table in a database)
public class Products {

    /*
    The id annotation identifies the primary key of the table
    The @GeneratedValue specify the strategy for generating unique automatic
    primary key ids for products
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long productID; // must be long always for numerical data, int is automatically rejected
    private String name;
    private int quantity;
    private double unitPrice;

    public Products(){} // Default contructor for JPA


    /*
    public Products(String name, int quantity, double unitPrice){
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

*/

    //setters

    public void setName(String name){
        this.name = name;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setUnitPrice(double unitPrice){
        this.unitPrice = unitPrice;
    }

    //getters
    public String getName(){
        return name;
    }

    public int getQuantity(){
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String toString(){

        return "Products {" +
                "id: "+ productID +"\n"+
                ",product name: '"+ name +"\n"+
                ",quantity: " + quantity +"\n"+
                "unit price" + unitPrice + "\n"+

                "}";


    }



}
