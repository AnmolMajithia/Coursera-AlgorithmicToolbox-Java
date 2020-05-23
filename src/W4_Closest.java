import java.io.*;
import java.util.*;

// This one has TLE, lemme know if you can pin point my mistake so I can change it

public class W4_Closest {
    private static Random random = new Random();

    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }
    }

    static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    }

    static Point[] constructPoints(int[] x, int[] y) {
        Point[] points = new Point[x.length];
        for (int i = 0; i < x.length; i++) {
            points[i] = new Point(x[i], y[i]);
        }
        return points;
    }

    static double brute(Point[] points, int lo, int hi) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = lo; i < hi; i++) {
            for (int j = i + 1; j <= hi; j++) {
                double dist = distance(points[i], points[j]);
                if(min > dist) {
                    min = dist;
                }
            }
        }
        return min;
    }

    static double centerMin(Point[] points, double gap, double midLine) {
        int l = 0, r = 0;
        int mid = points.length/2;
        for(int i = 0; i <= mid; i++) {
            if(Math.abs(points[i].x - midLine) <= gap) {
                l = i;
                break;
            }
        }
        for(int i = points.length-1; i > mid; i--) {
            if(Math.abs(points[i].x - mid) <= gap) {
                r = i;
                break;
            }
        }
        return brute(points, l, r);
    }

    static double divConq(Point[] points, int lo, int hi) {
        if((hi - lo) <= 3) {
            return brute(points, lo, hi);
        }
        int mid = lo + (hi - lo)/2;
        double leftMin = divConq(points, lo, mid);
        double rightMin = divConq(points, mid+1, hi);
        double partitionMin = Math.min(leftMin, rightMin);
        double midLine = (points[mid].x + points[mid + 1].x)/2;
        double centerRegionMin = centerMin(points, partitionMin, midLine);
        return Math.min(partitionMin, centerRegionMin);
    }

    static double minimalDistance(int[] x, int[] y) {
        Point[] points = constructPoints(x,y);
        Arrays.sort(points);
        return divConq(points, 0, x.length - 1);
    }

    public static void main(String[] args) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        System.out.println(minimalDistance(x, y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(Objects.requireNonNull(next()));
    }
}
