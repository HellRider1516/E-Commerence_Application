package in.mahesh.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import in.mahesh.Service.ReportServiceImp;

@RestController
public class ReportRestController {
	
	@Autowired
	private ReportServiceImp service;

}
