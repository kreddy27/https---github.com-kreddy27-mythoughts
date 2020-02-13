import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**@uthor:Kiran reddy
 * giturl:https://github.com/kreddy27/mythoughts.git
 */

/**
 * The Class DateGenerator.
 */
public class DateGenerator {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) {
		String quickRange = "last_month";
		String startDate = null;
		String endDate = null;

		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		LocalDate now = LocalDate.now();

		switch (quickRange) {
		case "yesterday":
			startDate = now.minusDays(1).format(format);
			endDate = now.minusDays(1).format(format);
			break;

		case "this_week":
			startDate = now.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).format(format);
			endDate = now.format(format);
			break;

		case "last_week":
			startDate = now.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).minusWeeks(1).format(format);
			endDate = now.with(TemporalAdjusters.previous(DayOfWeek.SATURDAY)).format(format);
			break;

		case "this_month":
			startDate = now.with(TemporalAdjusters.firstDayOfMonth()).format(format);
			endDate = now.with(TemporalAdjusters.lastDayOfMonth()).format(format);
			break;

		case "last_month":
			startDate = now.minusMonths(1).with(TemporalAdjusters.firstDayOfMonth()).format(format);
			endDate = now.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth()).format(format);
			break;

		case "this_year":
			startDate = now.with(TemporalAdjusters.firstDayOfYear()).format(format);
			endDate = now.format(format);
			break;

		case "last_year":
			startDate = now.with(TemporalAdjusters.firstDayOfYear()).minusYears(1).format(format);
			endDate = now.with(TemporalAdjusters.lastDayOfYear()).minusYears(1).format(format);
			break;
		}
		System.out.println(startDate);
		System.out.println(endDate);
	}

}
