/*
 * The MIT License
 *
 * Copyright 2016 mprabhu.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.manoharprabhu.services;

/**
 *
 * @author mprabhu
 */
public class NumberGenerator implements IValueGenerator {

    private boolean isNextRandom = false;
    private long minimumValue = 0;
    private Long currentValue = null;
    private long maximumValue = 0;
    private long startValue = 0;

    @Override
    public Object getNextValue() {
        if (isNextRandom) {
            long nextValue = (((long) (Math.random() * 1000)) % (maximumValue - minimumValue + 1)) + minimumValue;
            currentValue = nextValue;
        } else {
            if (currentValue == null) {
                if (startValue > maximumValue || startValue < minimumValue) {
                    startValue = minimumValue;
                }
                currentValue = startValue;
            } else {
                currentValue = currentValue + 1;
                if (currentValue > maximumValue) {
                    currentValue = minimumValue;
                }
            }
        }
        return currentValue;
    }

    /**
     * @return the isNextRandom
     */
    public boolean isIsNextRandom() {
        return isNextRandom;
    }

    /**
     * @param isNextRandom the isNextRandom to set
     */
    public void setIsNextRandom(boolean isNextRandom) {
        this.isNextRandom = isNextRandom;
    }

    /**
     * @return the minimumValue
     */
    public long getMinimumValue() {
        return minimumValue;
    }

    /**
     * @param minimumValue the minimumValue to set
     */
    public void setMinimumValue(long minimumValue) {
        this.minimumValue = minimumValue;
    }

    /**
     * @return the maximumValue
     */
    public long getMaximumValue() {
        return maximumValue;
    }

    /**
     * @param maximumValue the maximumValue to set
     */
    public void setMaximumValue(long maximumValue) {
        this.maximumValue = maximumValue;
    }

    /**
     * @param setStartValue the setStartValue to set
     */
    public void setStartValue(long startValue) {
        this.startValue = startValue;
    }

}
