package creational.patterns.abstract_factory;

import java.util.ArrayList;
import java.util.List;

public class PaymentsFileGenerator {

    private AbstractPaymentsFileFactory abstractPaymentsFileFactory;

    public PaymentsFileGenerator(AbstractPaymentsFileFactory abstractPaymentsFileFactory) {
        this.abstractPaymentsFileFactory = abstractPaymentsFileFactory;
    }

    public List<String> generate(List<PaymentBatch> paymentBatchList) {

        List<String> fileLines = new ArrayList<>();

        fileLines.add(abstractPaymentsFileFactory.createHeader());

        for (PaymentBatch paymentBatch : paymentBatchList) {
            fileLines.add(abstractPaymentsFileFactory.createBatchHeader(paymentBatch.getPaymentType()));
            fileLines.addAll(abstractPaymentsFileFactory.createPaymentDetails(paymentBatch.getPaymentList()));
            fileLines.add(abstractPaymentsFileFactory.createBatchTrailer(paymentBatch.getPaymentList()));
        }

        fileLines.add(abstractPaymentsFileFactory.createTrailer(paymentBatchList.size()));

        return fileLines;
    }

}
