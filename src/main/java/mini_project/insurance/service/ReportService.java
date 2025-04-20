package mini_project.insurance.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import mini_project.insurance.entity.CitizenPlan;
import mini_project.insurance.request.SearchRequest;

public interface ReportService {
	public List<String> getPlanName();
	public List<String> getPlanStatus();
	public List<CitizenPlan> search(SearchRequest request);
	public boolean exportExcel(HttpServletResponse response) throws Exception;
	public boolean exportPdf(HttpServletResponse response) throws Exception;
}
