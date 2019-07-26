package net.hopesun.BorrowerPlan.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import net.hopesun.BorrowerPlan.models.Annuity;
import net.hopesun.BorrowerPlan.models.LoanRequest;
import net.hopesun.BorrowerPlan.models.NextInitialPrincipal;
import net.hopesun.BorrowerPlan.models.RepaymentPlan;

@Service
public class AnnuityPlanCalculatorService {
	
	public RepaymentPlan calculatePlan(LoanRequest loanRequest) {
		double borrowerPaymentAmount = calculateBorrowerPaymentAmount(loanRequest);
		
		// This object holds the value of Initial Outstanding Principal and configured with LoanAmount for first time then it can be updated with remaining
		NextInitialPrincipal nextInitialPrincipal = new NextInitialPrincipal(loanRequest.getLoanAmount());
		
		List<Annuity> list = 
					IntStream
						.range(0, loanRequest.getDuration())
						.mapToObj(idx -> {
							return generateAnnuityObject(idx, loanRequest, borrowerPaymentAmount, nextInitialPrincipal);
						})
						.collect(Collectors.toList());
		
		return new RepaymentPlan(list);
	}
	
	private Annuity generateAnnuityObject(int idx, LoanRequest loanRequest, double borrowerPaymentAmount, NextInitialPrincipal nextInitialPrincipal) {
		Annuity annuity = new Annuity();
		double initialOutstandingPrincipal = nextInitialPrincipal.getInitialOutstandingPrincipal();
		
		annuity.setBorrowerPaymentAmount(borrowerPaymentAmount);
		annuity.setInitialOutstandingPrincipal(initialOutstandingPrincipal);
		
		// Calculating the next month
		annuity.setDate(loanRequest.getStartDate().plusMonths(idx));
		
		// Calculating interest
		double interest = calculateInterest(loanRequest.getNominalRate(), initialOutstandingPrincipal);
		annuity.setInterest(interest);
									
		// Calculating principal
		double principal = borrowerPaymentAmount - interest;
		double remaining = initialOutstandingPrincipal - principal;
		
		if(borrowerPaymentAmount > initialOutstandingPrincipal) {
			/**
			 * A special case is at the last annuity
			 */
			double last = borrowerPaymentAmount + remaining;
			annuity.setBorrowerPaymentAmount(last);
			
			principal = initialOutstandingPrincipal;
			// Since the principal is the same as initial outstanding principal, then remaining ahould be 0
			remaining = 0;
		}
		
		annuity.setPrincipal(principal);
		annuity.setRemainingOutstandingPrincipal(remaining);
		
		// To be used in the next coming item calculation
		nextInitialPrincipal.setInitialOutstandingPrincipal(remaining);
		
		return annuity;
	}
	
	private double calculateBorrowerPaymentAmount(LoanRequest loanRequest) {
		// Because provided rate is per year then we need to get the rate per month as the duration is in month
		double r = loanRequest.getNominalRate() / (100.0 * 12.0);
		double n = loanRequest.getDuration();
		double borrowerPaymentAmount = (loanRequest.getLoanAmount() * r) / ((1.0 - (1.0 / Math.pow(1.0 + r, n))));
		return Math.round(borrowerPaymentAmount * 100.0) / 100.0;
	}
	
	private double calculateInterest(double nominalRate, double initialOutstandingPrincipal) {
		double interest = nominalRate * 30.0 * initialOutstandingPrincipal / (360.0 * 100.0);
		return interest;
	}
}
