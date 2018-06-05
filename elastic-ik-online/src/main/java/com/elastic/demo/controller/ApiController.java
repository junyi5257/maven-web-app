package com.elastic.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author goujy
 * @date 6/5/18
 */
@RequestMapping("api")
@RestController
public class ApiController {
    Logger logger = LoggerFactory.getLogger(ApiController.class);

    @RequestMapping("/add")
    public Map<String, Object> addSensitiveWord(String word) {

        Map<String, Object> row = new HashMap<>(16);
        if (StringUtils.isEmpty(word)) {
            row.put("status", 1);
            row.put("word", word);
            row.put("msg", "error");
            row.put("error", "param empty");
            return row;
        }
        try {
            logger.info("==add==word:" + word);
            String path = this.getClass().getResource("/").getPath();
            File ikwordFile = new File(path + "/static/ikword.dic");
            if (!ikwordFile.exists()) {
                ikwordFile.createNewFile();
            }
            BufferedWriter fw = new BufferedWriter(new FileWriter(ikwordFile, true));
            String[] arrWord = word.split("#");
            for (String str : arrWord) {
                if (!StringUtils.isEmpty(str)) {
                    fw.newLine();
                    fw.write(str);
                }
            }
            fw.flush();
            fw.close();
            row.put("status", 1);
            row.put("word", word);
            row.put("msg", "success");
        } catch (Exception e) {

        }
        return row;
    }
}
