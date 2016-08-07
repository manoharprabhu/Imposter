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

import java.sql.Connection;

/**
 *
 * @author mprabhu
 */
public class DataStore {

    public static Connection connection = null;
    public static int databaseType = -1;
    public static String hostname = null;
    public static String username = null;
    public static String password = null;
    public static String database = null;
    public static int port = 0;

    public boolean isValueInitialized() {
        if (connection == null || databaseType == -1 || hostname == null || username == null || password == null || database == null) {
            return false;
        }
        return true;
    }

    public static void storeCredentials(Connection connection, int databaseType, String hostname, String username, String password, int port, String database) {
        DataStore.connection = connection;
        DataStore.databaseType = databaseType;
        DataStore.hostname = hostname;
        DataStore.username = username;
        DataStore.password = password;
        DataStore.port = port;
        DataStore.database = database;
    }

}

