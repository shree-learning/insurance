package mini_project.insurance.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import mini_project.insurance.request.SearchRequest;
import mini_project.insurance.service.ReportService;

@Controller
public class ReportController {
	
	@Autowired
	private ReportService service;
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response, Model model) throws Exception{
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment;filename=plans.pdf;");
		
		boolean status=service.exportPdf(response);
		if(status) {
			model.addAttribute("msg", "Report sent to your mail id");
		}
	}
	
	@GetMapping("excel")
	public void excelExport(HttpServletResponse response, Model model) throws Exception{
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename=plans.xls;");
		
		boolean status=service.exportExcel(response);
		if(status) {
			model.addAttribute("msg", "Report Send to your registered mail id");
		}
	}
	
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("request", new SearchRequest());
		init(model);
		return "index";
	}
	
	private void init(Model model) {
		model.addAttribute("planNames", service.getPlanName());
		model.addAttribute("planStatus", service.getPlanStatus());
	}
	
	@PostMapping("search")
	public String loadSearchData(@ModelAttribute("request") SearchRequest request, Model model) {
		init(model);
		System.out.println(request);
		model.addAttribute("searchResult", service.search(request));

		return "index";
	}
}
