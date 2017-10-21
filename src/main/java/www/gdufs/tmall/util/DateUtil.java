package www.gdufs.tmall.util;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by gu on 2017/10/14.
 */
public class DateUtil {

    public static Timestamp d2t(Date d) {
        if (null == d) {
            return null;
        }
        return new Timestamp(d.getTime());
    }

    public static Date t2d(Timestamp t) {
        if (null == t) {
            return null;
        }
        return new Date(t.getTime());
    }
}
