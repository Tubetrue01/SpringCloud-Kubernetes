package org.tubetrue01.utils;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2020/3/23
 * Time : 4:48 下午
 * Description :
 */
public enum StatusCode {
    SUCCESS(10010, "请求成功");

    public int code;
    public String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int getCode() {
        return code;
    }

    public static StatusCode get(int typeCode) {
        StatusCode result = null;
        try {
            StatusCode[] arr = StatusCode.class.getEnumConstants();
            var targetMethod = StatusCode.class.getDeclaredMethod("getCode");
            Integer typeCodeVal;
            for (StatusCode entity : arr) {
                typeCodeVal = Integer.valueOf(targetMethod.invoke(entity).toString());
                if (typeCodeVal.equals(typeCode)) {
                    result = entity;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
