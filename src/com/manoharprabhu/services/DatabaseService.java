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

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mprabhu
 */
public class DatabaseService {

    IDatabaseOperations databaseOperations = null;

    public DatabaseService(int type, String hostname, String username, String password, int port) {
        if (type == 0) {
            databaseOperations = new MySQLOperations(hostname, username, password, port);
        }
    }

    public boolean testConnection() {
        return databaseOperations.testConnection();
    }

    public List<String> getDatabaseList() {
        return databaseOperations.getDatabaseList();
    }
    
    public void setDatabase(String database) {
        databaseOperations.setDatabaseName(database);
    }
    
    public List<String> getTablesList() {
        return databaseOperations.getTablesList();
    }
        
    public List<Map<String, String>> getColumnNamesAndAttributes(String table) {
        return databaseOperations.getColumnNamesAndAttributes(table);
    }
    
    public String getTypeOfColumn(String columnTypeString) {
        return databaseOperations.getTypeOfColumn(columnTypeString);
    }
    
    public String getInsertSQL() {
        return databaseOperations.getInsertSQL();
    }
    
    public PreparedStatement getPreparedStatementForInsertQuery() {
        return databaseOperations.getPreparedStatementForInsertQuery();
    }
    
}
