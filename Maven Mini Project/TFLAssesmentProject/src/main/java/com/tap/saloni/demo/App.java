package com.tap.saloni.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tap.saloni.Entity.Question;
import com.tap.saloni.Repository.QuestionBank;
import com.tap.saloni.Store.FileIOManager;
import com.tap.saloni.ui.UIManager;

// Entry Point 
public class App {
    public static void main(String[] args) {
        QuestionBank questionBank = new QuestionBank();
        FileIOManager fileIOManager = new FileIOManager();

        Scanner scanner = new Scanner(System.in); 

        // running is a variable - It's used to control a loop
        boolean running = true;

        int choice;     // store the user's menu-options selection 
        UIManager uiManager = new UIManager();
        
        // Keeps showing the menu again and again until the user exits.
        while (running) {

            uiManager.displayMenu();  // Shows the list of options to the user

            choice = uiManager.getUserChoice(); // Reads the user’s menu selection (1 to 5) 

            switch (choice) {
                case 1:
                    // Add Question
                    Question newQuestion = uiManager.getQuestionInput();
                    questionBank.add(newQuestion);
                    List<Question> questions=new ArrayList<Question>();
                    questions=questionBank.getAll();

                    fileIOManager.saveQuestionsToFile(questions);
                    System.out.println("Question added and saved to file successfully!");
                    break;

                case 2:
                    // Remove Question
                    int questionIdToRemove = uiManager.getQuestionIdInput();
                    questionBank.remove(questionIdToRemove);
                    fileIOManager.saveQuestionsToFile(questionBank.getAll());
                    System.out.println("Question removed and changes saved to file.");
                    break;

                case 3:
                    // Update Question
                    int questionIdToUpdate = uiManager.getQuestionIdInput();
                    Question updatedQuestion = uiManager.getQuestionInput();
                    questionBank.update(questionIdToUpdate, updatedQuestion);
                    fileIOManager.saveQuestionsToFile(questionBank.getAll());
                    System.out.println("Question updated and saved to file successfully!");
                    break;

                case 4:
                    // View All Questions
                    List<Question> allQuestions = fileIOManager.loadQuestionsFromFile();
                    uiManager.displayQuestions(allQuestions);
                    System.out.println(" All questions displayed.");
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
