package net.hopesun.BorrowerPlan.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.hopesun.BorrowerPlan.models.LoanRequest;
import net.hopesun.BorrowerPlan.models.RepaymentPlan;
import net.hopesun.BorrowerPlan.services.AnnuityPlanCalculatorService;

@RestController
public class AnnuityPlanCalculator {
	
	@Autowired
	private AnnuityPlanCalculatorService annuityPlanCalculatorService;
	
	@RequestMapping(value = "/generate-plan", method = RequestMethod.POST)
    public ResponseEntity<RepaymentPlan> generate(@Valid @RequestBody LoanRequest loanRequest) {
		RepaymentPlan repaymentPlan = annuityPlanCalculatorService.calculatePlan(loanRequest);
        return new ResponseEntity<RepaymentPlan>(repaymentPlan, HttpStatus.OK);
    }
}