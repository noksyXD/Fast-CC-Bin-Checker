package me.waytner.ccbin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String gettextfile = "";
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        ArrayList<String> arraylist = new ArrayList<>();
        ArrayList<String> arraylistbins = new ArrayList<>();

        System.out.println("Welcome to Fast CC Bin Checker.");
        System.out.println("Checking bin list...");
        Thread.sleep(2000);
        try {
            FileInputStream fis = new FileInputStream("binlist.txt");
            Scanner sc = new Scanner(fis);

            System.out.println("Reading all lines..");
            Thread.sleep(2000);
            while (sc.hasNextLine()) {
                arraylist.add(sc.nextLine());            }
            gettextfile = new String(Files.readAllBytes(Paths.get("binlist.txt")));
        } catch (IOException ignored) {
            System.out.println("do not find binlist file. please enter your binlist path");
            Scanner scanner = new Scanner(System.in);
            String scanner31 = scanner.nextLine();
            if (scanner31 != null) {
                System.out.println("Getting your binlist. Please wait..");
                FileInputStream fis = new FileInputStream("binlist.txt");
                Scanner sc = new Scanner(fis);

                System.out.println("Reading all lines..");
                while (sc.hasNextLine()) {
                    arraylist.add(sc.nextLine());
                }
            } else {
                System.out.println("Please enter true path.");
                System.exit(0);
            }
        }
        System.out.println("Sucessfuly read bin list.");
        System.out.println("Readed lines: " + arraylist.size());
        while (true) {
            System.out.println("Please enter your wanted card number:");
            Scanner scanner = new Scanner(System.in);
            String scanners = scanner.nextLine();
            while (scanners !=null) {
                for (int i = 0; i < arraylist.size(); i++) {
               //     System.out.println(arraylist.get(i));
                    if (scanners.contains(arraylist.get(i).split("\\,")[0])) {
                        System.out.println("Your bin code:");
                        System.out.println(arraylist.get(i));
                        scanners = null;
                        break;
                    }
                    if (i == arraylist.size()-1) {
                        System.out.println("Do not find your bin");
                        scanners = null;
                        break;
                    }
                }
            }
        }
    }


}
