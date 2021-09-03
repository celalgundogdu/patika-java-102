package hw6_InsuranceManagementSystem;

import java.util.Collections;
import java.util.TreeSet;

public class AccountManager {

    private TreeSet<Account> accountSet;

    public AccountManager() {
        this.accountSet = new TreeSet<>();
    }

    public Account login(String email, String password){
        for(Account account : accountSet){
            try {
                account.login(email, password);
                return account;
            } catch (InvalidAuthenticationException e) {

            }
        }
        return null;
    }

    public TreeSet<Account> getAccountSet() {
        return accountSet;
    }

    public void printAccountsEmails(){
        for (Account account : accountSet){
            System.out.println(account.getUser().getEmail());
        }
    }
}
