package creational.patterns.abstract_factory;

import java.util.ArrayList;
import java.util.List;

public class PaymentBatch {

    private String paymentType;

    private List<Payment> paymentList;

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public void addPayment(Payment payment) {
        if (paymentList == null || paymentList.isEmpty()) {
            paymentList = new ArrayList<>();
        }

        paymentList.add(payment);
    }
}
