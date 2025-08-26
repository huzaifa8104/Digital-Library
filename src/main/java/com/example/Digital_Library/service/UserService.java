package com.example.Digital_Library.service;

import com.example.Digital_Library.dto.UserRequest;
import com.example.Digital_Library.model.Operator;
import com.example.Digital_Library.model.User;
import com.example.Digital_Library.model.UserFilterType;
import com.example.Digital_Library.model.UserType;
import com.example.Digital_Library.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.constraints.NotBlank;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private static final Log logger = LogFactory.getLog(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager em;

    public User addStudent(UserRequest userRequest) {
        User user = userRequest.toUser();
        user.setUserType(UserType.STUDENT);
        return userRepository.save(user);
    }

    public List<User> filter(String filterBy, String operator, String value) {
        String[] filters = filterBy.split(",");
        String[] operators = operator.split(",");
        String[] values = value.split(",");
        StringBuilder query = new StringBuilder();
        query.append("select * from user where ");


        for(int i = 0 ; i< operators.length; i++){
            UserFilterType userFilterType = UserFilterType.valueOf(filters[i]);
            Operator operator1 = Operator.valueOf(operators[i]);
            String finalValue = values[i];
            query = query.append(userFilterType).
                    append(operator1.getValue()).
                    append("'").append(finalValue).
                    append("'").append(" and ");
        }
        logger.info("query is :" + query.substring(0, query.length()-4));
        Query query1 =  em.createNativeQuery(query.substring(0, query.length()-4), User.class);
        return query1.getResultList();
//        return userRepository.findUsersByNativeQuery(query.substring(0, query.length()-4).toString());
    }

    public User getStudentByPhoneNo(String userPhone) {
        return userRepository.findByPhoneNoAndUserType(userPhone, UserType.STUDENT);

    }

}
