package com.an.an_aar.app.zxing.activity;

/**********************************************************
 * @文件名称：DEncodeHintType
 * @文件作者：staryumou@163.com
 * @创建时间：2016/8/25
 * @文件描述：null
 * @修改历史：2016/8/25
 **********************************************************/
public enum DEncodeHintType {
    ERROR_CORRECTION,
    CHARACTER_SET,
    DATA_MATRIX_SHAPE,
    MIN_SIZE,
    MAX_SIZE,
    MARGIN,
    PDF417_COMPACT,
    PDF417_COMPACTION,
    PDF417_DIMENSIONS,
    AZTEC_LAYERS;

    private DEncodeHintType() {
    }
}