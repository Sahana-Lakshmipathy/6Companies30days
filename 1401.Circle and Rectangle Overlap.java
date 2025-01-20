class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int closestX = clamp(xCenter, x1, x2);
        int closestY = clamp(yCenter, y1, y2);

        // calculate the squared distance from circle's center to the closest point
        int deltaX = closestX - xCenter;
        int deltaY = closestY - yCenter;

        int distanceSquared = deltaX * deltaX + deltaY * deltaY;

        // check if the distance withing the circle's radius
        return distanceSquared <= radius * radius;
    }

    public static int clamp(int value, int min, int max){
        // ensures that the circle's center coordinates are clamped within the rectangle's boundaries
        return Math.max(min, Math.min(value,max));
    }
}
