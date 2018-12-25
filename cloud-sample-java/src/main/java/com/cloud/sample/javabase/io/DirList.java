package com.cloud.sample.javabase.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @ClassName DirList
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/12/5 17:14
 */
public class DirList {

    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if(args.length == 0){
            list = path.list();
        }else {
            list = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String dirItem:list){
            System.out.println(dirItem);
        }
    }

    static class DirFilter implements FilenameFilter {
        private Pattern pattern;

        public DirFilter(String regex){
            pattern = Pattern.compile(regex);
        }
        @Override
        public boolean accept(File dir, String name) {
            return pattern.matcher(name).matches();
        }
    }
}
