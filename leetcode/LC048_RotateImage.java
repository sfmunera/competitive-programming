package leetcode;

public class LC048_RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            rotateLayer(matrix, layer);
        }
    }
    
    private void rotateLayer(int[][] matrix, int layer) {
        int n = matrix.length;
        int size = n - 2*layer;
        for (int offset = 0; offset < size - 1; offset++) {
            int tmp = matrix[layer][layer + offset];
            matrix[layer][layer + offset] = 
                matrix[n - 1 - layer - offset][layer];
            matrix[n - 1 - layer - offset][layer] = 
                matrix[n - 1 - layer][n - 1 - layer - offset];
            matrix[n - 1 - layer][n - 1 - layer - offset] = 
                matrix[layer + offset][n - 1 - layer];
            matrix[layer + offset][n - 1 - layer] = tmp;
        }
    }
}
