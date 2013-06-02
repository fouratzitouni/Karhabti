package Technique;

import java.io.File;

public class Mail
{
    private String mailAdrSender;
    private String pwd;
    private String mailAdrRecipient;
    private String mailObject;
    private String mailSubject;
    private File attachment;

    public String getMailAdrSender() {
        return mailAdrSender;
    }

    public void setMailAdrSender(String mailAdrSender) {
        this.mailAdrSender = mailAdrSender;
    }

    public File getAttachment() {
        return attachment;
    }

    public void setAttachment(File attachment) {
        this.attachment = attachment;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMailAdrRecipient() {
        return mailAdrRecipient;
    }

    public void setMailAdrRecipient(String mailAdrRecipient) {
        this.mailAdrRecipient = mailAdrRecipient;
    }

    public String getMailObject() {
        return mailObject;
    }

    public void setMailObject(String mailObject) {
        this.mailObject = mailObject;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }
    
    
}