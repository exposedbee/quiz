package fr.epita.Services;

public class MathServices {

    public static int factorial(int depth) {
        if (depth < 0) {
            throw new IllegalArgumentException("impossible to compute factorial on negative values");
        }
        if (depth == 0) {
            return 1;
        }else {
            return depth * factorial(depth -1);
        }
    }

}