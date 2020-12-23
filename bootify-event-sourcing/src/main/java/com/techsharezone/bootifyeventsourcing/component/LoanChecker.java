package com.techsharezone.bootifyeventsourcing.component;

/*
 * @created 22/12/2020 -17:49
 * @project bootify-event-sourcing
 * @author  saurabhshcs
 */


import ch.qos.logback.core.status.StatusUtil;
import com.techsharezone.bootifyeventsourcing.Statuses;
import com.techsharezone.bootifyeventsourcing.domain.Loan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LoanChecker {

    private static final Logger LOG = LoggerFactory.getLogger(LoanChecker.class);

    private static final BigDecimal MAX_THRESHOLD_AMOUNT = BigDecimal.valueOf(10000L);
    private LoanProcessor loanProcessor;

    @Autowired
    public LoanChecker(LoanProcessor loanProcessor) {
        this.loanProcessor = loanProcessor;
    }

    @StreamListener(LoanProcessor.APPLICATION_IN)
    public void checkAndSortLoan(final Loan loan) {
        LOG.info("{} {} for ${} for {}", loan.getStatus(), loan.getUuid(), loan.getAmount(), loan.getName());

        if (loan.getAmount().compareTo(MAX_THRESHOLD_AMOUNT) == 1) {
            loan.setStatus(Statuses.DECLINED.name());
            loanProcessor.declined().send(message(loan));
        }else{
            loan.setStatus(Statuses.APPROVED.name());
            loanProcessor.approved().send(message(loan));
        }
        LOG.info("{} {} for ${} for {}", loan.getStatus(), loan.getUuid(), loan.getAmount(), loan.getName());

    }
    private static final <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val).build();
    }
}
