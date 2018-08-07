package _735_Asteroid_Collision;

import java.util.Arrays;

public class Solution {
    int[] asteroids;
    int len;
    int head = 0, tail = 0;

    public int[] asteroidCollision(int[] asteroids) {
        len = asteroids.length;
        if (len == 0) return asteroids;
        this.asteroids = asteroids;
        while (!headTail()) {
            int curLen = head;
            for (int i = head + 1; i < len - tail; ++i) {
                if (asteroids[curLen] > 0 && asteroids[i] < 0) {
                    if (asteroids[curLen] < -asteroids[i])
                        asteroids[curLen] = asteroids[i];
                    else if (asteroids[curLen] == -asteroids[i]) {
                        if (curLen != 0)
                            --curLen;
                        else if (i < len - tail - 1)
                            asteroids[curLen] = asteroids[++i];
                        else {
                            --curLen;
                            break;
                        }
                    }
                } else
                    asteroids[++curLen] = asteroids[i];
            }
            ++curLen;
            for (int i = len - tail; i < len; ++i, ++curLen) {
                asteroids[curLen] = asteroids[i];
            }
            len = curLen;
        }
        return Arrays.copyOf(asteroids, len);
    }

    boolean headTail() {
        for (head = 0; head < len; ++head) {
            if (asteroids[head] > 0) break;
        }
        for (tail = 0; tail < len; ++tail) {
            if (asteroids[len - tail - 1] < 0) break;
        }
        return head + tail == len;
    }
}
