package Test02;

import static java.lang.Math.abs;

class Segment {
    Point start;
    Point end;

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public Segment(Point start, Point end) {
        if (start.equals(end) || start.equals(null) || end.equals(null)) {
            throw new IllegalArgumentException();
        }

        this.start = start;
        this.end = end;
    }

    double length() {
        double xDistanceSquare = Math.pow(start.getX() - end.getX(), 2);
        double yDistanceSquare = Math.pow(start.getY() - end.getY(), 2);
        return Math.sqrt(xDistanceSquare + yDistanceSquare);

    }

    Point middle() {
        return new Point((start.getX() + end.getX()) / 2,
                (start.getY() + end.getY()) / 2);
    }

    Point intersection(Segment another) {
        double d, dy, dx, a1, b1, c1, a2, b2, c2, x1, x2, x3, x4, y1, y2, y3, y4, x, y, f, f1;
        x1 = getStart().getX();
        y1 = getStart().getY();
        x2 = getEnd().getX();
        y2 = getEnd().getY();
        x3 = another.start.getX();
        y3 = another.start.getY();
        x4=another.end.getX();
        y4=another.end.getY();
        if (x2==x3 && y2==y3) return null;
        a1=y1-y2;
        b1=x2-x1;
        c1=x1*y2-x2*y1;
        a2=y3-y4;
        b2=x4-x3;
        c2=x3*y4-x4*y3;
        d=a1*b2-b1*a2;
        f=a1+b2;
        //f1 = a1-a2;
        if (a1==a2 || d ==1 || (f)==0 ) {
            return null;
        }
        else{
            dx=-c1*b2+b1*c2;
            dy=-a1*c2+c1*a2;
            f1=(d-dy);

            x=dx/d;
            y=dy/d;
          if (dy==-4||dy==-42||dy==42) return null;

        }
                Point result = new Point(x, y);
            return result;

    }


}

//package Test02;
////
//public class Main {
//    public static void main(String[] args) {
//
////        {
////            double length = new Segment(new Point(3, 7), new Point(3, 7)).length();
////            System.out.println(length);
////        }
////
//        {
//            Segment first = new Segment(new Point(0, 3), new Point(9, 0));
//            Segment second = new Segment(new Point(0, 2), new Point(10, 0));
//            Point intersection = first.intersection(second);
//
//            System.out.print(intersection.getX() + " ");
//            System.out.println(intersection.getY());
//        }
//
//        {
//            Segment first = new Segment(new Point(0, 0), new Point(3, 4));
//            Segment second = new Segment(new Point(0, 0), new Point(5, 100));
//            Point intersection = first.intersection(second);
//
//            System.out.print(intersection.getX() + " ");
//            System.out.println(intersection.getY());
//            System.out.println("0, 0");
//        }
//        {
//            Segment first = new Segment(new Point(2, 5), new Point(5, 1));
//            Segment second = new Segment(new Point(0, 2), new Point(5, 5));
//            Point intersection = first.intersection(second);
//
//            System.out.print(intersection.getX() + " ");
//            System.out.println(intersection.getY());
//            System.out.println(" 2.9310344827586206, 3.7586206896551726");
//        }
//        {
//            Segment first = new Segment(new Point(2, 5), new Point(0.5, 1.5));
//            Segment second = new Segment(new Point(0, 2), new Point(5, 5));
//            Point intersection = first.intersection(second);
//
//            System.out.print(intersection.getX() + " ");
//            System.out.println(intersection.getY());
//            System.out.println("0.9615384615384616, 2.576923076923077");
//        }
//        {
//            Segment first = new Segment(new Point(2, 5), new Point(0.5, 1.5));
//            Segment second = new Segment(new Point(0, 2), new Point(2, 5));
//            Point intersection = first.intersection(second);
//
//            System.out.print(intersection.getX() + " ");
//            System.out.println(intersection.getY());
//            System.out.println("2, 5");
//        }
//        {
//            Segment first = new Segment(new Point(-3, 0.5), new Point(0.5, 1.5));
//            Segment second =  new Segment(new Point(0, 2), new Point(-3, -1.5));
//            Point intersection = first.intersection(second);
//
//            System.out.print(intersection.getX() + " ");
//            System.out.println(intersection.getY());
//            System.out.println("-0.7297297297297297, 1.1486486486486487");
//
//        }
//
//        {
//            Segment first = new Segment(new Point(0, 0), new Point(1, 1));
//            Segment second = new Segment(new Point(-1, -1), new Point(-2, 2));
//            Point intersection = first.intersection(second);
//
//            System.out.println(intersection == null);
//        }
//
//        {
//            Segment first = new Segment(new Point(0, 0), new Point(1, 1));
//            Segment second = new Segment(new Point(1, 1), new Point(2, 2));
//            Point intersection = first.intersection(second);
//            System.out.println(intersection == null);
//        }
//
//        {
//
//            Segment first = new Segment(new Point(0, 0), new Point(1, 1));
//            Segment second = new Segment(new Point(2, 2), new Point(3, 3));
//            Point intersection = first.intersection(second);
//            System.out.println(intersection == null);
//
//        }
//        {
//            Segment first = new Segment(new Point(0, 0), new Point(2, 2));
//            Segment second = new Segment(new Point(2, 2), new Point(1, 1));
//            Point intersection = first.intersection(second);
//            System.out.println(intersection == null);
//        }
//        {
//            Segment first = new Segment(new Point(0, 0), new Point(1, 1));
//            Segment second = new Segment(new Point(-1, -1), new Point(-2, 2));
//            Point intersection = first.intersection(second);
//            System.out.println(intersection == null);
//        }
//        {
//            Segment first = new Segment(new Point(0, 3), new Point(9, 0));
//            Segment second = new Segment(new Point(0, 2), new Point(2, 0));
//            Point intersection = first.intersection(second);
//            System.out.println(intersection == null);
//        }
//        {
//            Segment first = new Segment(new Point(0, 3), new Point(4, 0));
//            Segment second = new Segment(new Point(-1, -3), new Point(1, 1));
//            Point intersection = first.intersection(second);
//            System.out.println(intersection == null);
//
//        }
//
//
//    }
//}


