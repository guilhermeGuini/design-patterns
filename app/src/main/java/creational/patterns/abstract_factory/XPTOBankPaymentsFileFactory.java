package creational.patterns.abstract_factory;

import static creational.patterns.abstract_factory.XPTOBankFields.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XPTOBankPaymentsFileFactory extends AbstractPaymentsFileFactory {

    private static final int SIZE_LINE = 14;

    private Bank bank = Bank.XPTO;

    @Override
    public String createHeader() {
        return new StringBuilder(SIZE_LINE)
                    .append(FormatFields.format(bank.getBankCode().toString(), HEADER_BANK_CODE.getSize(), HEADER_BANK_CODE.getType(), HEADER_BANK_CODE.isLeftPadding()))
                    .append("20190223")
                    .toString();
    }

    @Override
    public String createBatchHeader(String paymentType) {
        return new StringBuilder(SIZE_LINE)
                .append(FormatFields.format(bank.getBankCode().toString(), BATCH_HEADER_BANK_CODE.getSize(), BATCH_HEADER_BANK_CODE.getType(), BATCH_HEADER_BANK_CODE.isLeftPadding()))
                .append(FormatFields.format(paymentType, BATCH_HEADER_PAYMENT_TYPE.getSize(), BATCH_HEADER_PAYMENT_TYPE.getType(), BATCH_HEADER_PAYMENT_TYPE.isLeftPadding()))
                .toString();
    }

    @Override
    public List<String> createPaymentDetails(List<Payment> paymentList) {
        List<String> paymentDetailsList = new ArrayList<>();

        for (Payment payment : paymentList) {
            StringBuilder sb = new StringBuilder(SIZE_LINE);
            sb.append(FormatFields.format(bank.getBankCode().toString(), DETAILS_BANK_CODE.getSize(), DETAILS_BANK_CODE.getType(), DETAILS_BANK_CODE.isLeftPadding()));
            sb.append(FormatFields.format(payment.getValue().toString(), DETAILS_PAYMENT_VALUE.getSize(), DETAILS_PAYMENT_VALUE.getType(), DETAILS_BANK_CODE.isLeftPadding()));

            paymentDetailsList.add(sb.toString());
        }

        return paymentDetailsList;
    }

    @Override
    public String createBatchTrailer(List<Payment> paymentList) {
        return new StringBuilder(SIZE_LINE)
                    .append(FormatFields.format(bank.getBankCode().toString(), BATCH_TRAILER_BANK_CODE.getSize(), BATCH_TRAILER_BANK_CODE.getType(), BATCH_TRAILER_BANK_CODE.isLeftPadding()))
                    .append(FormatFields.format(String.valueOf(paymentList.size()), BATCH_TRAILER_AMOUNT_VALUE.getSize(), BATCH_TRAILER_AMOUNT_VALUE.getType(), BATCH_TRAILER_AMOUNT_VALUE.isLeftPadding()))
                    .toString();
    }

    @Override
    public String createTrailer(Integer numberOfBatches) {
        return new StringBuilder(SIZE_LINE)
                .append(FormatFields.format(bank.getBankCode().toString(), TRAILER_BANK_CODE.getSize(), TRAILER_BANK_CODE.getType(), TRAILER_BANK_CODE.isLeftPadding()))
                .append(FormatFields.format(numberOfBatches.toString(), TRAILER_NUMBER_OF_BATCHS.getSize(), TRAILER_NUMBER_OF_BATCHS.getType(), TRAILER_NUMBER_OF_BATCHS.isLeftPadding()))
                .toString();
    }
}
