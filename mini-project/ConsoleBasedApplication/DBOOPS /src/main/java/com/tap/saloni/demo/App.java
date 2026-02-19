package com.tap.saloni.demo;

import com.tap.saloni.UI.UIManager;
import com.tap.saloni.DBManagement.DBManager;

public class App {

    public static int choice;
    public static void main(String args[]) {
        UIManager manager = new UIManager();
        do {
            manager.displayMenu();
            choice = manager.getChoice();
            switch (choice) {
                case 1: {
                    if(DBManager.create()) {
                        UIManager.displayMessage(0);
                    }
                    break;
                }
                case 2: {
                    int rowsAffected = DBManager.insert();
                    if( rowsAffected > -1) {
                        UIManager.displayMessage(rowsAffected);
                    }
                    break;
                }
                case 3: {
                    int rowsAffected = DBManager.update();
                    if( rowsAffected > -1) {
                        UIManager.displayMessage(rowsAffected);
                    }
                    break;
                }
                case 4: {
                    int rowsAffected = DBManager.delete();
                    if( rowsAffected > -1) {
                        UIManager.displayMessage(rowsAffected);
                    }
                    break;
                }
                case 5: {
                    int rowsAffected = DBManager.getAll();
                    if( rowsAffected > -1) {
                        UIManager.displayMessage(rowsAffected);
                    }
                    break;
                }
                case 6: {
                    int rowsAffected = DBManager.truncate();
                    if( rowsAffected > -1) {
                        UIManager.displayMessage(rowsAffected);
                    }
                    break;
                }
                case 7: {
                    if(DBManager.alter()) {
                        UIManager.displayMessage(0);
                    }
                    break;
                }
                case 8: {
                    if(DBManager.drop()) {
                        UIManager.displayMessage(0);
                    }
                    break;
                }
                case 9: {
                    UIManager.displayMessage(0);
                    DBManager.close();
                    break;
                }
                default:
                    UIManager.displayMessage(0);
                    break;
            }

        } while (choice != 9);
    }
}