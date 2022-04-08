package lld.logisticssystem.service.impl;

import lld.logisticssystem.constants.PaymentMode;
import lld.logisticssystem.exceptions.InvalidInputException;
import lld.logisticssystem.model.Order;
import lld.logisticssystem.model.PaymentDetails;

public class PaymentServiceImpl {

    public static PaymentDetails generatePaymentDetails(Order order, PaymentMode paymentMode) {
        if (order == null || paymentMode == null) {
            throw new InvalidInputException("Order and payment mode cannot be null for generating payment");
        }
        return new PaymentDetails(order.getOrderId(), PriceServiceImpl.calculateOrderPrice(order), paymentMode);
    }
}
