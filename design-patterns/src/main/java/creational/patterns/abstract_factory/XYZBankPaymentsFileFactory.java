package creational.patterns.abstract_factory;

import org.apache.commons.lang3.StringUtils;

import static creational.patterns.abstract_factory.XYZBankFields.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XYZBankPaymentsFileFactory extends AbstractPaymentsFileFactory {

    private static final Integer LINE_SIZE = 20;

    private Bank bank = Bank.XYZ;

    @Override
    public String createHeader() {

        return new StringBuilder(LINE_SIZE)
                    .append(FormatFields.format(bank.getBankCode().toString(), HEADER_BANK_CODE.getSize(), HEADER_BANK_CODE.getType(), HEADER_BANK_CODE.isLeftPadding()))
                    .append("20190223191230")
                    .toString();
    }

    @Override
    public String createBatchHeader(String paymentType) {

        return new StringBuilder(LINE_SIZE)
                .append(FormatFields.format(bank.getBankCode().toString(), BATCH_HEADER_BANK_CODE.getSize(), BATCH_HEADER_BANK_CODE.getType(), BATCH_HEADER_BANK_CODE.isLeftPadding()))
                .append(FormatFields.format(paymentType, BATCH_HEADER_PAYMENT_TYPE.getSize(), BATCH_HEADER_PAYMENT_TYPE.getType(), BATCH_HEADER_PAYMENT_TYPE.isLeftPadding()))
                .append(FormatFields.format(StringUtils.EMPTY, BATCH_HEADER_PAYMENT_FILL_BLANK.getSize(), BATCH_HEADER_PAYMENT_FILL_BLANK.getType(), BATCH_HEADER_PAYMENT_FILL_BLANK.isLeftPadding()))
                .toString();
    }

    @Override
    public List<String> createPaymentDetails(List<Payment> paymentList) {

        List<String> paymentDetailsList = new ArrayList<>();

        paymentList.stream()
                   .forEach(payment -> {
                       StringBuilder sb = new StringBuilder(LINE_SIZE);
                       sb.append(FormatFields.format(bank.getBankCode().toString(), DETAILS_BANK_CODE.getSize(), DETAILS_BANK_CODE.getType(), DETAILS_BANK_CODE.isLeftPadding()));
                       sb.append(FormatFields.format(payment.getValue().toString(), DETAILS_PAYMENT_VALUE.getSize(), DETAILS_PAYMENT_VALUE.getType(), DETAILS_PAYMENT_VALUE.isLeftPadding()));
                       sb.append("190223");

                       paymentDetailsList.add(sb.toString());
                   });

        return paymentDetailsList;
    }

    @Override
    public String createBatchTrailer(List<Payment> paymentList) {

        BigDecimal amount = paymentList.stream()
                                       .map(payment -> payment.getValue())
                                       .reduce(BigDecimal.ZERO, BigDecimal::add)
                                       .setScale(2);

        return new StringBuilder(LINE_SIZE)
                    .append(FormatFields.format(bank.getBankCode().toString(), BATCH_TRAILER_BANK_CODE.getSize(), BATCH_TRAILER_BANK_CODE.getType(), BATCH_TRAILER_BANK_CODE.isLeftPadding()))
                    .append(FormatFields.format(String.valueOf(paymentList.size()), BATCH_TRAILER_AMOUNT_PAYMENTS.getSize(), BATCH_TRAILER_AMOUNT_PAYMENTS.getType(), BATCH_TRAILER_AMOUNT_PAYMENTS.isLeftPadding()))
                    .append(FormatFields.format(amount.toString(), BATCH_TRAILER_AMOUNT_VALUE.getSize(), BATCH_TRAILER_AMOUNT_VALUE.getType(), BATCH_TRAILER_AMOUNT_VALUE.isLeftPadding()))
                    .toString();
    }

    @Override
    public String createTrailer(Integer numberOfBatchs) {
        return new StringBuilder(LINE_SIZE)
                .append(FormatFields.format(bank.getBankCode().toString(), TRAILER_BANK_CODE.getSize(), TRAILER_BANK_CODE.getType(), TRAILER_BANK_CODE.isLeftPadding()))
                .append(FormatFields.format(numberOfBatchs.toString(), TRAILER_NUMBER_OF_BATCHS.getSize(), TRAILER_NUMBER_OF_BATCHS.getType(), TRAILER_NUMBER_OF_BATCHS.isLeftPadding()))
                .append(FormatFields.format(StringUtils.EMPTY, TRAILER_FILL_BLANK.getSize(), TRAILER_FILL_BLANK.getType(), TRAILER_FILL_BLANK.isLeftPadding()))
                .toString();
    }
}
