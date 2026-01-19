package coursewise.service;

import coursewise.util.Constant;

import java.io.*;
import java.util.Scanner;

public class AdminService {

    public boolean authenticateAdmin(String username, String password) {
        try (Scanner scanner = new Scanner(new File(Constant.ADMIN_FILE))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split("\\|");
                    if (parts.length == 2) {
                        if (parts[0].equals(username) && parts[1].equals(password)) {
                            return true;
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addAdmin(String username, String password) {
        try (FileWriter writer = new FileWriter(Constant.ADMIN_FILE, true)) {
            writer.write(username + "|" + password);
            writer.write("\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
