public class MapGenerator {
    public MapGenerator() {
        HeightMap heightmap = new HeightMap();
        int width = 16;
        int height = 16;
        int maxHeight = 256;
        int[][][] world = new int[width][maxHeight][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double value = heightmap.heightMap[x][y];
                int terrainHeight = (int) (value * (maxHeight - 1));  // Scale height value

                // Define terrain types based on height values
                if (value < 0.3) {
                    // Water
                    for (int z = 0; z <= terrainHeight; z++) {
                        world[x][z][y] = 0;  // Let's say '0' represents water
                    }
                } else if (value < 0.6) {
                    // Grassland
                    for (int z = 0; z <= terrainHeight; z++) {
                        world[x][z][y] = 1;  // Let's say '1' represents grass
                    }
                } else {
                    // Mountains
                    for (int z = 0; z <= terrainHeight; z++) {
                        world[x][z][y] = 2;  // Let's say '2' represents mountain
                    }
                }
            }
        }
    }
}
