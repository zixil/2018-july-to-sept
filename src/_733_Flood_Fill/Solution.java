package _733_Flood_Fill;

public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (newColor == image[sr][sc]) return image;
        if (sr != 0 && image[sr - 1][sc] == image[sr][sc]) {
            floodFill(image, sr - 1, sc, newColor);
        }
        if (sr != image.length - 1 && image[sr + 1][sc] == image[sr][sc]) {
            floodFill(image, sr + 1, sc, newColor);
        }
        if (sc != 0 && image[sr][sc - 1] == image[sr][sc]) {
            floodFill(image, sr, sc - 1, newColor);
        }
        if (sc != image[0].length - 1 && image[sr][sc + 1] == image[sr][sc]) {
            floodFill(image, sr, sc + 1, newColor);
        }
        image[sr][sc] = newColor;
        return image;
    }
}
