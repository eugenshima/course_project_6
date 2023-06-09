package com.example.courseProjectSpring.Services;

import com.example.courseProjectSpring.Model.Order;
import com.example.courseProjectSpring.Model.Product;
import com.example.courseProjectSpring.Repository.OrderRepository;
import com.example.courseProjectSpring.Repository.ProductRepository;
import com.example.courseProjectSpring.ServiceInterfaces.OrderService;
import com.example.courseProjectSpring.exportDataToExcel.ReceiptExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;


    @Override
    public Order Save(Order order) {
        String receiptInfo = "Название: Ваш продукт\nЦена: "+ order.getTotalPrice() +"\nКоличество: " + order.getQuantity();
        String filePath = "C:\\Users\\eugen\\OneDrive\\Рабочий стол\\Курсовой проект (6 сем)\\Receipt.txt";

        ReceiptExporter exporter = new ReceiptExporter();
        exporter.exportToTextFile(receiptInfo, filePath);
        order.setTotalPrice(order.getQuantity()*order.getTotalPrice());
        return orderRepository.save(order);
    }

    @Override
    public Order delete(Long id) {
        return null;
    }

    @Override
    public Order edit(Order order, Long id) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }
}
