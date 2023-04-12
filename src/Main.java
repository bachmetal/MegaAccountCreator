import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n" +
                "\n" +
                "    __  ___                    ___                               __     ______                __            \n" +
                "   /  |/  /__  ____ _____ _   /   | ______________  __  ______  / /_   / ____/_______  ____ _/ /_____  _____\n" +
                "  / /|_/ / _ \\/ __ `/ __ `/  / /| |/ ___/ ___/ __ \\/ / / / __ \\/ __/  / /   / ___/ _ \\/ __ `/ __/ __ \\/ ___/\n" +
                " / /  / /  __/ /_/ / /_/ /  / ___ / /__/ /__/ /_/ / /_/ / / / / /_   / /___/ /  /  __/ /_/ / /_/ /_/ / /    \n" +
                "/_/  /_/\\___/\\__, /\\__,_/  /_/  |_\\___/\\___/\\____/\\__,_/_/ /_/\\__/   \\____/_/   \\___/\\__,_/\\__/\\____/_/     \n" +
                "            /____/                                                                                          \n" +
                "\n");
        System.out.println("\n" +
                "\n" +
                "       __               __                     __   __             \n" +
                "  ____/ /__ _   _____  / /___  ____  ___  ____/ /  / /_  __  __    \n" +
                " / __  / _ \\ | / / _ \\/ / __ \\/ __ \\/ _ \\/ __  /  / __ \\/ / / /    \n" +
                "/ /_/ /  __/ |/ /  __/ / /_/ / /_/ /  __/ /_/ /  / /_/ / /_/ /     \n" +
                "\\__,_/\\___/|___/\\___/_/\\____/ .___/\\___/\\__,_/  /_.___/\\__, /      \n" +
                "                           /_/                        /____/       \n" +
                "    _   __            _     __   ____        __    __              \n" +
                "   / | / /___ __   __(_)___/ /  / __ \\____ _/ /_  / /_  ____ ______\n" +
                "  /  |/ / __ `/ | / / / __  /  / /_/ / __ `/ __ \\/ __ \\/ __ `/ ___/\n" +
                " / /|  / /_/ /| |/ / / /_/ /  / _, _/ /_/ / / / / /_/ / /_/ / /    \n" +
                "/_/ |_/\\__,_/ |___/_/\\__,_/  /_/ |_|\\__,_/_/ /_/_.___/\\__,_/_/     \n" +
                "                                                                   \n"
        );
        Scanner scanner = new Scanner(System.in);
        //Welcome Page:
        System.out.println("This program works with Microsoft Edge Version 112.0.1722.39\n" +
                "Please update your Microsoft Edge browser but\n" +
                "if you have newer version, you have to download the corresponded driver from this site:\n" +
                "https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver\n");
        System.out.print("Please enter your Gmail ID: ");

        //take the Gmail ID
        String gmailID = scanner.nextLine();

        //if it is not a gmail account, it doesn't work.
        if (gmailID.contains("@") && !gmailID.contains("@gmail.com")) {
            System.out.println("Other email addresses are not supported!");
            return;
        }

        //if it has @gmail.com after the ID, it will split and take just the id.
        else if (gmailID.contains("@gmail.com")) {
            String[] split = gmailID.split("@");
            gmailID = split[0];
        }
        String password;
        Console console = System.console();
        if (console == null) {
            System.out.print("Please enter the password for all accounts: ");
            password = scanner.nextLine();
        } else {
            //if it is run through CMD, password is hidden.
            char[] chars = console.readPassword("Please enter the password for all accounts: ");
            password = String.valueOf(chars);
        }
        System.out.print("How many account should be created?: ");
        int repeat = scanner.nextInt();
        scanner.close();
        Random randomTrick = new Random();

        //Run Program:
        for (int firstTime = 0; firstTime < repeat; firstTime++) {
            EdgeDriver driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.mega.io");

            //Every second it will watch the Register button. if it is shown on the page it will be clicked.
            while (true) {
                try {
                    if (driver.findElement(By.cssSelector("body > div.page-container.main-grid > div.animated-hero > div.text-pane.main-grid > div > a")).isEnabled()) {
                        driver.findElement(By.cssSelector("body > div.page-container.main-grid > div.animated-hero > div.text-pane.main-grid > div > a")).click();
                        break;
                    }
                    Thread.sleep(1000);
                } catch (Exception ignored) {
                }
            }
            createAccount(gmailID, password, randomTrick, driver);
            driver.quit();
            System.out.println("\n" +
                    "\n" +
                    " ___      ___ __ __    ___  _       ___   ____   ___  ___        ____   __ __      ____    ____  __ __  ____  ___        ____    ____  __ __  ____    ____  ____  \n" +
                    "|   \\    /  _]  |  |  /  _]| |     /   \\ |    \\ /  _]|   \\      |    \\ |  |  |    |    \\  /    ||  |  ||    ||   \\      |    \\  /    ||  |  ||    \\  /    ||    \\ \n" +
                    "|    \\  /  [_|  |  | /  [_ | |    |     ||  o  )  [_ |    \\     |  o  )|  |  |    |  _  ||  o  ||  |  | |  | |    \\     |  D  )|  o  ||  |  ||  o  )|  o  ||  D  )\n" +
                    "|  D  ||    _]  |  ||    _]| |___ |  O  ||   _/    _]|  D  |    |     ||  ~  |    |  |  ||     ||  |  | |  | |  D  |    |    / |     ||  _  ||     ||     ||    / \n" +
                    "|     ||   [_|  :  ||   [_ |     ||     ||  | |   [_ |     |    |  O  ||___, |    |  |  ||  _  ||  :  | |  | |     |    |    \\ |  _  ||  |  ||  O  ||  _  ||    \\ \n" +
                    "|     ||     |\\   / |     ||     ||     ||  | |     ||     |    |     ||     |    |  |  ||  |  | \\   /  |  | |     |    |  .  \\|  |  ||  |  ||     ||  |  ||  .  \\\n" +
                    "|_____||_____| \\_/  |_____||_____| \\___/ |__| |_____||_____|    |_____||____/     |__|__||__|__|  \\_/  |____||_____|    |__|\\_||__|__||__|__||_____||__|__||__|\\_|\n" +
                    "                                                                                                                                                                  \n" +
                    "\n");
        }
    }

    private static void createAccount(String gmailID, String password, Random l, EdgeDriver driver) {
        int random;
        while (true) {
            try {
                if (driver.getTitle().equalsIgnoreCase("Create Your Account - MEGA")) {
                    random = l.nextInt(2147483647);
                    String emailAddress = gmailID + "+" + random + "@gmail.com";
                    formFill(password, driver, emailAddress);
                    isSuccessful(driver);
                    break;
                }
                Thread.sleep(1000);
            } catch (Exception ignored) {
            }
        }
    }

    private static void isSuccessful(EdgeDriver driver) {
        while (true) {
            try {
                if (driver.findElement(By.xpath("//*[@id=\"bodyel\"]/section[5]/div[14]/header/i[2]")).isDisplayed()) {
                    driver.manage().deleteAllCookies();
                    break;
                }
                Thread.sleep(1000);
            } catch (Exception ignored) {
            }
        }
    }

    private static void formFill(String password, EdgeDriver driver, String registered) throws IOException {
        driver.findElement(By.xpath("//*[@id=\"register-firstname-registerpage2\"]")).sendKeys("N");
        driver.findElement(By.xpath("//*[@id=\"register-lastname-registerpage2\"]")).sendKeys("R");
        driver.findElement(By.xpath("//*[@id=\"register_form\"]/div[8]/label")).click(); //Understand
        driver.findElement(By.xpath("//*[@id=\"register-check-registerpage2\"]")).click(); //I have read
        driver.findElement(By.id("register-password-registerpage2")).click(); //Type
        driver.findElement(By.id("register-password-registerpage2")).sendKeys(password); //Type
        driver.findElement(By.xpath("//*[@id=\"register-password-registerpage3\"]")).click(); //Retype
        driver.findElement(By.xpath("//*[@id=\"register-password-registerpage3\"]")).sendKeys(password); //Retype
        driver.findElement(By.xpath("//*[@id=\"register-email-registerpage2\"]")).sendKeys(registered);
        driver.findElement(By.xpath("//*[@id=\"register-email-registerpage2\"]")).sendKeys(Keys.RETURN);
        writeToFile(registered);
    }

    public static void writeToFile(String email) throws IOException {
        var fileWriter = new FileWriter("accounts.txt", true);
        var print = new PrintWriter(fileWriter);
        print.println(email);
        print.close();
    }
}