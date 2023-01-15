package com.paysuremiddleware.easypayservice.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysuremiddleware.easypayservice.logic.dto.CustomResponse;
import com.paysuremiddleware.easypayservice.logic.dto.NibssConfig;
import com.paysuremiddleware.easypayservice.logic.dto.requests.*;
import com.paysuremiddleware.easypayservice.logic.dto.responses.nibss.NibssServerErrorResponse;
import com.paysuremiddleware.easypayservice.logic.services.EasypayService;
import com.paysuremiddleware.easypayservice.logic.services.impl.EasypayServiceImpl;
import com.paysuremiddleware.easypayservice.repository.AccountTransactionRepository;
import com.paysuremiddleware.easypayservice.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

@RestController
@RequestMapping("/api/paysuremiddleware/easypay")
public class EasypayController {

//    @Autowired
//    private Environment env;

    @Autowired
    private NibssConfig nibssConfigParam;

    @Autowired
    private AccountTransactionRepository transactionRepository;

    @Autowired
    private AuditLogRepository auditLogRepository;

//    @Resource
    EasypayService easypayService = null;



//    @PostMapping(value = "/orika-test")
//    public ResponseEntity<CustomResponse> OrikaTest(@RequestBody AccountEnquiry accountEnquiry) {
//        easypayService = new EasypayServiceImpl();
////            return nipService.LookUpAccount(accountEnquiry);
//
//        CustomResponse crs = new CustomResponse();
//        AccountEnquiryResponse response = easypayService.OrikaLookUpAccount(accountEnquiry);
//
//        crs.setStatus(200);
//        crs.setData(response);
//        return new ResponseEntity<>(crs, HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/session-test")
//    public ResponseEntity<CustomResponse> OrikaTest() {
//        easypayService = new EasypayServiceImpl();
////            return nipService.LookUpAccount(accountEnquiry);
//
//        CustomResponse crs = new CustomResponse();
////        NESingleResponse response = nipService.SessionLookUpAccount();
//
//        crs.setStatus(200);
//        crs.setData(easypayService.SessionLookUpAccount());
//        return new ResponseEntity<>(crs, HttpStatus.OK);
//    }

    @GetMapping(value = "/token-test")
    public ResponseEntity<CustomResponse> TokenTest() throws Exception {
        easypayService = new EasypayServiceImpl(null, null);
//            return nipService.LookUpAccount(accountEnquiry);

        CustomResponse crs = new CustomResponse();
//        NESingleResponse response = nipService.SessionLookUpAccount();

        crs.setStatus(200);
        crs.setData(easypayService.GenerateToken(nibssConfigParam));
        return new ResponseEntity<>(crs, HttpStatus.OK);
    }

    @PostMapping(value = "/accountlookup")
    public ResponseEntity<CustomResponse> AccountLookUp(@RequestBody AccountEnquiry accountEnquiry) {
        CustomResponse crs = new CustomResponse();
        try{
            easypayService = new EasypayServiceImpl(auditLogRepository, null);
//            return nipService.LookUpAccount(accountEnquiry);

            Object response = easypayService.LookUpAccount(accountEnquiry, nibssConfigParam);

            crs.setStatus(200);
            crs.setData(response);
            return new ResponseEntity<>(crs, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println("Errr" + e.getMessage());
            e.printStackTrace();
            crs.setStatus(400);
            crs.setMessage("Bad Request");
            crs.setData(e.getMessage());
            return new ResponseEntity<>(crs, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/fundtransfer/directcredit")//
    public ResponseEntity<CustomResponse>  FundTransferDC(@RequestBody FundsTransferRequest creditFundsTransfer) throws JsonProcessingException {
        CustomResponse crs = new CustomResponse();
        try{
            easypayService = new EasypayServiceImpl(auditLogRepository, transactionRepository);
//            return nipService.FundsTransferSingleDC(creditFundsTransfer);

            Object response = easypayService.FundsTransferSingleDC(creditFundsTransfer, nibssConfigParam);

            crs.setStatus(200);
            crs.setData(response);
            return new ResponseEntity<>(crs, HttpStatus.OK);

//        } catch (ServerErrorException e){
        } catch (HttpServerErrorException e){
            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
//                    .body(e.getResponseBodyAsString());
//            NibssServerErrorResponse nibssError = mapper.readValue(HandleServerErrror(e), NibssServerErrorResponse.class);
            System.out.println("Errr" + e.getMessage());
            e.printStackTrace();
            crs.setStatus(400);
            crs.setMessage("Bad Request");
            crs.setData(e.getMessage());
            crs.setData(HandleServerErrror(e));
            return new ResponseEntity<>(crs, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println("Errr" + e.getMessage());
            e.printStackTrace();
            crs.setStatus(400);
            crs.setMessage("Bad Request");
            crs.setData(e.getMessage());
            return new ResponseEntity<>(crs, HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping(value = "/fundtransfer/directcreditbypass")//
    public ResponseEntity<CustomResponse>  FundTransferDCAlt(@RequestBody FundsTransferRequest creditFundsTransfer) throws JsonProcessingException {
        CustomResponse crs = new CustomResponse();
        try{
            easypayService = new EasypayServiceImpl(auditLogRepository, transactionRepository);
//            return nipService.FundsTransferSingleDC(creditFundsTransfer);

            Object response = easypayService.FundsTransferSingleDCAlt(creditFundsTransfer, nibssConfigParam);

            crs.setStatus(200);
            crs.setData(response);
            return new ResponseEntity<>(crs, HttpStatus.OK);

//        } catch (ServerErrorException e){
        } catch (HttpServerErrorException e){
            ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
//                    .body(e.getResponseBodyAsString());
//            NibssServerErrorResponse nibssError = mapper.readValue(HandleServerErrror(e), NibssServerErrorResponse.class);
            System.out.println("Errr" + e.getMessage());
            e.printStackTrace();
            crs.setStatus(400);
            crs.setMessage("Bad Request");
            crs.setData(e.getMessage());
            crs.setData(HandleServerErrror(e));
            return new ResponseEntity<>(crs, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println("Errr" + e.getMessage());
            e.printStackTrace();
            crs.setStatus(400);
            crs.setMessage("Bad Request");
            crs.setData(e.getMessage());
            return new ResponseEntity<>(crs, HttpStatus.BAD_REQUEST);
        }
    }

//    @PostMapping(value = "/fundtransfer/directdebit")
//    public FTSingleDebitResponse FundTransferDD(@RequestBody DebitFundsTransfer debitFundsTransfer) {
//        easypayService = new EasypayServiceImpl();
//        return easypayService.FundsTransferSingleDD(debitFundsTransfer);
//    }

    @PostMapping(value = "/transactionstatusquery")
    public Object TransactionQuery(@RequestBody QueryTransactionStatus queryTransactionStatus) {
        CustomResponse crs = new CustomResponse();
        try {
            easypayService = new EasypayServiceImpl(auditLogRepository, transactionRepository);

            Object response = easypayService.TransactionQS(queryTransactionStatus, nibssConfigParam);

            crs.setStatus(200);
            crs.setData(response);
            return new ResponseEntity<>(crs, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Errr" + e.getMessage());
            e.printStackTrace();
            crs.setStatus(400);
            crs.setMessage("Bad Request");
            crs.setData(e.getMessage());
            return new ResponseEntity<>(crs, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/balanceenquiry")
    public ResponseEntity<CustomResponse> AccountBalance(@RequestBody BalanceEnquiry balanceEnquiry) {
//        easypayService = new EasypayServiceImpl();
//        return nipService.BalanceEnquiry(balanceEnquiry);

        CustomResponse crs = new CustomResponse();
        try{
            easypayService = new EasypayServiceImpl(null, null);
//            return nipService.FundsTransferSingleDC(creditFundsTransfer);

            Object response = easypayService.BalanceEnquiry(balanceEnquiry, nibssConfigParam);;

            crs.setStatus(200);
            crs.setData(response);
            return new ResponseEntity<>(crs, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println("Errr" + e.getMessage());
            e.printStackTrace();
            crs.setStatus(400);
            crs.setMessage("Bad Request");
            crs.setData(e.getMessage());
            return new ResponseEntity<>(crs, HttpStatus.BAD_REQUEST);
        }
    }

//
//    @PostMapping(value = "/fundtransfer-advice/directcredit")
//    public FTAdviceCreditResponse FundTransferDCAdvice(@RequestBody CreditFundsTransferAdvice creditFundsTransferAdvice) {
//        nipService = new NipServiceImpl();
//        return nipService.FundsTransferSingleDCAdvice(creditFundsTransferAdvice);
//    }
//
//    @PostMapping(value = "/fundtransfer-advice/directdebit")
//    public FTAdviceDebitResponse FundTransferDDAdvice(@RequestBody DebitFundsTransferAdvice debitFundsTransferAdvice) {
//        nipService = new NipServiceImpl();
//        return nipService.FundsTransferSingleDDAdvice(debitFundsTransferAdvice);
//    }
//
//    @PostMapping(value = "/amount-permission")
//    public AmountBlockResponse AmountPermission(@RequestBody AmountControl amountControl) {
//        nipService = new NipServiceImpl();
//        return nipService.AmountControl(amountControl);
//    }
//
//    @PostMapping(value = "/account-permission")
//    public AccountBlockResponse AccountPermission(@RequestBody AccountControl accountControl) {
//        nipService = new NipServiceImpl();
//        return nipService.AccountControl(accountControl);
//    }
//
//    @PostMapping(value = "/mandateadvice")
//    public AccountBlockResponse MandateAdvice(@RequestBody DebitAccount debitAccount) {
//        nipService = new NipServiceImpl();
//        return nipService.DebitMandate(debitAccount);
//    }
//
////    @PostMapping(value = "/institutions")
////    public AccountBlockResponse MandateAdvice(@RequestBody FinancialInstitutionListRequest financialInstitutionListRequest) {
////        nipService = new NipServiceImpl();
////        return nipService.FinancialInstitutionsList(financialInstitutionListRequest);
////    }

//    //Transaction Response Acknowledgement Callback
//    @PostMapping(value = "/fundstransfer-callback")
//    public Object MandateAdvice(@RequestBody FTAckCredit ackCredit) {
//        easypayService = new EasypayServiceImpl();
//        return easypayService.FundsTransFerNotification(ackCredit);
//    }


    private Object HandleServerErrror(HttpServerErrorException e) throws JsonProcessingException {
        e.printStackTrace();
        System.out.println(e.getMessage());
        System.out.println(e.getResponseBodyAsString());
        ObjectMapper mapper = new ObjectMapper();
//            return ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
//                    .body(e.getResponseBodyAsString());
        NibssServerErrorResponse nibssError = mapper.readValue(e.getResponseBodyAsString(), NibssServerErrorResponse.class);
        return nibssError;
    }

}
