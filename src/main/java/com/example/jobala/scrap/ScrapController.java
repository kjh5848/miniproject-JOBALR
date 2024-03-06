package com.example.jobala.scrap;

import com.example.jobala._core.util.ApiUtil;
import com.example.jobala._user.User;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ScrapController {
    private final ScrapRepository scrapRepository;
    private final HttpSession session;

    @DeleteMapping("/api/scrap/{id}")
    public ApiUtil<?> delete(@PathVariable Integer id, HttpServletResponse response){
        // 1. 인증 체크
        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            response.setStatus(401);
            return new ApiUtil<>(401, "인증안됨");
        }
        // 2. 권한 체크
        Scrap scrap = scrapRepository.findById(id);
        if(scrap.getResumeId() != sessionUser.getId()){
            response.setStatus(403);
            return new ApiUtil<>(403, "권한없음");
        }
        scrapRepository.deleteById(id);
        return new ApiUtil<>(null);
    }

    @PostMapping("/api/scrap")
    public ApiUtil<?> save(@RequestBody ScrapRequest.SaveDTO reqDTO, HttpServletResponse resp){
        // 1. 인증 체크
        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            resp.setStatus(401);
            return new ApiUtil<>(401, "인증안됨");
        }
        Scrap scrap = scrapRepository.save(reqDTO, sessionUser);
        return new ApiUtil<>(scrap);
    }


    @GetMapping("/comp/scrapForm")
    public String compScrapForm() {
        return "/comp/_myPage/scrapForm";
    }

    @GetMapping("/guest/scrapForm")
    public String guestScrapForm() {
        return "/guest/_myPage/scrapForm";
    }
}
