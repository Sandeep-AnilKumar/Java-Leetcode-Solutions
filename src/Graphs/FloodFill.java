package Graphs;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        floodFill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void floodFill(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] != oldColor) return;
        image[sr][sc] = newColor;
        floodFill(image, sr, sc + 1, oldColor, newColor);
        floodFill(image, sr + 1, sc, oldColor, newColor);
        floodFill(image, sr, sc - 1, oldColor, newColor);
        floodFill(image, sr - 1, sc, oldColor, newColor);
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 1}, {1, 0, 1}};
        image = new FloodFill().floodFill(image, 1, 1, 2);
        System.out.println("The flood filled image is := ");
        for (int[] i : image) {
            for (int n : i) {
                System.out.print(n + ", ");
            }
            System.out.println();
        }
    }
}
