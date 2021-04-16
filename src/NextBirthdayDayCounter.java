import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class NextBirthdayDayCounter {
    public static void main(String[] args) throws IOException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/M/d");
        System.out.println("Введите дату в формате yyyy/MM/dd");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String date = reader.readLine();
        LocalDate birthday = LocalDate.parse(date, formatter);
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(today.getYear(), birthday.getMonth(), birthday.getDayOfMonth());

        LocalDate nextBirthday = birthday.getDayOfYear() > today.getDayOfYear()
                ? thisYearBirthday : thisYearBirthday.plusYears(1);
        long daysTillBirthday = ChronoUnit.DAYS.between(today, nextBirthday);
        System.out.println(daysTillBirthday);
    }
}
