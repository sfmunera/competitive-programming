package topcoder;
import java.lang.reflect.*;
import java.util.regex.Pattern;
import java.util.Locale;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class RETester {
    public static final long TIME_LIMIT = 2000;

    public static void test(Class clazz, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Method[] ms = clazz.getMethods();
        int total = 0;
        int success = 0;
        for (Method m : ms)
            if (Modifier.isPublic(m.getModifiers()) && p.matcher(m.getName()).matches()) {
                total++;
                if (test(clazz, m))
                    success++;
            }
        System.out.println("Completed " + success + " of " + total + " tests successfully.");
        if (success < total)
            System.out.println("SOME TESTS HAVE FAILED.");
    }

    public static boolean test(Class clazz, Method method) {
        long time = System.currentTimeMillis();
        Throwable outcome;
        try {
            Object instance = clazz.newInstance();
            method.invoke(instance);
            outcome = null;
        } catch (InvocationTargetException e) {
            outcome = e.getCause();
        } catch (Throwable e) {
            outcome = e;
        }
        time = System.currentTimeMillis() - time;
        NumberFormat fmt = DecimalFormat.getInstance(Locale.US);
        fmt.setMinimumFractionDigits(3);
        System.out.print("Done " + method.getName() + " in " + fmt.format(time / 1000.0) + " sec - ");
        if (outcome instanceof MismatchException) {
            System.out.println("FAILED: " + outcome.getMessage());
            return false;
        } else if (outcome != null) {
            System.out.println("FAILED: " + outcome);
            outcome.printStackTrace(System.out);
            return false;
        } else if (time > TIME_LIMIT) {
            System.out.println("TIME LIMIT EXCEEDED");
            return false;
        } else {
            System.out.println("success");
            return true;
        }
    }

    public static class MismatchException extends RuntimeException {
        public MismatchException(String message) {
            super(message);
        }
    }

    public static final double MAX_DOUBLE_ERROR = 1E-9;

    public static boolean doubleCompare(double a, double b) {
        if (Double.isNaN(a)) {
            return Double.isNaN(b);
        } else if (Double.isInfinite(a)) {
            if (a > 0) {
                return b > 0 && Double.isInfinite(b);
            } else {
                return b < 0 && Double.isInfinite(b);
            }
        } else if (Double.isNaN(b) || Double.isInfinite(b)) {
            return false;
        } else if (Math.abs(b - a) < MAX_DOUBLE_ERROR) {
            //always allow it to be off a little, regardless of scale
            return true;
        } else {
            double min = Math.min(a * (1.0 - MAX_DOUBLE_ERROR),
                    a * (1.0 + MAX_DOUBLE_ERROR));
            double max = Math.max(a * (1.0 - MAX_DOUBLE_ERROR),
                    a * (1.0 + MAX_DOUBLE_ERROR));
            return b > min && b < max;
        }
    }

    public static boolean objectCompare(Object a, Object b) {
        return a == null ? b == null : a.equals(b);
    }

    public static void eq(double a, double b) {
        if (!doubleCompare(a, b))
            throw new MismatchException("expected " + b + ", received " + a);
    }

    public static void eq(int a, int b) {
        if (a != b)
            throw new MismatchException("expected " + b + ", received " + a);
    }

    public static void eq(char a, char b) {
        if (a != b)
            throw new MismatchException("expected '" + b + "', received '" + a + "'");
    }

    public static void eq(long a, long b) {
        if (a != b)
            throw new MismatchException("expected " + b + "L, received " + a + "L");
    }

    public static void eq(boolean a, boolean b) {
        if (a != b)
            throw new MismatchException("expected " + b + ", received " + a);
    }

    public static void eq(String a, String b) {
        if (!objectCompare(a, b))
            throw new MismatchException("expected \"" + b + "\", received \"" + a + "\"");
    }

    public static void eq(double[] a, double[] b) {
        if (a.length != b.length)
            throw new MismatchException("expected " + b.length + " elements, received " + a.length + " elements");
        for (int i = 0; i < a.length; i++)
            try {
                eq(a[i], b[i]);
            } catch (MismatchException e) {
                throw new MismatchException("differ in position " + i + ": " + e.getMessage());
            }
    }

    public static void eq(int[] a, int[] b) {
        if (a.length != b.length)
            throw new MismatchException("expected " + b.length + " elements, received " + a.length + " elements");
        for (int i = 0; i < a.length; i++)
            try {
                eq(a[i], b[i]);
            } catch (MismatchException e) {
                throw new MismatchException("differ in position " + i + ": " + e.getMessage());
            }
    }

    public static void eq(char[] a, char[] b) {
        if (a.length != b.length)
            throw new MismatchException("expected " + b.length + " elements, received " + a.length + " elements");
        for (int i = 0; i < a.length; i++)
            try {
                eq(a[i], b[i]);
            } catch (MismatchException e) {
                throw new MismatchException("differ in position " + i + ": " + e.getMessage());
            }
    }

    public static void eq(long[] a, long[] b) {
        if (a.length != b.length)
            throw new MismatchException("expected " + b.length + " elements, received " + a.length + " elements");
        for (int i = 0; i < a.length; i++)
            try {
                eq(a[i], b[i]);
            } catch (MismatchException e) {
                throw new MismatchException("differ in position " + i + ": " + e.getMessage());
            }
    }

    public static void eq(boolean[] a, boolean[] b) {
        if (a.length != b.length)
            throw new MismatchException("expected " + b.length + " elements, received " + a.length + " elements");
        for (int i = 0; i < a.length; i++)
            try {
                eq(a[i], b[i]);
            } catch (MismatchException e) {
                throw new MismatchException("differ in position " + i + ": " + e.getMessage());
            }
    }

    public static void eq(String[] a, String[] b) {
        if (a.length != b.length)
            throw new MismatchException("expected " + b.length + " elements, received " + a.length + " elements");
        for (int i = 0; i < a.length; i++)
            try {
                eq(a[i], b[i]);
            } catch (MismatchException e) {
                throw new MismatchException("differ in position " + i + ": " + e.getMessage());
            }
    }
}
