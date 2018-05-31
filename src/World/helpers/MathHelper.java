package World.helpers;

public class MathHelper {

    public static int ensureRange(int value, int min, int max) {
        return java.lang.Math.min(java.lang.Math.max(value, min), max);
    }


}
