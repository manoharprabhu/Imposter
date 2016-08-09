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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mprabhu
 */
public class NumberGeneratorTest {

    public NumberGeneratorTest() {
    }

    /**
     * Test of getNextValue method, of class NumberGenerator.
     */
    @Test
    public void testGetNextValueWithinRange() {
        NumberGenerator numberGenerator = new NumberGenerator();
        numberGenerator.setIsNextRandom(false);
        numberGenerator.setMaximumValue(100);
        numberGenerator.setMinimumValue(7);
        numberGenerator.setStartValue(13);
        IValueGenerator generator = (IValueGenerator) numberGenerator;
        assertEquals(13L, generator.getNextValue());
        assertEquals(14L, generator.getNextValue());
        assertEquals(15L, generator.getNextValue());
    }

    @Test
    public void testGetNextValueOutsideRange() {
        NumberGenerator numberGenerator = new NumberGenerator();
        numberGenerator.setIsNextRandom(false);
        numberGenerator.setMaximumValue(10);
        numberGenerator.setMinimumValue(7);
        numberGenerator.setStartValue(12);
        IValueGenerator generator = (IValueGenerator) numberGenerator;
        assertEquals(7L, generator.getNextValue());
        assertEquals(8L, generator.getNextValue());
        assertEquals(9L, generator.getNextValue());
    }

    @Test
    public void testGetNextValueWrap() {
        NumberGenerator numberGenerator = new NumberGenerator();
        numberGenerator.setIsNextRandom(false);
        numberGenerator.setMaximumValue(10);
        numberGenerator.setMinimumValue(7);
        numberGenerator.setStartValue(7);
        IValueGenerator generator = (IValueGenerator) numberGenerator;
        assertEquals(7L, generator.getNextValue());
        assertEquals(8L, generator.getNextValue());
        assertEquals(9L, generator.getNextValue());
        assertEquals(10L, generator.getNextValue());
        assertEquals(7L, generator.getNextValue());
    }

    @Test
    public void testGetNextValueOutsideRangeWrap() {
        NumberGenerator numberGenerator = new NumberGenerator();
        numberGenerator.setIsNextRandom(false);
        numberGenerator.setMaximumValue(10);
        numberGenerator.setMinimumValue(7);
        numberGenerator.setStartValue(2);
        IValueGenerator generator = (IValueGenerator) numberGenerator;
        assertEquals(7L, generator.getNextValue());
        assertEquals(8L, generator.getNextValue());
        assertEquals(9L, generator.getNextValue());
        assertEquals(10L, generator.getNextValue());
        assertEquals(7L, generator.getNextValue());
    }

    @Test
    public void testGetNextValueMidRangeWrap() {
        NumberGenerator numberGenerator = new NumberGenerator();
        numberGenerator.setIsNextRandom(false);
        numberGenerator.setMaximumValue(10);
        numberGenerator.setMinimumValue(7);
        numberGenerator.setStartValue(8);
        IValueGenerator generator = (IValueGenerator) numberGenerator;
        assertEquals(8L, generator.getNextValue());
        assertEquals(9L, generator.getNextValue());
        assertEquals(10L, generator.getNextValue());
        assertEquals(7L, generator.getNextValue());
    }

    @Test
    public void testGetNextValueRandom() {
        NumberGenerator numberGenerator = new NumberGenerator();
        numberGenerator.setIsNextRandom(true);
        numberGenerator.setMaximumValue(10);
        numberGenerator.setMinimumValue(1);
        IValueGenerator generator = (IValueGenerator) numberGenerator;
        for (int i = 0; i < 100; i++) {
            assertTrue((long) generator.getNextValue() >= 1);
            assertTrue((long) generator.getNextValue() <= 10);
        }
    }

}
