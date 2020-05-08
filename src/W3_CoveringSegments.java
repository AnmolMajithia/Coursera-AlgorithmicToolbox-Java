import java.util.*;

public class W3_CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        for(int i = 0; i < segments.length-1; i++) {
            for(int j = 0; j < segments.length-i-1; j++) {
                if(segments[j].end > segments[j+1].end) {
                    Segment temp = segments[j];
                    segments[j] = segments[j+1];
                    segments[j+1] = temp;
                }
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        int lim = segments[0].end;
        arr.add(lim);
        for(int i = 1; i < segments.length; i++) {
            if(segments[i].start > lim) {
                lim = segments[i].end;
                arr.add(lim);
            }
        }
        int[] points = new int[arr.size()];
        for (int i = 0; i < points.length; i++) {
            points[i] = arr.get(i);
        }
        return points;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
