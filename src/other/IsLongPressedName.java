package other;

import org.junit.Test;

public class IsLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) return false;
        int i = 0, j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) != typed.charAt(j)) break;
            while (i < name.length() && j < typed.length() && name.charAt(i) == typed.charAt(j)) {//当名字中又重复连续字母
                i++;
                j++;
            }
            while (j < typed.length() && typed.charAt(j - 1) == typed.charAt(j)) j++;//长按输入

        }
        return i == name.length() && j == typed.length();
    }
}
