import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;


public class Partition {
  public static class AngleComparator implements Comparator<Point> {
    @Override
    public int compare(Point a, Point b) {
      return a.x * b.y - b.x * a.y;
    }
  }
  
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    
    AngleComparator cmp = new AngleComparator();
    while (true) {
      int n = in.nextInt(), w = in.nextInt(), h = in.nextInt();
      
      if (n == 0) break;
      
      ArrayList<Point> above = new ArrayList<Point>();
      ArrayList<Point> below = new ArrayList<Point>();
      for (int i = 0; i < n; i++) {
        Point p = new Point(2 * in.nextInt() - w, 2 * in.nextInt() - h);
        if (p.y > 0 || (p.y == 0 && p.x > 0)) {
          above.add(p);
        } else {
          below.add(p);
        }
      }
      
      Collections.sort(above, cmp);
      Collections.sort(below, cmp);
      
      LinkedList<Point> aboveList = new LinkedList<Point>();
      LinkedList<Point> belowList = new LinkedList<Point>();
      if (above.size() > below.size()) {
        aboveList.addAll(below);
        belowList.addAll(above);
      } else {
        aboveList.addAll(above);
        belowList.addAll(below);
      }
      
      while (aboveList.size() < belowList.size()) {
        if (aboveList.isEmpty() || cmp.compare(belowList.getFirst(), aboveList.getFirst()) >= 0) {
          aboveList.add(belowList.removeFirst());
        } else {
          belowList.add(aboveList.removeFirst());
        }
      }
      
      for (Point p : aboveList) System.out.println((p.x + w) / 2 + " " + (p.y + h) / 2);
    }
    
    in.close();
  }
}
