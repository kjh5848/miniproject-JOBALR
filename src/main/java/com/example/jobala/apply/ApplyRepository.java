package com.example.jobala.apply;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ApplyRepository {
    @Autowired
    private final EntityManager em;


    /**
     * select at.id, jot.jobopen_title, rt.resume_title, rt.name
     * from apply_tb at inner join jobopen_tb jot on at.jobopen_id = jot.id
     * inner join resume_tb rt on rt.id = at.resume_id
     * where at.user_id = 3;
     */

    public List<ApplyResponse.ApplyDTO> findAllByUserId(int compId){ // 로그인한 기업 ID
        String q = """
                SELECT at.id, jot.jobopen_title, rt.resume_title, rt.name, rt.edu, jot.end_Time, at.state
                FROM apply_tb at
                INNER JOIN jobopen_tb jot ON at.jobopen_id = jot.id
                INNER JOIN resume_tb rt ON rt.id = at.resume_id
                WHERE at.user_id = ?;
                """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1, compId);

        // qlrm 사용하기
        JpaResultMapper mapper = new JpaResultMapper();
        List<ApplyResponse.ApplyDTO> responseDTO = mapper.list(query, ApplyResponse.ApplyDTO.class);
        return responseDTO;
    }

    public List<ApplyResponse.HireDTO> findAllByUserId2(int compId){ // 로그인한 기업 ID
        String q = """
                SELECT at.id, jot.jobopen_title, rt.resume_title, rt.name, at.state
                FROM apply_tb at
                INNER JOIN jobopen_tb jot ON at.jobopen_id = jot.id
                INNER JOIN resume_tb rt ON rt.id = at.resume_id
                WHERE at.user_id = ?;
                """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1, compId);

        // qlrm 사용하기
        JpaResultMapper mapper = new JpaResultMapper();
        List<ApplyResponse.HireDTO> responseDTO2 = mapper.list(query, ApplyResponse.HireDTO.class);
        return responseDTO2;
    }

    public void findAll() {
        return;
    }

    @Transactional
    public Apply findById(Integer id) {
        Query query = em.createNativeQuery("select * from apply_tb where id = ?", Apply.class);
        query.setParameter(1, id);

        try {
            Apply apply = (Apply) query.getSingleResult();
            return apply;
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public void save() {
        return;
    }

    @Transactional
    public void upDate() {
        return;
    }

    @Transactional
    public void delete() {
        return;
    }

}