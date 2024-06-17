package in.mahesh.Utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import in.mahesh.Dto.OrderDto;
import in.mahesh.Repo.OrderRepo;
import in.mahesh.entity.Order;

public class ExcelGenerator {
	
	private OrderRepo repo;
	
	
	public ByteArrayInputStream generatExcel(List<OrderDto> orders) throws Exception {
		List<Order> allOrders = repo.findAll();
		HSSFWorkbook workBook =new HSSFWorkbook();
		HSSFSheet sheet = workBook.createSheet("BOOKS_DETAILS");
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("OrderId");
		row.createCell(1).setCellValue("UserId");
		row.createCell(2).setCellValue("ProductId");
		row.createCell(3).setCellValue("Quantity");
		row.createCell(4).setCellValue("Price");
		row.createCell(4).setCellValue("PaymentType");
		int rowIndex=1;
		
		
		for( Order o : allOrders ) {
			HSSFRow row2 = sheet.createRow(rowIndex);
			row2.createCell(0).setCellValue(o.getOrderId());
			row2.createCell(1).setCellValue(o.getUserId());
			row2.createCell(2).setCellValue(o.getProductId());
			row2.createCell(3).setCellValue(o.getQuantity());
			row2.createCell(3).setCellValue(o.getPrice());
			row2.createCell(3).setCellValue(o.getPaymentType());
			rowIndex++;
		}
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		workBook.write(out);
		workBook.close();
		out.close();
		return new ByteArrayInputStream(out.toByteArray());
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
