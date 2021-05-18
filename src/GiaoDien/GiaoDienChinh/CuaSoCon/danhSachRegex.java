package GiaoDien.GiaoDienChinh.CuaSoCon;

import java.util.regex.Pattern;

public interface danhSachRegex {
    public Pattern pSoCMDN = Pattern.compile("^\\d{9}$");
    public Pattern pSoDT = Pattern.compile("^0((\\d{9})|(\\d{10}))$");
}
