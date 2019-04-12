package org.litespring.util;

/**
 * Created by liyinyong on 2018/6/18.
 */
public class Assert {
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
