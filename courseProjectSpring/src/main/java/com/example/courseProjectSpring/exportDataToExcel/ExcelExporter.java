package com.example.courseProjectSpring.exportDataToExcel;

import com.example.courseProjectSpring.Model.Product;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelExporter {
    public static void exportToExcel(List<Product> dataList, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Data");

            // Заголовки столбцов
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("name");
            headerRow.createCell(1).setCellValue("band");
            headerRow.createCell(2).setCellValue("cost");
            // Добавьте заголовки для остальных столбцов, если необходимо

            // Данные
            int rowNum = 1;
            for (Product data : dataList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(data.getNameOfProduct());
                row.createCell(1).setCellValue(data.getBand());
                row.createCell(2).setCellValue(data.getCost());
                // Заполните ячейки для остальных полей объекта, если необходимо
            }

            // Запись в файл
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            }

            System.out.println("Экспорт данных в Excel завершен.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
