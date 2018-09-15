/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex61;

import java.io.Serializable;

/**
 *
 * @author Student
 */
public class BankAccount implements Serializable{
    private String cusName;
    private String address;
    private char sex;
    
    private double amount;
    private String accNumber;
    private String branch;

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getName() {
        return cusName;
    }

    public void setName(String name) {
        this.cusName = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public BankAccount(String name, String address, char sex, double amount, String accNumber, String branch) {
        this.cusName = name;
        this.address = address;
        this.sex = sex;
        this.amount = amount;
        this.accNumber = accNumber;
        this.branch = branch;
    }

    public BankAccount() {
    }
    
    
           
}
