package com.techsharezone.bootifyeventsourcing.domain;

/*
 * @created 22/12/2020 -17:29
 * @project bootify-event-sourcing
 * @author  saurabhshcs
 */

import com.techsharezone.bootifyeventsourcing.Statuses;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Loan {

    private UUID uuid;
    private String name;
    private BigDecimal amount;
    private String status;

    public Loan(UUID uuid, String name, BigDecimal amount, String status) {
        this.uuid = uuid;
        this.name = name;
        this.amount = amount;
        this.status = Statuses.PENDING.name();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if(status.equalsIgnoreCase(Statuses.APPROVED.name())
                || status.equalsIgnoreCase(Statuses.DECLINED.name())
                || status.equalsIgnoreCase(Statuses.PENDING.name())
                || status.equalsIgnoreCase(Statuses.REJECTED.name())){

            this.status = status;
        }else{
            throw new IllegalArgumentException("Cannot set the LoanApplication's status to ");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return amount == loan.amount &&
                uuid.equals(loan.uuid) &&
                name.equals(loan.name) &&
                Objects.equals(status, loan.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, amount, status);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
