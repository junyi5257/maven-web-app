package cn.junyi.mavenWeb.bean;

import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.Arrays;
import java.util.List;

/**
 * MLPChina
 * Created by goujy on 6/11/17.
 * Address:<url>https://github.com/NLPchina/ansj_seg<url/>
 *
 */
public class Chap12NLP {
    public static void main(String[] args) {
        String str = "中华人民的共和国" ;
        List info = ToAnalysis.parse(str).getTerms();
        System.out.println(Arrays.toString(info.toArray()));
        System.out.println(ToAnalysis.parse(str));
    }
}
