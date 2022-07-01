package com.grenapex.Service;

import com.grenapex.Entity.Compliance;
import com.grenapex.Repository.ComplianceRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    @Autowired
    private ComplianceRepository complianceRepository;


    public Compliance addData(Compliance compliance) {
        return complianceRepository.save(compliance);
    }

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "/home/soumya/Desktop";

        List<Compliance> compliances = complianceRepository.findAll();

        File file = ResourceUtils.getFile("classpath:pdf.jrxml");

        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(compliances);
        Map<String,Object> parameter = new HashMap<>();
        parameter.put("created by", "Soumya");
        JasperPrint print = JasperFillManager.fillReport(jasperReport,parameter,jrBeanCollectionDataSource);

        if(reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(print,path+ "/report.pdf");
        }

        return path+"";
    }
}
