package creational.patterns.abstract_factory;

import java.util.List;

public abstract class AbstractPaymentsFileFactory {

    public abstract String createHeader();

    public abstract String createBatchHeader(String paymentType);

    public abstract List<String> createPaymentDetails(List<Payment> paymentList);

    public abstract String createBatchTrailer(List<Payment> paymentList);

    public abstract String createTrailer(Integer numberOfBatchs);
}
