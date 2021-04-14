package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class ReadCredentialsFile {

    List<String> emailColumns;
    List<String> passwordColumns;
    List<String> usernameColumns;
    List<String[]> rows;

    public ReadCredentialsFile() {
        rows = new ArrayList<>();
        emailColumns = new ArrayList<>();
        passwordColumns = new ArrayList<>();
        usernameColumns = new ArrayList<>();
    }

    public void readData() throws FileNotFoundException {
        Scanner file = new Scanner(new FileReader("credentials.txt"));
        int i = 0;
        while (file.hasNext()) {
            emailColumns.add(file.next());
            passwordColumns.add(file.next());
            usernameColumns.add(file.next());
            rows.add(new String[]{emailColumns.get(i), passwordColumns.get(i), usernameColumns.get(i)});
            i++;
        }
    }

    public List<String> getEmailColumns() {
        return emailColumns;
    }

    public List<String> getPasswordColumns() {
        return passwordColumns;
    }

    public List<String> getUsernameColumns() {
        return usernameColumns;
    }

    public List<String[]> getRows() {
        return rows;
    }
}
