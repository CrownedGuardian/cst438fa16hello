package edu.csumb.cst438fa16questionsanswers;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Test;

public class DayOfWeekTest {
    @Test
    public void test20160823() {
	Calendar day20160823 = new GregorianCalendar(2016, Calendar.AUGUST, 23);
	assertThat(DayOfWeek.day(day20160823), equalTo("Tuesday"));
    }

    @Test
    public void testToday() {
	assertThat(DayOfWeek.today(), anyOf(is("Monday"),
					    is("Tuesday"),
					    is("Wednesday"),
					    is("Thursday"),
					    is("Friday"),
					    is("Saturday"),
					    is("Sunday")));
    }
}
