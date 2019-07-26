package net.hopesun.BorrowerPlan.models;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import net.hopesun.BorrowerPlan.utils.Constants;
import net.hopesun.BorrowerPlan.utils.SerializeDouble2Decimal;

public class Annuity {
	@JsonSerialize(using = SerializeDouble2Decimal.class)
	private double borrowerPaymentAmount;
	@DateTimeFormat(pattern = Constants.SYSTEM_DATE_TIME_FORMAT)
	@JsonFormat(pattern = Constants.SYSTEM_DATE_TIME_FORMAT)
	private LocalDateTime date;
	@JsonSerialize(using = SerializeDouble2Decimal.class)
	private double initialOutstandingPrincipal;
	@JsonSerialize(using = SerializeDouble2Decimal.class)
	private double interest;
	@JsonSerialize(using = SerializeDouble2Decimal.class)
	private double principal;
	@JsonSerialize(using = SerializeDouble2Decimal.class)
	private double remainingOutstandingPrincipal;
	
	public Annuity() {}
	
	public Annuity(	double borrowerPaymentAmount,
					LocalDateTime date,
					double initialOutstandingPrincipal,
					double interest,
					double principal,
					double remainingOutstandingPrincipal) {
		this.borrowerPaymentAmount = borrowerPaymentAmount;
		this.date = date;
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
		this.interest = interest;
		this.principal = principal;
		this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
	}
	public double getBorrowerPaymentAmount() {
		return borrowerPaymentAmount;
	}
	public void setBorrowerPaymentAmount(double borrowerPaymentAmount) {
		this.borrowerPaymentAmount = borrowerPaymentAmount;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public double getInitialOutstandingPrincipal() {
		return initialOutstandingPrincipal;
	}
	public void setInitialOutstandingPrincipal(double initialOutstandingPrincipal) {
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public double getRemainingOutstandingPrincipal() {
		return remainingOutstandingPrincipal;
	}
	public void setRemainingOutstandingPrincipal(double remainingOutstandingPrincipal) {
		this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
	}
}
