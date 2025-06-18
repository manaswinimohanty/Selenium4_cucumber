package factories;

import com.github.javafaker.Faker;
import pojo.Users;
import utils.TimeStampBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Stream;
import java.time.Month;
import java.time.LocalDate;

public class UserFactories {

    private static final String Default_password="admin";
    private static final Faker faker;
static {
    faker=new Faker();
}

public static Users createDefault(){
    Users users=new Users();
   // Date dob = faker.date().birthday();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date dob= null;
    try {
        Date startDate=formatter.parse("1900-1-1");
        Date endDate=formatter.parse("2021-1-1");
        dob = faker.date().between(startDate,endDate);
    } catch (ParseException e) {
        throw new RuntimeException(e);
    }
    SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    String day = dayFormat.format(dob).replaceAll("^0+(?!$)", "");
    String month = monthFormat.format(dob);
    String year = yearFormat.format(dob);

    /*String dateAsString=formatter.format(dob);
    LocalDate currentDate
            = LocalDate.parse(dateAsString);
    // Get day from date
    int day = currentDate.getDayOfMonth();

    // Get month from date
    Month month = currentDate.getMonth();

    // Get year from date
    int year = currentDate.getYear();*/



    users.setUserName(faker.name().username());
    users.setEmail(TimeStampBuilder.buildUnqueTxtByPrefix(faker.internet().safeEmailAddress()));
    users.setFirstName(faker.name().firstName());
    users.setLastName(faker.name().lastName());
    users.setPassword(Default_password);
    users.setCompany(faker.company().name());
    users.setAddress(faker.address().fullAddress());
    users.setSecondaryAddress(faker.address().secondaryAddress());
    users.setCountry(faker.options().nextElement(Arrays.asList("India","United States","Canada","Australia","Israel","New Zealand","Singapore")));
    users.setCity(faker.address().city());
    users.setState(faker.address().state());
    users.setZipcode(faker.address().zipCode());
    users.setMobileNo(faker.phoneNumber().phoneNumber());
    users.setNewsletterChkBox(false);
    users.setOptions(false);
    users.setDay(day);
    users.setMonth(month);
    users.setYear(year);
    users.setGender(Stream.of("Male","Female").findAny().get());
    return users;
}



}
