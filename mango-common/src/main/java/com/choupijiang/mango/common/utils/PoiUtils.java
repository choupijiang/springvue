package com.choupijiang.mango.common.utils;

import java.io.*;
import org.apache.poi.ss.usermodel.Workbook;


public class PoiUtils {
    public static File createExcelFile(Workbook workbook, String fileName) {
        OutputStream stream = null;
        File file = null;
        try {
            file = File.createTempFile(fileName, ".xlsx");
            stream = new FileOutputStream(file.getAbsoluteFile());
            workbook.write(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(workbook);
            IOUtils.closeQuietly(stream);
        }
        return file;
    }
}
