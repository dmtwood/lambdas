package be.dimitrigevers.unevennumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class unevenNumbers {

    static List<Integer> nrs = new ArrayList<>();

    static List<Integer> getUnevenNumbers() {
       return nrs.stream()
               .filter(x -> x % 2 == 1)
               .sorted( (nr1, nr2) -> nr2 - nr1 )
               .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number. 0 to quit");
        int nrInput = scanner.nextInt();
        while (nrInput != 0) {
            nrs.add(nrInput);
            System.out.println("Enter a number. 0 to quit");
            nrInput = scanner.nextInt();
        }
        System.out.println(getUnevenNumbers());
    }
}
