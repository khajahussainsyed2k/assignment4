package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class KYC{
    private String anniversary;
    private Date signInDate;
    private Date todayDate;
    public void calculateRange(String signIn,String today){
    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
    try {
        signInDate=sdf.parse(signIn);
        todayDate=sdf.parse(today);
        if(signInDate.compareTo(todayDate)>0)
            System.out.println("no range");

        else {
            String s1=signIn.substring(0,6);

            anniversary=s1.concat(today.substring(6,10));

        //System.out.println(anniversary);
            Calendar c=Calendar.getInstance();
            c.setTime(sdf.parse(anniversary));

            c.add(Calendar.DATE,-30);
            String startRange= sdf.format(c.getTime());
            System.out.print(startRange);

            c.setTime(sdf.parse(anniversary));
            c.add(Calendar.DATE,+30);
            String endRange="";
            if(c.getTime().compareTo(todayDate)>0)
            {
                endRange= sdf.format(todayDate);
                System.out.print("\t"+endRange+"\n");
            }
            else
                System.out.print("\t" + sdf.format(c.getTime())+"\n");



    }
}
        catch (Exception e){
        System.out.println(e.getMessage());
    }
}
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        KYC kyc=new KYC();
        kyc.calculateRange("16-07-1998", "27-06-2017");
        kyc.calculateRange("04-02-2016", "04-04-2017");
        kyc.calculateRange("04-05-2017", "04-04-2017");
        kyc.calculateRange("04-04-2015", "04-04-2016");
        kyc.calculateRange("04-04-2015", "15-03-2016");
    }
}
