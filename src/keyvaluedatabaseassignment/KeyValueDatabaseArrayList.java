/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyvaluedatabaseassignment;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kshiteej
 */
public class KeyValueDatabaseArrayList {

    /**
     * @param args the command line arguments
     */
    private ArrayList<Datum> database;
    
    public KeyValueDatabaseArrayList() {
        database = new ArrayList();
    }
    
    public boolean insert(int key, String data) {
        Datum a = new Datum(key,data);
        return database.add(a);
    }
    
    public String read(int key) {
        for (Datum a : database) {
            if (a.key == key) {
                return a.data;
            }
        }
        return null;
    }
    
    public void update(int key, String newData) {
        for (Datum a : database) {
            if (a.key == key) {
                a.data = newData;
            }
        }
    }
    
    public void delete(int key) {
        int i = 0;
        for (; i < database.size(); i++) {
            Datum a = database.get(i);
            if (a.key == key) {
                break;
            }
        }
        database.remove(i);
    }
    
    public void displayAllRecords() {
        for (Datum a : database) {
            System.out.print(a.key + " : " + a.data + " , ");
        }
    }
    
    public void writeToFile() {
        try {
            FileWriter fw = new FileWriter("data.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (Datum a : database ){
                String dummy = a.key + " : " + a.data;
                pw.print(dummy + "\n");
            }
            pw.close();
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        KeyValueDatabaseArrayList dumdum = new KeyValueDatabaseArrayList();
        while (true) {
            System.out.println("Welcome to a basic CRUD Key - Value Pair database.\n Press 1 to insert a new entry \n Press 2 to search for a specific record based on its key \n Press 3 to update a record \n Press 4 to delete a record \n Press 5 to display all records. \n Press 6 to exit \n Press 7 to print to file.");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option) {
                case 1 :    System.out.println("Type in new key and data for new record.");
                            int key = sc.nextInt();
                            String data = sc.next();
                            dumdum.insert(key, data);
                            break;
                case 2 :    System.out.println("Type in the key for the record you wish to search for.");
                            key = sc.nextInt();
                            System.out.println(dumdum.read(key));
                            break;
                case 3 :    System.out.println("Please enter the key and the new data entry for the record you wish to update");
                            key = sc.nextInt();
                            data = sc.next();
                            dumdum.update(key, data);
                            break;
                case 4  :   System.out.println("Please enter the key of the record you wish to delete.");
                            key = sc.nextInt();
                            dumdum.delete(key);
                            break;
                case 5  :   dumdum.displayAllRecords();
                            break;
                case 6  :   System.exit(0);
                            break;
                case 7  :   dumdum.writeToFile();
            }
            
        
        
        
        
        
        }
    
    
    
    }
    
}
