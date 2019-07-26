package net.hopesun.BorrowerPlan;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.hopesun.BorrowerPlan.models.Annuity;
import net.hopesun.BorrowerPlan.models.LoanRequest;
import net.hopesun.BorrowerPlan.models.RepaymentPlan;
import net.hopesun.BorrowerPlan.services.AnnuityPlanCalculatorService;
import static net.hopesun.BorrowerPlan.utils.SerializeDouble2Decimal.round2Decimals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BorrowerPlanApplicationTests {
	AnnuityPlanCalculatorService annuityPlanCalculatorService = new AnnuityPlanCalculatorService();
	
	@Test
	public void successTest() {
		int duration = 24; // months
		LoanRequest loanRequest = new LoanRequest();
		loanRequest.setLoanAmount(5000);
		loanRequest.setNominalRate(5);
		loanRequest.setDuration(duration);
		loanRequest.setStartDate(LocalDateTime.now());
		
		RepaymentPlan res = annuityPlanCalculatorService.calculatePlan(loanRequest);
		assertEquals(res.getPlan().size(), duration);
		Annuity item0 = res.getPlan().get(0);
		
		assertEquals(round2Decimals(item0.getBorrowerPaymentAmount()), "219.36");
		assertEquals(round2Decimals(item0.getPrincipal()), "198.53");
		assertEquals(round2Decimals(item0.getInterest()), "20.83");
		assertEquals(round2Decimals(item0.getInitialOutstandingPrincipal()), "5000");
		assertEquals(round2Decimals(item0.getRemainingOutstandingPrincipal()), "4801.47");
		
		Annuity item1 = res.getPlan().get(1);
		assertEquals(round2Decimals(item1.getBorrowerPaymentAmount()), "219.36");
		assertEquals(round2Decimals(item1.getPrincipal()), "199.35");
		assertEquals(round2Decimals(item1.getInterest()), "20.01");
		assertEquals(round2Decimals(item1.getInitialOutstandingPrincipal()), "4801.47");
		assertEquals(round2Decimals(item1.getRemainingOutstandingPrincipal()), "4602.12");
	
		Annuity item23 = res.getPlan().get(23);
		assertEquals(round2Decimals(item23.getBorrowerPaymentAmount()), "219.28");
		assertEquals(round2Decimals(item23.getPrincipal()), "218.37");
		assertEquals(round2Decimals(item23.getInterest()), "0.91");
		assertEquals(round2Decimals(item23.getInitialOutstandingPrincipal()), "218.37");
		assertEquals(round2Decimals(item23.getRemainingOutstandingPrincipal()), "0");
	}
}
