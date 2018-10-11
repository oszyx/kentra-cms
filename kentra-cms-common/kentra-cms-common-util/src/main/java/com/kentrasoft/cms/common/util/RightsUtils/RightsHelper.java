package com.kentrasoft.cms.common.util.RightsUtils;

import java.math.BigInteger;

/**
 * 描述：权限计算帮助类
 *
 * @date 2018-9-11
 */
public class RightsHelper {
    /**
     * 描述：利用BigInteger对权限 进行2的权的和计算
     *
     * @param rights int型权限编码数组
     * @return 2的权的和
     */
    public static BigInteger sumRights(int[] rights) {
        BigInteger num = new BigInteger("0");
        for (int i = 0; i < rights.length; i++) {
            num = num.setBit(rights[i]);
        }
        return num;
    }


    /**
     * 描述：利用BigInteger对权限 进行2的权的和计算
     *
     * @param rights String型权限编码数组
     * @return 2的权的和
     */
    public static BigInteger sumRights(String[] rights) {
        BigInteger num = new BigInteger("0");
        for (int i = 0; i < rights.length; i++) {
            num = num.setBit(Integer.parseInt(rights[i]));
        }
        return num;
    }


    /**
     * 描述：测试是否具有指定编码的权限
     *
     * @param sum
     * @param targetRights
     * @return
     */
    public static boolean testRights(BigInteger sum, int targetRights) {
        return sum.testBit(targetRights);
    }


    /**
     * 描述：测试是否具有指定编码的权限
     *
     * @param sum
     * @param targetRights
     * @return
     */
    public static boolean testRights(String sum, int targetRights) {
        if (isEmpty(sum)) {
            return false;
        }
        return testRights(new BigInteger(sum), targetRights);
    }


    /**
     * 描述：测试是否具有指定编码的权限
     *
     * @param sum
     * @param targetRights
     * @return
     */
    public static boolean testRights(String sum, String targetRights) {
        if (isEmpty(sum)) {
            return false;
        }
        return testRights(new BigInteger(sum), targetRights);
    }


    /**
     * 描述：测试是否具有指定编码的权限
     *
     * @param sum
     * @param targetRights
     * @return
     */
    public static boolean testRights(BigInteger sum, String targetRights) {
        return testRights(sum, Integer.parseInt(targetRights));
    }


    /**
     * 检测字符串是否为空(null,"","null")
     *
     * @param s
     * @return 为空则返回true，不否则返回false
     */
    public static boolean isEmpty(String s) {
        return s == null || "".equals(s) || "null".equals(s);
    }
}
