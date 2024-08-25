public class HeightMap {
    public static void main(String[] args) {
        PerlinNoise perlinNoise = new PerlinNoise();

        int width = 16;   // Width of the world
        int length = 16;  // Height of the world (not vertical height, but the 2D grid's size)
        double[][] heightMap = new double[width][length];  // Initialize the height map
        double scale = 0.1;  // Adjust this to change the terrain's roughness

        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                heightMap[x][y] = perlinNoise.noise(x * scale, y * scale);  // Generate noise-based height
            }
        }

        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                int grayscale = (int)(heightMap[x][y] * 99);  // Convert to grayscale
                System.out.print(grayscale + " ");
            }
            System.out.println();
        }

    }
}
