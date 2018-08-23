package org.bttf.botlogger.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FundraisingState {

    private List<Donation> donations;

    private int currentDonationTotal;

    private int fundraisingTarget;

    private int takings;
}
