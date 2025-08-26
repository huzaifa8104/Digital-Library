package com.example.Digital_Library.repository;

import com.example.Digital_Library.model.Txn;
import com.example.Digital_Library.model.TxnStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TxnRepository extends JpaRepository<Txn, Integer> {
    Txn findByUserPhoneNoAndBookBookNoAndTxnStatus(String phoneNo, String bookNo, TxnStatus status);

//    @Transactional
//    @Modifying
//    @Query(value = "update txn set create_on = '2025-07-24 15:00:20.454000' , settlement_amount=0, txn_status=0 where id=1", nativeQuery = true)
//    void updateExistingTxn();

//    @Transactional
//    @Modifying
//    @Query(value = "update book set user_id = 2 where id=1", nativeQuery = true)
//    void updateBook();
}
