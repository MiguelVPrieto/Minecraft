import java.util.Random;

public class PerlinNoise {
    private int[] permutation;
    private final int permutationSize = 256;

    public PerlinNoise() {
        permutation = new int[permutationSize * 2];
        Random random = new Random();

        for (int i = 0; i < permutationSize; i++) {
            permutation[i] = i;
        }

        // Shuffle the array
        for (int i = 0; i < permutationSize; i++) {
            int j = random.nextInt(permutationSize);
            int temp = permutation[i];
            permutation[i] = permutation[j];
            permutation[j] = temp;
        }

        // Duplicate the array
        for (int i = 0; i < permutationSize; i++) {
            permutation[permutationSize + i] = permutation[i];
        }
    }

    private double fade(double t) {
        return t * t * t * (t * (t * 6 - 15) + 10);
    }

    private double lerp(double t, double a, double b) {
        return a + t * (b - a);
    }

    private double grad(int hash, double x, double y) {
        int h = hash & 15;
        double u = h < 8 ? x : y;
        double v = h < 4 ? y : h == 12 || h == 14 ? x : 0;
        return ((h & 1) == 0 ? u : -u) + ((h & 2) == 0 ? v : -v);
    }

    public double noise(double x, double y) {
        int X = (int) Math.floor(x) & 255;
        int Y = (int) Math.floor(y) & 255;

        x -= Math.floor(x);
        y -= Math.floor(y);

        double u = fade(x);
        double v = fade(y);

        int aa = permutation[X] + Y;
        int ab = permutation[X] + Y + 1;
        int ba = permutation[X + 1] + Y;
        int bb = permutation[X + 1] + Y + 1;

        double result = lerp(v, lerp(u, grad(permutation[aa], x, y), grad(permutation[ba], x - 1, y)),
                lerp(u, grad(permutation[ab], x, y - 1), grad(permutation[bb], x - 1, y - 1)));
        return (result + 1) / 2.0; // Normalize result to 0.0 - 1.0
    }

    public static void main(String[] args) {
    }
}
