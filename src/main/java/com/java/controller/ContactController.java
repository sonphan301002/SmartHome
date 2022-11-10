package com.java.controller;

import com.java.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ContactController {
    @Autowired
    SendMailService sendMailService;

    @PostMapping("/submit")
    public String submit(@RequestParam("toEmail")String toEmail,
                                @RequestParam("subject")String subject,
                                @RequestParam("content")String content,
                                @RequestParam("name")String name) {
        String body ="<table cellpadding=\"0\" cellspacing=\"0\" class=\"table__StyledTable-sc-1avdl6r-0 iasblw\" style=\"min-width: 450px; vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\"><tbody><tr><td style=\"text-align: center;\"><img src=\"https://drive.google.com/uc?id=1D8_zFcDLWCgHF_ipeLsMGZYELtthpK7A\" role=\"presentation\" width=\"130\" class=\"image__StyledImage-sc-hupvqm-0 eLouvR\" style=\"display: inline-block; max-width: 130px;\"></td></tr><tr style=\"text-align: center;\"><td><h2 color=\"#3979b8\" class=\"name__NameContainer-sc-1m457h3-0 jCjfGD\" style=\"margin: 0px; font-size: 18px; color: rgb(57, 121, 184); font-weight: 600;\"><span>Xin chào! " + "<span style=\"color:red; font-weight: bold;\">" + name + "</span>"
                +"</span><span>&nbsp;</span><span></span></h2><p color=\"#3979b8\" font-size=\"medium\" class=\"job-title__Container-sc-1hmtp73-0 ibpiyI\" style=\"margin: 0px; color: rgb(57, 121, 184); font-size: 14px; line-height: 22px;\"><span>Ý kiến đóng góp của bạn đã được nhận, chúng tôi sẽ phản hồi trong 1-2 ngày làm việc.</span></p><p color=\"#3979b8\" font-size=\"medium\" class=\"custom-field__CustomFieldContainer-sc-190n2f-0 hXbvbV\" style=\"color: rgb(57, 121, 184); margin: 0px; font-size: 14px; line-height: 22px;\"><span>Chúc bạn một ngày mới tốt lành!</span></p></td></tr><tr><td><table cellpadding=\"0\" cellspacing=\"0\" class=\"table__StyledTable-sc-1avdl6r-0 iasblw\" style=\"width: 100%; vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\">" +
                "<tbody><tr><td height=\"30\"></td></tr><tr><td color=\"#1460aB\" direction=\"horizontal\" width=\"auto\" height=\"1\" class=\"color-divider__Divider-sc-1h38qjv-0 dVPycS\" style=\"width: 100%; border-bottom: 1px solid rgb(20, 96, 171); border-left: none; display: block;\"></td></tr><tr><td height=\"30\"></td></tr></tbody></table><table cellpadding=\"0\" cellspacing=\"0\" class=\"table__StyledTable-sc-1avdl6r-0 iasblw\" style=\"width: 100%; vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\"><tbody><tr style=\"vertical-align: middle;\"><td><table cellpadding=\"0\" cellspacing=\"0\" class=\"table__StyledTable-sc-1avdl6r-0 iasblw\" style=\"vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\"><tbody><tr height=\"25\" style=\"vertical-align: middle;\"><td width=\"30\" style=\"vertical-align: middle;\">" +
                "<table cellpadding=\"0\" cellspacing=\"0\" class=\"table__StyledTable-sc-1avdl6r-0 iasblw\" style=\"vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\"><tbody><tr><td style=\"vertical-align: bottom;\"><span color=\"#1460aB\" width=\"11\" class=\"contact-info__IconWrapper-sc-mmkjr6-1 eOlNoC\" style=\"display: inline-block; background-color: rgb(20, 96, 171);\"><img src=\"https://cdn2.hubspot.net/hubfs/53/tools/email-signature-generator/icons/phone-icon-2x.png\" color=\"#1460aB\" alt=\"mobilePhone\" width=\"13\" class=\"contact-info__ContactLabelIcon-sc-mmkjr6-0 glcxte\" style=\"display: block; background-color: rgb(20, 96, 171);\"></span></td></tr></tbody></table></td>" +
                "<td style=\"padding: 0px; color: rgb(57, 121, 184);\"><a href=\"tel:0905008070\" color=\"#3979b8\" class=\"contact-info__ExternalLink-sc-mmkjr6-2 dwaWtg\" style=\"text-decoration: none; color: rgb(57, 121, 184); font-size: 12px;\"><span>0905008070</span></a></td></tr><tr height=\"25\" style=\"vertical-align: middle;\"><td width=\"30\" style=\"vertical-align: middle;\"><table cellpadding=\"0\" cellspacing=\"0\" class=\"table__StyledTable-sc-1avdl6r-0 iasblw\" style=\"vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\"><tbody><tr><td style=\"vertical-align: bottom;\"><span color=\"#1460aB\" width=\"11\" class=\"contact-info__IconWrapper-sc-mmkjr6-1 eOlNoC\" style=\"display: inline-block; background-color: rgb(20, 96, 171);\"><img src=\"https://cdn2.hubspot.net/hubfs/53/tools/email-signature-generator/icons/email-icon-2x.png\"" +
                " color=\"#1460aB\" alt=\"emailAddress\" width=\"13\" class=\"contact-info__ContactLabelIcon-sc-mmkjr6-0 glcxte\" style=\"display: block; background-color: rgb(20, 96, 171);\"></span></td></tr></tbody></table></td><td style=\"padding: 0px;\"><a href=\"mailto:digizone.com.vn@gmail.com\" color=\"#3979b8\" class=\"contact-info__ExternalLink-sc-mmkjr6-2 dwaWtg\" style=\"text-decoration: none; color: rgb(57, 121, 184); font-size: 12px;\"><span>digizone.com.vn@gmail.com</span></a></td></tr><tr height=\"25\" style=\"vertical-align: middle;\"><td width=\"30\" style=\"vertical-align: middle;\"><table cellpadding=\"0\" cellspacing=\"0\" class=\"table__StyledTable-sc-1avdl6r-0 iasblw\" style=\"vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\"><tbody><tr><td style=\"vertical-align: bottom;\"><span color=\"#1460aB\" width=\"11\" " +
                "class=\"contact-info__IconWrapper-sc-mmkjr6-1 eOlNoC\" style=\"display: inline-block; background-color: rgb(20, 96, 171);\"><img src=\"https://cdn2.hubspot.net/hubfs/53/tools/email-signature-generator/icons/link-icon-2x.png\" color=\"#1460aB\" alt=\"website\" width=\"13\" class=\"contact-info__ContactLabelIcon-sc-mmkjr6-0 glcxte\" style=\"display: block; background-color: rgb(20, 96, 171);\"></span></td></tr></tbody></table></td><td style=\"padding: 0px;\"><a href=\"//Digizone.com.vn\" color=\"#3979b8\" class=\"contact-info__ExternalLink-sc-mmkjr6-2 dwaWtg\" style=\"text-decoration: none; color: rgb(57, 121, 184); font-size: 12px;\"><span>Digizone.com.vn</span></a></td></tr><tr height=\"25\" style=\"vertical-align: middle;\"><td width=\"30\" style=\"vertical-align: middle;\"><table cellpadding=\"0\"" +
                " cellspacing=\"0\" class=\"table__StyledTable-sc-1avdl6r-0 iasblw\" style=\"vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\"><tbody><tr><td style=\"vertical-align: bottom;\"><span color=\"#1460aB\" width=\"11\" class=\"contact-info__IconWrapper-sc-mmkjr6-1 eOlNoC\" style=\"display: inline-block; background-color: rgb(20, 96, 171);\"><img src=\"https://cdn2.hubspot.net/hubfs/53/tools/email-signature-generator/icons/address-icon-2x.png\" color=\"#1460aB\" alt=\"address\" width=\"13\" class=\"contact-info__ContactLabelIcon-sc-mmkjr6-0 glcxte\" style=\"display: block; background-color: rgb(20, 96, 171);\"></span></td></tr></tbody></table></td><td style=\"padding: 0px;\"><span color=\"#3979b8\" class=\"contact-info__Address-sc-mmkjr6-3 ikFVIq\" style=\"font-size: 12px; color: rgb(57, 121, 184);\">" +
                "<span>105 Nguyễn Hoàng, Đà Nẵng</span></span></td></tr></tbody></table></td><td style=\"text-align: right;\"><table cellpadding=\"0\" cellspacing=\"0\" class=\"table__StyledTable-sc-1avdl6r-0 iasblw\" style=\"width: 100%; vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\"><tbody><tr><td><table cellpadding=\"0\" cellspacing=\"0\" class=\"table__StyledTable-sc-1avdl6r-0 iasblw\" style=\"display: inline-block; vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\"><tbody><tr style=\"text-align: right;\"><td><a href=\"https://www.facebook.com/Digizone.com.vn\" color=\"#1460AB\" class=\"social-links__LinkAnchor-sc-py8uhj-2 kyynGZ\" style=\"display: inline-block; padding: 0px; background-color: rgb(20, 96, 171);\"><img src=\"https://cdn2.hubspot.net/hubfs/53/tools/email-signature-generator/icons/facebook-icon-2x.png\" " +
                "alt=\"facebook\" color=\"#1460AB\" height=\"24\" class=\"social-links__LinkImage-sc-py8uhj-1 cKHJaU\" style=\"background-color: rgb(20, 96, 171); max-width: 135px; display: block;\"></a></td><td width=\"5\"><div></div></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table cellpadding=\"0\" cellspacing=\"0\" class=\"table__StyledTable-sc-1avdl6r-0 iasblw\" style=\"width: 100%; vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\"><tbody><tr><td height=\"30\"></td></tr><tr><td color=\"#1460aB\" direction=\"horizontal\" width=\"auto\" height=\"1\" class=\"color-divider__Divider-sc-1h38qjv-0 dVPycS\" style=\"width: 100%; border-bottom: 1px solid rgb(20, 96, 171); border-left: none; display: block;\"></td></tr><tr><td height=\"30\"></td></tr></tbody></table></td></tr></tbody></table>";

        sendMailService.queue(toEmail, "Liên hệ và góp ý", body);

        String adminSubject="Contact from "+name;
        String adminContent="<table cellpadding=\"0\" cellspacing=\"0\" class=\"table__StyledTable-sc-1avdl6r-0 iasblw\"\n" +
                "    style=\"min-width: 450px; vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td style=\"text-align: center;\"><img src=\"https://drive.google.com/uc?id=1D8_zFcDLWCgHF_ipeLsMGZYELtthpK7A\"\n" +
                "                    role=\"presentation\" width=\"130\" class=\"image__StyledImage-sc-hupvqm-0 eLouvR\"\n" +
                "                    style=\"display: inline-block; max-width: 130px;\"></td>\n" +
                "        </tr>\n" +
                "        <tr style=\"text-align: center;\">\n" +
                "            <td>\n" +
                "                <h2 color=\"#3979b8\" class=\"name__NameContainer-sc-1m457h3-0 jCjfGD\"\n" +
                "                    style=\"margin: 0px; font-size: 18px; color: rgb(57, 121, 184); font-weight: 600;\">" +
                "           <span>"+subject+"</span><span>&nbsp;</span><span></span></h2>\n" +
                "                <p color=\"#3979b8\" font-size=\"medium\" class=\"job-title__Container-sc-1hmtp73-0 ibpiyI\"\n" +
                "                    style=\"margin: 0px; color: rgb(57, 121, 184); font-size: 14px; line-height: 22px;\">" +
                "           <span>"+content+"</span></p>\n" +
                "                <p color=\"#3979b8\" font-size=\"medium\" class=\"custom-field__CustomFieldContainer-sc-190n2f-0 hXbvbV\"\n" +
                "                    style=\"color: rgb(57, 121, 184); margin: 0px; font-size: 14px; line-height: 22px;\"><span>Chúc bạn\n" +
                "                        một ngày mới tốt lành!</span></p>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>\n" +
                "                <table cellpadding=\"0\" cellspacing=\"0\" class=\"table__StyledTable-sc-1avdl6r-0 iasblw\"\n" +
                "                    style=\"width: 100%; vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\">\n" +
                "                    <tbody>\n" +
                "                        <tr>\n" +
                "                            <td height=\"30\"></td>\n" +
                "                        </tr>\n" +
                "                        <tr>\n" +
                "                            <td color=\"#1460aB\" direction=\"horizontal\" width=\"auto\" height=\"1\"\n" +
                "                                class=\"color-divider__Divider-sc-1h38qjv-0 dVPycS\"\n" +
                "                                style=\"width: 100%; border-bottom: 1px solid rgb(20, 96, 171); border-left: none; display: block;\">\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                        <tr>\n" +
                "                            <td height=\"30\"></td>\n" +
                "                        </tr>\n" +
                "                    </tbody>\n" +
                "                </table>\n" +
                "                <table cellpadding=\"0\" cellspacing=\"0\" class=\"table__StyledTable-sc-1avdl6r-0 iasblw\"\n" +
                "                    style=\"width: 100%; vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\">\n" +
                "                    <tbody>\n" +
                "                        <tr style=\"vertical-align: middle;\">\n" +
                "                            <td>\n" +
                "                                <table cellpadding=\"0\" cellspacing=\"0\" class=\"table__StyledTable-sc-1avdl6r-0 iasblw\"\n" +
                "                                    style=\"vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\">\n" +
                "                                    <tbody>\n" +
                "                                        <tr height=\"25\" style=\"vertical-align: middle;\">\n" +
                "                                            <td width=\"30\" style=\"vertical-align: middle;\">\n" +
                "                                                <table cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                    class=\"table__StyledTable-sc-1avdl6r-0 iasblw\"\n" +
                "                                                    style=\"vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\">\n" +
                "                                                    <tbody>\n" +
                "                                                        <tr>\n" +
                "                                                            <td style=\"vertical-align: bottom;\"><span color=\"#1460aB\"\n" +
                "                                                                    width=\"11\"\n" +
                "                                                                    class=\"contact-info__IconWrapper-sc-mmkjr6-1 eOlNoC\"\n" +
                "                                                                    style=\"display: inline-block; background-color: rgb(20, 96, 171);\"><img\n" +
                "                                                                        src=\"https://cdn2.hubspot.net/hubfs/53/tools/email-signature-generator/icons/email-icon-2x.png\"\n" +
                "                                                                        color=\"#1460aB\" alt=\"emailAddress\" width=\"13\"\n" +
                "                                                                        class=\"contact-info__ContactLabelIcon-sc-mmkjr6-0 glcxte\"\n" +
                "                                                                        style=\"display: block; background-color: rgb(20, 96, 171);\"></span>\n" +
                "                                                            </td>\n" +
                "                                                        </tr>\n" +
                "                                                    </tbody>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                            <td style=\"padding: 0px;\"><a href=\"mailto:"+toEmail+"\"\n" +
                "                                                    color=\"#3979b8\"\n" +
                "                                                    class=\"contact-info__ExternalLink-sc-mmkjr6-2 dwaWtg\"\n" +
                "                                                    style=\"text-decoration: none; color: rgb(57, 121, 184); font-size: 12px;\"><span>"+toEmail+"</span></a>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </tbody>\n" +
                "                                </table>\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                    </tbody>\n" +
                "                </table>\n" +
                "                <table cellpadding=\"0\" cellspacing=\"0\" class=\"table__StyledTable-sc-1avdl6r-0 iasblw\"\n" +
                "                    style=\"width: 100%; vertical-align: -webkit-baseline-middle; font-size: medium; font-family: Arial;\">\n" +
                "                    <tbody>\n" +
                "                        <tr>\n" +
                "                            <td height=\"30\"></td>\n" +
                "                        </tr>\n" +
                "                        <tr>\n" +
                "                            <td color=\"#1460aB\" direction=\"horizontal\" width=\"auto\" height=\"1\"\n" +
                "                                class=\"color-divider__Divider-sc-1h38qjv-0 dVPycS\"\n" +
                "                                style=\"width: 100%; border-bottom: 1px solid rgb(20, 96, 171); border-left: none; display: block;\">\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                        <tr>\n" +
                "                            <td height=\"30\"></td>\n" +
                "                        </tr>\n" +
                "                    </tbody>\n" +
                "                </table>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>";
        sendMailService.queue("digizone.smarthome+support@gmail.com",adminSubject,adminContent);
        return "/layout/contact";
    }
}

