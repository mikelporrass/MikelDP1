package iterator;

import java.util.Calendar;
import java.util.Date;

import businessLogic.BLFacade;
import configuration.UtilDate;
import domain.Event;
import factory.Factory;
import factory.IFactory;

public class main {

	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		   
		   int month=today.get(Calendar.MONTH);
		   month+=1;
		   int year=today.get(Calendar.YEAR);
		   if (month==12) { month=0; year+=1;}  
		
		 boolean isLocal=true;
		 //Facade objektua lortu lehendabiziko ariketa erabiliz
		 Factory f = new IFactory();
		 BLFacade facadeInterface =f.inplementazioaAukeratu(true);
		 //BLFacade facadeInterface=……….
		
		 ExtendedIterator<Event> i=facadeInterface.getEvents(UtilDate.newDate(2020,9,17));
		 Event ev;
		 i.goLast();
		 System.out.println(".............................");
		 while (i.hasPrevious()){
		 ev=i.previous();
		 //System.out.println("aa");
		 System.out.println(ev.toString());
		 }
		 //Nahiz eta suposatu hasierara ailegatu garela, eragiketa egiten dugu.
		 i.goFirst();
		 System.out.println(".............................");
		 while (i.hasNext()){
		 ev=i.next();
		 System.out.println(ev.toString());
		 }

}
	private static Date newDate(int year,int month,int day) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day,0,0,0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }
}
