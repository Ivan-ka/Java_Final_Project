package com.epam.winterJavaLab.task12.service.impls;

import com.epam.winterJavaLab.task12.dao.interfaces.DiagnosisDao;
import com.epam.winterJavaLab.task12.entity.Diagnosis;
import com.epam.winterJavaLab.task12.service.interfaces.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class DiagnosisServiceImpl implements DiagnosisService {

    private DiagnosisDao diagnosisDao;


    @Autowired
    public DiagnosisServiceImpl(DiagnosisDao diagnosisDao) {
        this.diagnosisDao = diagnosisDao;
    }


    @Override
    public List<Diagnosis> getAllDiagnoses() {
        return diagnosisDao.getAllDiagnoses();
    }

}
