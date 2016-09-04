package com.an.an_aar.app.zxing.activity;

import com.google.zxing.ResultPointCallback;

import java.util.List;

/**********************************************************
 * @文件名称：DDecodeHintType
 * @文件作者：staryumou@163.com
 * @创建时间：2016/9/2
 * @文件描述：null
 * @修改历史：2016/9/2
 **********************************************************/
public enum DDecodeHintType {
    OTHER(Object.class),
    PURE_BARCODE(Void.class),
    POSSIBLE_FORMATS(List.class),
    TRY_HARDER(Void.class),
    CHARACTER_SET(String.class),
    ALLOWED_LENGTHS(int[].class),
    ASSUME_CODE_39_CHECK_DIGIT(Void.class),
    ASSUME_GS1(Void.class),
    RETURN_CODABAR_START_END(Void.class),
    NEED_RESULT_POINT_CALLBACK(ResultPointCallback.class),
    ALLOWED_EAN_EXTENSIONS(int[].class);

    private final Class<?> valueType;

    private DDecodeHintType(Class<?> valueType) {
        this.valueType = valueType;
    }

    public Class<?> getValueType() {
        return this.valueType;
    }
}
