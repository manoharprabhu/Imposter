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

import java.util.List;
import java.util.Map;

/**
 *
 * @author mprabhu
 */
public class DataStore {

    private static DatabaseService databaseService = null;
    private static String selectedTable = null;
    private static List<Map<String, String>> columnNameTypeList = null;

    public static void storeDatabaseServiceInstance(DatabaseService instance) {
        if (databaseService == null) {
            databaseService = instance;
        }
    }

    public static DatabaseService getDatabaseServiceInstance() {
        return databaseService;
    }

    public static void setSelectedTable(String table) {
        if (selectedTable == null) {
            selectedTable = table;
        }
    }

    /**
     * @return the columnNameTypeList
     */
    public static List<Map<String, String>> getColumnNameTypeList() {
        return columnNameTypeList;
    }

    /**
     * @param aColumnNameTypeList the columnNameTypeList to set
     */
    public static void setColumnNameTypeList(List<Map<String, String>> aColumnNameTypeList) {
        if (columnNameTypeList == null) {
            columnNameTypeList = aColumnNameTypeList;
        }
    }

    public static String getTypeOfColumn(String column) {
        for (Map<String, String> item : columnNameTypeList) {
            if (column.equals(item.get("column_name"))) {
                return item.get("column_type");
            }
        }
        return null;
    }

    public static Map<String, String> getMapForColumn(String column) {
        for (Map<String, String> item : columnNameTypeList) {
            if (column.equals(item.get("column_name"))) {
                return item;
            }
        }
        return null;
    }
}
