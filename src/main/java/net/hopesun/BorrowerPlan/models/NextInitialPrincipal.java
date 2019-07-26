package net.hopesun.BorrowerPlan.models;

public class NextInitialPrincipal {
	private double initialOutstandingPrincipal;
	
	public NextInitialPrincipal(double initialOutstandingPrincipal) {
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
	}
	
	public double getInitialOutstandingPrincipal() {
		return initialOutstandingPrincipal;
	}
	public void setInitialOutstandingPrincipal(double initialOutstandingPrincipal) {
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
	}
}
