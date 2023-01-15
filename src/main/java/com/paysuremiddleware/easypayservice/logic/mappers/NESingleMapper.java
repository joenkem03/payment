package com.paysuremiddleware.easypayservice.logic.mappers;

import com.paysuremiddleware.easypayservice.logic.dto.requests.AccountEnquiry;
import com.paysuremiddleware.easypayservice.logic.dto.responses.AccountEnquiryResponse;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class NESingleMapper extends ConfigurableMapper{

    public void configure(MapperFactory factory) {

        System.out.println("Spring boot mapper initializing.....");
        factory.classMap(AccountEnquiry.class, AccountEnquiryResponse.class)
//                .mapNulls(false)
//                .mapNullsInReverse(false)
                .byDefault()
                .register();
    }
}
