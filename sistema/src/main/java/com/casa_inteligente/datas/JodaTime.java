package com.casa_inteligente.datas;
import java.util.Date;
import org.joda.time.DateTime;

public class JodaTime {

    java.util.Date juDate = new Date();
     DateTime dt = new DateTime(juDate);

    public String mostrarData(){

        return "Data: " + dt.getDayOfMonth() +"/"+ dt.getMonthOfYear() + "/"+ dt.getYear();       

    }

    public String mostrarHora(){
        int hora = dt.getHourOfDay();
        int minuto = dt.getMinuteOfHour();
        int segundo = dt.getSecondOfMinute();
        return "Hora: "+ hora + ":" + minuto + ":" + segundo;
    }


}
