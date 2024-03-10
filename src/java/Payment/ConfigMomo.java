/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Payment;

/**
 *
 * @author Dai Nhan
 */
public class ConfigMomo {

    public String partnerCode;
    public String returnUrl;
    public String IpnUrl;
    public String accessKey;
    public String secretKey;
    public String paymentUrl;

    public ConfigMomo(String partnerCode, String returnUrl, String IpnUrl, String accessKey, String secretKey, String paymentUrl) {
        this.partnerCode = partnerCode;
        this.returnUrl = returnUrl;
        this.IpnUrl = IpnUrl;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.paymentUrl = paymentUrl;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getIpnUrl() {
        return IpnUrl;
    }

    public void setIpnUrl(String IpnUrl) {
        this.IpnUrl = IpnUrl;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

}
