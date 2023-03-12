package main.java.controllers;

import main.java.Database;
import main.java.models.Lease;
import main.java.models.Payment;
import main.java.models.Tenant;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class PaymentController {
    private static final Scanner input = new Scanner(System.in);
    private static PaymentController instance = new PaymentController();

    private PaymentController() {
    }

    public static PaymentController getInstance() {
        if (instance == null) {
            instance = new PaymentController();
        }
        return instance;
    }

    private static Date getFirstDateOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    public void createNewPayment() {
        System.out.println("Please enter the tenant's lease id:");
        Lease lease = Database.getInstance().getLeaseById(input.nextInt());
        System.out.println("Please enter the tenant's id:");
        Tenant tenant = Database.getInstance().getTenantById(input.nextInt());
        System.out.println("Please enter the payment amount:");
        double amount = input.nextDouble();

        // Initialize new Calendar with local system time.
        Calendar sys = Calendar.getInstance();
        Date paidOn = sys.getTime();
        Date dueDate = getFirstDateOfMonth(sys.getTime());

        System.out.println("Do you confirm the Tenant has paid all balances (please enter 1 or 2): \n1 - Yes\n2 - No");
        if (input.nextInt() == 1) lease.setIsPaid(true);

        // Record payment in db
        Database.getInstance().addPayment(new Payment(lease, amount, tenant, dueDate, paidOn));
    }
}
