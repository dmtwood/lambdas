package geometrics;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Rectangles {
    private double rectHeigt, rectWidth;

    public Rectangles(double h, double w) {
        this.rectHeigt = h;
        this.rectWidth = w;
    }

    public double getSurface() {
        return rectHeigt * rectWidth;
    }

    @Override
    public String toString() {
        return "Heigt= " + rectHeigt + ", Width= " + rectWidth + " surface= " + getSurface();
    }


    public static void main(String[] args) {
        List<Rectangles> rectanglesList = Arrays.asList(
                new Rectangles(8, 1), new Rectangles(2, 2), new Rectangles(1, 4)
        );

        OptionalDouble smallestSurface = rectanglesList.stream()
                .mapToDouble(Rectangles::getSurface)
                .min();
        System.out.println("Smallest surface: " + smallestSurface.getAsDouble());

        System.out.println("******************");
        System.out.println("Following rectangles match this");
       //  smallestSurface.ifPresentOrElse(
                rectanglesList.stream()
                        .filter(rect -> rect.getSurface() == smallestSurface.getAsDouble())
                        .forEach(System.out::println);
        //);


    }


}
