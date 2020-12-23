package com.techsharezone.bootifyeventsourcing.component;

/*
 * @created 22/12/2020 -17:24
 * @project bootify-event-sourcing
 * @author  saurabhshcs
 */

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface LoanProcessor {

    String APPLICATION_IN = "output";
    String APPROVED_OUT = "approved";
    String DECLINED_OUT= "declined";

    @Input(APPLICATION_IN)
    SubscribableChannel sourceLoanApplication();

    @Output(APPROVED_OUT)
    MessageChannel approved();

    @Output(DECLINED_OUT)
    MessageChannel declined();
}
