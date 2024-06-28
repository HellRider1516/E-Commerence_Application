package in.mahesh.Rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.razorpay.Order;
import com.razorpay.RazorpayException;

import in.mahesh.Constants.AppConstants;
import in.mahesh.Dto.OrderResponse;
import in.mahesh.Dto.PaymentRequest;
import in.mahesh.Service.PaymentService;
import in.mahesh.mapper.OrderMapper;

@RequestMapping("/payment")
@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private PaymentService paymentService;

	@PostMapping(value = "/intiate-payment", produces = "application/json")
	public ResponseEntity<OrderResponse> createOrder(@RequestBody PaymentRequest paymentRequest)
			throws RazorpayException {
		Order order = paymentService.createOrder(paymentRequest);
		OrderResponse convertToOrderResponse = OrderMapper.convertToOrderResponse(order);
		if (convertToOrderResponse != null) {
			return new ResponseEntity<>(convertToOrderResponse, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/payment-callback")
	public ResponseEntity<String> handlePaymentCallback(@RequestBody Map<String, Object> payload) {
		boolean verifyPaymentSignature = paymentService.verifyPaymentSignature(payload);
		if (verifyPaymentSignature) {
			return new ResponseEntity<>(AppConstants.SUCCESS_MSG, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(AppConstants.FAILED_MSG, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
