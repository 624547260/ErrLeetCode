package com.snowfly.errleetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by qiaofeng on 2022/5/25
 * Desc：467. 环绕字符串中唯一的子字符串
 * [https://leetcode.cn/problems/unique-substrings-in-wraparound-string/]
 */
class Solution02 {
    Set<String> has = new HashSet<>();
    public int findSubstringInWraproundString(String p) {
        if(p.length() == 1){
            return 1;
        }
        int left = 0;
        int right = 1;
        for(; right< p.length();right++){
            if(!((p.charAt(right) - p.charAt(right-1) == 1)|| (p.charAt(right) == 'a' && p.charAt(right-1) == 'z'))){
                addHas(p.substring(left,right));
                left = right;
            }
        }
        if(left!= right){
            addHas(p.substring(left,right));
        }
        return has.size();
    }

    public void addHas(String msg){
        if(has.contains(msg)) return;
        for(int a =0 ;a<msg.length();a++){
            for(int b = a+1;b <= msg.length();b++){
                has.add(msg.substring(a,b));
            }
        }
    }
}
