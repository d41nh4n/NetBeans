/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Payment;

/**
 *
 * @author Dai Nhan
 */

    public class PaymentOrder {

        private String partnerCode;
        private String orderId;
        private String requestId;
        private long amount;
        private String orderInfo;
        private String orderType;
        private String partnerUserId;
        private long transId;
        private int resultCode;
        private String message;
        private String payType;
        private long responseTime;
        private String extraData;

        public PaymentOrder(String partnerCode, String orderId, String requestId, long amount, String orderInfo,
                String orderType, String partnerUserId, long transId, int resultCode, String message,
                String payType, long responseTime, String extraData) {
            this.partnerCode = partnerCode;
            this.orderId = orderId;
            this.requestId = requestId;
            this.amount = amount;
            this.orderInfo = orderInfo;
            this.orderType = orderType;
            this.partnerUserId = partnerUserId;
            this.transId = transId;
            this.resultCode = resultCode;
            this.message = message;
            this.payType = payType;
            this.responseTime = responseTime;
            this.extraData = extraData;
        }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getPartnerUserId() {
        return partnerUserId;
    }

    public void setPartnerUserId(String partnerUserId) {
        this.partnerUserId = partnerUserId;
    }

    public long getTransId() {
        return transId;
    }

    public void setTransId(long transId) {
        this.transId = transId;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }

        
    }

