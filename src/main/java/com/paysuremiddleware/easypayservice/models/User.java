package com.paysuremiddleware.easypayservice.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "UserApp")
public class User {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "created_date", nullable = false)
    private Date CreatedDate;
    @Column(name = "org_name", length = 64)
    private String OrgName;
    @Column(name = "description", length = 128)
    private String Description;
    @Column(name = "Ip_Address", unique = true, length = 32)
    private String IpAddress;
    @Column(name = "secrete_key", unique = true, length = 128)
    private String SecreteKey;
    @Column(name = "public_key", unique = true)
    private String PublicKey;

    @Column(name = "email", unique = true, length = 128)
    private String Email;
    @Column(name = "phone", unique = true, length = 16)
    private String Phone;
    @Column(name = "role", length = 16)
    private String Role;
    @Column(name = "last_auth_date")
    private Date LastAuthDate;
    @Column(name = "auth_failed_date")
    private Date AuthFailedDate;
    @Column(name = "auth_failed_count")
    private int AuthFailedCount;
    @Column(name = "is_email_confirmed")
    private boolean IsEmailConfirmed;
    @Column(name = "is_phone_confirmed")
    private boolean IsPhoneConfirmed;
    @Column(name = "email_confirmation_date")
    private Date EmailConfirmedDate;
    @Column(name = "phone_confirmation_date")
    private Date PhoneConfirmedDate;
    @Column(name = "email_confirmation_code", length = 8)
    private String EmailConfirmationCode;
    @Column(name = "phone_confirmation_code", length = 6)
    private String PhoneConfirmationCode;
    @Column(name = "is_key_reset_request")
    private boolean IsKeyResetRequest;
    @Column(name = "reset_key_request_date")
    private Date ResetKeyRequestDate;
    @Column(name = "reset_key_code", length = 8)
    private String ResetKeyCode;
    @Column(name = "reset_key_count")
    private int ResetKeyCount;

    @Column(name = "password_hash")
    private byte[] passwordHash;
    @Column(name = "password_salt")
    private byte[] passwordSalt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }

    public String getOrgName() {
        return OrgName;
    }

    public void setOrgName(String orgName) {
        OrgName = orgName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getIpAddress() {
        return IpAddress;
    }

    public void setIpAddress(String ipAddress) {
        IpAddress = ipAddress;
    }

    public String getSecreteKey() {
        return SecreteKey;
    }

    public void setSecreteKey(String secreteKey) {
        SecreteKey = secreteKey;
    }

    public String getPublicKey() {
        return PublicKey;
    }

    public void setPublicKey(String publicKey) {
        PublicKey = publicKey;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public Date getLastAuthDate() {
        return LastAuthDate;
    }

    public void setLastAuthDate(Date lastAuthDate) {
        LastAuthDate = lastAuthDate;
    }

    public Date getAuthFailedDate() {
        return AuthFailedDate;
    }

    public void setAuthFailedDate(Date authFailedDate) {
        AuthFailedDate = authFailedDate;
    }

    public int getAuthFailedCount() {
        return AuthFailedCount;
    }

    public void setAuthFailedCount(int authFailedCount) {
        AuthFailedCount = authFailedCount;
    }

    public boolean isEmailConfirmed() {
        return IsEmailConfirmed;
    }

    public void setEmailConfirmed(boolean emailConfirmed) {
        IsEmailConfirmed = emailConfirmed;
    }

    public boolean isPhoneConfirmed() {
        return IsPhoneConfirmed;
    }

    public void setPhoneConfirmed(boolean phoneConfirmed) {
        IsPhoneConfirmed = phoneConfirmed;
    }

    public Date getEmailConfirmedDate() {
        return EmailConfirmedDate;
    }

    public void setEmailConfirmedDate(Date emailConfirmedDate) {
        EmailConfirmedDate = emailConfirmedDate;
    }

    public Date getPhoneConfirmedDate() {
        return PhoneConfirmedDate;
    }

    public void setPhoneConfirmedDate(Date phoneConfirmedDate) {
        PhoneConfirmedDate = phoneConfirmedDate;
    }

    public String getEmailConfirmationCode() {
        return EmailConfirmationCode;
    }

    public void setEmailConfirmationCode(String emailConfirmationCode) {
        EmailConfirmationCode = emailConfirmationCode;
    }

    public String getPhoneConfirmationCode() {
        return PhoneConfirmationCode;
    }

    public void setPhoneConfirmationCode(String phoneConfirmationCode) {
        PhoneConfirmationCode = phoneConfirmationCode;
    }

    public boolean isKeyResetRequest() {
        return IsKeyResetRequest;
    }

    public void setKeyResetRequest(boolean keyResetRequest) {
        IsKeyResetRequest = keyResetRequest;
    }

    public Date getResetKeyRequestDate() {
        return ResetKeyRequestDate;
    }

    public void setResetKeyRequestDate(Date resetKeyRequestDate) {
        ResetKeyRequestDate = resetKeyRequestDate;
    }

    public String getResetKeyCode() {
        return ResetKeyCode;
    }

    public void setResetKeyCode(String resetKeyCode) {
        ResetKeyCode = resetKeyCode;
    }

    public int getResetKeyCount() {
        return ResetKeyCount;
    }

    public void setResetKeyCount(int resetKeyCount) {
        ResetKeyCount = resetKeyCount;
    }

    public byte[] getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(byte[] passwordHash) {
        this.passwordHash = passwordHash;
    }

    public byte[] getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(byte[] passwordSalt) {
        this.passwordSalt = passwordSalt;
    }
}
