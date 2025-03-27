package practiceAssignment.codility;

import java.util.Scanner;

public class checkPasswordStrength {
	
	public static String checkPasswordStrength(String password) {
		
        if (password.length() < 5) {
            return "too weak)";
        }

        boolean hasLetter = false, hasDigit = false, hasSpecialChar = false;
        String specialChars = "!@#$%^&*(){}[]|";

        for (char ch : password.toCharArray()) {
            if (Character.isLetter(ch)) hasLetter = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (specialChars.indexOf(ch) != -1) hasSpecialChar = true;
        }

        if (hasLetter && hasDigit && hasSpecialChar && password.length() >= 7) {
            return "Strong";
        } else if (hasLetter && hasDigit) {
            return "Medium";
        } else {
            return "Weak";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please Enter your password: ");
        String password = scanner.nextLine();

        String strength = checkPasswordStrength(password);
        System.out.println("strength of password: " + strength);

        scanner.close();
    }
	
}
