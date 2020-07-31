package com.nolan.bibliotheque.api.loan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bibliotheque/api")
public class LoanController {

	@Autowired 
	private LoanService loanService;
	
	@PostMapping("/save-loan")
	public Loan saveLoan(@RequestBody SimpleLoanDTO simpleLoanDTO) {
		return loanService.save(simpleLoanDTO);
	}
	
	@GetMapping("/loans")
	public List<LoanDTO> getAllLoanDTOs() {
		return loanService.mapLoansToLoanDTOs(loanService.findAllLoans());
	}
	
	@GetMapping("/loans/{status}")
	public List<LoanDTO> findLoansByStatus(@PathVariable("status") LoanStatus status) {
		return loanService.mapLoansToLoanDTOs(loanService.findLoansByStatus(status));
	}
	
	@GetMapping("/loans/customer")
	public List<LoanDTO> openLoansCustomer(@RequestParam("email") String email) {
		return loanService
				.mapLoansToLoanDTOs(loanService
						.findOpenLoansByCustomer(LoanStatus.OPEN, email));
	}
	
	public void deleteById(Long bookID, Long custID) {
		
	}
	
	@DeleteMapping("/delete-loan")
	public void deleteLoan(@RequestBody Loan loan) {
		loanService.delete(loan);
	}
	
}
