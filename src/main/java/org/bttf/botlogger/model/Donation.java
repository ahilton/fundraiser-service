package org.bttf.botlogger.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Donation {
    private String name;
    private String amount;
    private String message;
    private String donationId;
    private String time;
}
