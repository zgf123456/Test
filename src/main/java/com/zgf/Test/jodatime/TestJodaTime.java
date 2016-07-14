package com.zgf.Test.jodatime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class TestJodaTime {

	@Rule
	public TestName name = new TestName();

	@Before
	public void before() {
		System.out.println("+++++++++++++++test " + name.getMethodName() + " before");
	}

	@After
	public void after() {
		System.out.println("---------------test " + name.getMethodName() + " after");
	}

	@Test
	public void testDateTimeMethod() {
		DateTime dateTime = new DateTime();
		System.out.println("millis: " + dateTime.getMillis());
		System.out.println("millisOfSecond: " + dateTime.getMillisOfSecond());
		System.out.println("millisOfDay: " + dateTime.getMillisOfDay());
		System.out.println("secondOfMinute: " + dateTime.getSecondOfMinute());
		System.out.println("secondOfDay: " + dateTime.getSecondOfDay());
		System.out.println("minuteOfHour: " + dateTime.getMinuteOfHour());
		System.out.println("minuteOfDay: " + dateTime.getMinuteOfDay());
		System.out.println("hourOfDay: " + dateTime.getHourOfDay());
		System.out.println("dayOfWeek: " + dateTime.getDayOfWeek());
		System.out.println("dayOfMonth: " + dateTime.getDayOfMonth());
		System.out.println("dayOfYear: " + dateTime.getDayOfYear());
		System.out.println("monthOfYear: " + dateTime.getMonthOfYear());
		System.out.println("weekYear: " + dateTime.getWeekyear());
		System.out.println("year: " + dateTime.getYear());
		System.out.println("getCenturyOfEra: " + dateTime.getCenturyOfEra());
		System.out.println("getYearOfCentury: " + dateTime.getYearOfCentury());
		System.out.println("getEra: " + dateTime.getEra());
		System.out.println("getEra: " + dateTime.get(DateTimeFieldType.millisOfDay()));
	}

	@Test
	public void testNewDateTime() {
		DateTime dateTime = new DateTime(2016, 10, 9, 5, 4);
		System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void testDateTimeFormat() {
		DateTime dateTime = DateTime.now();
		System.out.println("basicDate: " + dateTime.toString(ISODateTimeFormat.basicDate()));
		System.out.println("basicDateTime: " + dateTime.toString(ISODateTimeFormat.basicDateTime()));
		System.out.println("basicDateTimeNoMillis: " + dateTime.toString(ISODateTimeFormat.basicDateTimeNoMillis()));
		System.out.println("basicOrdinalDate: " + dateTime.toString(ISODateTimeFormat.basicOrdinalDate()));
		System.out.println("basicOrdinalDateTime: " + dateTime.toString(ISODateTimeFormat.basicOrdinalDateTime()));
		System.out.println("basicOrdinalDateTimeNoMillis: " + dateTime.toString(ISODateTimeFormat.basicOrdinalDateTimeNoMillis()));
		System.out.println("basicTime: " + dateTime.toString(ISODateTimeFormat.basicTime()));
		System.out.println("basicTimeNoMillis: " + dateTime.toString(ISODateTimeFormat.basicTimeNoMillis()));
		System.out.println("basicTTime: " + dateTime.toString(ISODateTimeFormat.basicTTime()));
		System.out.println("basicTTimeNoMillis: " + dateTime.toString(ISODateTimeFormat.basicTTimeNoMillis()));
		System.out.println("basicWeekDate: " + dateTime.toString(ISODateTimeFormat.basicWeekDate()));
		System.out.println("basicWeekDateTimeNoMillis: " + dateTime.toString(ISODateTimeFormat.basicWeekDateTimeNoMillis()));
		System.out.println("dateHourMinuteSecondMillis: " + dateTime.toString(ISODateTimeFormat.dateHourMinuteSecondMillis()));
		System.out.println("dateHourMinuteSecondMillis: " + dateTime.toString(ISODateTimeFormat.dateHourMinuteSecond()));
		System.out.println("dateHourMinuteSecondFraction: " + dateTime.toString(ISODateTimeFormat.dateHourMinuteSecondFraction()));
		System.out.println("hourMinuteSecondMillis: " + dateTime.toString(ISODateTimeFormat.hourMinuteSecondMillis()));
		
		System.out.println("DateTimeFormat.forPattern: " + dateTime.toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")));
		
		System.out.println("DateTimeFormat.fullDate: " + dateTime.toString(DateTimeFormat.fullDate()));
		System.out.println("DateTimeFormat.fullDateTime: " + dateTime.toString(DateTimeFormat.fullDateTime()));
		System.out.println("DateTimeFormat.fullTime: " + dateTime.toString(DateTimeFormat.fullTime()));
	}

	@Test
	public void testModifyAble() {
		DateTime dateTime = new DateTime(2000, 1, 1, 0, 0, 0, 0);
		System.out.println(
				dateTime.plusDays(45).plusMonths(1).dayOfWeek().withMaximumValue().toString("yyyy-MM-dd HH:mm:ss"));
		System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
	}
}
