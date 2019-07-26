package net.hopesun.BorrowerPlan.models;

import java.util.List;

public class RepaymentPlan {
	private List<Annuity> plan;

	public RepaymentPlan() { }

	public RepaymentPlan(List<Annuity> plan) {
		this.plan = plan;
	}

	public List<Annuity> getPlan() {
		return plan;
	}
	public void setPlan(List<Annuity> plan) {
		this.plan = plan;
	}
}
