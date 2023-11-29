package com.training.org;

import com.training.org.bank.*;
import com.training.org.loan.*;

abstract class AbstractFactory {
	public abstract Bank getBank(String bank);

	public abstract Loan getLoan(String loan);
}