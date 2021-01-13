package com.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.tests.Test_ContactSupportTeam;
import com.tests.Test_CreateAccount;
import com.tests.Test_Login;
import com.tests.Test_SignUpForNewsletter;
import com.tests.Test_SignedInUserCompletesPurchaseBankWirePaymentMethod;
import com.tests.Test_SignedInUserCompletesPurchaseCheckPaymentMethod;
import com.tests.Test_UpdateCartAndVerifyBehavior;

@RunWith(Suite.class)
@SuiteClasses({ Test_Login.class, Test_ContactSupportTeam.class, 
		Test_CreateAccount.class,
		Test_SignedInUserCompletesPurchaseBankWirePaymentMethod.class, 
		Test_SignedInUserCompletesPurchaseCheckPaymentMethod.class,
		Test_SignUpForNewsletter.class, 
		Test_UpdateCartAndVerifyBehavior.class })

public class Test_Suite {

}
