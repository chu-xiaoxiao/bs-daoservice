package com.zyc.service.iservice;

import com.zyc.model.Example.SubjectExample;
import com.zyc.model.Subject;

import java.util.List;

/**
 * Created by YuChen Zhang on 18/03/11.
 */
public interface ISubjectService {
    List<Subject> querySubject(SubjectExample subjectExample);
    Subject querySubject(Integer id);
    Subject insertSubject(Subject subject);
    Integer deleteSubject(SubjectExample subjectExample);
    Integer deleteSubject(Integer id);
    Integer modifySubject(Subject subject,SubjectExample subjectExample);
}
