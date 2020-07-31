package com.nolan.bibliotheque.api.loan;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.nolan.bibliotheque.api.book.Book;
import com.nolan.bibliotheque.api.customer.Customer;

@Service
public class LoanService {
	@Autowired
	private LoanRepository loanRepository;
	
	public Loan save(SimpleLoanDTO simpleLoanDto) {
		return loanRepository.save(mapSimpleLoanDtoToLoan(simpleLoanDto));
	}
	
	public List<Loan> findAllLoans() {
		return loanRepository.findAll();
	}
	
	public Loan findById(Long id) {
		return loanRepository.findById(id).get();
	}
	
	public Loan update(SimpleLoanDTO simpleLoanDTO) {
		return loanRepository.save(mapSimpleLoanDtoToLoan(simpleLoanDTO));
	}
	
	public void deleteLoan(Long bookId, Long customerId) {
		
	}
	
	public void delete(Loan loan) {
		loanRepository.delete(loan);
	}
	
	public LoanDTO convertSimpleLoanDtoToLaonDto(SimpleLoanDTO simpleLoanDTO) {
		
		ModelMapper modelMapper = new ModelMapper();
		LoanDTO loanDTO = modelMapper.map(simpleLoanDTO, LoanDTO.class);
		
		return loanDTO;
	}
	
	public Loan convertLoanDtoToLoan(LoanDTO loanDTO) {
		
		ModelMapper mapperBook = new ModelMapper();
		Book book = mapperBook.map(loanDTO.getBookDTO(), Book.class);
		
		ModelMapper mapperCustomer = new ModelMapper();
		Customer customer = mapperCustomer.map(loanDTO.getCustomerDTO(), Customer.class);
		
		Loan loan = new Loan();
		loan.setLoanBookCustomer(new LoanBookCustomer(book, customer));
		loan.setFinishedAt(loanDTO.getFinishedAt());
		loan.setStatus(LoanStatus.OPEN);
		
		return loan;
	}
	
	public Loan mapSimpleLoanDtoToLoan(SimpleLoanDTO simpleLoanDTO) {
		
		LoanDTO loanDTO = convertSimpleLoanDtoToLaonDto(simpleLoanDTO);
		Loan loan = convertLoanDtoToLoan(loanDTO);
		/* Loan loan = new Loan();
		Book book = new Book();
		Customer customer = new Customer();
		book.setBookID(5L);
		//book.setBookID(simpleLoanDTO.getBookId());
		customer.setCustomerID(2L);
		//customer.setCustomerID(simpleLoanDTO.getCustomerId());
		
		LoanBookCustomer loanBookCustomer = new LoanBookCustomer(book, customer);
		
		loan.setLoanBookCustomer(loanBookCustomer);
		loan.setFinishedAt(simpleLoanDTO.getFinishedAt());
		loan.setStatus(LoanStatus.ENCOURS);*/
		
		return loan;
	}
	
	public List<Loan> findLoansByStatus(LoanStatus status) {
		return loanRepository.findLoansByStatus(status);
	}
	
	public List<Loan> findOpenLoansByCustomer(LoanStatus status, String email) {
		return loanRepository.findOpenLoansByCustomer(status, email);
	}
	
	public List<LoanDTO> mapLoansToLoanDTOs(List<Loan> loans) {
		
		Function<Loan, LoanDTO> mapperFunction = (loan)->{
			// The list of loans returned 
			LoanDTO loanDTO = new LoanDTO();
			// We recover the essential information to be exposed
			// For the book we will get the id, the isbn and the title
			loanDTO.getBookDTO().setBookID(loan.getLoanBookCustomer()
					.getBook().getBookID());
			loanDTO.getBookDTO().setIsbn(loan.getLoanBookCustomer()
					.getBook().getIsbn());
			loanDTO.getBookDTO().setTitle(loan.getLoanBookCustomer()
					.getBook().getTitle());
			// For the customer on recover the id, firstname and lastname and the email
			loanDTO.getCustomerDTO().setCustomerID(loan.getLoanBookCustomer()
					.getCustomer().getCustomerID());
			loanDTO.getCustomerDTO().setFirstName(loan.getLoanBookCustomer()
					.getCustomer().getFirstName());
			loanDTO.getCustomerDTO().setLastName(loan.getLoanBookCustomer()
					.getCustomer().getLastName());
			// We define the start and end dates of the loan to exhibit
			loanDTO.setStartedAt(loan.getStartedAt());
			loanDTO.setFinishedAt(loan.getFinishedAt());
			return loanDTO;
		};
		if(!CollectionUtils.isEmpty(loans)) {
			return loans.stream().map(mapperFunction).sorted().collect(Collectors.toList());
		}
		return null;
		
	}
	
}
