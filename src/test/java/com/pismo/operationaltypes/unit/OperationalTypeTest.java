package com.pismo.operationaltypes.unit;

import com.pismo.accounts.Account;
import com.pismo.accounts.AccountRepository;
import com.pismo.accounts.AccountService;
import com.pismo.operationaltypes.OperationalType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationalTypeTest {

    @Test
    public void shouldReturnPositiveValueForPayment() {
        //Given
        OperationalType operationalType = new OperationalType();
        operationalType.setId(4L);
        Double amount = 300D;

        //When
        Double calculatedAmout = operationalType.calculateAmount(amount);
        //Then
        assertEquals(calculatedAmout, amount);

    }

    @Test
    public void shouldReturnNegativeValueForWithdrawal() {
        //Given
        OperationalType operationalType = new OperationalType();
        operationalType.setId(3L);
        Double amount = 300D;

        //When
        Double calculatedAmout = operationalType.calculateAmount(amount);
        //Then
        assertEquals(calculatedAmout, amount * -1);

    }

    @Test
    public void shouldReturnNegativeValueForCashPurchase() {
        //Given
        OperationalType operationalType = new OperationalType();
        operationalType.setId(1L);
        Double amount = 300D;

        //When
        Double calculatedAmout = operationalType.calculateAmount(amount);
        //Then
        assertEquals(calculatedAmout, amount * -1);

    }

    @Test
    public void shouldReturnNegativeValueForInstallmentPurchase() {
        //Given
        OperationalType operationalType = new OperationalType();
        operationalType.setId(2L);
        Double amount = 300D;

        //When
        Double calculatedAmout = operationalType.calculateAmount(amount);
        //Then
        assertEquals(calculatedAmout, amount * -1);

    }
}
