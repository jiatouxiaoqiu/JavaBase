package cn.ebing.dog.api.test;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Locale;

public class SpringFormat {

	public static void main(String[] args) {
		Date date = new Date();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println("timestamp" + timestamp); //2019-6-3

		DateFormatter dateFormatter = new DateFormatter();
		System.out.println(dateFormatter.print(date, Locale.CHINA)); //2019-6-3
		System.out.println(dateFormatter.print(timestamp, Locale.CHINA)); //2019-6-3

		dateFormatter.setIso(DateTimeFormat.ISO.DATE_TIME);
		//dateFormatter.setStyle(DateFormat.FULL);
		System.out.println(dateFormatter.print(date, Locale.CHINA)); //2019-06-03T13:28:44.252Z
		System.out.println(dateFormatter.print(timestamp, Locale.CHINA)); //2019-06-03T13:28:44.252Z
	}
}
