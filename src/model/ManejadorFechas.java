package model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ManejadorFechas {

    public String actualDateTimeToString(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(LocalDateTime.now());
    }

    public String DateTimeToString(LocalDateTime fechaHora){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(fechaHora);
    }

    public LocalDateTime stringToLocalDateTime(String fechaHora){
        //String str = "2016-03-04 11:30:40";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.parse(fechaHora, formatter);
    }


}
