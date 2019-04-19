package com.example.demo.util;

import com.example.demo.vo.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kuangjunlin
 */
public class PatternCourseUtil {
    private static Pattern REMOVE_OTHER_SIGN = Pattern.compile("\\s*|\t|\r|\n");
    private static Pattern REMOVE_HTML = Pattern.compile("<[^>]+>");
    private static Pattern TABLE_PATTERN = Pattern.compile("<table>(.*?)</table>(.*?)<table>(.*?)(/table)");
    private static Pattern TR_PATTERN = Pattern.compile("<tr>(.*?)</tr>");
    private static Pattern COURSE_PATTERN = Pattern.compile("__(.*?)__(.*?)__(.*?)__(.*?)__(.*?)__(.*?)__(.*?)__(.*?)__");

    public static Course matchCourse(String tr){
        Matcher matcher = COURSE_PATTERN.matcher(tr);
        while (matcher.find()){
            return new Course.Builder(matcher).build();
        }
        return null;
    }

    public static List<Course> matchAllCourse(String response){
        String s = removeOtherSign(response);
        String allCourse = matchBody(s).substring(20);
        Matcher matcher = TR_PATTERN.matcher(allCourse);
        String tr = "";
        List<Course> courseList = new ArrayList<>();
        while (matcher.find()){
            tr = matcher.group();
            Course course = matchCourse(removeHtml(tr));
            if (course != null){
                courseList.add(matchCourse(removeHtml(tr)));
            }
        }
        return courseList;
    }

    public static String matchBody(String str){
        Matcher matcher = TABLE_PATTERN.matcher(str);
        String result = "";
        while (matcher.find()){
            result = matcher.group(3);
        }
        return result;
    }

    public static String removeHtml(String str){
        return REMOVE_HTML.matcher(str).replaceAll("_");
    }

    public static String removeOtherSign(String str) {
        return REMOVE_OTHER_SIGN.matcher(str).replaceAll("");
    }


}
