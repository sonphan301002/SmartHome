package com.java.rest.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.java.entity.Order;
import com.java.entity.OrderDetail;
import com.java.service.OrderService;
import com.java.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
    @Autowired
    OrderService orderService;
    @Autowired
    SendMailService sendMailService;

    @GetMapping
    public List<Order> getAll(Model model, HttpServletRequest request) {
        String tenND = request.getRemoteUser();
        return orderService.findByUsername(tenND);
    }

    @GetMapping("{maHD}")
    public List<OrderDetail> getOrderDetailList(@PathVariable("maHD") Long maHD){
        return orderService.findByMaHD(maHD);
    }

    @PostMapping()
    public Order create(@RequestBody JsonNode orderData) {
        return orderService.create(orderData);
    }
    
    @PutMapping("{maHD}")
    public Order update(@PathVariable("maHD") Long maHD, @RequestBody Order order){
        String toEmail = order.getTaiKhoan().getEmail();
        String tennd = order.getTaiKhoan().getHoTen();
        String subject ="";
        if (order.getTrangThai()==2){
             subject = "Đơn hàng của bạn đã được xác nhận!";
        }else if (order.getTrangThai()==3){
             subject = "Đơn hàng của bạn đang đuợc vận chuyển!";
        }else if (order.getTrangThai()==4){
             subject = "Đơn hàng của bạn đã hoàn thành!";
        }
        String body ="<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "    <table cellpadding=\"0\" cellspacing=\"0\" class=\"table__StyledTable-sc-1avdl6r-0 iasblw\"\n" +
                "        style=\"min-width: 450px; vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\">\n" +
                "        <tbody>\n" +
                "            <tr>\n" +
                "                <td style=\"text-align: center;\"><img\n" +
                "                        src=\"https://drive.google.com/uc?id=1D8_zFcDLWCgHF_ipeLsMGZYELtthpK7A\" role=\"presentation\"\n" +
                "                        width=\"130\" class=\"image__StyledImage-sc-hupvqm-0 eLouvR\"\n" +
                "                        style=\"display: inline-block; max-width: 130px;\"></td>\n" +
                "            </tr>\n" +
                "            <tr style=\"text-align: center;\">\n" +
                "                <td>\n" +
                "                    <h2 color=\"#3979b8\" class=\"name__NameContainer-sc-1m457h3-0 jCjfGD\"\n" +
                "                        style=\"margin: 0px; font-size: 18px; color: rgb(57, 121, 184); font-weight: 600;\"><span>Xin\n" +
                "                            chào! <span style=\"color:red; font-weight: bold;\">"+tennd+"</span></span><span>&nbsp;</span><span></span></h2>\n" +
                "                    <p color=\"#3979b8\" font-size=\"medium\" class=\"job-title__Container-sc-1hmtp73-0 ibpiyI\"\n" +
                "                        style=\"margin: 0px; color: rgb(57, 121, 184); font-size: 14px; line-height: 22px;\"><span> "+subject+"</span></p>\n" +
                "                            <p color=\"#3979b8\" font-size=\"medium\" class=\"job-title__Container-sc-1hmtp73-0 ibpiyI\"\n" +
                "                        style=\"margin: 0px; color: rgb(57, 121, 184); font-size: 14px; line-height: 22px;\"><span>Mã đơn hàng <span style=\"color:red; font-weight: bold;\">#"+maHD+"</span></span></p>\n" +
                "                        <p color=\"#3979b8\" font-size=\"medium\" class=\"custom-field__CustomFieldContainer-sc-190n2f-0 hXbvbV\"\n" +
                "                        style=\"color: rgb(57, 121, 184); margin: 0px; font-size: 14px; line-height: 22px;\"><span>Vui lòng truy cập <a href=\"//Digizone.com.vn\" style=\"text-decoration: none; color: rgb(57, 121, 184);\"> Digizone.com.vn</a> để biết thêm chi tiết.</span></p>\n" +
                "                        <p color=\"#3979b8\" font-size=\"medium\" class=\"custom-field__CustomFieldContainer-sc-190n2f-0 hXbvbV\"\n" +
                "                        style=\"color: rgb(57, 121, 184); margin: 0px; font-size: 14px; line-height: 22px;\"><span>Chúc\n" +
                "                            bạn một ngày mới tốt lành!</span></p>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td>\n" +
                "                    <table cellpadding=\"0\" cellspacing=\"0\" class=\"table__StyledTable-sc-1avdl6r-0 iasblw\"\n" +
                "                        style=\"width: 100%; vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\">\n" +
                "                        <tbody>\n" +
                "                            <tr>\n" +
                "                                <td height=\"30\"></td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td color=\"#1460aB\" direction=\"horizontal\" width=\"auto\" height=\"1\"\n" +
                "                                    class=\"color-divider__Divider-sc-1h38qjv-0 dVPycS\"\n" +
                "                                    style=\"width: 100%; border-bottom: 1px solid rgb(20, 96, 171); border-left: none; display: block;\">\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td height=\"30\"></td>\n" +
                "                            </tr>\n" +
                "                        </tbody>\n" +
                "                    </table>\n" +
                "                    <table cellpadding=\"0\" cellspacing=\"0\" class=\"table__StyledTable-sc-1avdl6r-0 iasblw\"\n" +
                "                        style=\"width: 100%; vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\">\n" +
                "                        <tbody>\n" +
                "                            <tr style=\"vertical-align: middle;\">\n" +
                "                                <td>\n" +
                "                                    <table cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                        class=\"table__StyledTable-sc-1avdl6r-0 iasblw\"\n" +
                "                                        style=\"vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\">\n" +
                "                                        <tbody>\n" +
                "                                            <tr height=\"25\" style=\"vertical-align: middle;\">\n" +
                "                                                <td width=\"30\" style=\"vertical-align: middle;\">\n" +
                "                                                    <table cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                        class=\"table__StyledTable-sc-1avdl6r-0 iasblw\"\n" +
                "                                                        style=\"vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\">\n" +
                "                                                        <tbody>\n" +
                "                                                            <tr>\n" +
                "                                                                <td style=\"vertical-align: bottom;\"><span\n" +
                "                                                                        color=\"#1460aB\" width=\"11\"\n" +
                "                                                                        class=\"contact-info__IconWrapper-sc-mmkjr6-1 eOlNoC\"\n" +
                "                                                                        style=\"display: inline-block; background-color: rgb(20, 96, 171);\"><img\n" +
                "                                                                            src=\"https://cdn2.hubspot.net/hubfs/53/tools/email-signature-generator/icons/phone-icon-2x.png\"\n" +
                "                                                                            color=\"#1460aB\" alt=\"mobilePhone\" width=\"13\"\n" +
                "                                                                            class=\"contact-info__ContactLabelIcon-sc-mmkjr6-0 glcxte\"\n" +
                "                                                                            style=\"display: block; background-color: rgb(20, 96, 171);\"></span>\n" +
                "                                                                </td>\n" +
                "                                                            </tr>\n" +
                "                                                        </tbody>\n" +
                "                                                    </table>\n" +
                "                                                </td>\n" +
                "                                                <td style=\"padding: 0px; color: rgb(57, 121, 184);\"><a\n" +
                "                                                        href=\"tel:0905008070\" color=\"#3979b8\"\n" +
                "                                                        class=\"contact-info__ExternalLink-sc-mmkjr6-2 dwaWtg\"\n" +
                "                                                        style=\"text-decoration: none; color: rgb(57, 121, 184); font-size: 12px;\"><span>0905008070</span></a>\n" +
                "                                                </td>\n" +
                "                                            </tr>\n" +
                "                                            <tr height=\"25\" style=\"vertical-align: middle;\">\n" +
                "                                                <td width=\"30\" style=\"vertical-align: middle;\">\n" +
                "                                                    <table cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                        class=\"table__StyledTable-sc-1avdl6r-0 iasblw\"\n" +
                "                                                        style=\"vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\">\n" +
                "                                                        <tbody>\n" +
                "                                                            <tr>\n" +
                "                                                                <td style=\"vertical-align: bottom;\"><span\n" +
                "                                                                        color=\"#1460aB\" width=\"11\"\n" +
                "                                                                        class=\"contact-info__IconWrapper-sc-mmkjr6-1 eOlNoC\"\n" +
                "                                                                        style=\"display: inline-block; background-color: rgb(20, 96, 171);\"><img\n" +
                "                                                                            src=\"https://cdn2.hubspot.net/hubfs/53/tools/email-signature-generator/icons/email-icon-2x.png\"\n" +
                "                                                                            color=\"#1460aB\" alt=\"emailAddress\"\n" +
                "                                                                            width=\"13\"\n" +
                "                                                                            class=\"contact-info__ContactLabelIcon-sc-mmkjr6-0 glcxte\"\n" +
                "                                                                            style=\"display: block; background-color: rgb(20, 96, 171);\"></span>\n" +
                "                                                                </td>\n" +
                "                                                            </tr>\n" +
                "                                                        </tbody>\n" +
                "                                                    </table>\n" +
                "                                                </td>\n" +
                "                                                <td style=\"padding: 0px;\"><a href=\"mailto:digizone.com.vn@gmail.com\"\n" +
                "                                                        color=\"#3979b8\"\n" +
                "                                                        class=\"contact-info__ExternalLink-sc-mmkjr6-2 dwaWtg\"\n" +
                "                                                        style=\"text-decoration: none; color: rgb(57, 121, 184); font-size: 12px;\"><span>digizone.com.vn@gmail.com</span></a>\n" +
                "                                                </td>\n" +
                "                                            </tr>\n" +
                "                                            <tr height=\"25\" style=\"vertical-align: middle;\">\n" +
                "                                                <td width=\"30\" style=\"vertical-align: middle;\">\n" +
                "                                                    <table cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                        class=\"table__StyledTable-sc-1avdl6r-0 iasblw\"\n" +
                "                                                        style=\"vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\">\n" +
                "                                                        <tbody>\n" +
                "                                                            <tr>\n" +
                "                                                                <td style=\"vertical-align: bottom;\"><span\n" +
                "                                                                        color=\"#1460aB\" width=\"11\"\n" +
                "                                                                        class=\"contact-info__IconWrapper-sc-mmkjr6-1 eOlNoC\"\n" +
                "                                                                        style=\"display: inline-block; background-color: rgb(20, 96, 171);\"><img\n" +
                "                                                                            src=\"https://cdn2.hubspot.net/hubfs/53/tools/email-signature-generator/icons/link-icon-2x.png\"\n" +
                "                                                                            color=\"#1460aB\" alt=\"website\" width=\"13\"\n" +
                "                                                                            class=\"contact-info__ContactLabelIcon-sc-mmkjr6-0 glcxte\"\n" +
                "                                                                            style=\"display: block; background-color: rgb(20, 96, 171);\"></span>\n" +
                "                                                                </td>\n" +
                "                                                            </tr>\n" +
                "                                                        </tbody>\n" +
                "                                                    </table>\n" +
                "                                                </td>\n" +
                "                                                <td style=\"padding: 0px;\"><a href=\"//Digizone.com.vn\" color=\"#3979b8\"\n" +
                "                                                        class=\"contact-info__ExternalLink-sc-mmkjr6-2 dwaWtg\"\n" +
                "                                                        style=\"text-decoration: none; color: rgb(57, 121, 184); font-size: 12px;\"><span>Digizone.com.vn</span></a>\n" +
                "                                                </td>\n" +
                "                                            </tr>\n" +
                "                                            <tr height=\"25\" style=\"vertical-align: middle;\">\n" +
                "                                                <td width=\"30\" style=\"vertical-align: middle;\">\n" +
                "                                                    <table cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                        class=\"table__StyledTable-sc-1avdl6r-0 iasblw\"\n" +
                "                                                        style=\"vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\">\n" +
                "                                                        <tbody>\n" +
                "                                                            <tr>\n" +
                "                                                                <td style=\"vertical-align: bottom;\"><span\n" +
                "                                                                        color=\"#1460aB\" width=\"11\"\n" +
                "                                                                        class=\"contact-info__IconWrapper-sc-mmkjr6-1 eOlNoC\"\n" +
                "                                                                        style=\"display: inline-block; background-color: rgb(20, 96, 171);\"><img\n" +
                "                                                                            src=\"https://cdn2.hubspot.net/hubfs/53/tools/email-signature-generator/icons/address-icon-2x.png\"\n" +
                "                                                                            color=\"#1460aB\" alt=\"address\" width=\"13\"\n" +
                "                                                                            class=\"contact-info__ContactLabelIcon-sc-mmkjr6-0 glcxte\"\n" +
                "                                                                            style=\"display: block; background-color: rgb(20, 96, 171);\"></span>\n" +
                "                                                                </td>\n" +
                "                                                            </tr>\n" +
                "                                                        </tbody>\n" +
                "                                                    </table>\n" +
                "                                                </td>\n" +
                "                                                <td style=\"padding: 0px;\"><span color=\"#3979b8\"\n" +
                "                                                        class=\"contact-info__Address-sc-mmkjr6-3 ikFVIq\"\n" +
                "                                                        style=\"font-size: 12px; color: rgb(57, 121, 184);\"><span>105\n" +
                "                                                            Nguyễn Hoàng, Đà Nẵng</span></span></td>\n" +
                "                                            </tr>\n" +
                "                                        </tbody>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                                <td style=\"text-align: right;\">\n" +
                "                                    <table cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                        class=\"table__StyledTable-sc-1avdl6r-0 iasblw\"\n" +
                "                                        style=\"width: 100%; vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\">\n" +
                "                                        <tbody>\n" +
                "                                            <tr>\n" +
                "                                                <td>\n" +
                "                                                    <table cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                        class=\"table__StyledTable-sc-1avdl6r-0 iasblw\"\n" +
                "                                                        style=\"display: inline-block; vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\">\n" +
                "                                                        <tbody>\n" +
                "                                                            <tr style=\"text-align: right;\">\n" +
                "                                                                <td><a href=\"https://www.facebook.com/Digizone.com.vn\"\n" +
                "                                                                        color=\"#1460AB\"\n" +
                "                                                                        class=\"social-links__LinkAnchor-sc-py8uhj-2 kyynGZ\"\n" +
                "                                                                        style=\"display: inline-block; padding: 0px; background-color: rgb(20, 96, 171);\"><img\n" +
                "                                                                            src=\"https://cdn2.hubspot.net/hubfs/53/tools/email-signature-generator/icons/facebook-icon-2x.png\"\n" +
                "                                                                            alt=\"facebook\" color=\"#1460AB\" height=\"24\"\n" +
                "                                                                            class=\"social-links__LinkImage-sc-py8uhj-1 cKHJaU\"\n" +
                "                                                                            style=\"background-color: rgb(20, 96, 171); max-width: 135px; display: block;\"></a>\n" +
                "                                                                </td>\n" +
                "                                                                <td width=\"5\">\n" +
                "                                                                    <div></div>\n" +
                "                                                                </td>\n" +
                "                                                            </tr>\n" +
                "                                                        </tbody>\n" +
                "                                                    </table>\n" +
                "                                                </td>\n" +
                "                                            </tr>\n" +
                "                                        </tbody>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                        </tbody>\n" +
                "                    </table>\n" +
                "                    <table cellpadding=\"0\" cellspacing=\"0\" class=\"table__StyledTable-sc-1avdl6r-0 iasblw\"\n" +
                "                        style=\"width: 100%; vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\">\n" +
                "                        <tbody>\n" +
                "                            <tr>\n" +
                "                                <td height=\"30\"></td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td color=\"#1460aB\" direction=\"horizontal\" width=\"auto\" height=\"1\"\n" +
                "                                    class=\"color-divider__Divider-sc-1h38qjv-0 dVPycS\"\n" +
                "                                    style=\"width: 100%; border-bottom: 1px solid rgb(20, 96, 171); border-left: none; display: block;\">\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td height=\"30\"></td>\n" +
                "                            </tr>\n" +
                "                        </tbody>\n" +
                "                    </table>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "        </tbody>\n" +
                "    </table>\n" +
                "</body>\n" +
                "\n" +
                "</html>";

        sendMailService.queue(toEmail, subject, body);

        return orderService.update(order);
    }
}