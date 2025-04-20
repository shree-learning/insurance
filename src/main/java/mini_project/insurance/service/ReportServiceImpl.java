package mini_project.insurance.service;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import mini_project.insurance.entity.CitizenPlan;
import mini_project.insurance.repo.CitizenPlanRepo;
import mini_project.insurance.request.SearchRequest;
import mini_project.insurance.util.EmailUtils;
import mini_project.insurance.util.ExcelGenerator;
import mini_project.insurance.util.PdfGenerator;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private CitizenPlanRepo planRepo;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public List<String> getPlanName() {
		return planRepo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		return planRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan entity = new CitizenPlan();
		
		if(null!=request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		
		if(null!=request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		
		if(null!=request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		
		if(null!=request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate = request.getStartDate();
			DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(startDate, pattern);
			entity.setPlanStartDate(localDate);
		}
		
		if(null!=request.getEndDate() && !"".equals(request.getEndDate())) {
			String endDate = request.getEndDate();
			DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(endDate, pattern);
			entity.setPlanEndDate(localDate);
		}
		
		return planRepo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception{
		File f=new File("Plans.xls");
		List<CitizenPlan> list = planRepo.findAll();
		excelGenerator.generate(response, list, f);
		
		String subject="Test Mail Subject";
		String body ="<h1>Test Mail Body</h1>";
		String to="sstambe.dvg@gmail.com";
		
		emailUtils.sendEmail(subject, body, to, f);
		f.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		File f = new File("plans.pdf");
		List<CitizenPlan> list = planRepo.findAll();
		pdfGenerator.generate(response, list, f);
		
		String subject="Test Mail Subject";
		String body ="<h1>Test Mail Body</h1>";
		String to="sstambe.dvg@gmail.com";
		
		emailUtils.sendEmail(subject, body, to, f);
		f.delete();
		return true;
	}

}
