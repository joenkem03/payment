package com.paysuremiddleware.easypayservice.logic.services;

import com.paysuremiddleware.easypayservice.logic.dto.NibssConfig;
import com.paysuremiddleware.easypayservice.logic.dto.requests.*;
import com.paysuremiddleware.easypayservice.logic.dto.responses.*;
import org.springframework.stereotype.Service;


@Service
public interface EasypayService {
    Object LookUpAccount(AccountEnquiry accountEnquiry, NibssConfig env) throws Exception;

    Object FundsTransferSingleDC(FundsTransferRequest creditFundsTransfer, NibssConfig env) throws Exception;
    Object FundsTransferSingleDCAlt(FundsTransferRequest creditFundsTransfer, NibssConfig env) throws Exception;

    FTSingleDebitResponse FundsTransferSingleDD(DebitFundsTransfer debitFundsTransfer);

    Object TransactionQS(QueryTransactionStatus debitFundTransfer, NibssConfig env) throws Exception;

    Object BalanceEnquiry(BalanceEnquiry balanceEnquiry, NibssConfig env) throws Exception;

    Object GenerateToken(NibssConfig env) throws Exception;

    FTAdviceCreditResponse FundsTransferSingleDCAdvice(CreditFundsTransferAdvice creditFundsTransferAdvice);

    FTAdviceDebitResponse FundsTransferSingleDDAdvice(DebitFundsTransferAdvice debitFundsTransferAdvice);

    AmountBlockResponse AmountControl(AmountControl amountControl);

    AccountBlockResponse AccountControl(AccountControl accountControl);

    Object FundsTransFerNotification(FTAckCredit ackCredit);

    AccountBlockResponse DebitMandate(DebitAccount debitAccount);

    String SessionLookUpAccount();

    AccountEnquiryResponse OrikaLookUpAccount(AccountEnquiry accountEnquiry);
}
