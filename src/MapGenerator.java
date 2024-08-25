public class MapGenerator {
    public static void main(String[] args) {
        HeightMap heightmap = new HeightMap();

        for (int y = 0; y < heightmap.length; y++) {
            for (int x = 0; x < heightmap.width; x++) {
                double value = heightmap.heightMap[x][y];
                if (value < 0.3) {
                    // Water
                } else if (value < 0.6) {
                    // Grassland
                } else {
                    // Mountain
                }
            }
        }
    }
}
