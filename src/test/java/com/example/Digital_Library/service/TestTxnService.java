package com.example.Digital_Library.service;

import com.example.Digital_Library.dto.TxnRequest;
import com.example.Digital_Library.exception.TxnException;
import com.example.Digital_Library.model.Book;
import com.example.Digital_Library.model.Txn;
import com.example.Digital_Library.model.User;
import com.example.Digital_Library.repository.TxnRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TestTxnService {
    @InjectMocks
    private TxnService txnService;

    @Mock
    private UserService userService;

    @Mock
    private BookService bookService;

    @Mock
    private TxnRepository txnRepository;

    @Before
    public void setUp(){
//        txnService = new TxnService();
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(txnService, "validDays", "12");
        ReflectionTestUtils.setField(txnService, "finePerDay", "2");
    }

//    @Test
//    public void testCalculateFine() throws ParseException {
//        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2025-08-01");
//        Txn txn = Txn.builder().createOn(date).build();
//        int calculatedAmount = txnService.calculateFine(txn, 100);
//        Assert.assertEquals(78, calculatedAmount);
//    }

    @Test(expected = TxnException.class)
    public void testGetUserFromDB() throws TxnException {
        TxnRequest txnRequest = TxnRequest.builder().build();
        when(userService.getStudentByPhoneNo(any())).thenReturn(null);
        txnService.getUserFromDB(txnRequest);
    }

    @Test
    public void testGetUserFromDBWhenNoException() throws TxnException {
        TxnRequest txnRequest = TxnRequest.builder().build();
        User user = User.builder().id(1).build();
        when(userService.getStudentByPhoneNo(any())).thenReturn(user);
        User output = txnService.getUserFromDB(txnRequest);
        Assert.assertEquals(user.getId(),output.getId());
    }

    @Test
    public void testReturnBook() throws TxnException, ParseException {
        TxnRequest txnRequest = TxnRequest.builder().build();
        User user = User.builder().id(1).build();
        when(userService.getStudentByPhoneNo(any())).thenReturn(user);

        List<Book> list = new ArrayList<>();
        list.add(Book.builder().id(1).bookNo("1").user(user).securityAmount(100).build());
        when((bookService.filter(any(), any(), any()))).thenReturn((list));

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2025-08-24");
        Txn txn = Txn.builder().id(1).user(user).book(list.get(0)).createOn(date).build();
        when(txnRepository.findByUserPhoneNoAndBookBookNoAndTxnStatus(any(), any(), any())).thenReturn(txn);
        int fine = txnService.returnBook(txnRequest);

        Assert.assertEquals(100, fine);

    }

}