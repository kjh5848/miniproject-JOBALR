package com.example.jobala.scrap;

import com.example.jobala._user.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ScrapRepository {
    private final EntityManager em;
    private Integer id;

    @Transactional
    public Scrap save(ScrapRequest.SaveDTO reqDTO, User sessionUser) {
        Query query = em.createNativeQuery("insert into scrap_tb(role, user_id, resume_id, jobopen_id,created_at) values(?,?,?,?,now())");
        query.setParameter(1, sessionUser.getRole());
        query.setParameter(2, sessionUser.getId());
        query.setParameter(3, reqDTO.getResumeId());
        query.setParameter(4, reqDTO.getJobopenId());
        query.executeUpdate();

        Query query2 = em.createNativeQuery("select * from scrap_tb where id = (select max(id) from scrap_tb)", Scrap.class);
        try {
            Scrap scrap = (Scrap) query2.getSingleResult();
            return scrap;
        } catch (Exception e) {
            return null;
        }
    }


    public ScrapResponse.DetailDTO findScrap(int resumeId) {
        String q = """
                SELECT count(*) FROM skill_tb
                WHERE resume_id = ?;
                """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1, resumeId);

        // 한건만 받을때는 바로 받기
        Scrap Scrap = (Scrap) query.getSingleResult();
        Integer id = 0;
        Boolean isScrap = false;

        System.out.println("id : " + id);
        System.out.println("isScrap : " + isScrap);

        ScrapResponse.DetailDTO respoDTO = new ScrapResponse.DetailDTO(
                id, isScrap
        );
        return respoDTO;
    }

    public Scrap findById(Integer id) {
        Query query = em.createNativeQuery("select * from scrap_tb where id = ?", Scrap.class);
        query.setParameter(1, id);

        try {
            Scrap scrap = (Scrap) query.getSingleResult();
            return scrap;
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public void deleteById(Integer id) {
        String q = """
                delete from love_tb where id = ?    
                """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1, id);

        query.executeUpdate();
    }



    @Transactional
    public void update() {
        return;
    }

    public void findAll() {
        return;
    }

    public List<Scrap> findByScrapAll() {
        String q = """
                select * from scrap_tb
                """;

        Query query = em.createNativeQuery(q, Scrap.class);
        return query.getResultList();
    }
}
