package com.java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailInfo {
    String from;
    String to;
    String subject;
    String body;
    String attachments;

    public MailInfo(String to, String subject, String body) {
        this.from = "Digizone support <project1.pd05200@gmail.com>";
        this.to = to;
        this.subject = subject;
        this.body = body;
    }
}
