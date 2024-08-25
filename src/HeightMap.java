public class HeightMap {
    public int width;
    public int length;
    public double[][] heightMap;
    public double scale;

    public HeightMap() {
        this.width = 16;
        this.length = 16;
        this.heightMap = new double[width][length];
        this.scale = 0.1;


        PerlinNoise perlinNoise = new PerlinNoise();

        // Generate the height map using Perlin noise
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                heightMap[x][y] = perlinNoise.noise(x * scale, y * scale);
            }
        }
    }

    public void printHeightMap() {
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                // Convert noise value [-1, 1] to [0, 99] range for grayscale
                int grayscale = (int)((heightMap[x][y] + 1) / 2 * 99);
                System.out.print(grayscale + " ");
            }
            System.out.println();
        }
    }
}
