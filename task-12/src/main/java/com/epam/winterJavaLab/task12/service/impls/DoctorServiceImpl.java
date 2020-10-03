package com.epam.winterJavaLab.task12.service.impls;

import com.epam.winterJavaLab.task12.dao.interfaces.DoctorDao;
import com.epam.winterJavaLab.task12.entity.Doctor;
import com.epam.winterJavaLab.task12.service.interfaces.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class DoctorServiceImpl implements DoctorService {

    private DoctorDao doctorDao;


    @Autowired
    public DoctorServiceImpl(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }


    @Override
    public List<Doctor> getAllDoctors() {
        return doctorDao.getAllDoctors();
    }

}
