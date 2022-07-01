package com.grenapex.Controller;

import com.grenapex.Entity.Compliance;
import com.grenapex.Service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/saveData")
    public Compliance addCompliance(@RequestBody Compliance compliance) {
        return reportService.addData(compliance);
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
        return reportService.exportReport(format);
    }
}
