package lld.logisticssystem.model;

import lld.logisticssystem.constants.PaymentMode;
import lld.logisticssystem.constants.PaymentStatus;

import java.util.UUID;

public class PaymentDetails {

    private final UUID invoiceId;

    private final UUID orderId;

    private Double amount;

    private PaymentMode paymentMode;

    private PaymentStatus paymentStatus;

    public PaymentDetails(UUID orderId, Double amount, PaymentMode paymentMode) {
        this.invoiceId = UUID.randomUUID();
        this.orderId = orderId;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.paymentStatus = PaymentStatus.INITIATED;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "invoiceId=" + invoiceId +
                ", orderId=" + orderId +
                ", amount=" + amount +
                ", paymentMode=" + paymentMode +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}
