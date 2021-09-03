package hw6_InsuranceManagementSystem;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AccountManager accountManager = new AccountManager();

        User user1 = new User("def", "abcdef", "def@gmail.com", "1234", "backend developer", 25, LocalDate.of(2021, 7, 3));
        Individual individual1 = new Individual(user1);

        User user2 = new User("xyz", "dexy", "xyz@gmail.com", "0123", "frontend developer", 20, LocalDate.of(2021, 9, 1));
        Individual individual2 = new Individual(user2);

        User user3 = new User("abc", "abcde", "abc@gmail.com", "123", "fullstack developer", 23, LocalDate.of(2021, 9, 3));
        Individual individual3 = new Individual(user3);

        accountManager.getAccountSet().add(individual1);
        accountManager.getAccountSet().add(individual2);
        accountManager.getAccountSet().add(individual3);

        accountManager.printAccountsEmails();

        System.out.println("----------------");
        Scanner input = new Scanner(System.in);
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Şifre: ");
        String password = input.nextLine();

        Account account = accountManager.login(email, password);
        if (account != null){
            account.showUserInfo();
        }
    }

}
