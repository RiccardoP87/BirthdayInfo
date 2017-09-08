package rp.com.birthdayinfo.Controller;

import android.content.Context;
import org.jetbrains.annotations.Contract;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.Seconds;
import org.joda.time.Weeks;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import rp.com.birthdayinfo.R;


public class AppController {

    private Context context;
    private int u;
    private Date date,date2;
    private DateTime dt1;
    private DateTime dt2;
    private DateFormat format;
    private String returned;
    public Map<String,Map<String,Boolean>> getRegistration;
    private Map.Entry<String, Map<String, Boolean>> entry;
    private Map.Entry<String, Boolean> entry2;
    private Map<String, Boolean> maps;
    private boolean sex;
    private StringBuilder builder;
    private String[] mouse = new String[]{"31-01-1900","18-02-1901","18-02-1912","05-02-1913",
            "05-02-1924","24-01-1925","24-01-1936","10-02-1937","10-02-1948","28-01-1949","28-01-1960",
            "14-02-1961", "15-02-1972","02-02-1973","02-02-1984","19-02-1985","19-02-1996",
            "06-02-1997","07-02-2008", "25-01-2009","25-01-2020","11-02-2021"};
    private String[] tiger = new String[]{"08-02-1902","28-01-1903","26-01-1914","13-02-1915",
            "13-02-1926","01-02-1927","31-01-1938","18-02-1939","17-02-1950","05-02-1951","05-02-1962",
            "24-01-1963","23-01-1974","20-02-1975","09-01-1986","28-01-1987","28-01-1998","15-02-1999",
            "14-02-2010","02-02-2011","01-01-2022","01-01-2023"};
    private String[] dragon = new String[]{"16-02-1904","03-02-1905","03-02-1916","22-01-1917",
            "23-01-1928","09-02-1929","08-02-1940","26-01-1941","27-01-1952","13-02-1953","13-02-1964",
            "01-02-1965","31-01-1976","17-02-1977","17-02-1988","05-02-1989","05-02-2000","23-01-2011",
            "23-01-2012","09-02-2013","01-01-2024","01-01-2025"};
    private String[] horse = new String[]{"25-01-1906","12-02-1907","11-02-1918","31-01-1919",
            "30-01-1930","16-02-1931","15-02-1942","04-02-1943","03-02-1954","16-02-1955","21-01-1966",
            "08-02-1967","07-02-1978","27-01-1979","27-01-1990","14-02-1991","12-02-2002","31-01-2003",
            "01-01-2014","01-01-2015","01-01-2016","01-01-2017"};
    private String[] dog = new String[]{"01-01-1910","01-01-1911","01-01-1922","01-01-1923",
            "01-01-1934","01-01-1935","01-01-1946","01-01-1947","01-01-1958","01-01-1959","01-01-1970",
            "01-01-1971","01-01-1982","01-01-1983","01-01-1994","01-01-1995","01-01-2006","01-01-2007",
            "01-01-2018","01-01-2019"};
    private String[] buffalo = new String[]{"19-02-1901","07-02-1902","06-02-1913","25-01-1914",
            "25-01-1925","12-02-1926","11-02-1937","30-01-1938","29-01-1949","16-02-1950","15-02-1961",
            "04-02-1962","03-02-1973","22-01-1974","20-02-1985","08-02-1986","07-02-1997","28-01-1998",
            "26-01-2009","14-02-2010","12-02-2021","01-01-2022","01-01-2033","01-01-2034"};
    private String[] rabbit = new String[]{"29-01-1903","15-02-1904","14-02-1915","02-02-1916",
            "02-02-1927","22-01-1928","19-02-1939","07-02-1940","06-02-1951","26-01-1952","25-01-1963",
            "12-02-1964","11-02-1975","30-01-1976","29-01-1987","16-02-1988","16-02-1999","04-01-2000",
            "03-02-2011","22-01-2012","01-01-2023","01-01-2024","01-01-2035","01-01-2036","01-01-2047",
            "01-01-2048"};
    private String[] snake = new String[]{"04-02-1905","24-01-1906","23-01-1917","10-02-1918",
            "10-02-1929","29-01-1930","27-01-1941","14-02-1942","14-02-1953","02-02-1954","02-02-1965",
            "20-01-1966","18-02-1977","06-02-1978","06-02-1989","25-01-1990","24-01-2001","11-02-2002",
            "10-02-2013","30-01-2014","01-01-2025","01-01-2026","01-01-2037","01-01-2038"};
    private String[] monkey = new String[]{"02-02-1908","21-01-1909","20-02-1920","07-02-1921",
            "06-02-1932","25-01-1933","25-01-1944","12-02-1945","12-02-1956","30-01-1957","30-01-1968",
            "16-02-1969","16-02-1980","04-02-1981","04-02-1992","22-01-1993","22-01-2004","08-02-2005",
            "08-02-2016","27-01-2017"};
    public String[] cock = new String[]{"22-01-1909","09-02-1910","08-02-1921","27-01-1922",
            "26-01-1933","13-02-1934","13-02-1945","01-02-1946","31-01-1957","17-02-1958","17-02-1969",
            "05-02-1970","05-02-1981","24-01-1982","23-01-1993","09-02-1994","09-02-2005","28-01-2006",
            "28-01-2017","15-02-2018","01-01-2029","01-01-2030"};
    private String[] goat = new String[]{"13-02-1907","01-02-1908","01-02-1919","19-02-1920",
            "17-02-1931","05-02-1932","05-02-1943","24-01-1944","24-01-1955","11-02-1956",
            "09-02-1967","20-01-1968","28-01-1979","15-02-1980","15-02-1991","03-02-1992","01-02-2003",
            "21-01-2004","19-02-2015","07-02-2016"};
    private String[] pig = new String[]{"30-01-1911","17-02-1912","16-02-1923","04-02-1924",
            "04-02-1935","23-01-1936","22-01-1947","09-02-1948","08-02-1959","27-01-1960",
            "27-01-1971","14-02-1972","13-02-1983","01-02-1972","13-02-1983","01-02-1984","31-01-1995",
            "18-02-1996","18-02-2007","06-02-2008","05-02-2019","23-01-2020"};
    private Date date3;
    private DateTime dt3;
    private int sign,sign2=-1;
    private boolean bool,bool1,bool2,bool3;
    private String[] zodiac = new String[]{"21-03","20-04","21-04","20-05","21-05","21-06","22-06",
            "22-07","23-07","23-08","24-08","22-09","23-09","22-10","23-10","22-11","23-11","21-12",
            "22-12","20-01","21-01","19-02","20-02","20-03"};
    private String[] zodiacM = new String[]{"14-12","10-01","11-01","07-02","08-02","08-03","09-03",
            "05-04","06-04","03-05","04-05","31-05","01-06","28-06","29-06","26-07","27-07","23-08",
            "24-08","20-09","21-09","18-10","19-10","16-11","17-11","13-12"};
    private String[] zodiacC = new String[]{"25-06","04-07","23-12","01-01","02-01","11-01","05-07",
            "14-07","12-01","24-01","15-07","25-07","25-01","03-02","26-07","04-08","04-02","08-02",
            "01-05","14-05","03-11","11-11","09-02","18-02","14-08","23-08","19-02","29-02","24-08","02-09",
            "01-03","10-03","03-09","12-09","11-03","20-03","13-09","22-09","21-03","22-03","31-03",
            "24-09","03-10","01-04","10-04","11-04","20-04","14-10","23-10","21-04","30-04","24-10","02-11",
            "15-05","24-05","12-11","21-11","25-05","03-06","22-11","01-12","04-06","13-06","02-12","11-12",
            "14-06","23-06","12-12","21-12","24-06","22-12"};
    private String[] monthC = new String[]{"01-11","31-01","01-02","30-04","01-05","31-07","01-08",
            "31-10"};
    private String[] zodiacA = new String[]{"21-03","20-04","22-06","22-07","24-08","23-09","24-10",
            "22-11","19-02","20-03","21-04","21-05","22-05","21-06","24-09","23-10","22-12","20-01",
            "21-01","18-02","23-07","23-08","23-11","21-12"};
    private int index,next;
    private StringBuilder build;
    private String year;
    private float ageEarth;
    private boolean isOk;
    private String signS;


    public AppController(Context context) {
        this.context = context;
    }

    public boolean differenceOk(String s, String s1)
            throws ParseException {
        assignday(s,s1);
        return dt2.isAfter(dt1)||dt2.isEqual(dt1);
    }

    public String eraseError(String in){

        char[] hour = in.toCharArray();
        char[] finalHour = new char[10];
        if(in.length()==10){
            finalHour = hour;
        }else{
            if(hour[0]<=57&&hour[1]<48){
                finalHour[0] = 48;
                finalHour[1] = hour[0];
                finalHour[2] = hour[1];
                for(int i = 2;i<hour.length;i++){
                    u = 2;
                    finalHour[u+i] = hour[i];
                }
            }else if(hour[0]<=51){
                for(int i=0;i<3;i++){
                    finalHour[i] = hour[i];
                }
                for(int i = 3;i<hour.length;i++){
                    u = 1;
                    finalHour[u+i] = hour[i];
                }
            }
            finalHour[3] = 48;
        }
        return new String(finalHour);
    }

    public String setNext(int index,String age,String today){
        char[] ages = age.toCharArray();
        char[] todays = today.toCharArray();
        char[] finale = new char[10];
        char[] age1 = new char[2];
        char[] age2 = new char[2];
        char[] mm1 = new char[2];
        char[] mm2 = new char[2];
        char[] yy1 = new char[4];
        char[] yy2 = new char[4];
        int day1,day2,month1,month2,year1,year2;
        for(int i=0;i<2;i++){
            age1[i] = ages[i];
            age2[i] = todays[i];
            mm1[i] = ages[i+3];
            mm2[i] = todays[i+3];
        }
        for(int u=6;u<ages.length;u++){
            yy1[u-6] = ages[u];
            yy2[u-6] = todays[u];
        }
        day1 = Integer.parseInt(new String(age1));
        day2 = Integer.parseInt(new String(age2));
        month1 = Integer.parseInt(new String(mm1));
        month2 = Integer.parseInt(new String(mm2));
        year1 = Integer.parseInt(new String(yy1));
        year2 = Integer.parseInt(new String(yy2));
        if((day1<day2&&month1==month2&&year1==year2||(day1>day2&&month1<month2&&year1==year2)||
                day1==day2&&month1==month2&&year1==year2||day1==day2&&month1<month2&&year1==year2
                ||day1<day2&&month1<month2&&year1==year2)){
            year1 += index;

        }else if((day1>day2&&month1<month2&&year1<year2)||(day1<day2&&month1==month2&&year1<year2)
                ||(day1<day2&&month1<month2&&year1<year2)){
            year1 = year2+index;

        }else{
            year1 = year2+(index-1);
        }
        yy1 = Integer.toString(year1).toCharArray();
        for(int y=0;y<2;y++){
            finale[y] = ages[y];
            finale[y+3] = ages[y+3];
        }
        for(int h=6;h<finale.length;h++){
            finale[h] = yy1[h-6];
        }
        finale[2] = ages[2];
        finale[5] = ages[5];
        return new String(finale);
    }

    public String computeAge(String age,String today) {
        assignday(age,today);
        Period period = new Period(dt1,dt2, PeriodType.yearMonthDay());
        return " "+ period.getYears()+" "+context.getString(R.string.year)+" "+
                period.getMonths()+" "+context.getString(R.string.months)+" "+
                period.getDays()+" "+context.getString(R.string.dayss);
    }

    public String getDiff(String age,String earth){
        assignday(age,earth);
        ageEarth = Float.parseFloat(computeYear(earth))-Float.parseFloat(computeYear(age));
        return Float.toString(ageEarth);
    }

    private void assignday(String age, String today) {
        format = new SimpleDateFormat("dd-MM-yyyy", Locale.ITALY);
        try {
            date = format.parse(age);
            date2 = format.parse(today);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        dt1 = new DateTime(date);
        dt2 = new DateTime(date2);
    }

    private void assignday(String age, String first,String second,int what) {
        if(what==0){
            format = new SimpleDateFormat("dd-MM-yyyy", Locale.ITALY);
        }else if(what==1){
            format = new SimpleDateFormat("dd-MM", Locale.ITALY);
        }else if(what==2){
            format = new SimpleDateFormat("dd-MM HH:mm:ss", Locale.ITALY);
        }else{
            format = new SimpleDateFormat("dd-MM-yyyy", Locale.ITALY);
            age = trasformMayan(age,0);
            first = trasformMayan(first+"-2016",0);
            second = trasformMayan(second+"-2016",1);
        }
        try {
            date = format.parse(age);
            date2 = format.parse(first);
            date3 = format.parse(second);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        dt1 = new DateTime(date);
        dt2 = new DateTime(date2);
        dt3 = new DateTime(date3);
    }

    private String trasformMayan(String data, int i) {
        char[] ages = data.toCharArray();
        char[] todays = new char[]{'2','0','1','6'};
        char[] finale = new char[10];
        build = new StringBuilder();
        for(int u=0;u<6;u++){
            finale[u] = ages[u];
        }
        for(int y=0;y<todays.length;y++){
            build.append(todays[y]);
        }
        year = Integer.toString(Integer.parseInt(build.toString())+i);
        for(int r=6;r<finale.length;r++){
            finale[r] = year.charAt(r-6);
        }
        return new String(finale);
    }

    public String computeM(String age, String today) {
        assignday(age,today);
        return Integer.toString(Months.monthsBetween(dt1,dt2).getMonths());
    }

    public String computeW(String age, String today) {
        assignday(age,today);
        return Integer.toString(Weeks.weeksBetween(dt1,dt2).getWeeks());
    }

    public String computeD(String age, String today) {
        assignday(age,today);
        return Integer.toString(Days.daysBetween(dt1,dt2).getDays());
    }


    public String computeH(String age, String today) {
        assignday(age,today);
        return Integer.toString(Hours.hoursBetween(dt1,dt2).getHours());
    }

    public String computeMin(String age, String today) {
        assignday(age,today);
        return Integer.toString(Minutes.minutesBetween(dt1,dt2).getMinutes());
    }

    public String computeSec(String age, String today) {
        assignday(age,today);
        return Integer.toString(Seconds.secondsBetween(dt1,dt2).getSeconds());
    }

    public String computeYear(String age) {
        char[] y = new char[age.toCharArray().length-6];
        for(int i=6;i<=age.toCharArray().length-1;i++){
            y[i-6] = age.toCharArray()[i];
        }
        returned = String.valueOf(y);
        return returned;
    }

    public String[] getComputedYear(String age) {
        return new String[]{ageOne(computeYear(age)),ageTwo(computeYear(age)),
                ageThree(computeYear(age)),ageFour(computeYear(age)),ageFive(computeYear(age)),
                ageSix(computeYear(age)), ageSeven(computeYear(age)),ageEight(computeYear(age)),
                ageNine(computeYear(age)),ageTen(computeYear(age)),ageEleven(computeYear(age)),
                ageTwelve(computeYear(age)),ageTh(computeYear(age)),ageFo(computeYear(age)),
                ageFi(computeYear(age))};
    }

    @Contract(pure = true)
    private String ageOne(String s){
        return ""+(Integer.parseInt(s)+753)+" ("+this.romanConvert((Integer.parseInt(s)+753))+")";
    }

    @org.jetbrains.annotations.Contract(pure = true)
    private String romanConvert(int i) {
        String roman = "";


        while (i >= 1000) {
            roman += "M";
            i -= 1000;
        }

        while (i >= 900) {
            roman += "CM";
            i -= 900;
        }

        while (i >= 500) {
            roman += "D";
            i -= 500;
        }

        while (i >= 400) {
            roman += "CD";
            i -= 400;
        }

        while (i >= 100) {
            roman += "C";
            i -= 100;
        }

        while (i >= 90) {
            roman += "XC";
            i -= 90;
        }

        while (i >= 50) {
            roman += "L";
            i -= 50;
        }

        while (i >= 40) {
            roman += "XL";
            i -= 40;
        }

        while (i >= 10) {
            roman += "X";
            i -= 10;
        }

        while (i >= 9) {
            roman += "IX";
            i -= 9;
        }

        while (i >= 5) {
            roman += "V";
            i -= 5;
        }

        while (i >= 4) {
            roman += "IV";
            i -= 4;
        }

        while (i >= 1) {
            roman += "I";
            i -= 1;
        }

        return roman;
    }

    private String ageTwo(String s){
        return Integer.toString(Integer.parseInt(s)-552)+" - "+
                Integer.toString(Integer.parseInt(s)-551);

    }
    private String ageThree(String s){
        return Integer.toString(Integer.parseInt(s)-594)+" - "+
                Integer.toString(Integer.parseInt(s)-593);

    }
    private String ageFour(String s){
        return Integer.toString(Integer.parseInt(s)+950);
    }
    private String ageFive(String s){
        return Integer.toString(Integer.parseInt(s)+5509)+" - "+
                Integer.toString(Integer.parseInt(s)+5508);
    }
    private String ageSix(String s){
        return Integer.toString(Integer.parseInt(s)+544);
    }
    private String ageSeven(String s){
        return Integer.toString(Integer.parseInt(s)+2696)+" - "+
                Integer.toString(Integer.parseInt(s)+2697);
    }
    private String ageEight(String s){
        return Integer.toString(Integer.parseInt(s)-284)+" - "+
                Integer.toString(Integer.parseInt(s)-283);
    }
    private String ageNine(String s){
        return Integer.toString(Integer.parseInt(s)+3759)+" - "+
                Integer.toString(Integer.parseInt(s)+3760);
    }
    private String ageTen(String s){
        return Integer.toString(Integer.parseInt(s)-8)+" - "+
                Integer.toString(Integer.parseInt(s)-7);
    }
    private String ageEleven(String s){
        return Integer.toString(Integer.parseInt(s)- +55)+" - "+
                Integer.toString(Integer.parseInt(s)+56);
    }
    private String ageTwelve(String s){
        return Integer.toString(Integer.parseInt(s)+78)+" - "+
                Integer.toString(Integer.parseInt(s)+77);

    }
    private String ageTh(String s){
        return Integer.toString(Integer.parseInt(s)+3101)+" - "+
                Integer.toString(Integer.parseInt(s)+3102);
    }
    private String ageFo(String s){
        return Integer.toString(Integer.parseInt(s)-583)+" - "+
                Integer.toString(Integer.parseInt(s)-582);
    }
    private String ageFi(String s){
        return Integer.toString(Integer.parseInt(s)-622)+" - "+
                Integer.toString(Integer.parseInt(s)-621);
    }

    public void registration(String name,String surname,boolean sex){
        getRegistration = new HashMap<>();
        Map<String,Boolean> maps = new HashMap<>();
        maps.put(surname,sex);
        getRegistration.put(name,maps);
        SharedUtilities.getInstance().saveMap(context,getRegistration);
    }

    public Map<String, Map<String, Boolean>> getGetRegistration() {
        return getRegistration = SharedUtilities.getInstance().getMap(context);
    }

    public void smap(){
        entry=getRegistration.entrySet().iterator().next();
        entry=getRegistration.entrySet().iterator().next();
        maps = entry.getValue();
        entry2 = maps.entrySet().iterator().next();
    }

    public String getName(){
        return entry.getKey();
    }

    public String getSurname(){
        return entry2.getKey();
    }

    public boolean getSex(){
        return this.sex = entry2.getValue();
    }

    public int computeMySign(String age) {
        for(int i=0;i<mouse.length;i+=2){
            assignday(age,mouse[i],mouse[i+1],0);
            if(isBetween(dt1,dt2,dt3)){
                sign2 = 0;
                return sign2;
            }
        }
        if(sign2==-1){
            for(int i=0;i<tiger.length;i+=2){
                assignday(age,tiger[i],tiger[i+1],0);
                if(isBetween(dt1,dt2,dt3)){
                    sign2 = 1;
                    return sign2;
                }
            }
        }
        if(sign2==-1l){
            for(int i=0;i<dragon.length;i+=2){
                assignday(age,dragon[i],dragon[i+1],0);
                if(isBetween(dt1,dt2,dt3)){
                    sign2 = 2;
                    return sign2;
                }
            }
        }
        if(sign2==-1l){
            for(int i=0;i<horse.length;i+=2){
                assignday(age,horse[i],horse[i+1],0);
                if(isBetween(dt1,dt2,dt3)){
                    sign2 = 3;
                    return sign2;
                }
            }
        }
        if(sign2==-1l){
            for(int i=0;i<dog.length;i+=2){
                assignday(age,dog[i],dog[i+1],0);
                if(isBetween(dt1,dt2,dt3)){
                    sign2 = 4;
                    return sign2;
                }
            }
        }
        if(sign2==-1l){
            for(int i=0;i<buffalo.length;i+=2){
                assignday(age,buffalo[i],buffalo[i+1],0);
                if(isBetween(dt1,dt2,dt3)){
                    sign2 = 5;
                    return sign2;
                }
            }
        }
        if(sign2==-1l){
            for(int i=0;i<rabbit.length;i+=2){
                assignday(age,rabbit[i],rabbit[i+1],0);
                if(isBetween(dt1,dt2,dt3)){
                    sign2 = 6;
                    return sign2;
                }
            }
        }
        if(sign2==-1l){
            for(int i=0;i<snake.length;i+=2){
                assignday(age,snake[i],snake[i+1],0);
                if(isBetween(dt1,dt2,dt3)){
                    sign2 = 7;
                    return sign2;
                }
            }
        }
        if(sign2==-1l){
            for(int i=0;i<monkey.length;i+=2){
                assignday(age,monkey[i],monkey[i+1],0);
                if(isBetween(dt1,dt2,dt3)){
                    sign2 = 8;
                    return sign2;
                }
            }
        }
        if(sign2==-1l){
            for(int i=0;i<cock.length;i+=2){
                assignday(age,cock[i],cock[i+1],0);
                if(isBetween(dt1,dt2,dt3)){
                    sign2 = 9;
                    return sign2;
                }
            }
        }
        if(sign2==-1l){
            for(int i=0;i<goat.length;i+=2){
                assignday(age,goat[i],goat[i+1],0);
                if(isBetween(dt1,dt2,dt3)){
                    sign2 = 10;
                    return sign2;
                }
            }
        }
        if(sign2==-1l){
            for(int i=0;i<pig.length;i+=2){
                assignday(age,pig[i],pig[i+1],0);
                if(isBetween(dt1,dt2,dt3)){
                    sign2 = 11;
                    return sign2;
                }
            }
        }
        return sign2;
    }

    public int computeSignZodiac(String in){
        index = 0;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 0;
        }
        index=2;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 1;
        }
        index=4;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 2;
        }
        index=6;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 3;
        }
        index=8;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 4;
        }
        index=10;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 5;
        }
        index=12;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 6;
        }
        index=14;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 7;
        }
        index=16;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 8;
        }
        index=18;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 9;
        }
        index=20;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 10;
        }
        index=22;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 11;
        }
        return sign;
    }

    public int computeSignZodiacMayan(String in){
        index = 0;
        assignday(in,zodiacM[index],zodiacM[index+1],3);
        if(isBetween(dt1,dt2,dt3)){
            sign2 = 0;
        }
        if(sign2==-1){
            index=2;
            assignday(in,zodiacM[index],zodiacM[index+1],1);
            if(isBetween(dt1,dt2,dt3)){
                sign2 = 1;
            }
        }
        if(sign2==-1){
            index=4;
            assignday(in,zodiacM[index],zodiacM[index+1],1);
            if(isBetween(dt1,dt2,dt3)){
                sign2 = 2;
            }
        }
        if(sign2==-1){
            index=6;
            assignday(in,zodiacM[index],zodiacM[index+1],1);
            if(isBetween(dt1,dt2,dt3)){
                sign2 = 3;
            }
        }
        if(sign2==-1){
            index=8;
            assignday(in,zodiacM[index],zodiacM[index+1],1);
            if(isBetween(dt1,dt2,dt3)){
                sign2 = 4;
            }
        }
        if(sign2==-1){
            index=10;
            assignday(in,zodiacM[index],zodiacM[index+1],1);
            if(isBetween(dt1,dt2,dt3)){
                sign2 = 5;
            }
        }
        if(sign2==-1){
            index=12;
            assignday(in,zodiacM[index],zodiacM[index+1],1);
            if(isBetween(dt1,dt2,dt3)){
                sign2 = 6;
            }
        }
        if(sign2==-1){
            index=14;
            assignday(in,zodiacM[index],zodiacM[index+1],1);
            if(isBetween(dt1,dt2,dt3)){
                sign2 = 7;
            }
        }
        if(sign2==-1){
            index=16;
            assignday(in,zodiacM[index],zodiacM[index+1],1);
            if(isBetween(dt1,dt2,dt3)){
                sign = 8;
            }
        }
        if(sign2==-1){
            index=18;
            assignday(in,zodiacM[index],zodiacM[index+1],1);
            if(isBetween(dt1,dt2,dt3)){
                sign2 = 9;
            }
        }
        if(sign2==-1){
            index=20;
            assignday(in,zodiacM[index],zodiacM[index+1],1);
            if(isBetween(dt1,dt2,dt3)){
                sign2 = 10;
            }
        }
        if(sign2==-1){
            index=22;
            assignday(in,zodiacM[index],zodiacM[index+1],1);
            if(isBetween(dt1,dt2,dt3)){
                sign2 = 11;
            }
        }
        if(sign2==-1){
            index=24;
            assignday(in,zodiacM[index],zodiacM[index+1],1);
            if(isBetween(dt1,dt2,dt3)){
                sign2 = 12;
            }
        }
        return sign2;
    }

    public int computeSignZodiacCeltic(String in){
        index = 0;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 0;
        }
        index=2;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 0;
        }
        index=4;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 1;
        }
        index=6;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 1;
        }
        index=8;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 3;
        }
        index=10;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 3;
        }
        index=12;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 4;
        }
        index=14;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 4;
        }
        index=16;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 4;
        }
        index=18;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 4;
        }
        index=20;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 5;
        }
        index=22;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 5;
        }
        index=24;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 6;
        }
        index=26;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 6;
        }
        index=28;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 7;
        }
        index=30;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 7;
        }
        index=32;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 8;
        }
        index=34;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 8;
        }
        index=36;
        assignday(in,zodiacC[index],zodiacC[index],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 9;
        }
        index=37;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 10;
        }
        index=39;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 10;
        }
        index=41;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 11;
        }
        index=43;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 11;
        }
        index=45;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 12;
        }
        index=47;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 12;
        }
        index=49;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 13;
        }
        index=51;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 13;
        }
        index=53;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 14;
        }
        index=55;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 14;
        }
        index=57;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 15;
        }
        index=59;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 15;
        }
        index=61;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 16;
        }
        index=63;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 16;
        }
        index=65;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 17;
        }
        index=67;
        assignday(in,zodiacC[index],zodiacC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 17;
        }
        index=69;
        assignday(in,zodiacC[index],zodiacC[index],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 18;
        }
        index=70;
        assignday(in,zodiacC[index],zodiacC[index],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 19;
        }
        assignday(in,zodiacC[zodiacC.length-1],zodiacC[zodiacC.length-1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 20;
        }
        return sign;
    }

    @Contract("null, _, _ -> false; !null, null, _ -> false; !null, !null, null -> false")
    private boolean isBetween(DateTime dt1, DateTime dt2, DateTime dt3) {
        if (dt1 != null && dt2 != null && dt3 != null) {
            bool1 = (dt1.isAfter(dt2) && dt1.isBefore(dt3));
            bool2 = dt1.isEqual(dt2);
            bool3 = dt1.isEqual(dt3);
            if (bool1||bool2||bool3) {
                bool =  true;
            }
            else {
                bool = false;
            }
        }
        return bool;
    }

    public String computeDayName(String age) {
        SimpleDateFormat inFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = inFormat.parse(age);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("EEEE");
        return Character.toUpperCase(outFormat.format(date).charAt(0))+outFormat.format(date).substring(1);
    }

    public String computeD2(String age, String today) {
        assignday(today,setNext(1,age,today));
        next = Days.daysBetween(dt1,dt2).getDays();
        return Integer.toString(next)+" Giorni";
    }

    public String computeMonthC(String in) {
        index = 0;
        assignday(in,monthC[index],monthC[index+1],3);
        if(isBetween(dt1,dt2,dt3)){
            signS = "Samain("+monthC[index]+"/"+monthC[index+1]+")";
        }
        index=2;
        assignday(in,monthC[index],monthC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            signS = "Imbolic("+monthC[index]+"/"+monthC[index+1]+")";
        }
        index=4;
        assignday(in,monthC[index],monthC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            signS = "Bealtine("+monthC[index]+"/"+monthC[index+1]+")";
        }
        index=6;
        assignday(in,monthC[index],monthC[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            signS = "Lùnasa("+monthC[index]+"/"+monthC[index+1]+")";
        }
        return signS;
    }


    public int computeSignArab(String in) {
        index = 0;
        assignday(in,zodiacA[index],zodiacA[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 0;
        }
        index=2;
        assignday(in,zodiacA[index],zodiacA[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 1;
        }
        index=4;
        assignday(in,zodiacA[index],zodiacA[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 2;
        }
        index=6;
        assignday(in,zodiacA[index],zodiacA[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 3;
        }
        index=8;
        assignday(in,zodiacA[index],zodiacA[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 4;
        }
        index=10;
        assignday(in,zodiacA[index],zodiacA[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 5;
        }
        index=12;
        assignday(in,zodiacA[index],zodiacA[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 6;
        }
        index=14;
        assignday(in,zodiacA[index],zodiacA[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 7;
        }
        index=16;
        assignday(in,zodiacA[index],zodiacA[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 8;
        }
        index=18;
        assignday(in,zodiacA[index],zodiacA[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 9;
        }
        index=20;
        assignday(in,zodiacA[index],zodiacA[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 10;
        }
        index=22;
        assignday(in,zodiacA[index],zodiacA[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 11;
        }
        return sign;
    }

    public String computeMamoettoB(String age) {
        assignday("20-04-570",age);
        next = Days.daysBetween(dt1,dt2).getDays();
        return Integer.toString(next)+" Giorni";
    }

    public int computeSignZodiacIndu(String in) {
        index = 0;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 0;
        }
        index=2;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 1;
        }
        index=4;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 2;
        }
        index=6;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 3;
        }
        index=8;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 4;
        }
        index=10;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 5;
        }
        index=12;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 6;
        }
        index=14;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 7;
        }
        index=16;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 8;
        }
        index=18;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 9;
        }
        index=20;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 10;
        }
        index=22;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            sign = 11;
        }
        return sign;
    }

    public String getMonth(String in) {

        index = 0;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            signS = "Vasanta";
        }
        index=2;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            signS = "Vasanta";
        }
        index=4;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            signS = "Grishma";
        }
        index=6;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            signS = "Grishma";
        }
        index=8;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            signS = "Varsha";
        }
        index=10;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            signS = "Varsha";
        }
        index=12;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            signS = "Sarat";
        }
        index=14;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            signS = "Sarat";
        }
        index=16;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            signS = "Hemantha";
        }
        index=18;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            signS = "Hemantha";
        }
        index=20;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            signS = "Sisir";
        }
        index=22;
        assignday(in,zodiac[index],zodiac[index+1],1);
        if(isBetween(dt1,dt2,dt3)){
            signS = "Sisir";
        }
        return signS;
    }
}