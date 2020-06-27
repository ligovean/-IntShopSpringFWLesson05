package com.flamexander.cloud.client;

import com.flamexander.cloud.client.entities.Employee;
import com.flamexander.cloud.client.services.EmplService;
import com.netflix.discovery.EurekaClient;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class GreetingControllerImpl implements GreetingController {
    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    ExcelReader excelReader;

    WriteExcel writeExcel;

    private EmplService emplService;

    @Autowired
    public void setGreetingClient(ExcelReader excelReader) {
        this.excelReader = excelReader;
    }

    @Autowired
    public void setWriteExcel(WriteExcel writeExcel) {
        this.writeExcel = writeExcel;
    }

    @Autowired
    public void setEmplService(EmplService emplService) {
        this.emplService = emplService;
    }


    @Value("${spring.application.name}")
    private String appName;

    @Value("${userValue}")
    private String username;

    @Override
    public String greeting() {
        String res ="";
        for (Employee e : emplService.getAllEmployee()) {
            res += e.toString() + "|| ";
        }
        return res;
//
//        return "TEST";
    }

    @Override
    public String greeting1() {
        return String.format("Hello1");
    }

    @Override
    public String greeting2() {
        return String.format("new Param");
    }

    @Override
    public void getIdByValue(String fileName) {
        try {
            ExcelReader.file = String.format("%s.xlsx",fileName);
            writeExcel.write(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public String getTableBase() {
//        return String.format("Hello1");
//    }

    @GetMapping("/abc")
    public void test() {
        System.out.println(username);
    }
}
