package com.example.server.manager.web.controller.manage.userinfo;

import com.example.server.manager.common.constants.CookieConstants;
import com.example.server.manager.dao.mysql.domain.User;
import com.example.server.manager.web.controller.base.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class UserinfoController extends BaseController {

    @RequestMapping("/userinfo")
    public String indexRequest(HttpServletRequest request, HttpServletResponse response, Model model) {
        prepare(request, response, model, "indexRequest");
        String userId = (String) request.getAttribute(CookieConstants.USER_ID);
        if (StringUtils.isNotBlank(userId)) {
            User user = (User) request.getSession().getAttribute(userId);
            if (user != null) {
                model.addAttribute("user", user);
            }
        }
        return "manage/screen/userinfo/index";
    }
}
