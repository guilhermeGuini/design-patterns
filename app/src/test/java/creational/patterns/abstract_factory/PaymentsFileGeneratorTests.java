package creational.patterns.abstract_factory;

import static org.junit.Assert.*;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PaymentsFileGeneratorTests {

    private static final String PAYMENT_TYPE_TED = "TED";
    private static final String PAYMENT_TYPE_DOC = "DOC";

    @Test
    public void shouldReturnLinesWithXPTOBankLayout() {

        List<PaymentBatch> paymentBatchList = createScenario();
        List<String> lines = new PaymentsFileGenerator(new XPTOBankPaymentsFileFactory()).generate(paymentBatchList);

        assertEquals(10, lines.size());
        assertEquals("1234520190223", lines.get(0));
        assertEquals("12345TED     ", lines.get(1));
        assertEquals("1234500875129", lines.get(2));
        assertEquals("1234500007510", lines.get(3));
        assertEquals("1234500000002", lines.get(4));
        assertEquals("12345DOC     ", lines.get(5));
        assertEquals("1234500077700", lines.get(6));
        assertEquals("1234500012300", lines.get(7));
        assertEquals("1234500000002", lines.get(8));
        assertEquals("1234500000002", lines.get(9));
    }

    @Test
    public void shouldReturnLinesWithXYZBankLayout() {

        List<PaymentBatch> paymentBatchList = createScenario();
        List<String> lines = new PaymentsFileGenerator(new XYZBankPaymentsFileFactory()).generate(paymentBatchList);

        assertEquals(10, lines.size());
        assertEquals("9876520190223191230", lines.get(0));
        assertEquals("98765TED           ", lines.get(1));
        assertEquals("9876500875129190223", lines.get(2));
        assertEquals("9876500007510190223", lines.get(3));
        assertEquals("9876500000200882639", lines.get(4));
        assertEquals("98765DOC           ", lines.get(5));
        assertEquals("9876500077700190223", lines.get(6));
        assertEquals("9876500012300190223", lines.get(7));
        assertEquals("9876500000200090000", lines.get(8));
        assertEquals("9876500000002      ", lines.get(9));
    }

    private List<PaymentBatch> createScenario() {
        List<PaymentBatch> paymentBatchList = new ArrayList<>();

        PaymentBatch batch = new PaymentBatch();
        batch.setPaymentType(PAYMENT_TYPE_TED);
        batch.addPayment(createPayment(PAYMENT_TYPE_TED, BigDecimal.valueOf(8751.29).setScale(2)));
        batch.addPayment(createPayment(PAYMENT_TYPE_TED, BigDecimal.valueOf(75.10).setScale(2)));

        paymentBatchList.add(batch);

        batch = new PaymentBatch();
        batch.setPaymentType(PAYMENT_TYPE_DOC);
        batch.addPayment(createPayment(PAYMENT_TYPE_DOC, BigDecimal.valueOf(777).setScale(2)));
        batch.addPayment(createPayment(PAYMENT_TYPE_DOC, BigDecimal.valueOf(123).setScale(2)));

        paymentBatchList.add(batch);

        return paymentBatchList;
    }

    private Payment createPayment(String paymentType, BigDecimal paymentValue) {
        Payment payment = new Payment();
        payment.setType(paymentType);
        payment.setValue(paymentValue);
        return payment;
    }
}
