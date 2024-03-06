package com.example.jobala.comp;

import com.example.jobala.jobopen.Jobopen;
import com.example.jobala.resume.Resume;
import com.example.jobala.scrap.Scrap;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CompRepository {
    private final EntityManager em;



    public List<Resume> findResumeAll() {
        String q = """
            select * from resume_tb order by id desc;              
            """;
        Query query = em.createNativeQuery(q, Resume.class);
        return query.getResultList();
    }

    public List<Resume> findAllByUserId(int userId) {
    Query query = em.createNativeQuery("select * from resume_tb where user_id = ? order by id desc", Resume.class);
    query.setParameter(1, userId);

    List<Resume> resumeList = query.getResultList();
    return resumeList;
    }


    public List<CompResponse.ScoutListDTO> scoutList(){
        String q = """
                SELECT rt.name, rt.resume_title, ut.age, ut.address, rt.career
                FROM user_tb ut
                INNER JOIN (
                select * 
                from resume_tb
                where id in (
                select max(id)
                from resume_tb
                group by user_id
                )
                ) rt ON ut.id = rt.user_id
                """;

        Query query = em.createNativeQuery(q);

       JpaResultMapper rm = new JpaResultMapper();
       List<CompResponse.ScoutListDTO> results = rm.list(query, CompResponse.ScoutListDTO.class);
        System.out.println(results);

        return results;
    }

    public Resume findResumeById(int id) {
        String q = """
                select * from resume_tb where id = ?;              
                """;
        Query query = em.createNativeQuery(q, Resume.class);
        query.setParameter(1, id);
        try {
            Resume resume = (Resume) query.getSingleResult();
            return resume;
        } catch (Exception e) {
            return null;
        }

    }

    public List<Jobopen> findJobopenAll() {
        String q = """
                select * from jobopen_tb order by id desc
                """;
        Query query = em.createNativeQuery(q, Jobopen.class);
        return query.getResultList();
    }

    public void findById() {
        return;
    }

    @Transactional
    public void save() {
        return;
    }

    @Transactional
    public void update() {
        return;
    }

    @Transactional
    public void delete() {
        return;
    }

    public List<Scrap> findByScrapAll() {
        String q = """
                SELECT * FROM scrap_tb order by id desc;
                """;
        Query query = em.createNativeQuery(q, Jobopen.class);
        return query.getResultList();
    }

    public List<Resume> findByResumeAll() {
        String q = """
                SELECT * FROM resume_tb order by id desc;
                """;
        Query query = em.createNativeQuery(q, Resume.class);
        return query.getResultList();
    }
}
//    public List<Resume> findResumeAll() {
//        String q = """
//            select
//            j.id,
//            j.user_id,
//            j.career,
//            j.compname,
//            j.content,
//            j.edu,
//            j.hope_job,
//            j.job_type,
//            j,jobopen_title,
//            a.jobopen_id
//            from jobopen_tb j
//            inner join scrap_tb a on j.id = a.jobopen_id
//            """;
//        Query query = em.createNativeQuery(q);
//        return query.getResultList();
//    }
//    public findAllByUserId(int guestId){
//        String q = """
//                SELECT r.id, r.resume_title, r.career, r.edu
//                FROM resume_tb r
//                WHERE r.user_id = ?;
//                """;
//        Query query = em.createNativeQuery(q,Resume.class);
//        query.setParameter(1, guestId);
//         List<Resume> resultList =query.getSingleResult();
////        JpaResultMapper mapper = new JpaResultMapper();
////        List<CompResponse.ResumeListDTO> resumeList = mapper.list(query, CompResponse.ResumeListDTO.class);
////        return resumeList;
//        return
//    }