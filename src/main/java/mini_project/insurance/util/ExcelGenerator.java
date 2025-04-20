package mini_project.insurance.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import mini_project.insurance.entity.CitizenPlan;

@Component
public class ExcelGenerator {
	
	
	public void generate(HttpServletResponse response, List<CitizenPlan> records, File file) throws Exception{
		
		
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("plans-data");
		Row headerRow = sheet.createRow(0);

		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Plan Name");
		headerRow.createCell(3).setCellValue("Plan Status");
		headerRow.createCell(4).setCellValue("Plan Start Date");
		headerRow.createCell(5).setCellValue("Plan End Date");
		headerRow.createCell(6).setCellValue("Benefit Amount");

		int dataRowIndex = 1;
		for (CitizenPlan citizenPlan : records) {
			Row rowData = sheet.createRow(dataRowIndex);
			rowData.createCell(0).setCellValue(citizenPlan.getCitizenId());
			rowData.createCell(1).setCellValue(citizenPlan.getCitizenName());
			rowData.createCell(2).setCellValue(citizenPlan.getPlanName());
			rowData.createCell(3).setCellValue(citizenPlan.getPlanStatus());

			if (null != citizenPlan.getPlanStartDate()) {
				rowData.createCell(4).setCellValue(citizenPlan.getPlanStartDate() + "");
			} else {
				rowData.createCell(4).setCellValue("N/A");
			}

			if (null != citizenPlan.getPlanEndDate()) {
				rowData.createCell(5).setCellValue(citizenPlan.getPlanEndDate() + "");
			} else {
				rowData.createCell(5).setCellValue("N/A");
			}

			if (null != citizenPlan.getBenefitAmount()) {
				rowData.createCell(6).setCellValue(citizenPlan.getBenefitAmount());
			} else {
				rowData.createCell(6).setCellValue("N/A");
			}
			dataRowIndex++;
		}
		
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
		fileOutputStream.close();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

	}
}
