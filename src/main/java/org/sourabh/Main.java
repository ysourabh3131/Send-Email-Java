package org.sourabh;

public class Main {
    public static void main(String[] args) {

        System.out.println("Starting to send out mails!!!");

        MailHandler mailHandler = new MailHandler();

        mailHandler.sendMail();
    }
}