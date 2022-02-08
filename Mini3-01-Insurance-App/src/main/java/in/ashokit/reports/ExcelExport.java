package in.ashokit.reports;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import in.ashokit.bindings.responce.PlanResponce;

public class ExcelExport {
	
	public void excelReport(List<PlanResponce> plans , HttpServletResponse responce) throws Exception{
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet createSheet = workbook.createSheet("plans");
		XSSFRow headerRow = createSheet.createRow(0);
		headerRow.createCell(0).setCellValue("Plan_Id");
		headerRow.createCell(1).setCellValue("Plan_Name");
		headerRow.createCell(2).setCellValue("Holder_Name");
		headerRow.createCell(3).setCellValue("Holder_SSN");
		headerRow.createCell(4).setCellValue("Plan_Status");
		
		for(int i=0; i<plans.size();i++) {
			PlanResponce plan = plans.get(i);
			XSSFRow dataRow = createSheet.createRow(i+1);
			dataRow.createCell(0).setCellValue(plan.getPlanId());
			dataRow.createCell(1).setCellValue(plan.getPlanName());
			dataRow.createCell(2).setCellValue(plan.getHolderName());
			dataRow.createCell(3).setCellValue(plan.getHolderSsn());
			dataRow.createCell(4).setCellValue(plan.getPlanStatus());
			
			 
		}
		 ServletOutputStream outputStream = responce.getOutputStream();
	        workbook.write(outputStream);
	        workbook.close();
	         
	        outputStream.close();
	}

}
