
import java.util.*;

class Solution {

    static class Point {

        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Line {

        int x1, y1, x2, y2;

        Line(int x1, int y1, int x2, int y2) {
            if (x1 < x2 || (x1 == x2 && y1 < y2)) {
                this.x1 = x1;
                this.y1 = y1;
                this.x2 = x2;
                this.y2 = y2;
            } else {
                this.x1 = x2;
                this.y1 = y2;
                this.x2 = x1;
                this.y2 = y1;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Line)) {
                return false;
            }
            Line l = (Line) o;
            return x1 == l.x1 && y1 == l.y1 && x2 == l.x2 && y2 == l.y2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2);
        }
    }

    public int solution(String dirs) {

        char[] dirsList = dirs.toCharArray();
        HashSet<Line> lines = new HashSet<>();
        Point st = new Point(0, 0);

        for (char dir : dirs.toCharArray()) {
            Point next = move(dir, st);
            if (next.x != st.x || next.y != st.y) { // 경계 넘어가면 st 그대로
                lines.add(new Line(st.x, st.y, next.x, next.y));
                st = next;
            }
        }

        return lines.size();
    }

    public static Point move(char dir, Point st) {
        int x = st.x;
        int y = st.y;

        switch (dir) {
            case 'L':
                if (x > -5) {
                    x--;

                }
                break;
            case 'R':
                if (x < 5) {
                    x++;

                }
                break;
            case 'D':
                if (y > -5) {
                    y--;

                }
                break;
            case 'U':
                if (y < 5) {
                    y++;

                }
                break;
        }

        return new Point(x, y);
    }
}
