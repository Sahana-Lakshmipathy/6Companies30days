class Solution {
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;
        int[][] result = new int[rows][cols];

        int[] directions = {-1,0,1};

        // for each cell in the img matrix
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int sum = 0;
                int count = 0;

                // for each cell in the directions array
                for(int dx: directions){
                    for(int dy: directions){
                        int x = i + dx;
                        int y = j + dy;

                        if (x >= 0 && x < rows && y >= 0 && y < cols){
                            sum += img[x][y];
                            count++;
                        }
                    }
                }

                result[i][j] = sum / count;
            }
        }

        return result;
    }
}
