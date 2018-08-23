package org.bttf.botlogger;

import lombok.extern.slf4j.Slf4j;
import org.bttf.botlogger.model.FundraisingState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path("/state")
@Slf4j
@CrossOrigin
public class FundController {

    @Autowired
    private FundCache fundCache;

    @GET
    @Produces(APPLICATION_JSON)
    @CrossOrigin
    public FundraisingState getFundRaisingState() {
        return FundraisingState.builder()
                .donations(fundCache.getDonations())
                .currentDonationTotal(fundCache.getCurrentDonationTotal())
                .takings(fundCache.getTakings())
                .fundraisingTarget(fundCache.getFundraisingTarget())
                .build();
    }

    @POST
    @Path("/takings")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @CrossOrigin
    public void updateTakings(@FormParam("takings")  int takings) {
        if (takings == 0){
            log.warn("Ignoring request to update takings to zero");
            return;
        }
        log.info("updating takings. old value {} -> new value {}", fundCache.getTakings(), takings);
        fundCache.updateTakings(takings);
    }

    @POST
    @Path("/target")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @CrossOrigin
    public void updateFundraisingTarget(@FormParam("target") int target) {
        if (target == 0){
            log.warn("Ignoring request to update target to zero");
            return;
        }
        log.info("updating target. old value {} -> new value {}", fundCache.getFundraisingTarget(), target);
        fundCache.updateFundraisingTarget(target);
    }

//    @POST
//    @Path("/update")
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
////    @Consumes(APPLICATION_JSON)
//    @CrossOrigin
//    public void updateTakings(@FormParam("takings") int takings,
//                              @FormParam("fundraisingTarget") int  fundraisingTarget) {
//        log.info("update state: {}", takings);
//    }

}
