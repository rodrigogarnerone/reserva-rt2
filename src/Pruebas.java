import model.ManejadorFechas;

import java.util.ArrayList;

public class Pruebas {
    public static void main(String[] args) {
        ArrayList<String[]> list = new ArrayList<>();
        String [] a = {"1","2","3"};
        String [] b = {"4","5","6"};
        list.add(a);
        list.add(b);
        System.out.println(list);

        ManejadorFechas fechas = new ManejadorFechas();
        fechas.stringToLocalDateTime("04/03/2016 11:30:40");

    }
}
