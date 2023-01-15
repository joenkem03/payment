package com.paysuremiddleware.easypayservice.logic.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.paysuremiddleware.easypayservice.logic.dto.AuthToken;
import com.paysuremiddleware.easypayservice.logic.dto.NibssConfig;
import com.paysuremiddleware.easypayservice.logic.dto.requests.*;
import com.paysuremiddleware.easypayservice.logic.dto.requests.nibss.BalanceEnquiryRequest;
import com.paysuremiddleware.easypayservice.logic.dto.requests.nibss.TSQuerySingleRequest;
import com.paysuremiddleware.easypayservice.logic.dto.responses.nibss.BalanceEnquiryResponse;
import com.paysuremiddleware.easypayservice.logic.dto.responses.nibss.FTSingleCreditResponse;
import com.paysuremiddleware.easypayservice.logic.dto.requests.nibss.FTSingleCreditRequest;
import com.paysuremiddleware.easypayservice.logic.dto.requests.nibss.NESingleRequest;
import com.paysuremiddleware.easypayservice.logic.dto.responses.nibss.NESingleResponse;
import com.paysuremiddleware.easypayservice.logic.dto.responses.nibss.NibssErrorResponse;
import com.paysuremiddleware.easypayservice.logic.dto.responses.nibss.TSQuerySingleResponse;
import com.paysuremiddleware.easypayservice.logic.helpers.Utility;
import com.paysuremiddleware.easypayservice.logic.mappers.DtoObjectMapper;
import com.paysuremiddleware.easypayservice.logic.mappers.NESingleMapper;
import com.paysuremiddleware.easypayservice.logic.services.EasypayService;
import com.paysuremiddleware.easypayservice.logic.dto.responses.*;
import com.paysuremiddleware.easypayservice.models.AccountTransactionEntry;
import com.paysuremiddleware.easypayservice.models.AuditLog;
import com.paysuremiddleware.easypayservice.repository.AccountTransactionRepository;
import com.paysuremiddleware.easypayservice.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.Calendar;

//@Component
@Service("NipService")
public class EasypayServiceImpl implements EasypayService {
//    @Value("${nibss.base_url}")
//    private String baseUrl;
//
//    @Value("${nibss.token_url}")
//    private String tokenUrl;
//
//    @Value("${nibss.grant_type}")
//    private String grantType;
//
//    @Value("${nibss.client_secret}")
//    private String clientSecret;
//
//    @Value("${nibss.client_id}")
//    private String clientId;
//
//    @Value("${nibss.scope}")
//    private String scope;
//
//    @Value("${nibss.client_code}")
//    private String clientCode;

    private String baseUrl;

    private String tokenUrl;

    private String grantType;

    private String clientSecret;

    private String clientId;

    private String scope;

    private String clientCode;

//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private DtoObjectMapper objectMapper = new DtoObjectMapper();

    @Autowired
    private NESingleMapper neSingleMapper = new NESingleMapper();

    @Autowired
    private Utility util = new Utility();


    private AccountTransactionRepository transactionRepository;
    private AuditLogRepository auditLogRepository;

    public EasypayServiceImpl(AuditLogRepository auditLogRepository, AccountTransactionRepository transactionRepository) {
        this.auditLogRepository = auditLogRepository;
        this.transactionRepository = transactionRepository;
    }


    @Override
    public Object LookUpAccount(AccountEnquiry accountEnquiry, NibssConfig env) throws Exception {
//        return null;

        NESingleRequest req = objectMapper.nibssNameEnquiryRe(accountEnquiry);
        return SingleAccountLookupHandler(req, accountEnquiry.getRequestId(), env);
    }

    private AccountEnquiryResponse SingleAccountLookupHandler(NESingleRequest req, String requestId, NibssConfig env) throws Exception {
        try{
        AuditLog auditLog = new AuditLog();
        auditLog.setAction("Name Enquiry");
        auditLog.setActionDesc("Beneficiary account number validation");
        auditLog.setRequestId(requestId);
        auditLog.setCreatedDate(DateTime());

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            headers.setBearerAuth(GetToken(env));
        } catch (Exception e){
            throw new Exception("Error generating token");
        }

        req.setTransactionId(util.GenerateSessionID(env.getClient_code()));
        req.setChannelCode("1");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String reqJson = ow.writeValueAsString(req);

        auditLog.setTransactionId(req.getTransactionId());
        auditLog.setRequestPayload(reqJson);

//            headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println(reqJson);
        HttpEntity<String> request =
                new HttpEntity<String>(reqJson, headers);
        System.out.println("====ep req====");
        System.out.println(request);

        System.out.println(request.getBody().toString());
        System.out.println(request.getHeaders().toString());

        System.out.println("Account Enquiry: "+ env.getBase_url() + "nameenquiry");


        ResponseEntity<String> res = restTemplate.postForEntity(env.getBase_url() + "nameenquiry", request, String.class);
//            ResponseEntity<NESingleResponse> res = restTemplate.postForEntity(env.getBase_url() + "nameenquiry", request, NESingleResponse.class);
//            ResponseEntity<NESingleResponse> res = restTemplate.postForEntity(env.getProperty("nibss.base_url") + "nameenquiry", request, NESingleResponse.class);

        System.out.println("Res length: "+String.valueOf(res.getBody().length()));
        auditLog.setResponsePayload(res.getBody());

        ObjectMapper mapper = new ObjectMapper();
        NESingleResponse objRes = mapper.readValue(res.getBody(), NESingleResponse.class);

        auditLog.setResponseCode(objRes.getResponseCode());
        auditLog.setSessionId(objRes.getSessionID());

        auditLogRepository.save(auditLog);

        return objectMapper.returnAccountEnquiryRes(objRes, requestId);
    } catch(HttpStatusCodeException e) {
            ObjectMapper mapper = new ObjectMapper();
    //            return ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
    //                    .body(e.getResponseBodyAsString());
            NibssErrorResponse nibssError = mapper.readValue(e.getResponseBodyAsString(), NibssErrorResponse.class);
            throw new Exception(HandleRequestErrror(e));
        } catch (Exception ex){
            System.out.println("errorrnorr");
            System.out.println(ex.getMessage());
    //            System.out.println(e.getCause());
            throw new Exception("Error");
        }
    }

    @Override
    public Object FundsTransferSingleDC(FundsTransferRequest creditFundsTransfer, NibssConfig env) throws Exception {
//        return null;
        try {

            if (transactionRepository.findByRequestId(creditFundsTransfer.getRequestId()) != null) throw new Exception("Duplicate transaction request Id");
            AuditLog auditLog = new AuditLog();
            auditLog.setAction("Funds Transfer");
            auditLog.setActionDesc("Funds transfer to beneficiary account");
            auditLog.setRequestId(creditFundsTransfer.getRequestId());
            auditLog.setCreatedDate(DateTime());

            AccountTransactionEntry transactionEntry = new AccountTransactionEntry();
            transactionEntry.setAccountBvn(creditFundsTransfer.getBeneficiaryBankVerificationNumber());
            transactionEntry.setAccountKyc(String.valueOf(creditFundsTransfer.getBeneficiaryKYCLevel()));
            transactionEntry.setAmount(creditFundsTransfer.getAmount());
            transactionEntry.setAccountNumber(creditFundsTransfer.getBeneficiaryAccountNumber());
            transactionEntry.setAccountName(creditFundsTransfer.getBeneficiaryAccountName());
            transactionEntry.setRequestId(creditFundsTransfer.getRequestId());


            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            try {
                headers.setBearerAuth(GetToken(env));
            } catch (Exception e){
                throw new Exception("Error generating token");
            }
//            NESingleRequest neReq = new NESingleRequest();
//            neReq.setAccountNumber(creditFundsTransfer.getBeneficiaryAccountNumber());
//            neReq.setDestinationInstitutionCode(creditFundsTransfer.getDestinationInstitutionCode());
//            AccountEnquiryResponse receiptAccount = SingleAccountLookupHandler(neReq, creditFundsTransfer.getRequestId(), env);


            FTSingleCreditRequest req = objectMapper.nibssFTReq(creditFundsTransfer);

//            req.setNameEnquiryRef(receiptAccount.getSessionID());
            req.setTransactionId(util.GenerateSessionID(env.getClient_code()));
            req.setChannelCode("1");
            req.setBillerId(env.getBiller_id());
            req.setSourceInstitutionCode(env.getInst_code());
            req.setOriginatorKYCLevel(env.getKyc());
            req.setOriginatorAccountName(env.getInst_account_name());
            req.setOriginatorAccountNumber(env.getInst_account());
            req.setMandateReferenceNumber(env.getAuth_code());
//            req.setPaymentReference("PAYSURE/"+ req.getTransactionId() +"/"+ req.getOriginatorAccountNumber() +"/"+ req.getBeneficiaryAccountNumber());
//            req.setPaymentReference("PAYSURE/"+ req.getTransactionId());
            req.setPaymentReference("PAYSURE/"+ creditFundsTransfer.getRequestId());


            transactionEntry.setMandateId(env.getAuth_code());
            transactionEntry.setTransactionId(req.getTransactionId());
            transactionEntry.setCreatedDate(DateTime());

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String reqJson = ow.writeValueAsString(req);

            headers.setContentType(MediaType.APPLICATION_JSON);
            System.out.println(reqJson);
            HttpEntity<String> request =
                    new HttpEntity<String>(reqJson, headers);
            System.out.println("====ep req====");
            System.out.println(request);

            double mandateBalance = CheckMandateAccountBalance(env);
            if (mandateBalance < req.getAmount()){
                throw new Exception("Cannot process transaction at the moment");
            }

            auditLog.setTransactionId(req.getTransactionId());
            auditLog.setRequestPayload(reqJson);


            System.out.println("Funds Transfer: "+ env.getBase_url() + "fundstransfer");

            System.out.println("***********Pre-req start*************");
//            ResponseEntity<FTSingleCreditResponse> res = restTemplate.postForEntity(env.getBase_url() + "fundstransfer", request, FTSingleCreditResponse.class);
            ResponseEntity<String> res = restTemplate.postForEntity(env.getBase_url() + "fundstransfer", request, String.class);
//            ResponseEntity<String> res = restTemplate.postForEntity(env.getBase_url() + "fundstransfer", request, String.class);

//            System.out.println("-----------Req start-----------");
//            System.out.println(res.toString());
//            System.out.println(res.getBody().toString());



            auditLog.setResponsePayload(res.getBody());

            ObjectMapper mapper = new ObjectMapper();
            FTSingleCreditResponse objRes = mapper.readValue(res.getBody(), FTSingleCreditResponse.class);


            auditLog.setResponseCode(objRes.getResponseCode());
            auditLog.setSessionId(objRes.getSessionID());


            transactionEntry.setStatus("PROCESSING");
            transactionEntry.setSessionId(objRes.getSessionID());
            transactionEntry.setBalanceAtTransfer(mandateBalance);
            if(objRes.getResponseCode().equals("00")){
                QueryTransactionStatus debitFundTransfer = new QueryTransactionStatus();
                debitFundTransfer.setTransactionId(objRes.getTransactionId());
                TSQuerySingleResponse tState = SingleTransactionStatusQueryHandler(debitFundTransfer, env);
                if(tState.getResponseCode().equals("00")){
                    transactionEntry.setStatus("SUCCESSFUL");
                }else {

                }
            }

            auditLogRepository.save(auditLog);
            transactionRepository.save(transactionEntry);

            return objectMapper.returnFundsTransferRes(objRes, creditFundsTransfer.getRequestId());
        } catch(HttpServerErrorException e) {
            e.printStackTrace();
            e.getCause();
            System.out.println(e.getRawStatusCode());
            System.out.println(e.getResponseHeaders());
//            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.getResponseBodyAsString());
            throw new Exception(e);
        } catch(HttpStatusCodeException e) {
            System.out.println(e.getMessage());
            throw new Exception(HandleRequestErrror(e));
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public Object FundsTransferSingleDCAlt(FundsTransferRequest creditFundsTransfer, NibssConfig env) throws Exception {
//        return null;
        try {

            if (transactionRepository.findByRequestId(creditFundsTransfer.getRequestId()) != null) throw new Exception("Duplicate transaction request Id");
            AuditLog auditLog = new AuditLog();
            auditLog.setAction("Funds Transfer");
            auditLog.setActionDesc("Funds transfer to beneficiary account");
            auditLog.setRequestId(creditFundsTransfer.getRequestId());
            auditLog.setCreatedDate(DateTime());

            AccountTransactionEntry transactionEntry = new AccountTransactionEntry();
            transactionEntry.setAccountBvn(creditFundsTransfer.getBeneficiaryBankVerificationNumber());
            transactionEntry.setAccountKyc(String.valueOf(creditFundsTransfer.getBeneficiaryKYCLevel()));
            transactionEntry.setAmount(creditFundsTransfer.getAmount());
            transactionEntry.setAccountNumber(creditFundsTransfer.getBeneficiaryAccountNumber());
            transactionEntry.setAccountName(creditFundsTransfer.getBeneficiaryAccountName());
            transactionEntry.setRequestId(creditFundsTransfer.getRequestId());


            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            try {
                headers.setBearerAuth(GetToken(env));
            } catch (Exception e){
                throw new Exception("Error generating token");
            }
//            NESingleRequest neReq = new NESingleRequest();
//            neReq.setAccountNumber(creditFundsTransfer.getBeneficiaryAccountNumber());
//            neReq.setDestinationInstitutionCode(creditFundsTransfer.getDestinationInstitutionCode());
//            AccountEnquiryResponse receiptAccount = SingleAccountLookupHandler(neReq, creditFundsTransfer.getRequestId(), env);


            FTSingleCreditRequest req = objectMapper.nibssFTReq(creditFundsTransfer);

//            req.setNameEnquiryRef(creditFundsTransfer.getNameEnquiryRef());
            req.setTransactionId(util.GenerateSessionID(env.getClient_code()));
            req.setChannelCode("1");
            req.setBillerId(env.getBiller_id());
            req.setSourceInstitutionCode(env.getInst_code());
            req.setOriginatorKYCLevel(env.getKyc());
            req.setOriginatorAccountName(env.getInst_account_name());
            req.setOriginatorAccountNumber(env.getInst_account());
            req.setMandateReferenceNumber(env.getAuth_code());
//            req.setPaymentReference("PAYSURE/"+ req.getTransactionId() +"/"+ req.getOriginatorAccountNumber() +"/"+ req.getBeneficiaryAccountNumber());
//            req.setPaymentReference("PAYSURE/"+ req.getTransactionId());
            req.setPaymentReference("PAYSURE/"+ creditFundsTransfer.getRequestId());


            transactionEntry.setMandateId(env.getAuth_code());
            transactionEntry.setTransactionId(req.getTransactionId());
            transactionEntry.setCreatedDate(DateTime());

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String reqJson = ow.writeValueAsString(req);

            headers.setContentType(MediaType.APPLICATION_JSON);
            System.out.println(reqJson);
            HttpEntity<String> request =
                    new HttpEntity<String>(reqJson, headers);
            System.out.println("====ep req====");
            System.out.println(request);
//
//            double mandateBalance = CheckMandateAccountBalance(env);
//            if (mandateBalance < req.getAmount()){
//                throw new Exception("Cannot process transaction at the moment");
//            }

            auditLog.setTransactionId(req.getTransactionId());
            auditLog.setRequestPayload(reqJson);


            System.out.println("Funds Transfer: "+ env.getBase_url() + "fundstransfer");

            System.out.println("***********Pre-req start*************");
//            ResponseEntity<FTSingleCreditResponse> res = restTemplate.postForEntity(env.getBase_url() + "fundstransfer", request, FTSingleCreditResponse.class);
            ResponseEntity<String> res = restTemplate.postForEntity(env.getBase_url() + "fundstransfer", request, String.class);
//            ResponseEntity<String> res = restTemplate.postForEntity(env.getBase_url() + "fundstransfer", request, String.class);

//            System.out.println("-----------Req start-----------");
//            System.out.println(res.toString());
//            System.out.println(res.getBody().toString());



            auditLog.setResponsePayload(res.getBody());

            ObjectMapper mapper = new ObjectMapper();
            FTSingleCreditResponse objRes = mapper.readValue(res.getBody(), FTSingleCreditResponse.class);


            auditLog.setResponseCode(objRes.getResponseCode());
            auditLog.setSessionId(objRes.getSessionID());


            transactionEntry.setStatus("PROCESSING");
            transactionEntry.setSessionId(objRes.getSessionID());
            transactionEntry.setBalanceAtTransfer(0);
            if(objRes.getResponseCode().equals("00")){
                QueryTransactionStatus debitFundTransfer = new QueryTransactionStatus();
                debitFundTransfer.setTransactionId(objRes.getTransactionId());
                TSQuerySingleResponse tState = SingleTransactionStatusQueryHandler(debitFundTransfer, env);
                if(tState.getResponseCode().equals("00")){
                    transactionEntry.setStatus("SUCCESSFUL");
                }else {

                }
            }

            auditLogRepository.save(auditLog);
            transactionRepository.save(transactionEntry);

            return objectMapper.returnFundsTransferRes(objRes, creditFundsTransfer.getRequestId());
        } catch(HttpServerErrorException e) {
            e.printStackTrace();
            e.getCause();
            System.out.println(e.getRawStatusCode());
            System.out.println(e.getResponseHeaders());
//            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.getResponseBodyAsString());
            throw new Exception(e);
        } catch(HttpStatusCodeException e) {
            System.out.println(e.getMessage());
//            throw new Exception(HandleRequestErrror(e));
            throw new Exception(e.getResponseBodyAsString());
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    private double CheckMandateAccountBalance(NibssConfig env) throws Exception {
        BalanceEnquiryRequest balanceEnquiry = new BalanceEnquiryRequest();
        balanceEnquiry.setTargetAccountName(env.getInst_account_name());
        balanceEnquiry.setTargetAccountNumber(env.getInst_account());
        balanceEnquiry.setTargetBankVerificationNumber(env.getBvn());
        balanceEnquiry.setDestinationInstitutionCode(env.getInst_code());

        AccountBalanceEnquiryResponse balRes = BalanceEnquirySingleRequestHandler(balanceEnquiry, "sjjjsjjjs", env);
        return balRes.getAvailableBalance();
    }

    @Override
    public FTSingleDebitResponse FundsTransferSingleDD(DebitFundsTransfer debitFundsTransfer) {
        return null;
    }

    @Override
    public Object TransactionQS(QueryTransactionStatus debitFundTransfer, NibssConfig env) throws Exception {
        return SingleTransactionStatusQueryHandler(debitFundTransfer, env);
    }

    private TSQuerySingleResponse SingleTransactionStatusQueryHandler(QueryTransactionStatus debitFundTransfer, NibssConfig env) throws Exception {
        try {
            AuditLog auditLog = new AuditLog();
            auditLog.setAction("Transaction Status");
            auditLog.setActionDesc("Get status of a successful funds transfer request");
            auditLog.setRequestId(debitFundTransfer.getRequestId());
            auditLog.setCreatedDate(DateTime());

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            try {
                headers.setBearerAuth(GetToken(env));
            } catch (Exception e){
                throw new Exception("Error generating token");
            }


            TSQuerySingleRequest req = new TSQuerySingleRequest();

            req.setTransactionId(debitFundTransfer.getTransactionId());
//            req.setChannelCode("1");
//            req.setBillerId(env.getBiller_id());
//            req.setAuthorizationCode(env.getAuth_code());

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String reqJson = ow.writeValueAsString(req);


            auditLog.setTransactionId(req.getTransactionId());
            auditLog.setRequestPayload(reqJson);

//            headers.setContentType(MediaType.APPLICATION_JSON);
            System.out.println(reqJson);
            HttpEntity<String> request =
                    new HttpEntity<String>(reqJson, headers);
            System.out.println("====ep req====");
            System.out.println(request);
            ResponseEntity<String > res = restTemplate.postForEntity(env.getBase_url() + "tsq", request, String.class);

            System.out.println(res.toString());
            System.out.println(res.getBody().toString());

            auditLog.setResponsePayload(res.getBody());

            ObjectMapper mapper = new ObjectMapper();
            TSQuerySingleResponse objRes = mapper.readValue(res.getBody(), TSQuerySingleResponse.class);

//            if (res.getStatusCode().is2xxSuccessful()) {
//            return objRes;
//            return objectMapper.returnBalanceEnquiryRes(res.getBody(), debitFundTransfer.getRequestId());

            auditLog.setResponseCode(objRes.getResponseCode());
            auditLog.setSessionId(objRes.getSessionID());

            auditLogRepository.save(auditLog);

//            return res.getBody();
            return objRes;
//            } else {
//                return res;
//            }
        } catch(HttpServerErrorException e) {
            e.printStackTrace();
            e.getCause();
            System.out.println(e.getRawStatusCode());
            System.out.println(e.getResponseHeaders());
//            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.getResponseBodyAsString());
            throw new Exception(e);
        } catch(HttpStatusCodeException e) {
            System.out.println(e.getResponseBodyAsString());
            throw new Exception(HandleRequestErrror(e));
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Object BalanceEnquiry(BalanceEnquiry balanceEnquiry, NibssConfig env) throws Exception {

        BalanceEnquiryRequest req = objectMapper.nibssBalanceEnquiryReq(balanceEnquiry);
        return BalanceEnquirySingleRequestHandler(req, balanceEnquiry.getRequestId(), env);
    }

    @Override
    public Object GenerateToken(NibssConfig env) throws Exception {
        return GetToken(env);
    }

    private AccountBalanceEnquiryResponse BalanceEnquirySingleRequestHandler(BalanceEnquiryRequest req, String reqId, NibssConfig env) throws Exception {
        try {
            AuditLog auditLog = new AuditLog();
            auditLog.setAction("Balance Enquiry");
            auditLog.setActionDesc("Get balance of funding account");
            auditLog.setRequestId(reqId);
            auditLog.setCreatedDate(DateTime());

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            try {
                headers.setBearerAuth(GetToken(env));
            } catch (Exception e){
                throw new Exception("Error generating token");
            }



            req.setTransactionId(util.GenerateSessionID(env.getClient_code()));
            req.setChannelCode("1");
            req.setBillerId(env.getBiller_id());
            req.setAuthorizationCode(env.getAuth_code());

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String reqJson = ow.writeValueAsString(req);

            auditLog.setTransactionId(req.getTransactionId());
            auditLog.setRequestPayload(reqJson);

            System.out.println(reqJson);
//            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request =
                    new HttpEntity<String>(reqJson, headers);
            System.out.println("====ep req====");
            System.out.println(request);

            System.out.println("Balance Enquiry: "+ env.getBase_url() + "balanceenquiry");
            ResponseEntity<String > res = restTemplate.postForEntity(env.getBase_url() + "balanceenquiry", request, String.class);

            System.out.println(res.toString());
            System.out.println(res.getBody().toString());

            auditLog.setResponsePayload(res.getBody());

            ObjectMapper mapper = new ObjectMapper();
            BalanceEnquiryResponse objRes = mapper.readValue(res.getBody(), BalanceEnquiryResponse.class);


            auditLog.setResponseCode(objRes.getResponseCode());
            auditLog.setSessionId(objRes.getSessionID());

//            auditLogRepository.save(auditLog);

//            if (res.getStatusCode().is2xxSuccessful()) {
            return objectMapper.returnBalanceEnquiryRes(objRes, reqId);
//            return res.getBody();
//            } else {
//                return res;
//            }
        } catch(HttpStatusCodeException e) {
            throw new Exception(HandleRequestErrror(e));
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Error");//
        }
    }

    @Override
    public FTAdviceCreditResponse FundsTransferSingleDCAdvice(CreditFundsTransferAdvice creditFundsTransferAdvice) {
        return null;
    }

    @Override
    public FTAdviceDebitResponse FundsTransferSingleDDAdvice(DebitFundsTransferAdvice debitFundsTransferAdvice) {
        return null;
    }

    @Override
    public AmountBlockResponse AmountControl(AmountControl amountControl) {
        return null;
    }

    @Override
    public AccountBlockResponse AccountControl(AccountControl accountControl) {
        return null;
    }

    @Override
    public Object FundsTransFerNotification(FTAckCredit ackCredit) {
        return null;
    }

    @Override
    public AccountBlockResponse DebitMandate(DebitAccount debitAccount) {
        return null;
    }

    @Override
    public String  SessionLookUpAccount() {
//        return util.GenerateSessionID(env.getClient_code());
        return null;
    }

    @Override
    public AccountEnquiryResponse OrikaLookUpAccount(AccountEnquiry accountEnquiry) {


        AccountEnquiryResponse ns =  neSingleMapper.map(accountEnquiry, AccountEnquiryResponse.class);

//        System.out.println(ns.toString());
//        NESingleResponse ns;
//        ns = objectMapper.testSuccessNeResponseAlt(accountEnquiry);
        System.out.println(ns.toString());
        ns.setAccountName("Abel Babel Caleb");
        ns.setSessionID("1212456300214577893112555225522");
        ns.setBankVerificationNumber("10102030254");
        ns.setKycLevel(2);
        ns.setResponseCode("00");

        return ns;
    }
    public String GetToken(NibssConfig env) throws Exception {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);




            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("grant_type", env.getGrant_type());
            formData.add("client_secret", env.getClient_secret());
            formData.add("client_id", env.getClient_id());
            formData.add("scope", env.getScope());

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(formData, headers);

            System.out.println(request);

            ResponseEntity<AuthToken> res = restTemplate.postForEntity(env.getToken_url(), request, AuthToken.class);
//            ResponseEntity<AuthToken> res = restTemplate.postForEntity(env.getProperty("nibss.token_url"), request, AuthToken.class);

//            System.out.println(res.toString());
//            System.out.println(res.getBody().toString());


            return res.getBody().getAccess_token();
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception("Error generating token");
        }
    }

    private String HandleRequestErrror(HttpStatusCodeException e) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
//                    .body(e.getResponseBodyAsString());
        System.out.println(e.getResponseHeaders());
        System.out.println(e.getResponseBodyAsString());
        NibssErrorResponse nibssError = mapper.readValue(e.getResponseBodyAsString(), NibssErrorResponse.class);
        return nibssError.getMessage();
    }

    private String HandleServerErrror(HttpServerErrorException e) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
//                    .body(e.getResponseBodyAsString());
        FTSingleCreditResponse nibssError = mapper.readValue(e.getResponseBodyAsString(), FTSingleCreditResponse.class);
        return nibssError.getResponseCode();
    }


    private static Timestamp DateTime(){

        Calendar calendar = Calendar.getInstance();
        java.util.Date currentTime = calendar.getTime();
        long time = currentTime.getTime();

        return new Timestamp(time);
    }
}
