package mini_project.insurance.util;

import java.awt.Color;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import mini_project.insurance.entity.CitizenPlan;

@Component
public class PdfGenerator {
	public void generate(HttpServletResponse response, List<CitizenPlan> list, File file) throws Exception{
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);
		Paragraph p = new Paragraph("Citizen Plans Info", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(p);
		
		PdfPTable table = new PdfPTable(7);
		table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.0f, 1.5f, 1.5f, 2.0f, 2.0f, 2.0f, 2.0f});
        table.setSpacingBefore(10);

		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Plan StartDate");
		table.addCell("Plan EndDate");
		table.addCell("Denail Reason");
		

		for (CitizenPlan citizenPlan : list) {
			table.addCell(String.valueOf(citizenPlan.getCitizenId()));
			table.addCell(citizenPlan.getCitizenName());
			table.addCell(citizenPlan.getPlanName());
			table.addCell(citizenPlan.getPlanStatus());
			if(null!=citizenPlan.getPlanStartDate()) {
				table.addCell(citizenPlan.getPlanStartDate()+"");
			}else {
				table.addCell("N/A");
			}
			if(null!=citizenPlan.getPlanEndDate()) {
				table.addCell(citizenPlan.getPlanEndDate()+"");
			}else {
				table.addCell("N/A");
			}
			if(null!=citizenPlan.getTeminationReason()) {
				table.addCell(citizenPlan.getTeminationReason());
			}else if(null!=citizenPlan.getDenialReason()){
				table.addCell(citizenPlan.getDenialReason());
			}
			else {
				table.addCell("N/A");
			}
			
		}
		document.add(table);
		document.close();
	}
}
