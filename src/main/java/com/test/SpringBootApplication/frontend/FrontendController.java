package com.test.SpringBootApplication.frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.http.MediaType.TEXT_HTML_VALUE;

@Controller
public class FrontendController {
    private static final Logger LOG = LoggerFactory.getLogger(FrontendController.class);

    @GetMapping(value = {"/", "/list", "/contact", "/{path:[^\\.]*}"}, produces = TEXT_HTML_VALUE)
    public String getFrontend() {
        LOG.info("Received request for ui");
        return "index";
    }
}