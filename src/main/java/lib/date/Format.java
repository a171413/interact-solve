package lib.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Format {
    // Timestamp を 文字列型に変換する
    public static String formatTimestamp(Timestamp timestamp, String timeFormat) {
        return new SimpleDateFormat(timeFormat).format(timestamp);
    }

    // 文字列型を Timestamp に変換する
    public static Timestamp formatString(String timestamp, String timeFormat) {
        try {
            return new Timestamp(new SimpleDateFormat(timeFormat).parse(timestamp).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            return null;
        }
    }
}
