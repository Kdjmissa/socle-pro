/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socle.pro.secuirty.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author kdjimissa
 */
public class Utils {

//    @Value("${creditplus.logo}")
//    public String standDefaultLogo;
//
//    public byte[] getStandDefaultLogoFile() throws IOException {
//        File file = new ClassPathResource(this.standDefaultLogo).getFile();
//        if (this.standDefaultLogo != null && file.exists()) {
//            FileInputStream fis = null;
//            byte[] bytesArray = new byte[(int) file.length()];
//            try {
//                fis = new FileInputStream(file);
//                if (fis.read(bytesArray) > 0) {
//                    return bytesArray;
//                }
//            } catch (IOException ex) {
//            } finally {
//                if (fis != null) {
//                    try {
//                        fis.close();
//                    } catch (IOException ex) {
//                    }
//                }
//            }
//        }
//        return new byte[0];
//    }
    public static Instant getDateToUTC(Instant date) {
        return getDateToUTC(date, LocalTime.MIN);
    }

    public static Instant getDateToUTC(Instant date, LocalTime localTime) {
        LocalDate localDate = date.atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDateTime time = localDate.atTime(localTime);
        return time.atZone(ZoneOffset.UTC).toInstant();
    }

    public static int getYearFromDate(LocalDate localDate) {
        int result = -1;
        if (localDate != null) {
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            Calendar cal = Calendar.getInstance().getInstance();
            cal.setTime(date);
            result = cal.get(Calendar.YEAR);
        }
        return result;
    }

    public static int getMonthFromDate(LocalDate localDate) {
        int result = -1;
        if (localDate != null) {
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            Calendar cal = Calendar.getInstance().getInstance();
            cal.setTime(date);
            result = cal.get(Calendar.MONTH);
        }
        return result;
    }


 

}
