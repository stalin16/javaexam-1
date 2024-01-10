import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a short date (YYYY-MM-DD): ");
            String shortDateInput = scanner.nextLine();
            if (isValidDate(shortDateInput)) {
                try {
                    SimpleDateFormat shortDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = shortDateFormat.parse(shortDateInput);
                    int year = getYear(date);
                    int month = getMonth(date);
                    int day = getDay(date);
                    String monthName = getMonthName(month);
                    System.out.println("Full Date: " + monthName + " " + day + ", " + year);
                } catch (ParseException e) {
                    System.out.println("Error parsing date. Please try again.");
                }
            } else {
                System.out.println("Invalid date format. Please enter date in the format YYYY-MM-DD.");
            }
        }
    }
    private static boolean isValidDate(String date) {
        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    private static int getYear(Date date) {
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        return Integer.parseInt(yearFormat.format(date));
    }

    private static int getMonth(Date date) {
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        return Integer.parseInt(monthFormat.format(date));
    }

    private static int getDay(Date date) {
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        return Integer.parseInt(dayFormat.format(date));
    }

    private static String getMonthName(int month) {
        String[] monthNames = {"", "January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        if (month >= 1 && month <= 12) {
            return monthNames[month];
        } else {
            return "Invalid Month";
        }
    }
}
