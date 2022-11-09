package com.mvc.savetravels.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.mvc.savetravels.models.Expense;
import com.mvc.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	//dependency injection for the repository here : 
	private final ExpenseRepository expRepo;
	
	//Constructor:
	public ExpenseService(ExpenseRepository expRepo) {
		this.expRepo = expRepo;
	}

	//a method that returns all the expenses:
	public List<Expense> allExpenses(){
		//i need to cast it or just put it in repository.
		return (List<Expense>) expRepo.findAll();
	}
	
	// a method that creates a new expense
	public Expense createExpense(Expense expense) {
		return expRepo.save(expense);
	}
	
	//a method that retrieves(reads) an expense:
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expRepo.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		return null;
	}
	
	//a method that updates an expense:
	public Expense updateExpense(Expense expense) {
		return expRepo.save(expense);
	}
	
	//a method that deletes an expense:
	public void deleteExpense(Long id) {
		expRepo.deleteById(id);
	}
}
