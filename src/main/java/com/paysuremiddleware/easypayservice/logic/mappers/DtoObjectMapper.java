package com.paysuremiddleware.easypayservice.logic.mappers;

import com.paysuremiddleware.easypayservice.logic.dto.requests.AccountEnquiry;
import com.paysuremiddleware.easypayservice.logic.dto.requests.BalanceEnquiry;
import com.paysuremiddleware.easypayservice.logic.dto.requests.CreditFundsTransfer;
import com.paysuremiddleware.easypayservice.logic.dto.requests.FundsTransferRequest;
import com.paysuremiddleware.easypayservice.logic.dto.requests.nibss.BalanceEnquiryRequest;
import com.paysuremiddleware.easypayservice.logic.dto.requests.nibss.FTSingleCreditRequest;
import com.paysuremiddleware.easypayservice.logic.dto.requests.nibss.NESingleRequest;
import com.paysuremiddleware.easypayservice.logic.dto.responses.AccountBalanceEnquiryResponse;
//import com.paysuremiddleware.easypayservice.logic.dto.responses.BalanceEnquiryResponse;
import com.paysuremiddleware.easypayservice.logic.dto.responses.nibss.BalanceEnquiryResponse;
//import com.paysuremiddleware.easypayservice.logic.dto.responses.FTSingleCreditResponse;
import com.paysuremiddleware.easypayservice.logic.dto.responses.nibss.FTSingleCreditResponse;
import com.paysuremiddleware.easypayservice.logic.dto.responses.AccountEnquiryResponse;
import com.paysuremiddleware.easypayservice.logic.dto.responses.FundsTransferResponse;
import com.paysuremiddleware.easypayservice.logic.dto.responses.nibss.NESingleResponse;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

@Component
public class DtoObjectMapper {

//    public Object GenericMapper(){
//        return new DefaultMapperFactory.Builder()
//            .mapNulls(false).build();
//    }
    public AccountEnquiryResponse testSuccessNeResponseAlt(AccountEnquiry source) {
        System.out.println("Spring boot mapper initializing.....");
        MapperFactory factory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade<AccountEnquiry, AccountEnquiryResponse> boundMapper = factory.getMapperFacade(AccountEnquiry.class, AccountEnquiryResponse.class);

        return boundMapper.map(source);
    }

    public AccountEnquiryResponse testSuccessNeResponse(AccountEnquiry source) {
        MapperFactory factory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade boundMapper = factory.getMapperFacade(AccountEnquiry.class, AccountEnquiryResponse.class);

        AccountEnquiryResponse destination = new AccountEnquiryResponse();

        factory.classMap(AccountEnquiry.class, AccountEnquiryResponse.class)
                .mapNulls(false)
                .mapNullsInReverse(false)
                .byDefault()
                .register();
//        destination.setCreatedDate(new Date());

        MapperFacade mapper = factory.getMapperFacade();
        destination = mapper.map(source, AccountEnquiryResponse.class);

        return destination;
    }

    public FTSingleCreditResponse testSuccessFTCResponse(CreditFundsTransfer source) {
        MapperFactory factory = new DefaultMapperFactory.Builder().build();

        FTSingleCreditResponse destination = new FTSingleCreditResponse();

        factory.classMap(CreditFundsTransfer.class, FTSingleCreditResponse.class)
                .mapNulls(false)
                .mapNullsInReverse(false)
                .byDefault()
                .register();
//        destination.setCreatedDate(new Date());

        MapperFacade mapper = factory.getMapperFacade();
        destination = mapper.map(source, FTSingleCreditResponse.class);

        return destination;
    }

    public BalanceEnquiryResponse testSuccessBalEnqCResponse(BalanceEnquiry source) {
        MapperFactory factory = new DefaultMapperFactory.Builder().build();

        BalanceEnquiryResponse destination = new BalanceEnquiryResponse();

        factory.classMap(BalanceEnquiry.class, BalanceEnquiryResponse.class)
                .mapNulls(false)
                .mapNullsInReverse(false)
                .byDefault()
                .register();
//        destination.setCreatedDate(new Date());

        MapperFacade mapper = factory.getMapperFacade();
        destination = mapper.map(source, BalanceEnquiryResponse.class);

        return destination;
    }


    public NESingleRequest nibssNameEnquiryRe(AccountEnquiry accountEnquiry) {
        MapperFactory factory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade boundMapper = factory.getMapperFacade(AccountEnquiry.class, NESingleRequest.class);

        NESingleRequest destination = new NESingleRequest();

        factory.classMap(AccountEnquiry.class, NESingleRequest.class)
                .mapNulls(false)
                .mapNullsInReverse(false)
                .byDefault()
                .register();
//        destination.setCreatedDate(new Date());

        MapperFacade mapper = factory.getMapperFacade();
        destination = mapper.map(accountEnquiry, NESingleRequest.class);

        return destination;
    }
    public AccountEnquiryResponse returnAccountEnquiryRes(NESingleResponse neSingleResponse, String requestId) {
        MapperFactory factory = new DefaultMapperFactory.Builder().build();
        BoundMapperFacade boundMapper = factory.getMapperFacade(NESingleResponse.class, AccountEnquiryResponse.class);

        AccountEnquiryResponse destination = new AccountEnquiryResponse();

        factory.classMap(NESingleResponse.class, NESingleRequest.class)
                .mapNulls(false)
                .mapNullsInReverse(false)
                .byDefault()
                .register();
//        destination.setCreatedDate(new Date());
        destination.setRequestId(requestId);

        MapperFacade mapper = factory.getMapperFacade();
        destination = mapper.map(neSingleResponse, AccountEnquiryResponse.class);

        return destination;
    }



    public FTSingleCreditRequest nibssFTReq(FundsTransferRequest source) {
        MapperFactory factory = new DefaultMapperFactory.Builder().build();

        FTSingleCreditRequest destination = new FTSingleCreditRequest();

        factory.classMap(FundsTransferRequest.class, FTSingleCreditRequest.class)
                .mapNulls(false)
                .mapNullsInReverse(false)
                .byDefault()
                .register();
//        destination.setCreatedDate(new Date());

        MapperFacade mapper = factory.getMapperFacade();
        destination = mapper.map(source, FTSingleCreditRequest.class);

        return destination;
    }

    public FundsTransferResponse returnFundsTransferRes(FTSingleCreditResponse body, String requestId) {
        MapperFactory factory = new DefaultMapperFactory.Builder().build();

        FundsTransferResponse destination = new FundsTransferResponse();

        factory.classMap(FTSingleCreditResponse.class, FundsTransferResponse.class)
                .mapNulls(false)
                .mapNullsInReverse(false)
                .byDefault()
                .register();
//        destination.setCreatedDate(new Date());
        destination.setRequestId(requestId);

        MapperFacade mapper = factory.getMapperFacade();
        destination = mapper.map(body, FundsTransferResponse.class);

        return destination;
    }

    public BalanceEnquiryRequest nibssBalanceEnquiryReq(BalanceEnquiry balanceEnquiry) {
        MapperFactory factory = new DefaultMapperFactory.Builder().build();

        BalanceEnquiryRequest destination = new BalanceEnquiryRequest();

        factory.classMap(BalanceEnquiry.class, BalanceEnquiryRequest.class)
                .mapNulls(false)
                .mapNullsInReverse(false)
                .byDefault()
                .register();
//        destination.setCreatedDate(new Date());

        MapperFacade mapper = factory.getMapperFacade();
        destination = mapper.map(balanceEnquiry, BalanceEnquiryRequest.class);

        return destination;
    }

    public AccountBalanceEnquiryResponse returnBalanceEnquiryRes(BalanceEnquiryResponse body, String requestId) {
        MapperFactory factory = new DefaultMapperFactory.Builder().build();

        AccountBalanceEnquiryResponse destination = new AccountBalanceEnquiryResponse();

        factory.classMap(BalanceEnquiryResponse.class, AccountBalanceEnquiryResponse.class)
                .mapNulls(false)
                .mapNullsInReverse(false)
                .byDefault()
                .register();
//        destination.setCreatedDate(new Date());
        destination.setRequestId(requestId);

        MapperFacade mapper = factory.getMapperFacade();
        destination = mapper.map(body, AccountBalanceEnquiryResponse.class);

        return destination;
    }
}
