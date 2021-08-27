package ec.gob.inspi.gidi.sit.cmm;

import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setMinimalDaysInFirstWeek(4);
		calendar.setTime(new Date());
		int numberWeekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
		System.out.print(numberWeekOfYear);
	}

}
