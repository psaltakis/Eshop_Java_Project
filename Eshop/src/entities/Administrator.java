/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.util.Date;


public class Administrator extends User {
     public Administrator(String name, String username, String telephone, String email, String password, Date dateRegistered) {
        super(name, username, telephone, email, password, dateRegistered);
    }
     public String getUserInfo() {
         return getName()+","+getTelephone()+","+getEmail();
}}
