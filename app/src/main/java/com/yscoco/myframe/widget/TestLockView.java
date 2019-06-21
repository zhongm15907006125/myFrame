package com.yscoco.myframe.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：ZhongM on 2019/6/20 18:07
 */
public class TestLockView extends View {

    private float moveX, moveY;
    private Boolean isActionUp, isActionMove, isActionDown;
    private int width;
    private int height;

    private int cellRadius, cellInnerRadius;
    private int cellBoxWidth, cellBoxHeight;

    //相当于一个内部的padding
    private int offset = 10;

    private Paint defaultPaint, selectPaint, errorPaint;
    private Path trianglePath;

    /**
     * 构建3*3矩阵
     */
    private Matrix triangleMatrix;

    /**
     * 画布
     */
    Canvas mcanvas;

    private Cell[][] mCells = new Cell[3][3];
    private List<Cell> sCells = new ArrayList<Cell>();

    public TestLockView(Context context) {
        super(context, null);
    }

    public TestLockView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public TestLockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        initCellSize();
    }

    private void initCellSize() {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
}

class Cell {
    int x, y, row, column, index;

    public Cell() {
    }

    public Cell(int x, int y, int row, int column, int index) {
        this.x = x;
        this.y = y;
        this.row = row;
        this.column = column;
        this.index = index;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
