package com.zheng;

import lombok.experimental.UtilityClass;

/**
 * @author: ZhengTianLiang
 * @date: 2022/10/11 22:47
 * @desc:
 */
@UtilityClass
public class CommonUtil {

    /**
     * 分解从0到max的前后区间
     *
     * @param max  最大值,不包括
     * @param step 步长
     * @return
     */
    public static int[][] range(int max, int step) {
        int size = max / step + (max % step == 0 ? 0 : 1);
        if (size < 1) {
            return new int[0][];
        } else {
            int[][] result = new int[size][2];
            for (int i = 0; i < result.length; i++) {
                int[] tmp = new int[2];
                tmp[0] = i * step;
                tmp[1] = (i + 1) * step;
                result[i] = tmp;
            }
            if (result[result.length - 1][1] > max) {
                result[result.length - 1][1] = max;
            }
            return result;
        }
    }
}
