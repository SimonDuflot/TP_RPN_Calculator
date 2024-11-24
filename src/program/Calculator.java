package program;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Calculatrice 'ala polonaise' prenant une saisie utilisateur, et effectue des operations.
 * Si c'est un nombre une liste est créée, il y est ajouté. Si la liste existe déjà, il y est ajouté.
 * Si c'est une chaîne de caractères, on vérifie qu'il y en a qu'un seul puis la calculatrice fait une opération
 * suivant la lettre saisie.
 *
 * @author sduflot
 * @version 0.1
 * @since 24/11/2024
 */
public class Calculator {

    /// ATTRIBUTES ///
    private String userInput;
    private double result = 0;
    private boolean exit = false;
    private boolean checkInput = false;
    private boolean isNumber = false;
    private boolean isStringOfOne = false;
    private List<Double> numbers = new ArrayList<>();

    /// METHODS ///
    public void showMenuStoreInputIfValid() {
        do {
            result = 0;
            checkInput = false;
            isNumber = false;
            isStringOfOne = false;
            StringBuilder displayStack = new StringBuilder();
            for (Double number : numbers) {
                displayStack.append("\r\n").append(number);
            }

            userInput = JOptionPane.showInputDialog(
                    displayStack +
                            "\r\nVeuillez saisir un opérande ou une opération : "
                            + "\r\n+ : addition."
                            + "\r\n- : soustraction."
                            + "\r\n* : multiplication."
                            + "\r\n/ : division."
                            + "\r\nc : supprime tous les nombres."
                            + "\r\ne : efface le dernier nombre entré."
                            + "\r\ni : change de place les deux derniers nombres entré."
                            + "\r\nq : quitter.");
            checkInput();
            processInput();
        } while (!exit);
    }

    public boolean checkInput() {
        if (isNumber() || isStringOfOne()) {
            return checkInput = true;
        }
        return checkInput = false;
    }

    /**
     * Is the user input a number
     *
     * @return an error message or number is valid
     */
    public boolean isNumber() {
        if (userInput == null || userInput.trim().isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(userInput.trim());
            return isNumber = true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Is the user input a String
     *
     * @return an error message or String is valid
     */
    public boolean isStringOfOne() {
        if (userInput.trim().length() == 1) {
            return isStringOfOne = true;
        }
        return false;
    }
    public void processInput() {
        if (isNumber && checkInput) {
            Double validInput = Double.parseDouble(userInput.trim());
            numbers.add(validInput);
        } else if (isStringOfOne && checkInput) {
            int lastNumber = (numbers.size() - 1);
            String validInput = userInput.toLowerCase().trim();
            switch (validInput) {
                case "c":
                    numbers.clear();
                    break;
                case "e":
                    numbers.remove(numbers.size() -1);
                    break;
                case "i": result = numbers.get(lastNumber - 1);
                            numbers.add(result);
                            numbers.remove(lastNumber -1);
                            break;
                case "q":
                    exit = true;
                break;
                case "+": result = numbers.get(lastNumber) + numbers.get((lastNumber -1));
                    numbers.add(result);
                            numbers.remove(lastNumber -1);
                            numbers.remove(lastNumber -1);

                            break;
                case "-": result = numbers.get(lastNumber) - numbers.get((lastNumber -1));
                    numbers.add(result);
                    numbers.remove(lastNumber -1);
                    numbers.remove(lastNumber -1);
                    break;
                case "*": result = numbers.get(lastNumber) * numbers.get((lastNumber -1));
                    numbers.add(result);
                    numbers.remove(lastNumber -1);
                    numbers.remove(lastNumber -1);
                    break;
                case "/": if (numbers.get((lastNumber -1)) != 0) {
                    result = numbers.get(lastNumber) / numbers.get((lastNumber - 1));
                    numbers.add(result);
                    numbers.remove(lastNumber -1);
                    numbers.remove(lastNumber -1);
                } else {
                    JOptionPane.showMessageDialog(null, "Impossible de diviser par 0.");
                }
                break;
                default:
            }
        }
    }
}

