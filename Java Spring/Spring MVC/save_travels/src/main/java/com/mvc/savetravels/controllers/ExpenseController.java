package com.mvc.savetravels.controllers;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.mvc.savetravels.models.Expense;
import com.mvc.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	private final ExpenseService expenseService;

	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@GetMapping("/")
	public String dashboard() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		model.addAttribute("expenses", expenseService.allExpenses());
	 	return "index.jsp";
	}
	@PostMapping("/createExpense")
	public String addExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expenses", expenseService.allExpenses());
            return "index.jsp";
        } else {
		expenseService.createExpense(expense);
		return "redirect:/expenses";
        }
	}
	//this is a method that renders jsp file because i want to edit an expense.
	@GetMapping("/expenses/{id}")
	public String  edit(Model model, @PathVariable("id") Long id) {
		Expense currentExpense = expenseService.findExpense(id);
		model.addAttribute("currentExpense", currentExpense);
		return "editExpense.jsp";
	}
	@PutMapping("/expenses/{id}")
	public String update(@Valid @ModelAttribute("currentExpense") Expense expense, BindingResult result, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "editExpense.jsp";
		}
		System.out.println("hei");
		expenseService.updateExpense(expense);
		return "redirect:/";
	}
	
}
 