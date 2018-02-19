package helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
    private Date date = new Date();

    public String getCurrentDateTime(){
        return dateFormat.format(date);
    }
}
