/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ANDRON
 */

public class Patterns {
    private String defaultCountryCode = "+7";
    private String defaultTownCode = " (812) ";
    private String euroFormat="";
    private String tel;
    
    Patterns(String telephoneNumber){
        this.tel = telephoneNumber;
        
        Pattern p = Pattern.compile("^\\+?" 
                + "(\\d{1,2})?" //+ код страны (он может быть, а может и нет)
                + "(\\D|\\s)*?" // любые НЕСИМВОЛЬНЫЕ знаки ПЕРЕД кодом города
                + "(\\d{3})?" //код города (он может быть, а может и нет)
                + "(\\D|\\s)*?" // любые НЕСИМВОЛЬНЫЕ знаки ПОСЛЕ кода города
                + "[0-9]+(\\s|\\-)*?"   //
                + "[0-9]+(\\s|\\-)*?"   // Номер телефона
                + "[0-9]+");            //
        Matcher m = p.matcher(tel);
        
        /* если строка с файла соответствует данному паттерну, тогда 
         * выберем лишь цифры из данной строки */ 
        if (m.matches()) {
            String alphabeth = "0123456789";
            String modifyNumber=""; // номер без доп. символов.
            char[] number = tel.toCharArray(); // разбиваем строку на символы
           
            for (char c: number){
                if (alphabeth.indexOf(c) != -1 ) { modifyNumber+=c; }
            }
            
            //Проверяем по количеству символов номер телефона
            String temp="";
            switch (modifyNumber.toCharArray().length) {
                case 12:
                case 11: //7 050 552 11 52
                    int size = modifyNumber.toCharArray().length;
                    String countryCode = "+" + modifyNumber.substring(0, size-10);
                    String townCode = " (" + modifyNumber.substring(size - 10, size - 7) + ") ";
                    String telephone = modifyNumber.substring(size - 7, size - 4)
                            + "-" + modifyNumber.substring(size-4, size-2)
                            + "-" + modifyNumber.substring(size-2);
                    
                    
                    euroFormat = countryCode + townCode + telephone;
                    break;
                                    
                case 10: //050 552 11 52
                    countryCode = defaultCountryCode;
                    townCode = " (" + modifyNumber.substring(0, 3) + ") ";
                    telephone = modifyNumber.substring(3, 6) 
                            + "-" + modifyNumber.substring(6,8) 
                            + "-" + modifyNumber.substring(8);
                    
                    euroFormat = countryCode + townCode + telephone;
                    break;
                case 7: //552 11 52
                    countryCode = defaultCountryCode;
                    townCode = defaultTownCode;
                    telephone = modifyNumber.substring(0, 3) 
                            + "-" + modifyNumber.substring(3,5) 
                            + "-" + modifyNumber.substring(5);
                    
                    euroFormat = countryCode + townCode + telephone;
                    break;
                    
                default:
                    euroFormat = "Это не телефон!";
                    break;
            }
        }
        else { System.out.println("Incoming tel: " + telephoneNumber + " -> Это не телефон!"); return; }
        System.out.println("Incoming tel: " + telephoneNumber + " - > Outcoming tel: " + euroFormat);
    }
    
}
