package com.example.courseProjectSpring.exportDataToExcel;

import java.io.FileWriter;
import java.io.IOException;

public class ReceiptExporter {

    public void exportToTextFile(String receiptInfo, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(receiptInfo);
            writer.close();
            System.out.println("Чек успешно экспортирован в файл: " + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка при экспорте чека: " + e.getMessage());
        }
    }
//    }
}